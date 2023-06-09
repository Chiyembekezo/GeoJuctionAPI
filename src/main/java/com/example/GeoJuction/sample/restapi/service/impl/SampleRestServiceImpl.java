package com.example.GeoJuction.sample.restapi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.sample.model.Sample;
import com.example.GeoJuction.sample.repository.SampleRepository;
import com.example.GeoJuction.sample.restapi.dto.SampleDto;
import com.example.GeoJuction.sample.restapi.service.SampleRestService;

@Service
public class SampleRestServiceImpl implements SampleRestService {

    @Autowired
    private SampleRepository sampleRepository;

    @Override
    public List<Sample> getSamples() {
        return sampleRepository.findAll();
    }

    @Override
    public SampleDto save(SampleDto sampleDto) {
        var sample = new Sample();
        BeanUtils.copyProperties(sampleDto, sample);

        Sample storedSampleDetails = sampleRepository.save(sample);

        var returnValue = new SampleDto();
        BeanUtils.copyProperties(storedSampleDetails, returnValue);

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
