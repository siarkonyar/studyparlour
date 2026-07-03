package com.studyparlour.studyparlour.services;

import com.studyparlour.studyparlour.core.mappers.StudyRoomMapper;
import com.studyparlour.studyparlour.dataAccess.StudyRoomRepository;
import com.studyparlour.studyparlour.dto.CreateStudyRoomRequestDto;
import com.studyparlour.studyparlour.dto.StudyRoomResponseDto;
import com.studyparlour.studyparlour.models.StudyRoom;
import com.studyparlour.studyparlour.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyRoomService {
    private final StudyRoomRepository studyRoomRepository;
    private final StudyRoomMapper studyRoomMapper;

    public StudyRoomResponseDto createRoom(CreateStudyRoomRequestDto requestDto, User owner) {
        StudyRoom room = StudyRoom.builder()
                .name(requestDto.getName())
                .isTemporary(requestDto.getIsTemporary())
                .maxParticipants(requestDto.getMaxParticipants())
                .owner(owner)
                .build();

        StudyRoom saved = studyRoomRepository.save(room);

        return studyRoomMapper.studyRoomToStudyRoomResponseDto(room);
    }
}
