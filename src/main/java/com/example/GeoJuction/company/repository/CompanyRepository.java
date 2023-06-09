package com.example.GeoJuction.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GeoJuction.company.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer>{
    
}
