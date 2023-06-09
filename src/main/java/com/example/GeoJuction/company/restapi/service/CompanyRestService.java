package com.example.GeoJuction.company.restapi.service;

import java.util.List;

import com.example.GeoJuction.company.model.Company;
import com.example.GeoJuction.company.restapi.dto.CompanyDto;

public interface CompanyRestService {
     //get a list of all companies
     public List<Company> getCompanies();
     //save new company
     CompanyDto save(CompanyDto companyDto);
     //delete company
     void delete(int id);
     //get company by id
     void getById(int id);
}
