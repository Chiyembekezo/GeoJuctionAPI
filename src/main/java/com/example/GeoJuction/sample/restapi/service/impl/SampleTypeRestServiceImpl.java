package com.example.GeoJuction.sample.restapi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.sample.model.SampleType;
import com.example.GeoJuction.sample.repository.SampleTypeRepository;
import com.example.GeoJuction.sample.restapi.dto.SampleTypeDto;
import com.example.GeoJuction.sample.restapi.service.SampleTypeRestService;

@Service
public class SampleTypeRestServiceImpl implements SampleTypeRestService {

    @Autowired
    private SampleTypeRepository sampleTypeRepository;

    @Override
    public List<SampleType> getSampleTypes() {
      return sampleTypeRepository.findAll();
    }

    @Override
    public SampleTypeDto save(SampleTypeDto sampleTypeDto) {
        var sampleType = new SampleType();
        BeanUtils.copyProperties(sampleTypeDto, sampleType);

        SampleType storedSampleTypeDetails = sampleTypeRepository.save(sampleType);

        var returnValue = new SampleTypeDto();
        BeanUtils.copyProperties(storedSampleTypeDetails, returnValue);

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
