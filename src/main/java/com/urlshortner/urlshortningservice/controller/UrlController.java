package com.urlshortner.urlshortningservice.controller;

import com.urlshortner.urlshortningservice.exception.NoResourceFoundException;
import com.urlshortner.urlshortningservice.model.Url;
import com.urlshortner.urlshortningservice.model.UrlDTO;
import com.urlshortner.urlshortningservice.service.UrlService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class UrlController {

    @Autowired
    UrlService service;

    @PostMapping("/generate")
    public UrlDTO shortenUrl(@RequestBody Url url) {
        return service.shortenUrl(url);
    }

    @GetMapping("/{shortlink}")
    public void urlMapping(@PathVariable String shortlink, HttpServletResponse response) throws IOException, NoResourceFoundException {
        UrlDTO url = service.getEncodedUrl(shortlink);
        response.sendRedirect(url.getUrl());
    }
}
