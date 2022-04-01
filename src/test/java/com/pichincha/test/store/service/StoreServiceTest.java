package com.pichincha.test.store.service;

import com.pichincha.store.service.impl.StoreServiceImpl;
import com.pichincha.store.service.mapper.StoreMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 
 * @author jhonny calderon
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = StoreServiceImpl.class)
class StoreServiceTest {

  @Autowired
  private StoreServiceImpl storeService;
  
  @MockBean
  private StoreMapper storeMapper;




  @Test
  void givenNotify_whenHttpStatusCodeException_thenReturnError() {
  }
}
