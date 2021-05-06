package com.github.cassette.model.repositories;

import com.github.cassette.model.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMessageRepository extends JpaRepository <Message, Integer> {
}
