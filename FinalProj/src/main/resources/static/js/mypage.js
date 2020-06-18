$(function(){
	
})

function myRecipe(){
	
	/*$('.mypageMain').remove();*/
	$('#mypageMain').load("/mypage/myRecipeIng");
}

function myFrequent(){
/*	$('.myRecipeBasic').remove();
	$('.myWrittenMain').remove();
	$('.myRecipeIngMain').remove();*/
	$('#mypageSuvMain').remove();
	$('#mypageMain').load("/mypage/myFollow");
	console.log("myFrequent");
}

function myActivity(){
	$('#myBasic').remove();
	$('#mypageMain').load("/mypage/myTalk");
}

function myCom(){
	$('#myBasic').remove();
	$('#mypageMain').load("/mypage/myCom");
}

function myInquiryList(){
	$('#myBasic').remove();
	$('#mypageMain').load("/mypage/myInquiryList");
}

function myInquiry(){
	$('#myBasic').remove();
	$('#mypageMain').load("/mypage/myInquiry");
}

function myWritten(){
	$('#mypageMain').load("/mypage/myWritten");
	console.log("myWritten");
}

function myScraped(){
	$('#mypageMain').load("/mypage/myScraped");
	console.log("myScraped");
}

function sendInq(){
	
	$('.sendInq').click(function(){
		
		var myInqTitle = $('.myInqTitle').val();
		var myInqCont = $('.myInqCont').val();
		
		if(myInqTitle && myInqCont != null){
			alert("정상적으로 접수되었습니다");
		} else{
			alert("제목과 내용 모두 입력해주세요");
		}
	})
	
}