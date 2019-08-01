package com.paulohva.workshopspringbootmongodb.repository;

import com.paulohva.workshopspringbootmongodb.domain.Post;
import com.paulohva.workshopspringbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String text);
}
