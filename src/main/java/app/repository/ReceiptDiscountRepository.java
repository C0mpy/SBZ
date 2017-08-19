package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.ReceiptDiscount;

public interface ReceiptDiscountRepository extends JpaRepository<ReceiptDiscount, Long> {

}
