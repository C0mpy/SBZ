package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Customer;
import app.models.Manager;
import app.models.Salesman;
import app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findOneByUsernameAndPassword(String username, String password);
	User findOneByUsername(String username);
	Customer findOneCustomerById(Long id);
}
