package com.comverse.blog.service;

import com.comverse.blog.dto.Member;

public interface MemberService {

    int duplCheck(Member member);

    int insert(Member member);


    Member selectId(String memberId);
}
