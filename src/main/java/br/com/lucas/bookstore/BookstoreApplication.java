package br.com.lucas.bookstore;

import br.com.lucas.bookstore.service.impl.DBServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
		System.out.println("Se mais pessoas valorizasse o lar mais do que o ouro o mundo seria um lugar melhor 'thorin'");

	}

}
