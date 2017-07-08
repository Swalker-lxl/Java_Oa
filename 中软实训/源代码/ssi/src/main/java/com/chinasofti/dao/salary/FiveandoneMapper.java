package com.chinasofti.dao.salary;

import java.util.List;

import com.chinasofti.model.salary.Fiveandone;

public interface FiveandoneMapper {
    int deleteByPrimaryKey(String id);

    int insert(Fiveandone record);

    int insertSelective(Fiveandone record);

    Fiveandone selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Fiveandone record);

    int updateByPrimaryKey(Fiveandone record);

	Long count(Fiveandone fiveandone);

	List<Fiveandone> selectList(Fiveandone fiveandone);
}