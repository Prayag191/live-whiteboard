package com.prayag.whiteboard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Board {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
}