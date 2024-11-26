package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.doctor.CreateOrUpdateDoctorDTO;
import io.github.talelin.latticy.mapper.DoctorMapper;
import io.github.talelin.latticy.model.DoctorDO;
import io.github.talelin.latticy.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 医师服务实现类
 */
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public boolean createDoctor(CreateOrUpdateDoctorDTO validator) {
        DoctorDO doctor = new DoctorDO();
        doctor.setName(validator.getName());
        doctor.setTitle(validator.getTitle());
        doctor.setHospital(validator.getHospital());
        doctor.setDepartment(validator.getDepartment());
        doctor.setPhone(validator.getPhone());
        doctor.setSummary(validator.getSummary());
        doctor.setImage(validator.getImage());
        return doctorMapper.insert(doctor) > 0;
    }

    @Override
    public List<DoctorDO> getDoctorByKeyword(String q) {
        return doctorMapper.selectByNameLikeKeyword(q);
    }

    @Override
    public boolean updateDoctor(DoctorDO doctor, CreateOrUpdateDoctorDTO validator) {
        doctor.setName(validator.getName());
        doctor.setTitle(validator.getTitle());
        doctor.setHospital(validator.getHospital());
        doctor.setDepartment(validator.getDepartment());
        doctor.setPhone(validator.getPhone());
        doctor.setSummary(validator.getSummary());
        doctor.setImage(validator.getImage());
        return doctorMapper.updateById(doctor) > 0;
    }

    @Override
    public DoctorDO getById(Integer id) {
        return doctorMapper.selectById(id);
    }

    @Override
    public List<DoctorDO> findAll() {
        return doctorMapper.selectList(null);
    }

    @Override
    public boolean deleteById(Integer id) {
        return doctorMapper.deleteById(id) > 0;
    }
}
