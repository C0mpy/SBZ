package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
