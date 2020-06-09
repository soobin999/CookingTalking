package com.cook.talk.model.dto;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import com.cook.talk.model.VO.QnAVO;
import com.cook.talk.model.VO.UserVO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
	private Long id;
	
	@NotBlank(message = "닉네임은 필수 입력 값입니다.")
    private String nickName;
	
	 @NotBlank(message = "이메일은 필수 입력 값입니다.")
	 @Email(message = "이메일 형식에 맞지 않습니다.")
	    private String userId;
	 
	 @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
	 @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{8,16}",
	 message = "영문 +숫자 조합 8~16자리 ")
	 private String userPw;
	 
	 
	 @Builder
	 public UserDTO(String userId, String userPw,String nickName,Date birth,
			 boolean gender) {
		 this.userId=userId;
		 this.userPw=userPw;
		 this.nickName=nickName;
		 this.birth=birth;
		 this.gender=gender;
		 
	 }
		 
	private UserVO user;
	private QnAVO qna;

	private Date birth;

	private boolean gender;

	public static CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setPassword(String encode) {
		// TODO Auto-generated method stub

	}
}