package com.example.GeoJuction.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.GeoJuction.company.model.Company;
import com.example.GeoJuction.company.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;

    @GetMapping("/companies")
    public String getCompanies(Model model)
    {
        List<Company> companyList = companyService.getCompanies();
        model.addAttribute("companies", companyList);
        return "company/company_list";
    }

    @GetMapping("/companies/manageCompany/{id}")
    public String manageCompany(@PathVariable int id, Model model) {
        Optional<Company> company = companyService.getById(id);
        model.addAttribute("company", company.orElse(null));
        return "company/company_manage";
    }
    

    @RequestMapping("/companies/{id}")
    @ResponseBody
    public Optional<Company> findById(@PathVariable Integer id)
    {
        return companyService.getById(id);
    }

     //add agent using company id
     @GetMapping("/companies/manageCompany/addProject/{id}")
     public String addProject(@PathVariable int id, Model model)
     {
         Optional<Company> company = companyService.getById(id);
         model.addAttribute("company", company.orElse(null));
 
         return "company/company_project_add";
     }

    @PostMapping("/companies")
    public String save(Company company)
    {
        companyService.save(company);
        return "redirect:/company/companies";
    }

    @RequestMapping(value="/companies/update/{id}", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Company company) {
        companyService.save(company);
        return "redirect:/company/companies";
    }

}
