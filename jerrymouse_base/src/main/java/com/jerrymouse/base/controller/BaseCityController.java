package com.jerrymouse.base.controller;

import com.jerrymouse.base.pojo.City;
import com.jerrymouse.base.service.CityService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/city")
public class BaseCityController {
    @Autowired
    private CityService cityService;

    @PostMapping
    public Result add(City city){
        cityService.add(city );
        return Result.createBySuccessMessage("城市新增成功");
    }
    @GetMapping
    public Result findAll(){
        return Result.createBySuccess(cityService.findAll());
    }
    @PutMapping(value = "/{id}")
    public Result update(City city,@PathVariable(value = "id") String id){
        cityService.update(city,id);
        return Result.createBySuccessMessage("修改城市信息成功");
    }
    @DeleteMapping(value = "/{id}")
    public Result delete(@PathVariable (value = "id")String id){
        cityService.delete(id);
        return Result.createBySuccessMessage("城市删除成功");
    }
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id")String id){
        return Result.createBySuccess(cityService.findById(id));
    }
    @GetMapping(value = "/search/{page}/{size}")
    public Result search(City city,@PathVariable(value = "page")Integer page,@PathVariable (value = "size")Integer size){
      return cityService.search(city,page,size);
    }

}
