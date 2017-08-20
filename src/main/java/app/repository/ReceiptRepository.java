package app.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {

	ArrayList<Receipt> findAllByCustomerId(Long customerId);
	Receipt findOneByCustomerIdAndState(Long customerId, String state);
	Receipt findOneByCode(String code);
	ArrayList<Receipt> findAllByState(String state);
}
