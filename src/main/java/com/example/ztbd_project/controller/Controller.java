package com.example.ztbd_project.controller;

import com.example.ztbd_project.ScraperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    private ScraperUtils scraperUtils;

    @GetMapping("/api")
    private String scrap() {
        scraperUtils.scrap();
        return "test";
    }
}
