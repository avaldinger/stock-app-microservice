package com.avaldinger.customer.customerservice.repository;

import com.avaldinger.customer.customerservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
}
