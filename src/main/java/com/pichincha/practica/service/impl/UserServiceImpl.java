package com.pichincha.practica.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pichincha.practica.dto.UserDTO;
import com.pichincha.practica.exception.ApplicationException;
import com.pichincha.practica.model.User;
import com.pichincha.practica.repository.UserRepository;
import com.pichincha.practica.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repo;

	@Override
	public UserDTO save(UserDTO user) throws ApplicationException {
		return repo.save(user.toEntity()).toDTO();
	}

	@Override
	public UserDTO update(Long id, UserDTO user) throws ApplicationException {
		Optional<UserDTO> data = findById(id);
		if (data.isPresent()) {
			User objUser = user.toEntity();
			objUser.setUser(user.getUser());
			objUser.setId(id);
			objUser.setCreationDate(data.get().getCreationDate());
			return repo.save(objUser).toDTO();
		} else {
			throw new ApplicationException("Not exists");
		}
	}

	@Override
	public List<UserDTO> findAll() {
		List<User> users = repo.findAll();		
		return users.stream().map(c -> c.toDTO()).collect(Collectors.toList());
	}

	@Override
	public Optional<UserDTO> findById(Long id) throws ApplicationException {
		Optional<User>  user = repo.findById(id);
		Optional<UserDTO> userDTO = Optional.empty();
		if(user.isPresent()) {			
			userDTO =  Optional.of(user.get().toDTO());
		}
		return userDTO;
	}

	@Override
	public void delete(Long id) throws ApplicationException {
		Optional<UserDTO> data = findById(id);
		if (data.isPresent()) {
			repo.deleteById(id);
		} else {
			throw new ApplicationException("Not exists");
		}
		
	}

}