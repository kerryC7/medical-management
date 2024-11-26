package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.pharma.CreateOrUpdatePharmaDTO;
import io.github.talelin.latticy.model.PharmaDO;

import java.util.List;

/**
 * @author your_name
 * 医药公司服务接口
 */
public interface PharmaService {

    /**
     * 新增医药公司
     * @param validator 数据传输对象
     * @return 是否成功
     */
    boolean createPharma(CreateOrUpdatePharmaDTO validator);

    /**
     * 根据关键字获取医药公司集合
     * @param q 查询关键字
     * @return 医药公司数据对象列表
     */
    List<PharmaDO> getPharmaByKeyword(String q);

    /**
     * 更新医药公司
     * @param pharma 医药公司对象
     * @param validator 数据传输对象
     * @return 是否更新成功
     */
    boolean updatePharma(PharmaDO pharma, CreateOrUpdatePharmaDTO validator);

    /**
     * 获取医药公司
     * @param id 主键id
     * @return 医药公司数据对象
     */
    PharmaDO getById(Integer id);

    /**
     * 查询所有医药公司
     * @return 医药公司数据对象集合
     */
    List<PharmaDO> findAll();

    /**
     * 删除医药公司
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
