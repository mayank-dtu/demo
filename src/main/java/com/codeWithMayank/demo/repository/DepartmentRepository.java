package com.codeWithMayank.demo.repository;

import com.codeWithMayank.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByDepartmentNameIgnoreCase(String departmentName);

    @Query(value = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT.department_Code=:depcode",nativeQuery = true)
    Department searchDepartmentCode(@Param("depcode") String departmentCode);
}

