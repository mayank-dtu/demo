package com.codeWithMayank.demo.service;

import com.codeWithMayank.demo.entity.Department;
import com.codeWithMayank.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> fetchDepartment(long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    @Override
    public Department getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

    @Override
    public Department getDepartmentByCode(String departmentCode) {
        return departmentRepository.searchDepartmentCode(departmentCode);
    }

    @Override
    public void deleteDepartment(long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(long departmentId, Department department) {
        Department depFromRepo = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
        !"".equalsIgnoreCase(department.getDepartmentName()))
            depFromRepo.setDepartmentName(department.getDepartmentName());

        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode()))
            depFromRepo.setDepartmentCode(department.getDepartmentCode());

        if (Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress()))
            depFromRepo.setDepartmentAddress(department.getDepartmentAddress());

        return departmentRepository.save(depFromRepo);
    }
}
