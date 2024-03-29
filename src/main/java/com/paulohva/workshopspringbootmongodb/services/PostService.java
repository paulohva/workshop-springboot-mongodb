package com.paulohva.workshopspringbootmongodb.services;

import com.paulohva.workshopspringbootmongodb.domain.Post;
import com.paulohva.workshopspringbootmongodb.domain.User;
import com.paulohva.workshopspringbootmongodb.dto.UserDTO;
import com.paulohva.workshopspringbootmongodb.repository.PostRepository;
import com.paulohva.workshopspringbootmongodb.repository.UserRepository;
import com.paulohva.workshopspringbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll() {
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text) {
        return repo.findByTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
        return repo.fullSearch(text,minDate,maxDate);
    }
}
