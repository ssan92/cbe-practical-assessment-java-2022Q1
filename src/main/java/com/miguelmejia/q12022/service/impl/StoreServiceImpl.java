package com.miguelmejia.q12022.service.impl;

import com.miguelmejia.q12022.entity.Store;
import com.miguelmejia.q12022.entity.User;
import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.repository.StoreRepository;
import com.miguelmejia.q12022.repository.UserRepository;
import com.miguelmejia.q12022.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(StorePresenter storePresenter) {
        User user = userRepository.findById(storePresenter.getUserPresenter().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Existe el usuario con este Id"));
        Store store = fromPresenter(storePresenter);
        store.setUser(user);
        storeRepository.save(store);
    }

    private Store fromPresenter(StorePresenter storePresenter) {
        return modelMapper.map(storePresenter, Store.class);
    }
}
