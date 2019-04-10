package com.velmen.spring5webapp.bootstrap;

import com.velmen.spring5webapp.model.Author;
import com.velmen.spring5webapp.model.Book;
import com.velmen.spring5webapp.model.Publisher;
import com.velmen.spring5webapp.repositories.AuthorRepository;
import com.velmen.spring5webapp.repositories.BookRepository;
import com.velmen.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher publisher1 = new Publisher("Harper Collins");
        publisherRepository.save(publisher1);
        Book ddd = new Book("Domain Driven Design", "1234", publisher1);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher1);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher2 = new Publisher("Worx");
        publisherRepository.save(publisher2);
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher2);
        rod.getBooks().add(noEJB);
        noEJB.setPublisher(publisher2);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
