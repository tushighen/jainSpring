package com.example.jain.controller;

import com.example.jain.model.Ads;
import com.example.jain.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/ads")
@CrossOrigin(origins = "*")
public class AdsController {

    @Autowired
    AdsService adsService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List getAllAds() {
        return adsService.getAllAds();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public void addAds(@RequestBody Ads ads) {
        adsService.addAds(ads);
    }
}