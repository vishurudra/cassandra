package com.example.democassandra.repository;

import com.example.democassandra.entity.Book;
import org.springframework.data.cassandra.core.mapping.BasicMapId;
import org.springframework.data.cassandra.core.mapping.MapId;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book, MapId> {
    //MapId mapId = BasicMapId.id("isbn", …).with("title", …);

}