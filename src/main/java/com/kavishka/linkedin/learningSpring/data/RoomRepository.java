package com.kavishka.linkedin.learningSpring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room,Long> { // Class and the type of primary key
    List<Room> findRoomByName(String name);
}
