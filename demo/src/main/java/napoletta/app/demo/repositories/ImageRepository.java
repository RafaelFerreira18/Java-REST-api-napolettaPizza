package napoletta.app.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import napoletta.app.demo.models.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}
