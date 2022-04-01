package com.bp.chapter.test.ChapterTest.controller;


import com.bp.chapter.test.ChapterTest.model.response.ApiResponse;
import com.bp.chapter.test.ChapterTest.model.response.DataResponse;
import com.bp.chapter.test.ChapterTest.model.response.headerApp;
import com.bp.chapter.test.ChapterTest.request.StoreRequest;
import com.bp.chapter.test.ChapterTest.service.StoreService;
import com.bp.chapter.test.ChapterTest.util.UtilResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

    private static final String LOGGER_RESPONSE_FORMAT = "001-RES";
    private static final String LOGGER_REQUEST_FORMAT = "001-REQ";
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    private ApiResponse apiResponse = null;
    private DataResponse dataResponse = null;

    @Autowired
    private StoreService storeService;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create(@RequestBody StoreRequest storeRequest) {

        String method = "create";
        logger.info("1. created store [ " + storeRequest.getName() + " ]", method, LOGGER_REQUEST_FORMAT);
        DataResponse dataResponse = new DataResponse();
        var header = new headerApp();
        try {
            dataResponse = storeService.fnCreateStore(storeRequest);
        } catch (Exception e) {
            header = new headerApp(400, "Consulte con el administrador ha surgido un inconveniente");
            dataResponse.setHeaderApp(header);
            logger.error("Se produjo un error al crear la tienda en el método \t" + method + "\t"
                    + e, LOGGER_RESPONSE_FORMAT);
        }
        return new ResponseEntity<Object>(dataResponse, UtilResponse.getHttpStatus(dataResponse.getHeaderApp().getCode()));

    }
}
