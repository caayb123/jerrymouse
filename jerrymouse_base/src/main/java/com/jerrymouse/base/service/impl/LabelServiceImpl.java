package com.jerrymouse.base.service.impl;

import com.jerrymouse.base.dao.LabelDao;
import com.jerrymouse.base.pojo.Label;
import com.jerrymouse.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import util.IdWorker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    @Override
    public Result<PageResult<Label>> findSearch(Label label, Integer page, Integer size) {
         if (page==null){
            page=1;
        }
        if (size==null){
            page=2;
        }
        Page<Label> labelPage = labelDao.findAll(new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<>();
                if (StringUtils.isNotBlank(label.getLabelName())) {
                    list.add(criteriaBuilder.like(root.get("labelName").as(String.class), "%" + label.getLabelName() + "%")); //where labelname like %?%
                }
                if (StringUtils.isNotBlank(label.getState())) {
                    list.add(criteriaBuilder.equal(root.get("state").as(String.class), label.getState())); // state= ?
                }
                if (StringUtils.isNotBlank(label.getRecommend())) {
                    list.add(criteriaBuilder.equal(root.get("recommend").as(String.class), label.getRecommend())); // recommend= ?
                }
                return criteriaBuilder.and(list.toArray(new Predicate[list.size()]));
            }
        }, PageRequest.of(page - 1, size));
        return Result.createBySuccess(new PageResult<Label>(labelPage.getTotalElements(),labelPage.getContent()));
    }

    @Override
    public List<Label> topList(String recommend) {
        return labelDao.findByRecommend(recommend);
    }


}
