package com.avaldinger.portfolioservice.resources;

import com.avaldinger.portfolioservice.model.Ticker;
import com.avaldinger.portfolioservice.repository.TickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/hi")
    public String greetings2() {

        return "Hello 2";
    }
}
