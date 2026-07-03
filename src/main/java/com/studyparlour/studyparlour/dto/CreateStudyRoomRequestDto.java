package com.studyparlour.studyparlour.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateStudyRoomRequestDto {
    @NotBlank
    @Size(min=4, max = 20)
    private String name;

    @NotBlank
    private Boolean isTemporary;

    @NotBlank
    private Integer maxParticipants;
}
