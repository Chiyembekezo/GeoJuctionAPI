package com.example.GeoJuction.site.restapi.controller;

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

import com.example.GeoJuction.site.model.Site;
import com.example.GeoJuction.site.restapi.dto.SiteDto;
import com.example.GeoJuction.site.restapi.model.request.SiteRequestModel;
import com.example.GeoJuction.site.restapi.model.response.SiteRest;
import com.example.GeoJuction.site.restapi.service.SiteRestService;

@RestController
@RequestMapping("/api/v1/site")
public class SiteRestController {
    
    @Autowired
    private SiteRestService siteRestService;

    @CrossOrigin
    @GetMapping
    public @ResponseBody Map<String, Object> getSites() {
        List<Site> getSiteList = siteRestService.getSites();
        Map<String, Object> response = new HashMap<>();
        response.put("site",  getSiteList);
        return response;
    }

    @CrossOrigin
    @PostMapping
    public SiteRest save(@RequestBody SiteRequestModel siteDetails)
    {
        var siteDto = new SiteDto();

        BeanUtils.copyProperties(siteDetails, siteDto);

        SiteDto createdSite = siteRestService.save(siteDto);
        var returnValue = new SiteRest();

        BeanUtils.copyProperties(createdSite, returnValue);
        return returnValue;
    }
}
