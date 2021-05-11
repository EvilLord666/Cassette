package com.github.cassette.model.repositories;

import com.github.cassette.model.entities.MessageStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageStatusRepository extends JpaRepository<MessageStatusEntity, Long> {
    
}
