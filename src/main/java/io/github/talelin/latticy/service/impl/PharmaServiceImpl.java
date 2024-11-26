package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.pharma.CreateOrUpdatePharmaDTO;
import io.github.talelin.latticy.mapper.PharmaMapper;
import io.github.talelin.latticy.model.PharmaDO;
import io.github.talelin.latticy.service.PharmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author your_name
 * 医药公司服务实现类
 */
@Service
public class PharmaServiceImpl implements PharmaService {

    @Autowired
    private PharmaMapper pharmaMapper;

    @Override
    public boolean createPharma(CreateOrUpdatePharmaDTO validator) {
        PharmaDO pharma = new PharmaDO();
        pharma.setName(validator.getName());
        pharma.setAddress(validator.getAddress());
        pharma.setPhone(validator.getPhone());
        pharma.setEmail(validator.getEmail());
        pharma.setPolicy(validator.getPolicy());
        return pharmaMapper.insert(pharma) > 0;
    }

    @Override
    public List<PharmaDO> getPharmaByKeyword(String q) {
        return pharmaMapper.selectByKeyword(q);
    }

    @Override
    public boolean updatePharma(PharmaDO pharma, CreateOrUpdatePharmaDTO validator) {
        pharma.setName(validator.getName());
        pharma.setAddress(validator.getAddress());
        pharma.setPhone(validator.getPhone());
        pharma.setEmail(validator.getEmail());
        pharma.setPolicy(validator.getPolicy());
        return pharmaMapper.updateById(pharma) > 0;
    }

    @Override
    public PharmaDO getById(Integer id) {
        return pharmaMapper.selectById(id);
    }

    @Override
    public List<PharmaDO> findAll() {
        return pharmaMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return pharmaMapper.deleteById(id) > 0;
    }
}
