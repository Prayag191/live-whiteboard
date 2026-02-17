package com.prayag.whiteboard.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String email;
}