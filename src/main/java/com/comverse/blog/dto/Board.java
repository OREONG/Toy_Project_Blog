package com.comverse.blog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class Board {

    private int board_no;
    private int board_parent;
    private String member_id;
    private String board_title;
    private String board_content;
    private int board_count;
    private Date board_reg;
    private String board_del;

    //	페이징용
    private int startRow;
    private int endRow;

    // 검색용
    private String searchOpn;
    private String keyword;

    // 정렬용
    private String order;
}
