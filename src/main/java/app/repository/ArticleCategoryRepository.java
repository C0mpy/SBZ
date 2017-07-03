package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.ArticleCategory;

public interface ArticleCategoryRepository extends JpaRepository<ArticleCategory, Long> {

}
