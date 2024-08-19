package com.analysis.knowledge.RestMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.analysis.knowledge.RestMongoDB.entity.Employee;

@Repository
public interface MongoDBEmployeeRepo extends MongoRepository<Employee, String> {

}
