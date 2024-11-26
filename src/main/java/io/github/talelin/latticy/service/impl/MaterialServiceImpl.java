package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.material.CreateOrUpdateMaterialDTO;
import io.github.talelin.latticy.mapper.MaterialMapper;
import io.github.talelin.latticy.model.MaterialDO;
import io.github.talelin.latticy.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 必备材料服务实现类
 */
@Service
public class MaterialServiceImpl implements MaterialService {

    @Autowired
    private MaterialMapper materialMapper;

    @Override
    public boolean createMaterial(CreateOrUpdateMaterialDTO validator) {
        MaterialDO material = new MaterialDO();
        material.setName(validator.getName());
        material.setDescription(validator.getDescription());
        return materialMapper.insert(material) > 0;
    }

    @Override
    public List<MaterialDO> getMaterialByKeyword(String name) {
        return materialMapper.selectByName("%" + name + "%");
    }

    @Override
    public boolean updateMaterial(MaterialDO material, CreateOrUpdateMaterialDTO validator) {
        material.setName(validator.getName());
        material.setDescription(validator.getDescription());
        return materialMapper.updateById(material) > 0;
    }

    @Override
    public MaterialDO getById(Integer id) {
        return materialMapper.selectById(id);
    }

    @Override
    public List<MaterialDO> findAll() {
        return materialMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return materialMapper.deleteById(id) > 0;
    }
}
