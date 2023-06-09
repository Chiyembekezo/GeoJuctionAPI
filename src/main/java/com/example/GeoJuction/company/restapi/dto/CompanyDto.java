package com.example.GeoJuction.company.restapi.dto;

import lombok.Data;

@Data
public class CompanyDto {
    private int id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
