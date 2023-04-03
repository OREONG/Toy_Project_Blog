package com.comverse.blog.mapper;

import com.comverse.blog.dto.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    int duplCheck(Member member);

    int insert(Member member);

    Member selectId(String memberId);
}