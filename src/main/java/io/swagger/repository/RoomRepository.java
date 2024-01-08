package io.swagger.repository;

import io.swagger.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Integer> {
}
