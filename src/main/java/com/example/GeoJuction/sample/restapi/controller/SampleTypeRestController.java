package com.example.GeoJuction.sample.restapi.controller;

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

import com.example.GeoJuction.sample.model.SampleType;
import com.example.GeoJuction.sample.restapi.dto.SampleTypeDto;
import com.example.GeoJuction.sample.restapi.model.request.SampleTypeRequestModel;
import com.example.GeoJuction.sample.restapi.model.response.SampleTypeRest;
import com.example.GeoJuction.sample.restapi.service.SampleTypeRestService;

@RestController
@RequestMapping("/api/v1/sampleType")
public class SampleTypeRestController {
    
    @Autowired
    private SampleTypeRestService sampleTypeRestService;

    @CrossOrigin
    @GetMapping
    public @ResponseBody  Map<String, Object> getSampleTypes() {
        List<SampleType>  getSampleTypeList = sampleTypeRestService.getSampleTypes();
        

        Map<String, Object> response = new HashMap<>();
        response.put("type",  getSampleTypeList);
        return response;
    }

    @CrossOrigin
    @PostMapping
    public SampleTypeRest save(@RequestBody SampleTypeRequestModel sampleTypeDetails)
    {
       
        var sampleTypeDto = new SampleTypeDto();

        BeanUtils.copyProperties(sampleTypeDetails, sampleTypeDto);

        SampleTypeDto createdSampleType = sampleTypeRestService.save(sampleTypeDto);
        var returnValue = new SampleTypeRest();

        BeanUtils.copyProperties(createdSampleType, returnValue);
        return returnValue;
    }
}
