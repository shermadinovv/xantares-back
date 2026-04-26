package com.boogoo.xantares.repository;

import com.boogoo.xantares.entity.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HabitRepository extends JpaRepository<Habit, Long> {
    List<Habit> findByUserId(Long userId); // Найти все привычки конкретного юзера
}