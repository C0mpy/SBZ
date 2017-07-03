package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Discount;

public interface DiscountRepository extends JpaRepository<Discount, Long> {

}
