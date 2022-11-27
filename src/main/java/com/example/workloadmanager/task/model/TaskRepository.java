package com.example.workloadmanager.task.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskDO, Long> {

  List<TaskDO> findByUserId(long userId);
}
