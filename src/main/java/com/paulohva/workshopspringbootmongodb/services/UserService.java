package com.paulohva.workshopspringbootmongodb.services;

import com.paulohva.workshopspringbootmongodb.domain.User;
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

}
