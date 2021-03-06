package com.avaldinger.portfolioservice.resources;

import com.avaldinger.portfolioservice.model.Portfolio;
import com.avaldinger.portfolioservice.repository.PortfolioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {

    Logger logger = LoggerFactory.getLogger(PortfolioController.class);

    @Autowired
    private PortfolioRepository portfolioRepository;

    @RequestMapping("/all")
    public List<Portfolio> getAllPortfolios() {

        logger.info("Before");

        List<Portfolio> allPortfolios = portfolioRepository.findAll();

        logger.info("After " +  allPortfolios);

        return allPortfolios;
    }

    @RequestMapping("/hi")
    public String greetings2() {

        logger.info("Greetings");

        return "Hello";


    }

    @GetMapping("/{portfolioId}")
    public Portfolio getPortfolioById(@PathVariable int portfolioId) {

        if (portfolioRepository.findById(portfolioId).isPresent()) {
            return portfolioRepository.findById(portfolioId).orElse(null);
        } else {
            throw new EntityNotFoundException("Portfolio with id " + portfolioId + " doesn't exists.");
        }

    }

    @PostMapping("/add")
    public String addPortfolio(@RequestBody Portfolio portfolio) {

        portfolioRepository.save(portfolio);

        return "Portfolio with id " +  portfolio.getId() + "has been created.";

    }

    @PutMapping("/update")
    public Portfolio updatePortfolio(@RequestBody Portfolio portfolio) {

        Portfolio existingPortfolio = portfolioRepository.getById(portfolio.getId());

        existingPortfolio.setAccountId(portfolio.getAccountId());
        existingPortfolio.setAmount(portfolio.getAmount());
        existingPortfolio.setTicker(portfolio.getTicker());

        portfolioRepository.save(existingPortfolio);

        return existingPortfolio;
    }

    @DeleteMapping("/delete/{portfolioId}")
    public String removePortfolio(@PathVariable int portfolioId) {

        if (portfolioRepository.findById(portfolioId).isPresent()) {
            Portfolio toRemove = portfolioRepository.findById(portfolioId).orElse(null);
            portfolioRepository.delete(toRemove);
            return "Portfolio with id: " + portfolioId + " has been removed.";
        } else {
            throw new EntityNotFoundException("Portfolio with id " + portfolioId + " doesn't exists.");
        }
    }
}
