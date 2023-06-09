package com.example.GeoJuction.company.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.company.model.Company;
import com.example.GeoJuction.company.repository.CompanyRepository;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;


    public List<Company> getCompanies()
    {
       final List<Company> companies = companyRepository.findAll();
       return companies;
    }

    public void save(Company company)
    {
        companyRepository.save(company);
    }

    // delete company by id
    public void delete(int id)
    {
        companyRepository.deleteById(id);
    }
    //find company by id
    public Optional<Company> getById(int id)
    {
        return companyRepository.findById(id);
    }
    
}
