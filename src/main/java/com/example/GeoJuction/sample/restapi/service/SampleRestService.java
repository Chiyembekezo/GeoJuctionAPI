package com.example.GeoJuction.sample.restapi.service;

import java.util.List;

import com.example.GeoJuction.sample.model.Sample;
import com.example.GeoJuction.sample.restapi.dto.SampleDto;

public interface SampleRestService {
    //get list of samples
    public List<Sample> getSamples();

    SampleDto save(SampleDto sampleDto);

    //delete samples
    void delete(int id);

    void getById(int id);

}
