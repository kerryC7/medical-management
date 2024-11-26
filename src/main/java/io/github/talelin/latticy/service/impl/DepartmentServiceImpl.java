package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.department.CreateOrUpdateDepartmentDTO;
import io.github.talelin.latticy.mapper.DepartmentMapper;
import io.github.talelin.latticy.model.DepartmentDO;
import io.github.talelin.latticy.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 * 科室服务实现类
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public boolean createDepartment(CreateOrUpdateDepartmentDTO validator) {
        DepartmentDO department = new DepartmentDO();
        department.setDepartmentName(validator.getDepartmentName());
        department.setDescription(validator.getDescription());
        department.setNumberOfStaff(validator.getNumberOfStaff());
        return departmentMapper.insert(department) > 0;
    }

    @Override
    public List<DepartmentDO> getDepartmentByKeyword(String q) {
        return departmentMapper.selectByDepartmentNameLikeKeyword(q);
    }

    @Override
    public boolean updateDepartment(DepartmentDO department, CreateOrUpdateDepartmentDTO validator) {
        department.setDepartmentName(validator.getDepartmentName());
        department.setDescription(validator.getDescription());
        department.setNumberOfStaff(validator.getNumberOfStaff());
        return departmentMapper.updateById(department) > 0;
    }

    @Override
    public DepartmentDO getById(Integer id) {
        return departmentMapper.selectById(id);
    }

    @Override
    public List<DepartmentDO> findAll() {
        return departmentMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return departmentMapper.deleteById(id) > 0;
    }
}
