package com.bvr;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedDatabasePatternApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SharedDatabasePatternApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(SharedDatabasePatternApplication.class);
	
	@Autowired 
	private BookRepository repository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		log.info("DB pattern Application started");
		
		repository.save(new Book("Javascript"));
		repository.save(new Book("Python"));
		repository.save(new Book("PySpark"));
		repository.save(new Book("Java"));
		repository.save(new Book("GoLang"));
		repository.save(new Book("Erlang"));
		repository.save(new Book("Nodejs"));
		repository.save(new Book("PyTorch"));
		
		log.info("Created Book Records");
		
		
		System.out.println("\n Find all records");
		
		repository.findAll().forEach(x -> System.out.println(x));

		System.out.println("\n Find By Id records");
		
		repository.findById(7L).ifPresent(x -> System.out.println(x));

		System.out.println("\n Find By Name records");
		
		repository.findByName("Java").forEach(x -> System.out.println(x));
		
		
		
		
		
		/*
		System.out.println("\n Delete by Book ID ");
		
		Book bookToDelete = repository.findById(108L).get();
		
		System.out.println("Book to delete : " + bookToDelete.getName());
		
		repository.delete(bookToDelete);
		
		
		
		
		System.out.println("\n Delete by Book ID ");
		
		repository.deleteById(155L);

		
		
		
		System.out.println("\n Delete Book by title");
		
		repository.findByName("Java").forEach(book -> {
			System.out.println("Deleting Book : " + book.getName());
			repository.delete(book);
		});
		
		
		
		System.out.println("\n Delete all by Book ID ");
		
		repository.deleteAllById(Arrays.asList(102L, 103L, 154L, 156L, 207L, 208L));
		
		
		System.out.println("\n Delete By NameD ");
		
		repository.deleteAll(repository.findByName("Javascript"));

		*/
		
		System.out.println("\n Updating Record");
		
		repository.findById(159L).ifPresent(x -> {
			System.out.println(x);
			x.setName("Adversarial Robustness Toolbox");
			repository.save(x);
		});
		
	}

	
	
}
