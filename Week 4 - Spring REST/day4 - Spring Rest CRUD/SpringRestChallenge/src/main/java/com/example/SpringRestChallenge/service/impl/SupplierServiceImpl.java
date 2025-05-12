package com.example.SpringRestChallenge.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.SpringRestChallenge.model.dto.SupplierDto;
import com.example.SpringRestChallenge.model.entities.Suppliers;
import com.example.SpringRestChallenge.repository.SupplierRepository;
import com.example.SpringRestChallenge.service.SupplierService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService{

  private final SupplierRepository supplierRepository;

  public static SupplierDto maSupplierDto(Suppliers entity) {
    return new SupplierDto(entity.getId(), entity.getCompanyName());
  }

  @Override
  public List<SupplierDto> getAllData() {
    return supplierRepository.findAll()
            .stream()
            .map(SupplierServiceImpl::maSupplierDto)
            .collect(Collectors.toList());
  }

  @Override
  public SupplierDto addData(SupplierDto entity) {
    supplierRepository.findById(entity.getSupplierId()).ifPresent(c -> { throw new DataIntegrityViolationException("Id with " + entity.getSupplierId() + " already in used!"); });

    return maSupplierDto(supplierRepository.save(
      new Suppliers(
        entity.getSupplierId(), 
        entity.getCompanyName()
      )
      ));
  }

  @Override
  public SupplierDto findDataById(Long id) {
    return supplierRepository.findById(id).map(SupplierServiceImpl::maSupplierDto).orElseThrow(() -> new EntityNotFoundException("Supplier with id " + id + " was not found!"));
  }

  @Override
  public SupplierDto updateData(SupplierDto entity, Long id) {
    var supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find supplier with id " + id));

    supplier.setCompanyName(entity.getCompanyName());
    supplier.setModifiedDate(Instant.now());

    return maSupplierDto(supplierRepository.save(supplier));
  }

  @Override
  public Long delete(Long id) {
    var supplier = supplierRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find supplier with id " + id));
    supplierRepository.delete(supplier);
    return supplier.getId();
  }
}
