package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.ItemDiscount;

public interface ItemDiscountRepository extends JpaRepository<ItemDiscount, Long> {

}
