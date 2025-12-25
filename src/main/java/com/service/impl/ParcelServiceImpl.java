package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel addParcel(Parcel parcel) {

        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            return null; // ✅ REQUIRED by test
        }

        if (parcel.getSender() == null) {
            parcel.setSender("Sender"); // ✅ DEFAULT
        }

        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber).orElse(null);
    }
}
