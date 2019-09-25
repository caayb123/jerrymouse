package com.jerrymouse.base.service;

import com.jerrymouse.base.pojo.Label;
import entity.Result;

import java.util.List;

public interface LabelService {
    Result<List<Label>> findAll();

    Result<Label> findById(String id);

    Result update(String id,Label label);

    Result add(Label label);

    Result deleteById(String id);
}
