package com.studyparlour.studyparlour.core.mappers;

import com.studyparlour.studyparlour.dto.StudyRoomResponseDto;
import com.studyparlour.studyparlour.models.StudyRoom;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudyRoomMapper {
    //Entity -> Response
    @Mapping(source = "owner.id", target = "ownerId")
    @Mapping(source = "owner.username", target = "ownerUsername")
    StudyRoomResponseDto studyRoomToStudyRoomResponseDto(StudyRoom studyRoom);
}
