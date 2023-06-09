package com.example.GeoJuction.sample.restapi.service;

import java.util.List;

import com.example.GeoJuction.sample.model.SampleType;
import com.example.GeoJuction.sample.restapi.dto.SampleTypeDto;

public interface SampleTypeRestService {
    //get list of samples
    public List<SampleType> getSampleTypes();

    SampleTypeDto save(SampleTypeDto sampleTypeDto);

    //delete samples
    void delete(int id);

    void getById(int id);
}
