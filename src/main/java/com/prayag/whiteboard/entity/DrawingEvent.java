package com.prayag.whiteboard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
public class DrawingEvent {

    @Id
    @GeneratedValue
    private UUID id;

    private UUID boardId;
    private UUID userId;

    private float x;
    private float y;

    private String color;
    private int strokeWidth;

    private LocalDateTime createdAt = LocalDateTime.now();
}