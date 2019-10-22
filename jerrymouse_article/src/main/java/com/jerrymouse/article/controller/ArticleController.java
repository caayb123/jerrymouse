package com.jerrymouse.article.controller;

import com.jerrymouse.article.service.ArticleService;
import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PutMapping(value = "/state/{id}")
    public Result check(@PathVariable(value = "id")String id){

        int check = articleService.check(id);
        if (check>0){
            return Result.createBySuccessMessage("审核成功");
        }else {
            return Result.createByError("审核失败");
        }

    }
    @PutMapping(value = "/thumbup/{id}")
    public Result thumbup(@PathVariable(value = "id")String id){
        int thumbup = articleService.thumbup(id);
        if (thumbup>0){
            return Result.createBySuccessMessage("点赞成功");
        }else {
            return Result.createByError("点赞失败");
        }
    }
    @GetMapping(value = "/{id}")
    public Result findById(@PathVariable(value = "id") String id){
        return Result.createBySuccess(articleService.findArticleById(id));
    }

}
