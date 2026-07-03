package com.studyparlour.studyparlour.business.concretes;

import com.studyparlour.studyparlour.business.abstracts.StudyRoomService;
import com.studyparlour.studyparlour.core.mappers.StudyRoomMapper;
import com.studyparlour.studyparlour.dataAccess.abstracts.StudyRoomRepository;
import com.studyparlour.studyparlour.dto.CreateStudyRoomRequestDto;
import com.studyparlour.studyparlour.dto.StudyRoomResponseDto;
import com.studyparlour.studyparlour.models.StudyRoom;
import com.studyparlour.studyparlour.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudyRoomServiceImpl implements StudyRoomService {
    private final StudyRoomRepository studyRoomRepository;
    private final StudyRoomMapper studyRoomMapper;

    @Override
    public StudyRoomResponseDto createRoom(CreateStudyRoomRequestDto requestDto, User owner) {
        StudyRoom room = StudyRoom.builder()
                .name(requestDto.getName())
                .isTemporary(requestDto.getIsTemporary())
                .maxParticipants(requestDto.getMaxParticipants())
                .owner(owner)
                .build();

        StudyRoom saved = studyRoomRepository.save(room);

        return studyRoomMapper.studyRoomToStudyRoomResponseDto(saved);
    }

    @Override
    public StudyRoomResponseDto getRoomById(Long id){
        StudyRoom room = studyRoomRepository.findById(id).orElseThrow();
        return studyRoomMapper.studyRoomToStudyRoomResponseDto(room);
    }
}
