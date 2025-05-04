package com.codeid.eshopper.service.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeid.eshopper.entities.Department;
import com.codeid.eshopper.repository.DepartmentRepository;
import com.codeid.eshopper.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{
    
    private final DepartmentRepository departmentRepository;

    //constructor injection
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public List<Department> findAllDepartment() {
       return departmentRepository.findAll();
    }
    
}
