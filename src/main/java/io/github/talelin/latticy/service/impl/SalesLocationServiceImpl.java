package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.saleslocation.CreateOrUpdateSalesLocationDTO;
import io.github.talelin.latticy.mapper.SalesLocationMapper;
import io.github.talelin.latticy.model.SalesLocationDO;
import io.github.talelin.latticy.service.SalesLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 销售地点服务实现类
 */
@Service
public class SalesLocationServiceImpl implements SalesLocationService {

    @Autowired
    private SalesLocationMapper salesLocationMapper;

    @Override
    public boolean createSalesLocation(CreateOrUpdateSalesLocationDTO validator) {
        SalesLocationDO salesLocation = new SalesLocationDO();
        salesLocation.setName(validator.getName());
        salesLocation.setAddress(validator.getAddress());
        return salesLocationMapper.insert(salesLocation) > 0;
    }

    @Override
    public List<SalesLocationDO> getSalesLocationByKeyword(String name) {
        return salesLocationMapper.selectByNameLikeKeyword(name);
    }

    @Override
    public boolean updateSalesLocation(SalesLocationDO salesLocation, CreateOrUpdateSalesLocationDTO validator) {
        salesLocation.setName(validator.getName());
        salesLocation.setAddress(validator.getAddress());
        return salesLocationMapper.updateById(salesLocation) > 0;
    }

    @Override
    public SalesLocationDO getById(Integer id) {
        return salesLocationMapper.selectById(id);
    }

    @Override
    public List<SalesLocationDO> findAll() {
        return salesLocationMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return salesLocationMapper.deleteById(id) > 0;
    }
}
