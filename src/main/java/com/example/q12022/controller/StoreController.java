package com.example.q12022.controller;

import com.example.q12022.domain.dto.OrderDTO;
import com.example.q12022.domain.dto.Response;
import com.example.q12022.domain.dto.StoreDTO;
import com.example.q12022.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api("Apis that manage the stores")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/store")
public class StoreController {

    private final StoreService storeService;

    @ApiOperation("Find a store by Name")
    @GetMapping(value = "getStoreByName/{name}")
    public ResponseEntity<Response> getStoreByName(@PathVariable("name") String name) {
        Response response = new Response();
        try {
            StoreDTO result = storeService.getStoreByName(name);
            response.setAuto(result);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation("Create or update a store")
    @PostMapping(value = "saveStore", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<Response> saveStore(@RequestBody StoreDTO dto) {
        Response response = new Response();
        try {
            StoreDTO result = storeService.saveStore(dto);
            response.setAuto(result);
            response.setStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation("Delete a store")
    @DeleteMapping("deleteStore/{id}")
    public ResponseEntity<Response> deleteStore(@PathVariable("id") Long id) {
        Response response = new Response();
        try {
            Long result = storeService.deleteStore(id);
            response.setAuto(result);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Apis to manage orders
     */

    @ApiOperation("Place an order")
    @PostMapping(value = "orders/placeOrder", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<Response> placeOrder(@RequestBody OrderDTO data) {
        Response response = new Response();
        try {
            Boolean result = storeService.placeOrder(data);
            response.setAuto(result);
            response.setStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }
}
