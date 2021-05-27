package com.avaldinger.portfolioservice.repository;



import com.avaldinger.portfolioservice.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PortfolieRepository extends JpaRepository<Portfolio, Integer> {

}
