package com.avaldinger.portfolioservice.resources;

import com.avaldinger.portfolioservice.model.PriceHistory;
import com.avaldinger.portfolioservice.model.Ticker;
import com.avaldinger.portfolioservice.repository.PriceHistoryRepository;
import com.avaldinger.portfolioservice.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/pricehistory")
public class PriceHistoryController {

    @Autowired
    PriceHistoryRepository priceHistoryRepository;


    @GetMapping("/all")
    public List<PriceHistory> geTAllHistorys() {

        List<PriceHistory> priceHistoryList = priceHistoryRepository.findAll();

        return priceHistoryList;

    }

    @GetMapping("/{historyId}")
    public PriceHistory getHistoryById(@PathVariable int historyId) {

        if(priceHistoryRepository.findById(historyId).isPresent()) {
            return priceHistoryRepository.findById(historyId).orElse(null);
        } else {
            throw new EntityNotFoundException("Ticker with id " + historyId + " doesn't exists.");
        }

    }

    @PostMapping("/add")
    public String addPriceHistory(@RequestBody PriceHistory priceHistory) {

        priceHistoryRepository.save(priceHistory);

        return "Portfolio with id " +  priceHistory.getId() + "has been created.";

    }

    @PutMapping("/update/")
    public PriceHistory updateHistory(@RequestBody PriceHistory priceHistory) {

        PriceHistory existingHistory = priceHistoryRepository.getById(priceHistory.getId());

        existingHistory.setPrice(priceHistory.getPrice());
        existingHistory.setTickerName(priceHistory.getTickerName());
        existingHistory.setTimeStamp(priceHistory.getTimeStamp());




        priceHistoryRepository.save(existingHistory);

        return existingHistory;
    }

    @DeleteMapping("/delete/{historyId}")
    public String removePriceHistory(@PathVariable int historyId) {

        if (priceHistoryRepository.findById(historyId).isPresent()) {
            PriceHistory toRemove = priceHistoryRepository.findById(historyId).orElse(null);
            priceHistoryRepository.delete(toRemove);
            return "Ticker with id: " + historyId + " has been removed.";
        } else {
            throw new EntityNotFoundException("Portfolio with id " + historyId + " doesn't exists.");
        }
    }
}
