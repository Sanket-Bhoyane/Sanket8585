package com.example.jpa;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.jpa.entity.Post;
import com.example.jpa.entity.User;
import com.example.jpa.repository.PostRepository;
import com.example.jpa.repository.UserRepository;

@SpringBootApplication
public class SocialMediaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMediaBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(UserRepository userRepository, PostRepository postRepository) {
		return args -> {

			User u = new User();
			u.setName("amit");
			u.setFollwer(500);
			u.setGender("male");
			userRepository.save(u);

			postRepository.save(new Post(2, "p1", 11, "excellent", u));
			postRepository.save(new Post(3, "p2", 12, "coool", u));
			postRepository.save(new Post(4, "p3", 13, "extraordinary", u));
			postRepository.save(new Post(5, "p4", 14, "savage", u));

			User u2 = new User();
			u2.setName("sanket");
			u2.setFollwer(800);
			u2.setGender("males");
			userRepository.save(u2);

			postRepository.save(new Post(6, "p5", 110, "good", u2));
			postRepository.save(new Post(7, "p6", 125, "coools", u2));
			postRepository.save(new Post(8, "p7", 131, "ur great", u2));
			postRepository.save(new Post(9, "p8", 14, "sanky", u2));

			User u3 = new User();
			u3.setName("pratiksha");
			u3.setFollwer(600);
			u3.setGender("female");
			userRepository.save(u3);

			postRepository.save(new Post(10, "p9", 111, "god", u3));
			postRepository.save(new Post(11, "p10", 15, "cols", u3));
			postRepository.save(new Post(12, "p11", 1031, "u great", u3));
			postRepository.save(new Post(13, "p12", 148, "sank", u3));
			System.out.println("---- saved ------");
			User ue = userRepository.findById(1).get();
			List<Post> pp = ue.getPostlist();
			for (Post p : pp)
				System.out.println(p.getP_name() + " " + p.getLike());

			System.out.println("-----Query annotation test-----");
			List<User> lc = userRepository.findByNameLike("pratiksha");
			for (User t : lc)
				System.out.println(t.getName() + " " + t.getGender());
			Iterable<User> lc1 = userRepository.findUsersByname("pratiksha");
			for (User t : lc1)
				System.out.println(t.getName() + " " + t.getGender());

			User lc2 = userRepository.findByGenderLike("female");
			System.out.println(lc2.getGender() + " " + lc2.getName());
		};

	}

}
