package com.velmen.spring5webapp.repositories;

import com.velmen.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
