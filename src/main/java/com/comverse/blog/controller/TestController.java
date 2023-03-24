package com.comverse.blog.controller;

import com.comverse.blog.dto.Portfolio;
import com.comverse.blog.service.TestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TestController {
        @Autowired
        private TestService ts;

      @RequestMapping("test")
        public String test(Model model) {
            List<Portfolio> list = ts.getAllDataList();
            model.addAttribute("list", list);
            System.out.println(list);
            return "test";
        }

        @GetMapping("/main")
        public String main() {

          return "main";
      }

        @GetMapping("/post")
        public String post() {

            return "post";
        }
}
