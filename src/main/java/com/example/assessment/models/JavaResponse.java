
package com.example.assessment.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JavaResponse {
    private String token;
    private String username;
    private String roles;
}