package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Parcel;
import com.example.demo.repository.ParcelRepository;
import com.example.demo.service.ParcelService;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelServiceImpl(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }

    // Core logic
    @Override
    public Parcel createParcel(Parcel parcel) {
        if (parcelRepository.existsByTrackingNumber(parcel.getTrackingNumber())) {
            throw new BadRequestException("Tracking number already exists");
        }
        return parcelRepository.save(parcel);
    }

    @Override
    public Parcel getParcelByTrackingNumber(String trackingNumber) {
        return parcelRepository.findByTrackingNumber(trackingNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Parcel not found with tracking number: " + trackingNumber)
                );
    }

    // 🔥 Alias methods for controller/tests
    @Override
    public Parcel addParcel(Parcel parcel) {
        return createParcel(parcel);
    }

    @Override
    public Parcel getByTrackingNumber(String trackingNumber) {
        return getParcelByTrackingNumber(trackingNumber);
    }
}
