package com.codeWithMayank.demo.controller;

import com.codeWithMayank.demo.entity.Department;
import com.codeWithMayank.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public String addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return "Department Added Successfully";
    }

    @GetMapping("/departments")
    public List<Department> listDepartment(){
        return departmentService.listDepartment();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> fetchDepartment(@PathVariable("id") long departmentId) {
        return departmentService.fetchDepartment(departmentId);
    }

    @GetMapping("/departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.getDepartmentByName(departmentName);
    }

    @GetMapping("/departments/code/{code}")
    public Department getDepartmentByCode(@PathVariable("code") String departmentCode){
        return departmentService.getDepartmentByCode(departmentCode);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartment(@PathVariable("id") long departmentId){
        departmentService.deleteDepartment(departmentId);
        return "Record Deleted Successfully";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") long departmentId,
                                       @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }
}
