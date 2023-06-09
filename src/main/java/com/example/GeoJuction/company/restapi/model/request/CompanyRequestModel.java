package com.example.GeoJuction.company.restapi.model.request;

import lombok.Data;

@Data
public class CompanyRequestModel {
    private String name;
    private String phone;
    private String email;
    private String address;
}
