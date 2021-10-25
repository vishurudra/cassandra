package com.example.democassandra.repository;


import com.datastax.oss.driver.api.core.ConsistencyLevel;
import com.datastax.oss.driver.api.core.DefaultConsistencyLevel;
import com.example.democassandra.entity.Tutorial;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Consistency;

import java.util.List;
import java.util.UUID;

public interface TutorialRepository extends CassandraRepository<Tutorial, UUID> {
    @AllowFiltering
    List<Tutorial> findByPublished(boolean published);

    @Consistency(value = DefaultConsistencyLevel.LOCAL_ONE)
    List<Tutorial> findByTitleContaining(String title);
}