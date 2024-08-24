package com.analysis.knowledge.RestMongoDB.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTO {

	
	@Id
	@JsonProperty(value = "id")
	@NotNull(message = "Id Cannot be Null")
    private String id;

	@JsonProperty(value = "name")
	private String name;

	@JsonProperty(value = "department")
	private String department;

	@JsonProperty(value = "salary")
	private Double salary;
	  
	@JsonProperty(value = "employment_status")
	private String employmentStatus;
	
	
}
