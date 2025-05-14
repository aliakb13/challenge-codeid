package com.example.SpringRestChallenge.service;

import java.util.List;

public interface BaseService<T, ID> {
  List<T> getAllData();
  T addData(T entity);
  T findDataById(ID id);
  T updateData(T entity, ID id);
  ID delete(ID id);
}
