package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
	
	Category findOneByName(String name);

}
