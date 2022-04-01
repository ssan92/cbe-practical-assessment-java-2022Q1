package com.miguelmejia.q12022.service;

import com.miguelmejia.q12022.entity.Store;
import com.miguelmejia.q12022.entity.User;
import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.presenter.UserPresenter;
import com.miguelmejia.q12022.repository.StoreRepository;
import com.miguelmejia.q12022.repository.UserRepository;
import com.miguelmejia.q12022.service.impl.StoreServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StoreServiceTest {
    @InjectMocks
    private StoreService storeService = new StoreServiceImpl();

    @Mock
    private StoreRepository storeRepository;

    @Mock
    private UserRepository userRepository;

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @Test
    public void shouldSaveStore() {
        when(userRepository.findById(any())).thenReturn(Optional.of(User.builder().build()));
        when(storeRepository.save(any())).thenReturn(Store.builder().build());
        storeService.save(StorePresenter.builder().userPresenter(UserPresenter.builder().build()).build());
        verify(storeRepository).save(any());
    }

    @Test
    public void shouldSaveStore_ExceptOnNoUserId() {
        when(userRepository.findById(any())).thenReturn(Optional.empty());
        Assertions.assertThrows(ResponseStatusException.class, () -> storeService.save(StorePresenter.builder().userPresenter(UserPresenter.builder().build()).build()));
    }

    @Test
    public void shouldFindByName() {
        when(storeRepository.findByName(any())).thenReturn(Store.builder().id(1).user(User.builder().build()).build());
        StorePresenter fakeName = storeService.findByName("fakeName");
        Assertions.assertEquals(1, fakeName.getId());
    }

    @Test
    public void shouldUpdateStore() {
        when(storeRepository.findById(any())).thenReturn(Optional.of(Store.builder().build()));
        when(userRepository.findById(any())).thenReturn(Optional.of(User.builder().build()));
        when(storeRepository.save(any())).thenReturn(Store.builder().build());
        storeService.update(StorePresenter.builder().userPresenter(UserPresenter.builder().build()).build());
        verify(storeRepository).save(any());
    }
}
