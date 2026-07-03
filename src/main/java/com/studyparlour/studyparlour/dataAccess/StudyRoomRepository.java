package com.studyparlour.studyparlour.dataAccess;

import com.studyparlour.studyparlour.models.StudyRoom;
import com.studyparlour.studyparlour.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long> {
    List<StudyRoom> findByOwner(User owner);
}
