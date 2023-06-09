package com.example.GeoJuction.company.restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.GeoJuction.company.model.Company;
import com.example.GeoJuction.company.restapi.dto.CompanyDto;
import com.example.GeoJuction.company.restapi.model.request.CompanyRequestModel;
import com.example.GeoJuction.company.restapi.model.response.CompanyRest;
import com.example.GeoJuction.company.restapi.service.CompanyRestService;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyRestController {
    @Autowired
    private CompanyRestService companyRestService;

    @CrossOrigin
    @GetMapping
    public @ResponseBody Map<String, Object> getCompanies()
    {
        List<Company> companyList = companyRestService.getCompanies();
        Map<String, Object> response = new HashMap<>();
        response.put("companies",  companyList);
       return response;
    }
    
    @CrossOrigin
    @PostMapping
    public Map<String, Object> saveCompany(@RequestBody CompanyRequestModel companyDetails) {
    
        var companyDto = new CompanyDto();
        BeanUtils.copyProperties(companyDetails, companyDto);
    
        var returnValue = new CompanyRest();
    
        CompanyDto createdCompany = companyRestService.save(companyDto);
        BeanUtils.copyProperties(createdCompany, returnValue);
    
        Map<String, Object> response = new HashMap<>();
        response.put("company", returnValue);
    
        return response;
    }
}
