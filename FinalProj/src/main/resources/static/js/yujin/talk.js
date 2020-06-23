$(function(){
	updateTalk();
	deleteTalk();
})

function deleteTalk(){
	$('#btnDelete').on('click',function(){
		$(location).attr('href', '/talk/delete/'+$('#talk-code').val())
		alert('삭제가 완료되었습니다.')	
	})
	
	
}



//게시판 삭제 기능

function updateTalk(){
	$('#saveBtn').on('click',function(){
		alert('수정 되었습니다.')	
	})
	
	
}


