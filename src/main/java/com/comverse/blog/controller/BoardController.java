package com.comverse.blog.controller;

import com.comverse.blog.dto.Board;
import com.comverse.blog.service.BoardService;
import com.comverse.blog.service.PagingBean;
import jakarta.servlet.http.HttpSession;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BoardController {

        @Autowired
        private BoardService bs;


        @RequestMapping("/")
        public String main(HttpSession session, Model model, Board board, String pageNum, String searchOpn, String keyword, String order) {
            String member_id = (String)session.getAttribute("member_id");

            // 검색
            if (keyword != null) {
                board.setSearchOpn(searchOpn);
                board.setKeyword(keyword);
            }

            // 페이징
            int rowPerPage = 5; // 페이지 당 게시글 갯수
            // 페이지 이동 or새로고침 시 1페이지로 지정
            int currentPage = 1;
            try {
                if (pageNum != null && !pageNum.equals("")) {
                    currentPage = Integer.parseInt(pageNum);
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            // 글 갯수 전부를 가져옴
            int total = bs.getTotal(board);
            // 해당 페이지의 첫 글 번호
            int startRow = (currentPage - 1) * rowPerPage + 1;
            // 해당 페이지의 마지막 글 번호
            int endRow = startRow + rowPerPage -1;

            board.setStartRow(startRow);
            board.setEndRow(endRow);
            PagingBean pb = new PagingBean(currentPage, rowPerPage, total);

            board.setOrder(order);
            List<Board> boardList = bs.boardList(board);

            model.addAttribute("boardList", boardList);
            model.addAttribute("pb", pb);
            model.addAttribute("member_id", member_id);
            model.addAttribute("order", order);
            model.addAttribute("searchOpn", searchOpn);
            model.addAttribute("keyword", keyword);

          return "main";
      }

        @RequestMapping("/post")
        public String post(HttpSession session, Model model, int board_no) {
            String member_id = (String)session.getAttribute("member_id");

            int result = bs.updateCount(board_no);
            Board board = bs.selectPost(board_no);

            // 불러온 board_content를 Document타입으로 형변환
            Document doc = Jsoup.parse(board.getBoard_content());
            board.setDoc(doc);

            List<Board> reviewList = bs.reviewList(board_no);

            model.addAttribute("board", board);
            model.addAttribute("reviewList", reviewList);
            model.addAttribute("member_id", member_id);
            return "post";
        }

        @RequestMapping("/writeForm")
        public String postInsert(HttpSession session) {
            return "writeForm";
        }

        @RequestMapping("/write")
        public String write(HttpSession session, Model model, Board board) {
            String member_id = (String)session.getAttribute("member_id");
            board.setMember_id(member_id);
            int result = bs.postInsert(board);

            model.addAttribute("member_id", member_id);
            model.addAttribute("result", result);
            return "write";
        }

        @RequestMapping("/reviewInsert")
        public String reviewInsert(HttpSession session, Model model, Board board, int parent_board_no) {
            String member_id = (String)session.getAttribute("member_id");
            board.setMember_id(member_id);

            board.setBoard_parent(parent_board_no);
            int result = bs.reviewInsert(board);

            model.addAttribute("member_id", member_id);
            model.addAttribute("result", result);
            return "post";
        }

    @RequestMapping("/postDelete")
    public String postDelete(Model model, int board_no) {
            System.out.println(board_no);
            int result = bs.postDelete(board_no);

            model.addAttribute("result", result);
            return "postDelete";
    }

    @PostMapping("/reviewDelete/{board_no}")
    @ResponseBody
    public ResponseEntity<String> reviewDelete(@PathVariable("board_no") int board_no) {
        try {
            int result = bs.postDelete(board_no);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping("/postUpdateForm")
    public String postUpdateForm(Model model, Board board) {

            model.addAttribute("board", board);
        return "postUpdateForm";
    }

    @RequestMapping("/postUpdate")
    public String postUpdate(Model model, Board board) {
        System.out.println(board);
        int result = bs.postUpdate(board);
        model.addAttribute("result", result);
            return "postUpdate";
    }

    @RequestMapping("/reviewUpdate")
    public String reviewUpdate(Model model, Board board) {
        System.out.println(board);
        int result = bs.postUpdate(board);
        model.addAttribute("result", result);
            return "post";
    }

}
