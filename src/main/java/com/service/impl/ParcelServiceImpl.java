package com.example.demo.service.impl;

import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    @Override
    public Parcel createParcel(Parcel parcel) {
        if (parcel.getTrackingNumber() == null) {
            parcel.setTrackingNumber(UUID.randomUUID().toString());
        }
        if (parcel.getStatus() == null) {
            parcel.setStatus("CREATED");
        }
        return parcelRepository.save(parcel);
    }

    @Override
    public List<Parcel> getAllParcels() {
        return parcelRepository.findAll();
    }

    @Override
    public Parcel getParcel(Long id) {
        return parcelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Parcel not found"));
    }
}