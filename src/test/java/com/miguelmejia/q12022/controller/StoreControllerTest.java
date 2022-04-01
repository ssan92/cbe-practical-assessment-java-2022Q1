package com.miguelmejia.q12022.controller;

import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.service.StoreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StoreControllerTest {
    @InjectMocks
    private StoreController storeController;

    @Mock
    private StoreService storeService;

    @Test
    public void shouldSaveNewStore() {
        doNothing().when(storeService).save(any());
        storeController.createStore(StorePresenter.builder().build());
        verify(storeService).save(any());
    }

    @Test
    public void shouldFindByName() {
        when(storeService.findByName(any())).thenReturn(StorePresenter.builder().id(1).build());
        StorePresenter fakeName = storeController.findByName("fake name");
        Assertions.assertEquals(1, fakeName.getId());
    }
}
