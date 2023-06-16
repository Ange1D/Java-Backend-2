package org.bedu.hotel.repository;

import org.bedu.hotel.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r LEFT JOIN r.guests WHERE r.id = :id")
    Optional<Room> findByIdWithGuests(long id);
}
