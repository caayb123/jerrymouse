package com.jerrymouse.qa.service.impl;

import com.jerrymouse.qa.dao.ProblemDao;
import com.jerrymouse.qa.pojo.Problem;
import com.jerrymouse.qa.service.ProblemService;
import entity.PageResult;
import entity.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import util.IdWorker;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;


@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDao problemDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public Result<PageResult<Problem>> findNewList(String labelId, Integer page, Integer size) {
       //todo
        Pageable pageable= PageRequest.of(page-1,size);
        Page<Problem> newList = problemDao.findNewList(labelId, pageable);
//        newList.getContent().stream().forEach(System.out::println);
        return Result.createBySuccess(new PageResult<Problem>(newList.getTotalElements(),newList.getContent()));
    }

    @Override
    public Result<PageResult<Problem>> findHotList(String labelId, Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Problem> hotList = problemDao.hotList(labelId, pageable);

        return Result.createBySuccess(new PageResult<Problem>(hotList.getTotalElements(),hotList.getContent()));
    }

    @Override
    public Result<PageResult<Problem>> findWaitList(String labelId, Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        Page<Problem> waitList = problemDao.waitList(labelId, pageable);
        return Result.createBySuccess(new PageResult<Problem>(waitList.getTotalElements(),waitList.getContent()));
    }

    @Override
    @Transactional
    public void add(Problem problem) {
        problem.setId(idWorker.nextId()+"");
        problemDao.save(problem);
    }

    @Override
    public List<Problem> findAll() {
       return problemDao.findAll();
    }

    @Override
    public Problem findById(String id) {
        return problemDao.findById(id).get();
    }

    @Override
    public void update(Problem problem,String id) {
        problem.setId(id);
        problemDao.save(problem);
    }

    @Override
    public void delete(String id) {
        problemDao.deleteById(id);
    }

    @Override
    public Result<PageResult<Problem>> search(Problem problem, Integer page, Integer size) {
        Page<Problem> problemPage = problemDao.findAll((root, cq, cb) -> {
            List<Predicate> list = new ArrayList<>();
            if (StringUtils.isNotBlank(problem.getTitle())) {
                list.add(cb.like(root.get("title").as(String.class), "%" + problem.getTitle() + "%"));
            }
            if (StringUtils.isNotBlank(problem.getContent())) {
                list.add(cb.like(root.get("content").as(String.class), "%" + problem.getContent() + "%"));
            }
            return cb.and(list.toArray(new Predicate[list.size()]));
        }, PageRequest.of(page - 1, size));
        return Result.createBySuccess(new PageResult<Problem>(problemPage.getTotalElements(),problemPage.getContent()));
    }



//    public static void main(String[] args) {
//      List<String> list=new ArrayList<>();
//      list.add("张三");
//      list.add("李四");
//      list.add("王五");
//        list.add("张三1");
//        list.add("李四1");
//        list.add("王五1");
//        List<String> collect = list.stream().filter(s -> s.length() == 3).collect(Collectors.toList());
//        list.stream().distinct().forEach(s-> System.out.println());
//        collect.forEach(System.out::println);
//
//    }
}
