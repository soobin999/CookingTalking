$(function(){
	enterkey();
})


function enterkey(){
	
	$('#chefSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			chefSearch();
			event.preventDefault();
		};
	});
	
	$('#talkSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			myTalkSearch();
			event.preventDefault();
		};
	});
	
}

function searchButtonClick(){
	$('#btnChefSearchInMy').on('click', function(){
		chefSearch();
	})
}

function chefSearch(){
	var key = $('#chefSearchInMy').val(); /*쉐프 검색 키워드*/
	console.log("key:"+key);
	
	
	$.ajax({
		type : "POST",
		url : "/searchMyFollow",
		data : { followChef : key
			},
			
		success : function(data){
			console.log(data);
			/*$('#myFrequent').remove();*/
			$('.myFrequent').append('<table><tbody><tr><td>'+data+'</td></tr></tbody></table>');
		},
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
		success : function(data) {
			
			var result = $('#myActivity');
			$('#myTalkMain').remove();
			var searchedTalk = '<div id="myTalkMain">';
			console.log(data);
			$.each(data, function(index, value){
				console.log(data);
				searchedTalk = searchedTalk+value;
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