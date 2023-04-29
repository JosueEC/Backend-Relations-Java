package com.example.springjpaadvance;

import com.example.springjpaadvance.domain.Client;
import com.example.springjpaadvance.domain.User;
import com.example.springjpaadvance.repositorys.ClientRepository;
import com.example.springjpaadvance.repositorys.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJpaAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAdvanceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (UserRepository userRepository, ClientRepository clientRepository) {
		return args -> {
			User user1 = userRepository.save(new User(null,"josue-cruz","123"));
			Client client1 = clientRepository.save(new Client(null,"Josue Evangelista Cruz", user1));
			System.out.println(client1.toString());
		};
	}

}
