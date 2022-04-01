package com.example.market.controller;

import com.example.market.model.MarketEntity;
import com.example.market.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class MarketController {

    @Autowired
    MarketRepository marketRepository;

    @GetMapping("/markets/{name}")
    public ResponseEntity<List<MarketEntity>> getTutorialByName(@PathVariable("name") String name) {
        try{
            List<MarketEntity> marketData = new ArrayList<MarketEntity>();
            marketRepository.findByName(name).forEach(marketData::add);
            if (marketData.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(marketData, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/markets")
    public ResponseEntity<MarketEntity> createTutorial(@RequestBody MarketEntity market) {
        try {
      MarketEntity _tutorial =
          marketRepository.save(
              new MarketEntity(market.getName(), market.getCategory(), market.getUserEntity()));
            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/markets/{id}")
    public ResponseEntity<MarketEntity> updateTutorial(@PathVariable("id") long id, @RequestBody MarketEntity market) {
        Optional<MarketEntity> marketData = marketRepository.findById((int) id);
        if (marketData.isPresent()) {
            MarketEntity _market = marketData.get();
            _market.setName(market.getName());
            _market.setCategory(market.getCategory());
            return new ResponseEntity<>(marketRepository.save(_market), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


