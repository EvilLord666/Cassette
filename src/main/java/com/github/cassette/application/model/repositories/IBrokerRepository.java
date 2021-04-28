
package com.github.cassette.application.model.repositories;

import com.github.cassette.application.model.entities.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBrokerRepository extends JpaRepository <BrokerEntity, Integer> {
}
