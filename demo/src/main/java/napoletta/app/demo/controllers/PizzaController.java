package napoletta.app.demo.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import napoletta.app.demo.service.PizzaService;
import napoletta.app.demo.models.ImageModel;
import napoletta.app.demo.models.Pizza;

@RestController
@RequestMapping("pizza")
public class PizzaController {
    @Autowired
    private final PizzaService pizzaService;

	public PizzaController(PizzaService pizzaService){
        this.pizzaService = pizzaService;
    }
    @GetMapping
    public ResponseEntity<Iterable<Pizza>> searchAll(){
        return ResponseEntity.ok(pizzaService.searchAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> searchById(@PathVariable Long id){
        Pizza returnedPizza = pizzaService.searchById(id);
        return ResponseEntity.ok(returnedPizza);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Pizza> insert(@RequestPart("pizza") Pizza pizza, @RequestPart("imageFile") MultipartFile file){
        try{
            ImageModel image = uploadImage(file);
            pizza.setPizzaImage(image);
            var pizzaCreated = pizzaService.insert(pizza);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(pizzaCreated.getId())
                .toUri();
            return ResponseEntity.created(location).body(pizzaCreated);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
	}

	@PutMapping("/{id}")
	public ResponseEntity<Pizza> atualizar(@PathVariable Long id, @RequestBody Pizza pizza) {
		pizzaService.update(id, pizza);
		return ResponseEntity.ok(pizza);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pizzaService.delete(id);
		return ResponseEntity.ok().build();
	}

    // compress the image bytes before storing it in the database
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}

	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}
    public ImageModel uploadImage(MultipartFile multipartFiles) throws IOException{
        ImageModel imageModels = new ImageModel(multipartFiles.getOriginalFilename(), multipartFiles.getContentType(), multipartFiles.getBytes());
        return imageModels;
    }
}
