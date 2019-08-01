package com.paulohva.workshopspringbootmongodb;

import com.paulohva.workshopspringbootmongodb.domain.Post;
import com.paulohva.workshopspringbootmongodb.domain.User;
import com.paulohva.workshopspringbootmongodb.dto.AuthorDTO;
import com.paulohva.workshopspringbootmongodb.dto.CommentDTO;
import com.paulohva.workshopspringbootmongodb.repository.PostRepository;
import com.paulohva.workshopspringbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.of(2018,3,20), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, LocalDate.of(2018,3,22), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));

        post1.setComments(Arrays.asList(c1, c2));
        post2.setComments(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        maria.setPosts(Arrays.asList(post1, post2));

        userRepository.save(maria);
    }
}
