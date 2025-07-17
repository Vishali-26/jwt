

package com.example.assessment.services;

import com.example.assessment.models.RegisterDetails;
import com.example.assessment.models.ToDo;
import com.example.assessment.repository.RegisterDetailsRepository;
import com.example.assessment.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    ToDoRepository todoRepository;

    @Autowired
    private RegisterDetailsRepository registerDetailRepository;

    public String assignTaskToEmployee(int empID, Todo todo) {
        RegisterDetails employee = registerDetailRepository.findById(empID)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        todo.setEmployee(employee);
        todoRepository.save(todo);

        return "Task assigned to employee with ID: " + empID;
    }

    public List<Todo> getTodoByEmployee(int empID) {
        return todoRepository.findByEmployeeEmpID(empID);
    }


}