package com.comverse.blog.service;

import com.comverse.blog.mapper.TestMapper;
import com.comverse.blog.dto.Portfolio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private TestMapper tm;

    @Override
    public List<Portfolio> getAllDataList() {
        System.out.println(1);
        return tm.getAllDataList();
    }
}
