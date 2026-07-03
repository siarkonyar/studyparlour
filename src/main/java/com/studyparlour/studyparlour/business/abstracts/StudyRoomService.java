package com.studyparlour.studyparlour.business.abstracts;

import com.studyparlour.studyparlour.dto.CreateStudyRoomRequestDto;
import com.studyparlour.studyparlour.dto.StudyRoomResponseDto;
import com.studyparlour.studyparlour.models.User;

import java.util.List;

public interface StudyRoomService {
    public StudyRoomResponseDto createRoom(CreateStudyRoomRequestDto requestDto, User owner);
    public StudyRoomResponseDto getRoomById(Long id);
    public List<StudyRoomResponseDto> getStudyRoomsByOwner(User owner);
}
