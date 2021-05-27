package com.avaldinger.portfolioservice.repository;


import com.avaldinger.portfolioservice.model.PriceHistory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceHistoryRepository extends JpaRepository<PriceHistory, Integer> {

}
