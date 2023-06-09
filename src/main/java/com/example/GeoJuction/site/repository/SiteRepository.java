package com.example.GeoJuction.site.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GeoJuction.site.model.Site;

@Repository
public interface SiteRepository extends JpaRepository<Site, Integer> {
    
}
