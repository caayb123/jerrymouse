package com.jerrymouse.base.dao;

import com.jerrymouse.base.pojo.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityDao extends JpaRepository<City,String>, JpaSpecificationExecutor<City> {

}
