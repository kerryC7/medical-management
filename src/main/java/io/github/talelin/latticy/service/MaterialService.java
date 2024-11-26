package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.material.CreateOrUpdateMaterialDTO;
import io.github.talelin.latticy.model.MaterialDO;

import java.util.List;

/**
 * 必备材料服务接口
 */
public interface MaterialService {

    /**
     * 新增必备材料
     * @param validator 必备材料创建/更新DTO
     * @return 是否成功
     */
    boolean createMaterial(CreateOrUpdateMaterialDTO validator);

    /**
     * 根据关键字获取必备材料列表
     * @param name 材料名称关键字
     * @return 材料数据对象列表
     */
    List<MaterialDO> getMaterialByKeyword(String name);

    /**
     * 更新必备材料
     * @param material 必备材料数据对象
     * @param validator 必备材料创建/更新DTO
     * @return 是否更新成功
     */
    boolean updateMaterial(MaterialDO material, CreateOrUpdateMaterialDTO validator);

    /**
     * 获取指定ID的必备材料
     * @param id 材料ID
     * @return 必备材料数据对象
     */
    MaterialDO getById(Integer id);

    /**
     * 获取所有必备材料
     * @return 必备材料数据对象列表
     */
    List<MaterialDO> findAll();

    /**
     * 删除指定ID的必备材料
     * @param id 材料ID
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
