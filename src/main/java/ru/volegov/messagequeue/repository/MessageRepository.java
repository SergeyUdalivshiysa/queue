package ru.volegov.messagequeue.repository;

import lombok.ToString;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.volegov.messagequeue.entities.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
    @Query("select m from Message m where m.id = (select min(id) from m)")
    Message findFirst();

    @Query("select m from Message m where m.id = (select max(id) from m)")
    Message findLast();

    /*Message findFirstByOrderByIdAsc();
    Message findFirstByOrderByIdDesc();*/

}
