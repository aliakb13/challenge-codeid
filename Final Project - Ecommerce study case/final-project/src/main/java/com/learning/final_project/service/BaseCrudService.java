package com.learning.final_project.service;

import java.util.List;

public interface BaseCrudService <ResObj, ID, ReqObj>{
  List<ResObj> getAllData();
  ResObj addData(ReqObj entity);
  ResObj findById(ID id);
  ResObj updateData(ReqObj entity, ID id);
  ID deleteData(ID id);
}
