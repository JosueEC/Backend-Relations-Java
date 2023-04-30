package com.example.springjpaadvance;

import com.example.springjpaadvance.domain.Address;
import com.example.springjpaadvance.domain.Client;
import com.example.springjpaadvance.domain.Product;
import com.example.springjpaadvance.domain.User;
import com.example.springjpaadvance.repositorys.AddressRepository;
import com.example.springjpaadvance.repositorys.ClientRepository;
import com.example.springjpaadvance.repositorys.ProductRepository;
import com.example.springjpaadvance.repositorys.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Set;

@SpringBootApplication
public class SpringJpaAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaAdvanceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner (UserRepository userRepository, ClientRepository clientRepository, AddressRepository addressRepository, ProductRepository productRepository) {
		return args -> {
			// Client and User
			User user1 = userRepository.save(new User(null,"josue-cruz","123"));

			// Asignacion @OneToOne
			Client client1 = clientRepository.save(new Client(null,"Josue Evangelista Cruz", user1, null, null));

			// Address
			Address address1 = addressRepository.save(new Address(null, "Negrete", "15", client1));
			Address address2 = addressRepository.save(new Address(null, "Allende", "10", client1));
			Address address3 = addressRepository.save(new Address(null, "Morelos", "5", client1));
			Address address4 = addressRepository.save(new Address(null, "Iturbe", "2", client1));

			// Products
			Product product1 = productRepository.save(new Product(null, "Teclado Asus", 200.00));
			Product product2 = productRepository.save(new Product(null, "Mouse Logitech", 450.99));
			Product product3 = productRepository.save(new Product(null, "Monitor Acer", 1200.50));
			Product product4 = productRepository.save(new Product(null, "Escritorio elevable", 9000.00));

			// Asignacion @OneToMany
			client1.setAddresses(Set.of(address1, address2, address3, address4));
			// Asignacion @ManyToMany
			client1.setProducts(Set.of(product1, product2, product3));

			Client josue = clientRepository.save(client1);
			System.out.println("Client name: " + josue.getName());
			System.out.println("User name: " + josue.getUser().getUsername());
			josue.getAddresses().forEach(address -> {
				System.out.println("Address: " + address.getStreet() + " No." + address.getNumber() );
			});
			System.out.println("-----------------------------------------------------------------------");
			josue.getProducts().forEach(product -> {
				System.out.println("Product Description: " + product.getName() + " $" + product.getPrice());
			});
 			System.out.println(josue);
		};
	}
}

// Nota: Cuando hacemos un save de una entidad que ya antes fue creada, osea que ya tiene un id asignado, JPA
// interpreta que se trata de un UPDATE y no una creacion como tal, debido a que el registro ya existe
