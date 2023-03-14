package com.api.springcrud.services;

import com.api.springcrud.models.ParkingSpotModel;
import com.api.springcrud.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ParkingSpotService implements IParkingSpotService {

  final ParkingSpotRepository parkingSpotRepository;

  public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
    this.parkingSpotRepository = parkingSpotRepository;
  }

  @Transactional
  public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
    return parkingSpotRepository.save(parkingSpotModel);
  }

  public boolean existsByLicensePlateCar(String licensePlateCar) {
    return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
  }

  public boolean existsByParkingSpotNumber(String spotNumber) {
    return parkingSpotRepository.existsByParkingSpotNumber(spotNumber);
  }

  public boolean existsByApartmentAndBlock(String apartment, String block) {
    return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
  }


  public Page<ParkingSpotModel> findAll(Pageable pageable) {
    return parkingSpotRepository.findAll(pageable);
  }

  public Optional<ParkingSpotModel> findById(UUID id) {
    return parkingSpotRepository.findById(id);
  }

  @Transactional
  public void delete(ParkingSpotModel parkingSpotModel) {
    parkingSpotRepository.delete(parkingSpotModel);
  }

}
