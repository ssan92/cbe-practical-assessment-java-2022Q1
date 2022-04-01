package com.example.q12022.controller;

import com.example.q12022.domain.dto.Response;
import com.example.q12022.domain.dto.UserStoreDTO;
import com.example.q12022.service.UserStoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api("Apis that manage the users")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/user")
public class UserStoreController {

    private static final Logger LOG = LoggerFactory.getLogger(UserStoreController.class);

    private final UserStoreService userStoreService;

    @ApiOperation("Find a user by ID")
    @GetMapping(value = "getUserStore/{id}")
    public ResponseEntity<Response> getUserStore(@PathVariable("id") Long id) {
        Response response = new Response();
        try {
            UserStoreDTO result = userStoreService.getCustomer(id);
            response.setAuto(result);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
            LOG.error(e.getMessage());
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation("Find all users")
    @GetMapping(value = "getAllUserStore")
    public ResponseEntity<Response> getAllUserStore() {
        Response response = new Response();
        try {
            List<UserStoreDTO> result = userStoreService.getAllCustomers();
            response.setMessage(String.valueOf(result.size()).concat(" Registros encontrados"));
            response.setAuto(result);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation("Create or update a user")
    @PostMapping(value = "saveUserStore", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<Response> saveUserStore(@RequestBody UserStoreDTO dto) {
        Response response = new Response();
        try {
            UserStoreDTO result = userStoreService.saveCustomer(dto);
            response.setAuto(result);
            response.setStatus(HttpStatus.CREATED);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @ApiOperation("Delete a user")
    @DeleteMapping("deleteUserStore/{id}")
    public ResponseEntity<Response> deleteUserStore(@PathVariable("id") Long id) {
        Response response = new Response();
        try {
            Long result = userStoreService.deleteCustomer(id);
            response.setAuto(result);
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            response.setMessage(e.getMessage());
            response.setError(true);
        }
        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }
}
