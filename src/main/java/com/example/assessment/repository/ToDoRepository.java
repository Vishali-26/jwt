

package com.example.assessment.repository;

import com.example.assessment.models.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<ToDo,Integer> {
    List<ToDo> findByEmployeeEmpID(int empID);
}