package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.city.CreateOrUpdateCityDTO;
import io.github.talelin.latticy.mapper.CityMapper;
import io.github.talelin.latticy.model.CityDO;
import io.github.talelin.latticy.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市服务实现类
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public boolean createCity(CreateOrUpdateCityDTO validator) {
        CityDO city = new CityDO();
        city.setName(validator.getName());
        city.setCountry(validator.getCountry());
        return cityMapper.insert(city) > 0;
    }

    @Override
    public List<CityDO> getCityByKeyword(String name) {
        return cityMapper.selectByNameLikeKeyword(name);
    }

    @Override
    public boolean updateCity(CityDO city, CreateOrUpdateCityDTO validator) {
        city.setName(validator.getName());
        city.setCountry(validator.getCountry());
        return cityMapper.updateById(city) > 0;
    }

    @Override
    public CityDO getById(Integer id) {
        return cityMapper.selectById(id);
    }

    @Override
    public List<CityDO> findAll() {
        return cityMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return cityMapper.deleteById(id) > 0;
    }
}
