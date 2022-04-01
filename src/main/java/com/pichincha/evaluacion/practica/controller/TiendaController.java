package com.pichincha.evaluacion.practica.controller;

import com.pichincha.evaluacion.practica.entity.StoreEntity;
import com.pichincha.evaluacion.practica.handler.exceptions.GeneralErrorException;
import com.pichincha.evaluacion.practica.service.EvaluationService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/store")
@Slf4j
public class TiendaController {

    @Autowired
    private EvaluationService evaluationService;

    @GetMapping("/all")
    public ResponseEntity<StoreEntity> getStores() throws GeneralErrorException {
        try {
            List<StoreEntity> response = evaluationService.getStoresList();
            return new ResponseEntity(response, HttpStatus.OK);
        }catch (Exception e){
            throw new GeneralErrorException("EndPoint Not Found");
        }
    }
}
