package com.comverse.blog.service;

import com.comverse.blog.dto.Board;

import java.util.List;

public interface BoardService {
    List<Board> boardList(Board board);

    Board selectPost(int board_no);

    List<Board> reviewList(int board_no);

    int getTotal(Board board);

    int reviewInsert(Board board);

    int postInsert(Board board);

    int postDelete(int boardNo);

    int postUpdate(Board board);

    int updateCount(int boardNo);
}
