package com.bp.chapter.test.ChapterTest.service.impl;

import com.bp.chapter.test.ChapterTest.dao.StoreDao;
import com.bp.chapter.test.ChapterTest.entity.Store;
import com.bp.chapter.test.ChapterTest.exception.InternalServerErrorException;
import com.bp.chapter.test.ChapterTest.exception.StoreException;
import com.bp.chapter.test.ChapterTest.model.response.DataResponse;
import com.bp.chapter.test.ChapterTest.model.response.headerApp;
import com.bp.chapter.test.ChapterTest.request.StoreRequest;
import com.bp.chapter.test.ChapterTest.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImp implements StoreService {

    @Autowired
    StoreDao storeDao;


    private String message = "";
    private Integer code = 0;


    public DataResponse fnCreateStore(StoreRequest storeRequest) throws StoreException {
        Store store = new Store();
        try {

            store.setCategory(storeRequest.getCategory());
            store.setDirection(storeRequest.getDirection());
            store.setIdentifier(storeRequest.getIdentifier());
            //store.setUser();

            storeDao.save(store);
            message = "Se inserto correctamente";
            code = 200;

        }catch (Exception storeException) {
            code = 400;
            message = "Consulte con el administrador del sistema no se pudo generar la operación";
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");

        }

        headerApp header = new headerApp(code, message);
        DataResponse response = new DataResponse();
        response.setHeaderApp(header);
        return response;
    }
}
