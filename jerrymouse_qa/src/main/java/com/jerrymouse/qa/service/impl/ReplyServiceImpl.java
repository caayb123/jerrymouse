package com.jerrymouse.qa.service.impl;

import com.jerrymouse.qa.dao.ReplyDao;
import com.jerrymouse.qa.pojo.Reply;
import com.jerrymouse.qa.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

@Service(value = "replyService")
public class ReplyServiceImpl implements ReplyService {
    @Autowired
    private ReplyDao replyDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public void add(Reply reply) {
        reply.setId(idWorker.nextId()+"");
        replyDao.save(reply);
    }

    @Override
    public List<Reply> findAll() {
        return replyDao.findAll();
    }

    @Override
    public Reply findById(String id) {
        return replyDao.findById(id).get();
    }

    @Override
    public void update(Reply reply, String id) {
        reply.setId(id);
        replyDao.save(reply);
    }

    @Override
    public void delete(String id) {
        replyDao.deleteById(id);
    }

    @Override
    public List<Reply> findByProblem(String problemId) {
       return replyDao.findByProblemId(problemId);
    }
}
