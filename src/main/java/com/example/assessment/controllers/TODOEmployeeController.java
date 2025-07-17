

package com.example.assessment.controllers;

import com.example.assessment.models.ToDo;
import com.example.assessment.repository.RegisterDetailsRepository;
import com.example.assessment.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class EmpTodoController {

    @Autowired
    TodoService todoServices;


    @GetMapping("/get/{empID}")
    public List<Todo> getTodoByEmployee(@PathVariable int empID){
        return todoServices.getTodoByEmployee(empID);
    }

    @PostMapping("/assign/{empID}")
    public String assignTask(@PathVariable int empID, @RequestBody Todo todo) {
        return todoServices.assignTaskToEmployee(empID, todo);
    }


}