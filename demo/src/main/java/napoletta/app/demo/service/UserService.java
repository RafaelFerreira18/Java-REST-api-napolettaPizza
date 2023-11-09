package napoletta.app.demo.service;

import napoletta.app.demo.models.User;

public interface UserService {

	Iterable<User> searchAll();

	User searchById(Long id);

	User insert(User user);

	void update(Long id, User user);

	void delete(Long id);

}
