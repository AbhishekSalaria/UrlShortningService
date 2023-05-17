package com.urlshortner.urlshortningservice.service;

import com.google.common.hash.Hashing;
import com.urlshortner.urlshortningservice.exception.NoResourceFoundException;
import com.urlshortner.urlshortningservice.model.Url;
import com.urlshortner.urlshortningservice.model.UrlDTO;
import com.urlshortner.urlshortningservice.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlService {

    @Autowired
    UrlRepository repository;

    public UrlDTO shortenUrl(Url url) {
        String encodedUrl = encodeUrl(url.getUrl());
        UrlDTO dto = new UrlDTO();
        dto.setUrl(url.getUrl());
        dto.setMappedUrl("http://localhost:8086/" + encodedUrl);
        return repository.save(dto);
    }

    private String encodeUrl(String url) {
        return Hashing.murmur3_32_fixed().hashString(
                url,StandardCharsets.UTF_8
        ).toString();
    }

    public UrlDTO getEncodedUrl(String shortlink) throws NoResourceFoundException {
        UrlDTO url = repository.findByMappedUrl("http://localhost:8086/" + shortlink);

        if(url == null) {
            throw new NoResourceFoundException("Invalid Url. Please Check Again.");
        }

        return url;
    }
}
