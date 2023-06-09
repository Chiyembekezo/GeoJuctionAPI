package com.example.GeoJuction.site.restapi.service;

import java.util.List;

import com.example.GeoJuction.site.model.Site;
import com.example.GeoJuction.site.restapi.dto.SiteDto;

public interface SiteRestService {
      //get list of samples
      public List<Site> getSites();

      SiteDto save(SiteDto siteDto);
  
      //delete samples
      void delete(int id);
  
      void getById(int id);
}
