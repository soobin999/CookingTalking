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
					$("#userid").focus();

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
