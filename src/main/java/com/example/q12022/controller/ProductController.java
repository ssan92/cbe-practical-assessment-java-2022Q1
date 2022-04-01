package com.example.q12022.controller;

import com.example.q12022.domain.dto.ProductDTO;
import com.example.q12022.domain.dto.Response;
import com.example.q12022.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("Apis that manage the products")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductService productService;

    @ApiOperation("Create or update a product")
    @PostMapping(value = "saveProduct", headers = "Accept=application/json;charset=UTF-8")
    public ResponseEntity<Response> saveProduct(@RequestBody ProductDTO dto) {
        Response response = new Response();
        try {
            ProductDTO result = productService.saveProduct(dto);
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
