package com.urlshortner.urlshortningservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlDTO {

    @Id
    @GeneratedValue
    private long id;

    private String url;

    private String mappedUrl;
}
