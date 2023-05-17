package com.urlshortner.urlshortningservice.repository;

import com.urlshortner.urlshortningservice.model.UrlDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends JpaRepository<UrlDTO,Integer> {
    UrlDTO findByMappedUrl(String url);
}
