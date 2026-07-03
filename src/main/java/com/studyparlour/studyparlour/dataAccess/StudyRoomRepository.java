package com.studyparlour.studyparlour.dataAccess;

import com.studyparlour.studyparlour.models.StudyRoom;
import com.studyparlour.studyparlour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long> {
    Optional<StudyRoom> findByOwner(User owner);
}
