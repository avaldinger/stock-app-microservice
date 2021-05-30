package com.avaldinger.portfolioservice.resources;

import com.avaldinger.portfolioservice.model.Portfolio;
import com.avaldinger.portfolioservice.model.Ticker;
import com.avaldinger.portfolioservice.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/ticker")
public class TickerController {


    @Autowired
    TickerRepository tickerRepository;


    @GetMapping("/all")
    public List<Ticker> geTAllTickers() {

        List<Ticker> allTickers = tickerRepository.findAll();

        return allTickers;

    }

    @GetMapping("/{tickerId}")
    public Ticker getTickerById(@PathVariable int tickerId) {

        if(tickerRepository.findById(tickerId).isPresent()) {
            return tickerRepository.findById(tickerId).orElse(null);
        } else {
            throw new EntityNotFoundException("Ticker with id " + tickerId + " doesn't exists.");
        }

    }

    @PostMapping("/add")
    public String addPortfolio(@RequestBody Ticker ticker) {

        tickerRepository.save(ticker);

        return "Portfolio with id " +  ticker.getId() + "has been created.";

    }

    @PutMapping("/update/")
    public Ticker updatePortfolio(@RequestBody Ticker ticker) {

        Ticker existingTicker = tickerRepository.getById(ticker.getId());

        existingTicker.setTickerId(ticker.getTickerId());
        existingTicker.setActualPrice(ticker.getActualPrice());
        existingTicker.setCurrency(ticker.getCurrency());
        existingTicker.setName(ticker.getName());
        existingTicker.setTotalAmount(ticker.getTotalAmount());
        existingTicker.setType(ticker.getType());


        tickerRepository.save(existingTicker);

        return existingTicker;
    }

    @DeleteMapping("/delete/{tickerIdd}")
    public String removePortfolio(@PathVariable int tickerIdd) {

        if (tickerRepository.findById(tickerIdd).isPresent()) {
            Ticker toRemove = tickerRepository.findById(tickerIdd).orElse(null);
            tickerRepository.delete(toRemove);
            return "Ticker with id: " + tickerIdd + " has been removed.";
        } else {
            throw new EntityNotFoundException("Portfolio with id " + tickerIdd + " doesn't exists.");
        }
    }


}
