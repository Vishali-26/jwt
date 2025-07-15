

package com.example.assessment.repository;

import com.example.assessment.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegisterDetailsRepository extends JpaRepository<RegisterDetails, Integer> {

    RegisterDetails findByEmail(String email);

    Optional<RegisterDetails> findByUserName(String userName);

    List<RegisterDetails> findByRoles_Name(String roleName);
}