package com.chinasofti.dao.employee;

import java.util.List;

import com.chinasofti.model.employee.Job;

public interface JobMapper {
    int deleteByPrimaryKey(String id);

    int insert(Job record);

    int insertSelective(Job record);

    Job selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Job record);

    int updateByPrimaryKey(Job record);

	Long count(Job job);

	List<Job> selectList(Job job);
}