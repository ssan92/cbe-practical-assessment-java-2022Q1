package com.miguelmejia.q12022.service.impl;

import com.miguelmejia.q12022.entity.Store;
import com.miguelmejia.q12022.entity.User;
import com.miguelmejia.q12022.presenter.StorePresenter;
import com.miguelmejia.q12022.presenter.UserPresenter;
import com.miguelmejia.q12022.repository.StoreRepository;
import com.miguelmejia.q12022.repository.UserRepository;
import com.miguelmejia.q12022.service.ProductService;
import com.miguelmejia.q12022.service.StoreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(StorePresenter storePresenter) {
        User user = userRepository.findById(storePresenter.getUserPresenter().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "No Existe el usuario con este Id"));
        Store store = fromPresenter(storePresenter);
        store.setUser(user);
        storeRepository.save(store);
    }

    @Override
    public StorePresenter findByName(String name) {
        return toPresenter(storeRepository.findByName(name));
    }

    @Override
    public Store findById(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "No existe la tienda con este Id"));
    }

    @Override
    public void update(StorePresenter storePresenter) {
        Store store = storeRepository.findById(storePresenter.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "No existe la tienda a modificar"));
        User user = userRepository.findById(storePresenter.getUserPresenter().getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "No Existe el usuario con este Id"));
        store.setUser(user);
        store.setCategory(storePresenter.getCategory());
        store.setName(storePresenter.getName());
        storeRepository.save(store);
    }

    @Override
    public void deleteEmptyStore(Long id) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "No existe la tienda a modificar"));
        if (productService.findAllByStore(id).isEmpty()) {
            storeRepository.delete(store);
        } else {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "La tienda no se encuentra vacía");
        }
    }

    @Override
    public List<StorePresenter> findAll() {
        return storeRepository.findAll().stream().map(this::toPresenter).collect(Collectors.toList());
    }

    private Store fromPresenter(StorePresenter storePresenter) {
        return modelMapper.map(storePresenter, Store.class);
    }

    private StorePresenter toPresenter(Store store) {
        StorePresenter storePresenter = modelMapper.map(store, StorePresenter.class);
        storePresenter.setUserPresenter(modelMapper.map(store.getUser(), UserPresenter.class));
        storePresenter.setProducts(productService.findAllByStore(store.getId()));
        return storePresenter;
    }
}
