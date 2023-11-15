package napoletta.app.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import napoletta.app.demo.models.User;
import napoletta.app.demo.repositories.UserRepository;
import napoletta.app.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
	private UserRepository userRepository;
	
	@Override
	public Iterable<User> searchAll() {
		return userRepository.findAll();
	}

	@Override
	public User searchById(Long id) {
		Optional<User> User = userRepository.findById(id);
		return User.get();
	}

	@Override
	public void update(Long id, User User) {
		Optional<User> userBd = userRepository.findById(id);
        if(userBd.isPresent()){
            userRepository.save(User);
        }
	}

	@Override
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

    @Override
    public User insert(User user) {
		if(userRepository.existsByEmail(user.getEmail())){
			throw new IllegalArgumentException("This email already exists");
		}
        return this.userRepository.save(user);
    }

}
