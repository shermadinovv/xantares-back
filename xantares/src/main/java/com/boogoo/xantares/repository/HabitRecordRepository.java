package com.boogoo.xantares.repository;

import com.boogoo.xantares.entity.HabitRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HabitRecordRepository extends JpaRepository<HabitRecord, Long> {
    List<HabitRecord> findByHabitId(Long habitId);
}
