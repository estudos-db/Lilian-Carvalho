package com.api.springcrud.services;

import com.api.springcrud.models.ParkingSpotModel;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IParkingSpotService {

  ParkingSpotModel save(ParkingSpotModel parkingSpotModel);

  boolean existsByLicensePlateCar(String licensePlateCar);

  boolean existsByParkingSpotNumber(String spotNumber);

  boolean existsByApartmentAndBlock(String apartment, String block);

  Page<ParkingSpotModel> findAll(Pageable pageable);

  Optional<ParkingSpotModel> findById(UUID id);

  void delete(ParkingSpotModel parkingSpotModel);

}
