package com.paulohva.workshopspringbootmongodb.repository;

import com.paulohva.workshopspringbootmongodb.domain.Post;
import com.paulohva.workshopspringbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
