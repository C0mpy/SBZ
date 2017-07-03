package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
