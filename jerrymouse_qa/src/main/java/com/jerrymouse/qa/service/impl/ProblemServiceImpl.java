package com.jerrymouse.qa.service.impl;

import com.jerrymouse.qa.dao.ProblemDao;
import com.jerrymouse.qa.pojo.Problem;
import com.jerrymouse.qa.service.ProblemService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;



@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDao problemDao;

    @Override
    public Result<Page<Problem>> findNewList(String labelId, Integer page, Integer size) {
       //todo
        Pageable pageable= PageRequest.of(page,size);
        return Result.createBySuccess(problemDao.findNewList(labelId,pageable));
    }

    @Override
    public Result<Page<Problem>> findHotList(String labelId, Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        return Result.createBySuccess(problemDao.hotList(labelId,pageable));
    }

    @Override
    public Result<Page<Problem>> findWaitList(String labelId, Integer page, Integer size) {
        Pageable pageable= PageRequest.of(page,size);
        return Result.createBySuccess(problemDao.waitList(labelId,pageable));
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
