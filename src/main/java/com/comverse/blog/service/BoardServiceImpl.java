package com.comverse.blog.service;

import com.comverse.blog.dto.Board;
import com.comverse.blog.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper bm;
    @Override
    public List<Board> boardList(Board board) {
        return bm.boardList(board);
    }

    @Override
    public Board selectPost(int board_no) {
        return bm.selectPost(board_no);
    }

    @Override
    public List<Board> reviewList(int board_no) {
        return bm.reviewList(board_no);
    }

    @Override
    public int getTotal(Board board) {
        return bm.getTotal(board);
    }

    @Override
    public int reviewInsert(Board board) {
        return bm.reviewInsert(board);
    }

    @Override
    public int postInsert(Board board) {
        return bm.postInsert(board);
    }

    @Override
    public int postDelete(int boardNo) {
        return bm.postDelete(boardNo);
    }

    @Override
    public int postUpdate(Board board) {
        return bm.postUpdate(board);
    }

    @Override
    public int updateCount(int boardNo) {
        return bm.updateCount(boardNo);
    }

}
