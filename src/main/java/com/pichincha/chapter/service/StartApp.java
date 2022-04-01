package com.pichincha.chapter.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class StartApp {

    @Autowired
    private StoreService storeService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @EventListener(ApplicationReadyEvent.class)
    public void startApp() {
        log.info("Start application...");
        this.initStore();
    }

    private void initStore() {
        List<String> lisSQL = getSqlStoreList();
        lisSQL.forEach(sql -> executeSql(sql));
    }

    private List<String> getSqlStoreList() {
        String sql1 = "INSERT INTO STORE (COD, NAME, CATEGORY, OWNER) VALUES (1, 'Abarrotes', 'Tienda de barrio', 'Christian Muyon')";
        String sql2 = "INSERT INTO STORE (COD, NAME, CATEGORY, OWNER) VALUES (2, 'Alimentos', 'Supermaxi', 'Juan Perez')";
        String sql3 = "INSERT INTO STORE (COD, NAME, CATEGORY, OWNER) VALUES (3, 'licores', 'TO-GO', 'Emily Caminos')";

        List<String> listSql = new ArrayList<>();
        listSql.add(sql1);
        listSql.add(sql2);
        listSql.add(sql3);

        return listSql;
    }

    private void executeSql(String sql) {
        try {
            jdbcTemplate.execute(sql);
        } catch (DataAccessException e) {
            log.error("Error: " + e.getMessage());
        }
    }

}
