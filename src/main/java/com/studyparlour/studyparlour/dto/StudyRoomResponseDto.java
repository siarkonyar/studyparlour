package com.studyparlour.studyparlour.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudyRoomResponseDto {
    private Long id;
    private String name;
    private Boolean isTemporary;
    private Integer maxParticipants;
    private LocalDateTime createdAt;
    private Long ownerId;
    private String ownerUsername;
}
