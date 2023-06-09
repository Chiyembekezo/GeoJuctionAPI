package com.example.GeoJuction.site.restapi.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.GeoJuction.site.model.Site;
import com.example.GeoJuction.site.repository.SiteRepository;
import com.example.GeoJuction.site.restapi.dto.SiteDto;
import com.example.GeoJuction.site.restapi.service.SiteRestService;

@Service
public class SiteRestServiceImpl implements SiteRestService {

    @Autowired
    private SiteRepository siteRepository;


    @Override
    public List<Site> getSites() {
       return siteRepository.findAll();
    }

    @Override
    public SiteDto save(SiteDto siteDto) {
        var site = new Site();
        BeanUtils.copyProperties(siteDto, site);

        Site storedSiteDetails = siteRepository.save(site);

        var returnValue = new SiteDto();
        BeanUtils.copyProperties(storedSiteDetails, returnValue);

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
