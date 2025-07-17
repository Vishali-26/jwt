

package com.example.assessment.repository;

import com.example.assessment.models.RegisterDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterDetails,Integer> {


    RegisterDetails findByEmail(String email);

    Optional<RegisterDetails> findByUsername(String username);


}