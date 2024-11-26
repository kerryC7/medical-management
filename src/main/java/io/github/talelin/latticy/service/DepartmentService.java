package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.department.CreateOrUpdateDepartmentDTO;
import io.github.talelin.latticy.model.DepartmentDO;

import java.util.List;

/**
 * @author pedro@TaleLin
 * @author Juzi@TaleLin
 * 科室服务接口
 */
public interface DepartmentService {

    /**
     * 新增科室
     * @param validator 数据传输对象
     * @return 是否成功
     */
    boolean createDepartment(CreateOrUpdateDepartmentDTO validator);

    /**
     * 根据关键字获取科室集合
     * @param q 查询关键字
     * @return DepartmentDO List
     */
    List<DepartmentDO> getDepartmentByKeyword(String q);

    /**
     * 更新科室
     * @param department 科室对象
     * @param validator 数据传输对象
     * @return 是否更新成功
     */
    boolean updateDepartment(DepartmentDO department, CreateOrUpdateDepartmentDTO validator);

    /**
     * 获取科室
     * @param id 主键id
     * @return 科室数据对象
     */
    DepartmentDO getById(Integer id);

    /**
     * 查询所有科室
     * @return 科室数据对象集合
     */
    List<DepartmentDO> findAll();

    /**
     * 删除科室
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
