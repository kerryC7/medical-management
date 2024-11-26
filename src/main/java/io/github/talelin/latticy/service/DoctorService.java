package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.doctor.CreateOrUpdateDoctorDTO;
import io.github.talelin.latticy.model.DoctorDO;

import java.util.List;

/**
 * 医师服务接口
 */
public interface DoctorService {

    /**
     * 新增医师
     * @param validator 数据传输对象
     * @return 是否成功
     */
    boolean createDoctor(CreateOrUpdateDoctorDTO validator);

    /**
     * 根据关键字获取医师集合
     * @param q 查询关键字
     * @return 医师数据对象集合
     */
    List<DoctorDO> getDoctorByKeyword(String q);

    /**
     * 更新医师信息
     * @param doctor 医师数据对象
     * @param validator 数据传输对象
     * @return 是否更新成功
     */
    boolean updateDoctor(DoctorDO doctor, CreateOrUpdateDoctorDTO validator);

    /**
     * 获取医师信息
     * @param id 主键id
     * @return 医师数据对象
     */
    DoctorDO getById(Integer id);

    /**
     * 查询所有医师
     * @return 医师数据对象集合
     */
    List<DoctorDO> findAll();

    /**
     * 删除医师
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
