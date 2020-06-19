$(function(){
	enterkey();
})


function enterkey(){
	
	$('#chefSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			chefSearch();
			event.preventDefault();
		};
	})
	
	$('#talkSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			myTalkSearch();
			event.preventDefault();
		};
	})
	
}

function searchButtonClick(){
	$('#btnChefSearchInMy').on('click', function(){
		chefSearch();
	})
}

function chefSearch(){
	var key = $('#chefSearchInMy').val();
	console.log("key:"+key);
	
	$.ajax({
		type : "POST",
		url : "/searchMyFollow",
		data : {followChef : key},
		success : function(data){
		console.log(data);
		/*	var result = $('#myFrequent');
			$('.myFrequent').remove();
			var searchedChef = '<div th:class="myFrequent">';
			$.each(data, function(index, value){
				searchedChef = searchedChef+'<table><tbody><tr><td>'+value+'</td></tr></tbody></table>';
			});
			
			result.append(searchedChef+'</div>');
		}*/},
		error : function(){
			alert("ChefSearch Error");
		}
	});
}

function myTalkSearch(){
	var key = $('#talkSearchInMy').val();
	console.log("key:"+key);
	
	$.ajax({
		type : "POST",
		url : "/searchMyTalk",
		data : {talkCont : key},
		success : function(data){
			
			var result = $('#myActivity');
			$('.myTalkMain').remove();
			var searchedChef = '<div th:class="myTalkMain">';
			$.each(data, function(index, value){
				searchedTalk = searchedTalk+'<table><tbody><tr><td>'+value+'</td></tr></tbody></table>';
			});
			
			result.append(searchedTalk+'</div>');
		},
		error : function(){
			alert("TalkSearch Error");
		}
	});
}



function myRecipe(){
	
	/*$('.mypageMain').remove();*/
	$('#mypageMain').load("/mypage/myRecipeIng");
}

function myFrequent(){
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