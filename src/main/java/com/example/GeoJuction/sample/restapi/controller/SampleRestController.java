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

import com.example.GeoJuction.sample.model.Sample;
import com.example.GeoJuction.sample.restapi.dto.SampleDto;
import com.example.GeoJuction.sample.restapi.model.request.SampleRequestModel;
import com.example.GeoJuction.sample.restapi.model.response.SampleRest;
import com.example.GeoJuction.sample.restapi.service.SampleRestService;

@RestController
@RequestMapping("/api/v1/sample")
public class SampleRestController {

    @Autowired
    private SampleRestService sampleRestService;

    @CrossOrigin
    @GetMapping
    public @ResponseBody  Map<String, Object> getSamples() {
        List<Sample>  getSampleList = sampleRestService.getSamples();
        

        Map<String, Object> response = new HashMap<>();
        response.put("sample",  getSampleList);
        return response;
    }

    @CrossOrigin
    @PostMapping
    public SampleRest save(@RequestBody SampleRequestModel sampleDetails)
    {
       
        var sampleDto = new SampleDto();

        BeanUtils.copyProperties(sampleDetails, sampleDto);

        SampleDto createdSample = sampleRestService.save(sampleDto);
        var returnValue = new SampleRest();

        BeanUtils.copyProperties(createdSample, returnValue);
        return returnValue;
    }
}
