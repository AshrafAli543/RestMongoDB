package com.analysis.knowledge.RestMongoDB.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "Employee")
public class Employee {

	
	@Id
	@JsonProperty(value = "id")
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
