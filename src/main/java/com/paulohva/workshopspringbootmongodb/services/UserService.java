package com.paulohva.workshopspringbootmongodb.services;

import com.paulohva.workshopspringbootmongodb.domain.User;
import com.paulohva.workshopspringbootmongodb.dto.UserDTO;
import com.paulohva.workshopspringbootmongodb.repository.UserRepository;

import com.paulohva.workshopspringbootmongodb.services.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id) {
        Optional<User> user = repo.findById(id);
        return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User user) {
        return repo.insert(user);
    }
    
    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

	public void delete(String id) {
        User user = findById(id);
        repo.delete(user);
	}

	public User update(User obj) {
        User newObj = findById(obj.getId());
        newObj = updateData(newObj, obj);
        return repo.save(newObj);
	}

    private User updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
        return newObj;
    }

}
