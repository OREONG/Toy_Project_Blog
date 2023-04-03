package com.comverse.blog.service;

import com.comverse.blog.dto.Member;
import com.comverse.blog.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberMapper mm;


    @Override
    public int duplCheck(Member member) {
        return mm.duplCheck(member);
    }

    @Override
    public int insert(Member member) {
        return mm.insert(member);
    }

    @Override
    public Member selectId(String memberId) {
        return mm.selectId(memberId);
    }
}
