package com.studyparlour.studyparlour.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateStudyRoomRequestDto {
    @NotBlank
    @Size(min=4, max = 20)
    private String name;

    @NotNull
    private Boolean isTemporary;

    @NotNull
    @Min(2)
    @Max(6)
    private Integer maxParticipants;
}
