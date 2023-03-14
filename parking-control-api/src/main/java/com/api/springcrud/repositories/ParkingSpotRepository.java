package com.api.springcrud.repositories;

import com.api.springcrud.models.ParkingSpotModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

  boolean existsByLicensePlateCar(String licensePlateCar);

  boolean existsByParkingSpotNumber(String spotNumber);

  boolean existsByApartmentAndBlock(String apartment, String block);
}
