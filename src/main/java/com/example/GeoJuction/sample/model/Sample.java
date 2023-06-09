package com.example.GeoJuction.sample.model;

import com.example.GeoJuction.project.model.Project;
import com.example.GeoJuction.site.model.Site;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Sample {
    
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="record_seq_gen")
    @SequenceGenerator(name="record_seq_gen", sequenceName="record_seq",initialValue = 8000,allocationSize = 1)
    @Column(name="id")
    private int id;

    private double utmEast;
    private double utmNorth;
    private double sampleDepth;
    private double fraction;
    private String coordinateSystem;
    private String collectionDate;
    private String comments;
    private String regolithCharacter;
    private String colourShade;
    private String soilColour;
    private String slopeAngle;


    @ManyToOne
    @JoinColumn(name = "sample_type_id", insertable = false, updatable = false)
    private SampleType sampleType;
    private int sample_type_id;

    @ManyToOne
    @JoinColumn(name = "project_id", insertable = false, updatable = false)
    private Project project;
    private int project_id;

    @ManyToOne
    @JoinColumn(name = "site_id", insertable = false, updatable = false)
    private Site site;
    private int site_id;
}
