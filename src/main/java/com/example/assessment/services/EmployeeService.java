


package com.example.assessment.services;

import com.example.assessment.models.RegisterDetails;
import com.example.assessment.models.UserDetailsDto;
import com.example.assessment.repository.RegisterDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    RegisterDetailsRepository registerDetailsRepository;

    public List<RegisterDetails> getMethod() {
        return registerDetailsRepository.findAll();
    }

    public RegisterDetails getEmployeeById(int empId) {
        return registerDetailsRepository.findById(empId).orElse(new RegisterDetails());
    }

    public String addEmployee(RegisterDetails employee) {
        registerDetailsRepository.save(employee);
        return "Employee Added Successfully";
    }

    public String updateEmployee(int empId) {
        RegisterDetails user = registerDetailsRepository.findById(empId)
                .orElseThrow(() -> new RuntimeException("No Such User Present"));


        user.setUserName("UpdatedName");
        user.setEmail("updated@example.com");

        registerDetailsRepository.save(user);
        return "Employee Updated Successfully";
    }

    public String deleteEmployeeById(int empID) {
        registerDetailsRepository.deleteById(empID);
        return "Employee Deleted Successfully";
    }

    // 🔽 New method to get users by role name
    public List<RegisterDetails> getUsersByRole(String roleName) {
        return registerDetailsRepository.findUsersByRoleName(roleName);
    }
}
