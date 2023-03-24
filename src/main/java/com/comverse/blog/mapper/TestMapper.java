package com.comverse.blog.mapper;

import com.comverse.blog.dto.Portfolio;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface TestMapper {
    List<Portfolio> getAllDataList();
}

