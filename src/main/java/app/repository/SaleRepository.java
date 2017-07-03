package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
