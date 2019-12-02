package com.nxtlab.reactivespringboot.repository;

import com.nxtlab.reactivespringboot.model.Book;
import org.springframework.context.annotation.Profile;
import org.springframework.data.cassandra.repository.ReactiveCassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Profile({"prod", "cassandraTest"})
public interface BookRepository extends ReactiveCassandraRepository<Book, UUID> {}
