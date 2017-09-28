package com.example.jain.service;

import com.example.jain.model.Ads;
import com.example.jain.repository.AdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsService {

    @Autowired
    AdsRepository adsRepository;

    public List getAllAds() {
        return adsRepository.findAll();
    }

    public void addAds(Ads ads) {
        adsRepository.save(ads);
    }
}
