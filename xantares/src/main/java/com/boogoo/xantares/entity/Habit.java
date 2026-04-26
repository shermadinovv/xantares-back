package com.boogoo.xantares.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "habits")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private HabitType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Привязка к пользователю
}