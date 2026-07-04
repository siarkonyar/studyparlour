package com.studyparlour.studyparlour.controllers;

import com.studyparlour.studyparlour.business.abstracts.StudyRoomService;
import com.studyparlour.studyparlour.business.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/study-rooms")
@RequiredArgsConstructor
public class StudyRoomController {
    private final StudyRoomService studyRoomService;
    private final UserService userService;


}
