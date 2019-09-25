package com.jerrymouse.base.service.impl;

import com.jerrymouse.base.dao.LabelDao;
import com.jerrymouse.base.pojo.Label;
import com.jerrymouse.base.service.LabelService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {
     @Autowired
     private LabelDao labelDao;
     @Autowired
     private IdWorker idWorker;

     @Override
     public Result<List<Label>> findAll() {
         return Result.createBySuccess(labelDao.findAll());
     }

     @Override
     public Result<Label> findById(String id) {
        return Result.createBySuccess(labelDao.findById(id).get());
     }

     @Override
     public Result update(String id,Label label) {
          label.setId(id);
          labelDao.save(label);
          return Result.createBySuccessMessage("更新成功");
     }

     @Override
     public Result add(Label label) {
            label.setId(idWorker.nextId()+"");
            labelDao.save(label);
            return Result.createBySuccessMessage("新增成功");
     }

     @Override
     public Result deleteById(String id) {
           labelDao.deleteById(id);
           return Result.createBySuccessMessage("删除成功");
     }
}
