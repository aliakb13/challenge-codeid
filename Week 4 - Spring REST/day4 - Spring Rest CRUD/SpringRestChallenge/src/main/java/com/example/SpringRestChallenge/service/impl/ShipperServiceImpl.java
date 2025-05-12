package com.example.SpringRestChallenge.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.SpringRestChallenge.model.dto.ShippersDto;
import com.example.SpringRestChallenge.model.entities.Shippers;
import com.example.SpringRestChallenge.model.mapper.MapperObj;
import com.example.SpringRestChallenge.repository.ShippersRepository;
import com.example.SpringRestChallenge.service.ShippersService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShipperServiceImpl implements ShippersService {

  private final ShippersRepository shippersRepository;

  @Override
  public List<ShippersDto> getAllData() {
    return shippersRepository.findAll()
      .stream()
      .map(MapperObj::mapToShipperDto)
      .collect(Collectors.toList());
  }

  @Override
  public ShippersDto addData(ShippersDto entity) {
    shippersRepository.findById(entity.getShipId()).ifPresent(c -> { throw new DataIntegrityViolationException("Id with " + entity.getShipId() + " already in used!"); });

    return MapperObj.mapToShipperDto(shippersRepository.save(new Shippers(
      entity.getShipId(), 
      entity.getCompanyName(), 
      entity.getPhone()
    )));
  }

  @Override
  public ShippersDto findDataById(Long id) {
    return shippersRepository.findById(id).map(MapperObj::mapToShipperDto).orElseThrow(() -> new EntityNotFoundException("Shipper with id " + id + " was not found!"));
  }

  @Override
  public ShippersDto updateData(ShippersDto entity, Long id) {
    var shipper = shippersRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find shipper with id " + id));

    shipper.setCompanyName(entity.getCompanyName());
    shipper.setPhone(entity.getPhone());
    shipper.setModifiedDate(Instant.now());

    return MapperObj.mapToShipperDto(shippersRepository.save(shipper));
  }

  @Override
  public Long delete(Long id) {
    var shipper = shippersRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find shipper with id " + id));

    shippersRepository.delete(shipper);
    return shipper.getId();
  }
}
