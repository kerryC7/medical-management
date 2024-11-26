package io.github.talelin.latticy.service;

import io.github.talelin.latticy.dto.saleslocation.CreateOrUpdateSalesLocationDTO;
import io.github.talelin.latticy.model.SalesLocationDO;

import java.util.List;

/**
 * 销售地点服务接口
 */
public interface SalesLocationService {

    /**
     * 新增销售地点
     * @param validator 数据传输对象
     * @return 是否成功
     */
    boolean createSalesLocation(CreateOrUpdateSalesLocationDTO validator);

    /**
     * 根据名称查询销售地点列表
     * @param name 销售地点名称
     * @return 销售地点数据对象列表
     */
    List<SalesLocationDO> getSalesLocationByKeyword(String name);

    /**
     * 更新销售地点
     * @param salesLocation 销售地点对象
     * @param validator 数据传输对象
     * @return 是否更新成功
     */
    boolean updateSalesLocation(SalesLocationDO salesLocation, CreateOrUpdateSalesLocationDTO validator);

    /**
     * 获取销售地点
     * @param id 主键id
     * @return 销售地点数据对象
     */
    SalesLocationDO getById(Integer id);

    /**
     * 查询所有销售地点
     * @return 销售地点数据对象集合
     */
    List<SalesLocationDO> findAll();

    /**
     * 删除销售地点
     * @param id 主键id
     * @return 是否删除成功
     */
    boolean deleteById(Integer id);
}
