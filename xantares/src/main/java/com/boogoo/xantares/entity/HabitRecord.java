package com.boogoo.xantares.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "habit_records")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabitRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date; // Дата записи

    private Integer value; // Значение: для BOOLEAN это 0 или 1, для COUNTER - число

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;
}
