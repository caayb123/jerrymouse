package com.jerrymouse.base.service.impl;

import com.jerrymouse.base.dao.CityDao;
import com.jerrymouse.base.pojo.City;
import com.jerrymouse.base.pojo.Label;
import com.jerrymouse.base.service.CityService;
import entity.PageResult;
import entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service(value = "cityService")
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    @Transactional
    public void add(City city) {
        city.setId(idWorker.nextId()+"");
        cityDao.save(city);
    }

    @Override
    public List<City> findAll() {

        return cityDao.findAll();
    }

    @Override
    public void update(City city,String id) {
        city.setId(id);
        cityDao.save(city);
    }

    @Override
    public void delete(String id) {
        cityDao.deleteById(id);
    }

    @Override
    public City findById(String id) {
        return cityDao.findById(id).get();
    }

    @Override
    public Result<PageResult<City>> search(City city, Integer page, Integer size) {
       Page<City> cityPage= cityDao.findAll((root,cq,cb)->{
             List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(city.getName())){
                list.add(cb.like(root.get("name").as(String.class),  city.getName()));
            }
            if (StringUtils.isNotBlank(city.getIsHot())){
                list.add(cb.like(root.get("isHot").as(String.class),  city.getIsHot()));
            }
             return cb.and(list.toArray(new Predicate[list.size()]));
         },PageRequest.of(page - 1, size));
        return Result.createBySuccess(new PageResult<City>(cityPage.getTotalElements(),cityPage.getContent()));
    }
}
