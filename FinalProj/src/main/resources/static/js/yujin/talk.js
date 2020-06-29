$(function() {
	updateTalk();
	deleteTalk();
	comment();
	deleteCom();
	talkSave();
	/* com_Delete(); */
	comUpdate();
	comDelete();
	// insertLike();
	// deleteLike();
	// showComUpdate();
})

// 게시판 삭제 기능
function deleteTalk() {
	$('#btnDelete').on('click', function() {
		console.log('aaa')
		$(location).attr('href', '/talk/delete/' + $('#talk-code').val())
		alert('삭제가 완료되었습니다.')
	})
}

function updateTalk() {
	$('#saveBtn').on('click', function() {
		alert('수정 되었습니다.')
	})
}

// 게시 목록

function comment() {
	$('#btn_comment').on('click', function() {

		$.ajax({
			url : "/com/comInsert",
			type : "POST",
			data : {
				talkCode : $('#talk_code').val(),
				talkComCode : $('#talkComCode').val(),
				userId : $('#userId').val(),
				talkCom : $('#talk-comment').val()
			}
		}).done(function(data) {
			alert('등록되었습니다');
			location.reload();
		}).fail(function(request, error, status) {
			console.log("code:" + request.status + "\n");
			console.log("msg:" + request.responseText + "\n");
			console.log("error:" + error + "\n");
			alert('comment insert fail');
		})
	})
}

/* 댓글 삭제 */
function deleteCom() {
	$('#btn_Delete').on('click', function() {
		console.log('aaa')
		$(location).attr('href', '/com/delete/' + $('#talkcom-code').val())
		alert('삭제가 완료되었습니다.')
	})
}
// 이미지 등록
function talkSave() {
	$('#btnSave').on('click', function() {
		var file = $('#talk-file')[0].files[0];
		var fileName = '';
		if (file != null)
			fileName = file.name;
		else if (file == null)
			fileName = $('#talk-img').data('img');

		var forData = new FormData();
		forData.append("imgFile", file);
		$.ajax({
			url : '/com/talk/upload',
			type : 'post',

			data : formData,
			enctype : 'multipart/form-data',
			contentType : false,
			processData : false,
			cache : false
		}).done(function() {
			alert('등록되었습니다')
		}).fail(function() {
			alert('upload fail')
		})
	})
}
// 댓글 수정
function showComUpdate(talkComCode) {
	$.ajax({
		type : "get",
		url : "/talk/detail/",
		success : function(result) {
			$("#modifyCom").html(result);
			$("#modifyCom").css("visibility", "visible");
		}
	})
}
// 댓글 수정
function comUpdate() {

	$("#com_update").click(function() {
		$.ajax({
			type : "put",
			url : "/com/update /${talkComCode}",
			headers : {
				"Content-Type" : "application/json"
			},
			data : JSON.stringify,
			dataType : "text",
			success : function(result) {
				if (result == "success") {
					$("modifiyCom").css("visibility", "hidden");

				}
			}

		});
	});
}

function comDelete() {

	$("#com_Delete").click(function() {
		var com = $(this).attr('value');

		if (confirm($(this).attr('value') + " 삭제하시겠습니까?")) {

			$.ajax({
				method : "post",
				url : '/com/deletCom/${talkComCode}',
				data : {
					talkComCode : com
				},
				success : function(result) {
					if (result == "success") {
						alert("삭제되었습니다");
						$("modifiyCom").css("visibility", "hidden");

					}
				}
			})

		}

	})

};

/*
 * function insertLike(){ $('comLike_btn').on('click',function(event){
 * event.preventDefault(); var talkVO={
 * 
 * userId :'${user.userId}', talkCode:'${talk.talkCode}', }; $.ajax({
 * url:'/talk/' }) }) }
 */

/*
 * function com_Delete(rno, callback, error) { $('#com_Delete').on('click',
 * function() {
 * 
 * $.ajax({ type : 'delete', url : '/com/deletCom/{talkComCode}', success :
 * function(deleteResult, status, xhr) { if (call back) {
 * callback(deleteResult); } }, error : function (xhr, status, er) { if (error) {
 * error(er); } }
 * 
 * }); }) }
 */
/*
 * function updateCom(){ S('#com_update').click(function(){
 * if(confirm("수정하시겠습니까?")){ var talkCode = $("#talkCode").val(); var talkCont =
 * $("textarea#talkCont").text(); var userId = $("#userId").val(); var
 * talkComCode= $("#talkComCode").val(); // 변수에 저장 var curPage =
 * $("#curPage").val(); var search_option = $("#search_option").val(); var
 * keyword = $("#keyword").val();
 * 
 * document.form1.action="reply_update.do?rno="+rno+"&r_content="+encodeURI(r_content)+"&user_id="+user_id+"&member_bno="+member_bno+"&curPage="+curPage+"&search_option="+search_option+"&keyword="+keyword;
 * document.form1.submit();
 * 
 * 
 * alert("댓글이 수정되었습니다.") } }); } }) }
 * 
 * 
 */