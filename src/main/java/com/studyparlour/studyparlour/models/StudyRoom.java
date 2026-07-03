package com.studyparlour.studyparlour.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "study_rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Boolean isTemporary;

    @Column(nullable = false)
    private Integer maxParticipants;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
