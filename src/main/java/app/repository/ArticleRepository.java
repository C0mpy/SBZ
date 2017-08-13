package app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query("select distinct a from Article as a join a.category as c WHERE"
			+ "(:code is null or lower(a.code) like CONCAT('%', lower(:code), '%')) AND "
			+ "(:name is null or lower(a.name) like CONCAT('%', lower(:name), '%')) AND "
			+ "(:minPrice = 0.0 or a.price > :minPrice) AND "
			+ "(:maxPrice = 0.0 or a.price < :maxPrice) AND "
			+ "(:category is null or c.name like :category) AND "
			+ "(:status is null or a.status like :status)")
	Page<Article> findArticle(@Param("code") String code, @Param("name") String name, @Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice,
			@Param("category") String category, @Param("status") String status, Pageable pageable);
	
	@Query("select distinct a from Article as a join a.category as c WHERE"
			+ "(:code is null or lower(a.code) like CONCAT('%', lower(:code), '%')) AND "
			+ "(:name is null or lower(a.name) like CONCAT('%', lower(:name), '%')) AND "
			+ "(:minPrice = 0.0 or a.price > :minPrice) AND "
			+ "(:maxPrice = 0.0 or a.price < :maxPrice) AND "
			+ "(:category is null or c.name like :category) AND "
			+ "(:status is null or a.status like :status)")
	List<Article> countArticle(@Param("code") String code, @Param("name") String name, @Param("minPrice") double minPrice, @Param("maxPrice") double maxPrice,
			@Param("category") String category, @Param("status") String status);
	
	Article findOneByCode(String code);

}
