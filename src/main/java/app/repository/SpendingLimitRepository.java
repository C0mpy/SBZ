package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.models.SpendingLimit;

public interface SpendingLimitRepository extends JpaRepository<SpendingLimit, Long> {

}
