package com.example.GeoJuction.company.restapi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.company.model.Company;
import com.example.GeoJuction.company.repository.CompanyRepository;
import com.example.GeoJuction.company.restapi.dto.CompanyDto;
import com.example.GeoJuction.company.restapi.service.CompanyRestService;

@Service
public class CompanyRestServiceImpl implements CompanyRestService {

    @Autowired
    private CompanyRepository companyRepository;
    
    @Override
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public CompanyDto save(CompanyDto companyDto) {
        var companyEntity = new Company();
        BeanUtils.copyProperties(companyDto, companyEntity);

        Company storedCompanyDetails = companyRepository.save(companyEntity);

        var returnValue = new CompanyDto();
        BeanUtils.copyProperties(storedCompanyDetails, returnValue);

        return returnValue;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void getById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }
    
}
