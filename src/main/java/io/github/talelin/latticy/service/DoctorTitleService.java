package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.doctor.CreateOrUpdateDoctorTitleDTO;
import io.github.talelin.latticy.model.DoctorTitleDO;

import java.util.List;

/**
 * 职称服务接口
 */
public interface DoctorTitleService {

    /**
     * 新增职称
     * @param validator 数据传输对象
     * @return 是否成功
     */
    boolean createDoctorTitle(CreateOrUpdateDoctorTitleDTO validator);

    /**
     * 根据职称名称模糊查询职称
     * @param titleName 职称名称
     * @return 职称数据对象列表
     */
    List<DoctorTitleDO> getDoctorTitleByTitleName(String titleName);

    /**
     * 更新职称
     * @param doctorTitle 职称数据对象
     * @param validator 数据传输对象
     * @return 是否更新成功
     */
    boolean updateDoctorTitle(DoctorTitleDO doctorTitle, CreateOrUpdateDoctorTitleDTO validator);

    /**
     * 获取职称信息
     * @param id 职称ID
     * @return 职称数据对象
     */
    DoctorTitleDO getById(Integer id);

    /**
     * 获取所有职称
     * @return 职称数据对象集合
     */
    List<DoctorTitleDO> findAll();

    /**
     * 删除职称
     * @param id 职称ID
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
