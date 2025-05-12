package com.example.SpringRestChallenge.service.impl;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.SpringRestChallenge.model.dto.CategoriesDto;
import com.example.SpringRestChallenge.model.entities.Categories;
import com.example.SpringRestChallenge.model.mapper.MapperObj;
import com.example.SpringRestChallenge.repository.CategoriesRepository;
import com.example.SpringRestChallenge.service.CategoriesService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriesServiceImpl implements CategoriesService {

  private final CategoriesRepository categoriesRepository;

  @Override
  public List<CategoriesDto> getAllData() {
    return categoriesRepository.findAll()
            .stream()
            .map(MapperObj::mapToCategoriesDto)
            .collect(Collectors.toList());
  }

  @Override
  public CategoriesDto findDataById(Long id) {
    return categoriesRepository.findById(id).map(MapperObj::mapToCategoriesDto)
            .orElseThrow(() -> new EntityNotFoundException("Category with id " + id + " is not found!"));
  }

   @Override
  public CategoriesDto addData(CategoriesDto entity) {
      // var checkData = categoriesRepository.findById(entity.getCategoryId());

      // if (checkData.isEmpty()) {
      //   return mapToDto(categoriesRepository.save(new Categories(entity.getCategoryId(), entity.getCategoryName(), entity.getCategoryDescription())));
      // } else {
      //   throw new DataIntegrityViolationException("Id with " + entity.getCategoryId() + " already in used!");
      // }

      categoriesRepository.findById(entity.getCategoryId()).ifPresent(c -> { throw new DataIntegrityViolationException("Id with " + entity.getCategoryId() + " already in used!"); });

      return MapperObj.mapToCategoriesDto(categoriesRepository.save(new Categories(
        entity.getCategoryId(),
        entity.getCategoryName(),
        entity.getCategoryDescription()
      )));
  }

  @Override
  public CategoriesDto updateData(CategoriesDto entity, Long id) {
    var category = categoriesRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find category with id " + id));

    category.setName(entity.getCategoryName());
    category.setDescription(entity.getCategoryDescription());
    category.setModifiedDate(Instant.now());

    categoriesRepository.save(category);
    return MapperObj.mapToCategoriesDto(categoriesRepository.save(category));
  }

  @Override
  public Long delete(Long id) {
    var category = categoriesRepository.findById(id).orElseThrow(() -> new IllegalStateException("Cannot find category with id " + id));

    categoriesRepository.delete(category);
    return category.getId();
  }

}