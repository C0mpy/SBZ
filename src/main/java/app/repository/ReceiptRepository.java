package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

}
