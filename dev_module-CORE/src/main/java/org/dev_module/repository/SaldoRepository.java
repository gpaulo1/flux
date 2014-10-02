package org.dev_module.repository;

import org.dev_module.model.Saldo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface SaldoRepository extends JpaRepository<Saldo, Long>,
		QueryDslPredicateExecutor<Saldo> {

}
