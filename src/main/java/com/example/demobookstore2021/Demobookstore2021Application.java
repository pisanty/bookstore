package com.example.demobookstore2021;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demobookstore2021.model.Book;
import com.example.demobookstore2021.model.BookRepository;
import com.example.demobookstore2021.model.Category;
import com.example.demobookstore2021.model.CategoryRepository;

@SpringBootApplication
public class Demobookstore2021Application {
	private static final Logger log = LoggerFactory.getLogger(Demobookstore2021Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Demobookstore2021Application.class, args);
	}
	
	@Bean
	public CommandLineRunner Demobookstore2021(BookRepository srepository, CategoryRepository drepository) {
		return (args) -> {
			log.info("save a couple of books");
			drepository.save(new Category("Detective and Mystery"));
			drepository.save(new Category("History"));
			drepository.save(new Category("Fantasy"));
			
			srepository.save(new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", 2003, "0-7475-5100-6", 24.90, drepository.findByName("Fantasy").get(0)));
			srepository.save(new Book("The Hound of the Baskervilles", "Arthur Conan Doyle", 1902, "978-81-7991-066-5", 15.00, drepository.findByName("Detective and Mystery").get(0)));	
			
			log.info("fetch all books");
			for (Book book : srepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}
