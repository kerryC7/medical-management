package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.drug.CreateOrUpdateDrugDTO;
import io.github.talelin.latticy.mapper.DrugMapper;
import io.github.talelin.latticy.model.DrugDO;
import io.github.talelin.latticy.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品服务实现类
 */
@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugMapper drugMapper;

    @Override
    public boolean createDrug(CreateOrUpdateDrugDTO validator) {
        DrugDO drug = new DrugDO();
        drug.setName(validator.getName());
        drug.setDescription(validator.getDescription());
        drug.setPrice(validator.getPrice());
        return drugMapper.insert(drug) > 0;
    }

    @Override
    public List<DrugDO> getDrugByKeyword(String q) {
        return drugMapper.selectByNameLikeKeyword(q);
    }

    @Override
    public boolean updateDrug(DrugDO drug, CreateOrUpdateDrugDTO validator) {
        drug.setName(validator.getName());
        drug.setDescription(validator.getDescription());
        drug.setPrice(validator.getPrice());
        return drugMapper.updateById(drug) > 0;
    }

    @Override
    public DrugDO getById(Integer id) {
        return drugMapper.selectById(id);
    }

    @Override
    public List<DrugDO> findAll() {
        return drugMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return drugMapper.deleteById(id) > 0;
    }
}
