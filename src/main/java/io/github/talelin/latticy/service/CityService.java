package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.city.CreateOrUpdateCityDTO;
import io.github.talelin.latticy.model.CityDO;

import java.util.List;

/**
 * 城市服务接口
 */
public interface CityService {

    /**
     * 新增城市
     * @param validator 城市创建数据传输对象
     * @return 是否成功
     */
    boolean createCity(CreateOrUpdateCityDTO validator);

    /**
     * 根据关键字获取城市列表
     * @param name 查询关键字
     * @return 城市数据对象列表
     */
    List<CityDO> getCityByKeyword(String name);

    /**
     * 更新城市信息
     * @param city 城市对象
     * @param validator 城市数据传输对象
     * @return 是否更新成功
     */
    boolean updateCity(CityDO city, CreateOrUpdateCityDTO validator);

    /**
     * 获取指定ID的城市
     * @param id 主键id
     * @return 城市数据对象
     */
    CityDO getById(Integer id);

    /**
     * 查询所有城市
     * @return 城市数据对象集合
     */
    List<CityDO> findAll();

    /**
     * 删除城市
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
