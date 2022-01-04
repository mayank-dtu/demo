package com.codeWithMayank.demo.service;

import com.codeWithMayank.demo.entity.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    public Department addDepartment(Department department);

    public List<Department> listDepartment();

    public Optional<Department> fetchDepartment(long departmentId);

    public Department getDepartmentByName(String departmentName);

    public Department getDepartmentByCode(String departmentCode);

    public void deleteDepartment(long departmentId);

    public Department updateDepartment(long departmentId, Department department);
}
