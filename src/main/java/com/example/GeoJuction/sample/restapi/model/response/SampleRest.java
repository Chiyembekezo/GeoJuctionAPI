package com.example.GeoJuction.sample.restapi.model.response;

import lombok.Data;

@Data
public class SampleRest {
    private double utmEast;
    private double utmNorth;
    private double sampleDepth;
    private double fraction;
    private String coordinateSystem;
    private String collectionDate;
    private String regolithCharacter;
    private String colourShade;
    private String soilColour;
    private String slopeAngle;
    private String comments;
    private int sample_type_id;
    private int project_id;
    private int site_id;
}
