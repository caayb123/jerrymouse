package com.jerrymouse.base.service;

import com.jerrymouse.base.pojo.City;
import entity.PageResult;
import entity.Result;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CityService {
     void add(City city);
     List<City> findAll();
     void update(City city,String id);
     void delete(String id);
     City findById(String id);
     Result<PageResult<City>> search(City city, Integer page, Integer size);
}
