package com.avaldinger.portfolioservice.repository;

import com.avaldinger.portfolioservice.model.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TickerRepository extends JpaRepository<Ticker, Integer> {

}
