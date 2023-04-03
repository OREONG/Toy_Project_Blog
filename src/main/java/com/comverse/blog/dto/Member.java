package com.comverse.blog.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
@Getter
public class Member {
//    @NotBlank(message = "아이디를 입력해주세요")
//    @Size(min = 4, max=10, message = "아이디는 2자 이상 10자 이하로 입력해주세요")
    private String member_id;

//    @NotBlank(message = "비밀번호를 입력해주세요")
//    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$",
//            message = "비밀번호는 영문, 특수문자, 숫자 포함 8자 이상 입력해주세요")
    private String password;

//    @NotBlank(message = "이름을 입력해주세요")
    private String name;

//    @NotBlank(message = "이메일 주소를 입력해주세요")
//    @Email(message = "올바른 이메일 주소를 입력해주세요")
    private String email;
    private Date reg_date;
    private String del;

}
