package com.jerrymouse.qa.dao;

import com.jerrymouse.qa.pojo.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ProblemDao extends JpaRepository<Problem,String>, JpaSpecificationExecutor<Problem> {
        @Query(value = "SELECT * FROM `tb_problem` as bl,tb_pl as pl where bl.id=pl.problemid and pl.labelid=:labelid ORDER BY bl.replytime desc",nativeQuery = true)
        Page<Problem> findNewList(@Param(value = "labelid") String labelId, Pageable pageable);
        @Query(value = "SELECT * FROM `tb_problem` as bl,tb_pl as pl where bl.id=pl.problemid and pl.labelid=:labelid ORDER BY bl.reply desc",nativeQuery = true)
        Page<Problem> hotList(@Param(value = "labelid") String labelId, Pageable pageable);
        @Query(value = "SELECT * FROM `tb_problem` as bl,tb_pl as pl where bl.id=pl.problemid and pl.labelid=:labelid and reply=0 ORDER BY bl.createtime desc",nativeQuery = true)
        Page<Problem> waitList(@Param(value = "labelid") String labelId, Pageable pageable);

}
