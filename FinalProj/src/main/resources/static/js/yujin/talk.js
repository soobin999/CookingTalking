$(function() {
	updateTalk();
	deleteTalk();
	comment();
})

function deleteTalk() {
	$('#btnDelete').on('click', function() {
		console.log('aaa')
		$(location).attr('href', '/talk/delete/' + $('#talk-code').val())
		alert('삭제가 완료되었습니다.')
	})
}

// 게시판 삭제 기능

function updateTalk() {
	$('#saveBtn').on('click', function() {
		alert('수정 되었습니다.')
	})
}

function comment() {

	$('#btn_comment').on('click', function() {
		
		var talkCom = $("#talkCom").val();
		var talkComCode = "${talkComCode}";
		var params = {
			"talkCom" : talkCom,
			"talkComCode" : talkComCode
		};
		$.ajax({
			url : "/com/comInsert",
			type : "POST",
			data : {"talkCom": talkCom,
				"talkComCode": talkComCode},

			success : function(data) {
				alert("댓글이 등록되었습니다");
			}
		});
	});
}
// 게시 목록

