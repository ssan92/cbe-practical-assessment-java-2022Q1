package com.pichincha.chapter.service;

import com.pichincha.chapter.domain.jpa.Store;
import com.pichincha.chapter.repository.StoreRepository;
import com.pichincha.chapter.service.impl.StoreServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith({MockitoExtension.class, SpringExtension.class})
public class StoreServiceTest {

    @InjectMocks
    private StoreServiceImpl storeService;

    @Mock
    private StoreRepository storeRepository;

    @Test
    void shouldGetStoreByName() {
        doReturn(getListStore())
                .when(storeRepository).findByName(any());
        Store store = storeService.getStoreByName("Tienda x");
        Assert.assertNotNull(store);
        Assert.assertSame("Tienda x", store.getName());
    }

    private List<Store> getListStore() {
        List<Store> listStore = new ArrayList<>();
        listStore.add(getStore());
        return listStore;
    }

    private Store getStore() {
        return Store.builder()
                .name("Tienda x")
                .cod(2L)
                .category("alimentis")
                .owner("Chris")
                .build();
    }

}
