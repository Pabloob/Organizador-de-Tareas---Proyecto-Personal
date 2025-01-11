package com.example.organizador_tareas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String taskName;

    @Column()
    private String description;

    @Column(length = 20)
    private String priority;

    private LocalDate expirationDate;

    @Column(nullable = false)
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
