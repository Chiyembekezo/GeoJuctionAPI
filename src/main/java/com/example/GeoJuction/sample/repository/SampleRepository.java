package com.example.GeoJuction.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.GeoJuction.sample.model.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {
    
}
