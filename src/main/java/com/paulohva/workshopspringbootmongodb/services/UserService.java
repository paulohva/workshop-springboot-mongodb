package com.paulohva.workshopspringbootmongodb.services;

import com.paulohva.workshopspringbootmongodb.domain.User;
import com.paulohva.workshopspringbootmongodb.repository.UserRepository;
import com.paulohva.workshopspringbootmongodb.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
