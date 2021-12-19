package com.swapnil.full.service;

import com.swapnil.full.entity.Department;
import com.swapnil.full.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList(){
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId){
       return  departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteDepartment(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department udpateDepartment(Long departmentId, Department department) {
        Department department1 = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            department1.setDepartmentName(department.getDepartmentName());
        }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            department1.setDepartmentCode(department.getDepartmentCode());
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())) {
            department1.setDepartmentAddress(department.getDepartmentAddress());
        }

        departmentRepository.save(department1);
        Department updatedDepartment = departmentRepository.getById(departmentId);
        return updatedDepartment;

    }

    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }


}
