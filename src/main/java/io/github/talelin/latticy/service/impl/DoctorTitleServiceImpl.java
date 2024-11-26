package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.doctor.CreateOrUpdateDoctorTitleDTO;
import io.github.talelin.latticy.mapper.DoctorTitleMapper;
import io.github.talelin.latticy.model.DoctorTitleDO;
import io.github.talelin.latticy.service.DoctorTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职称服务实现类
 */
@Service
public class DoctorTitleServiceImpl implements DoctorTitleService {

    @Autowired
    private DoctorTitleMapper doctorTitleMapper;

    @Override
    public boolean createDoctorTitle(CreateOrUpdateDoctorTitleDTO validator) {
        DoctorTitleDO doctorTitle = new DoctorTitleDO();
        doctorTitle.setTitleName(validator.getTitleName());
        doctorTitle.setNumberOfDoctors(validator.getNumberOfDoctors());
        doctorTitle.setDescription(validator.getDescription());
        return doctorTitleMapper.insert(doctorTitle) > 0;
    }

    @Override
    public List<DoctorTitleDO> getDoctorTitleByTitleName(String titleName) {
        return doctorTitleMapper.selectByTitleName("%" + titleName + "%");
    }

    @Override
    public boolean updateDoctorTitle(DoctorTitleDO doctorTitle, CreateOrUpdateDoctorTitleDTO validator) {
        doctorTitle.setTitleName(validator.getTitleName());
        doctorTitle.setNumberOfDoctors(validator.getNumberOfDoctors());
        doctorTitle.setDescription(validator.getDescription());
        return doctorTitleMapper.updateById(doctorTitle) > 0;
    }

    @Override
    public DoctorTitleDO getById(Integer id) {
        return doctorTitleMapper.selectById(id);
    }

    @Override
    public List<DoctorTitleDO> findAll() {
        return doctorTitleMapper.selectAll();
    }

    @Override
    public boolean deleteById(Integer id) {
        return doctorTitleMapper.deleteById(id) > 0;
    }
}
