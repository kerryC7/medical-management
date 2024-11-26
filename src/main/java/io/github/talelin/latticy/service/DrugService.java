package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.drug.CreateOrUpdateDrugDTO;
import io.github.talelin.latticy.model.DrugDO;

import java.util.List;

/**
 * 药品服务接口
 */
public interface DrugService {

    /**
     * 新增药品
     * @param validator 数据传输对象
     * @return 是否成功
     */
    boolean createDrug(CreateOrUpdateDrugDTO validator);

    /**
     * 根据关键字获取药品列表
     * @param q 查询关键字
     * @return DrugDO List
     */
    List<DrugDO> getDrugByKeyword(String q);

    /**
     * 更新药品
     * @param drug 药品对象
     * @param validator 数据传输对象
     * @return 是否更新成功
     */
    boolean updateDrug(DrugDO drug, CreateOrUpdateDrugDTO validator);

    /**
     * 获取药品
     * @param id 主键id
     * @return 药品数据对象
     */
    DrugDO getById(Integer id);

    /**
     * 查询所有药品
     * @return 药品数据对象集合
     */
    List<DrugDO> findAll();

    /**
     * 删除药品
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
