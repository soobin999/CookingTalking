var pwJ = /^[A-Za-z0-9]{8,16}$/;
// 비밀번호 정규식
var nameJ = /^[가-힣]{2,6}$/;
// 이메일 검사 정규식

$(function() {

	$("#alert-success").hide();
	$("#alert-danger").hide();
	$("input").keyup(function() {
		var userPw = $("#userPw").val();
		var userPw2 = $("#userPw2").val();
		if (userPw != "" || userPw2 != "") {
			if (userPw == userPw2) {
				$("#alert-success").show();
				$("#alert-danger").hide();
				$("#submit").removeAttr("disabled");
			} else {
				$("#alert-success").hide();
				$("#alert-danger").show();
				$("#submit").attr("disabled", "disabled");
			}
		}
	});
});

// 아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )

var id_btn = 0;
$(function() {

	// idck 버튼을 클릭했을 때
	$("#id_btn").click(function() {

		// userid 를 param.
		var userId = $("#userId").val();

		$.ajax({
			async : true,
			type : 'POST',
			data : userId,
			url : "idCheck.do",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				console.log(data);
				if (data == 1) {

					alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					// 아이디가 존제할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
					$("#divInputId").addClass("has-error")
					$("#divInputId").removeClass("has-success")
					$("#userId").focus();

				} else {
					alert("사용가능한 아이디입니다.");
					// 아이디가 존제할 경우 빨깡으로 , 아니면 파랑으로 처리하는 디자인
					$("#divInputId").addClass("has-success")
					$("#divInputId").removeClass("has-error")
					$("#userpwd").focus();
					// 아이디가 중복하지 않으면 id_btn = 1
					id_btn = 0;

				}
			},
			error : function(error) {

				alert("error : " + error);
			}
		});
	});
});

// 닉네임 체크
var nick_btn = 0;
$(function() {

	// idck 버튼을 클릭했을 때
	$("#nick_btn").click(function() {

		// userid 를 param.
		var nickName = $("#nickName").val();

		$.ajax({
			async : true,
			type : 'POST',
			data : nickName,
			url : "nickNameCheck",
			contentType : "application/json; charset=UTF-8",
			success : function(data) {
				console.log(data);
				if (data == 1) {

					alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
					// 아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
					$("#divInputNick").addClass("has-error")
					$("#divInputNick").removeClass("has-success")
					$("#nickName").focus();

				} else {
					alert("사용가능한 아이디입니다.");
					// 아이디가 존재할 경우 빨강으로 , 아니면 파랑으로 처리하는 디자인
					$("#divInputNick").addClass("has-success")
					$("#divInputNick").removeClass("has-error")
					$("#userpwd").focus();
					// 아이디가 중복하지 않으면 id_btn = 1
					nick_btn = 0;

				}
			},
			error : function(error) {

				alert("error : " + error);
			}
		});
	});
});





//비밀번호 검사 

$(document).ready(function(){
	$("#userPw").change(function() {
		
		checkPassword($('#userPw').val(),
						$('#userId').val());
});

});

function checkPassword(userPw, userId) {

	if (!/^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/
			.test(userPw)) {
		alert('숫자+영문자 조합으로 8자리 이상 사용해야 합니다.');
		
		$('#userPw').val('').focus();
		return false;
	}
	
	var checkNumber = userPw.search(/[0-9]/g);
	var checkEnglish = userPw.search(/[a-z]/ig);
	if (checkNumber < 0 || checkEnglish < 0) {
		alert("숫자와 영문자를 혼용하여야 합니다.");
	
		$('#userPw').val('').focus();
		return false;
	}
	if (/(\w)\1\1\1/.test(userPw)) {
		alert('같은 문자를 4번 이상 사용하실 수 없습니다.');
		$('#userPw').val('').focus();
		return false;
	}

	if (userPw.search(userId) > -1) {
		alert("비밀번호에 아이디가 포함되었습니다.");
		$('#password').val('').focus();
		return false;
	}
	return true;
}



$(document).ready(function() {
	//기본형태
	//$('#registerForm').validate(); //유효성 검사를 적용

	// validate signup form on keyup and submit
	//확장옵션
	$('#registerForm').validate({
		rules : {
			userId : {
				required : true,
				minlength : 3,
				remote : "Validate"
			},
			userPw : "required",
			userPw2 : {
				required : true,
				equalTo : '#userPw'
			},
			nickName : {
				required : true
			},
			gender : {
				required : true
			}
		//
		},
		messages : {
			userId : {
				required : "아이디를 입력하시오.",
				minlength : jQuery.format("아이디는 {0}자 이상 입력해주세요!"),
				remote : jQuery.format("입력하신 {0}는 이미존재하는 아이디입니다. ")
			},
			userPw : "암호를 입력하시오.",
			userPw2 : {
				required : "암호확인를 입력하시오.",
				equalTo : "암호를 다시 확인하세요"
			},

			nickName : {
				required : "닉네임을 입력하시오."
			},

			gender : {
				required : "성별을 선택해 주세요 ."
			}
		},
		submitHandler : function(frm) {
			frm.submit(); //유효성 검사를 통과시 전송

		},
		success : function(e) {
			//
		}

	});
}); //end ready()