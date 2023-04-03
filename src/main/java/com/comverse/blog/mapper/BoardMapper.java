package com.comverse.blog.mapper;

import com.comverse.blog.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> boardList(Board board);

    Board selectPost(int board_no);

    List<Board> reviewList(int boardNo);

    int getTotal(Board board);

    int reviewInsert(Board board);

    int postInsert(Board board);

    int postDelete(int boardNo);

    int postUpdate(Board board);

    int updateCount(int boardNo);
}
