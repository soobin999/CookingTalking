$(function(){
	enterkey();
})


function enterkey(){
	/*쉐프 검색하기 via 엔터*/
	$('#chefSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			chefSearch();
			event.preventDefault();
		};
	});
	
	/*토크 검색하기 via 엔터*/
	$('#talkSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			myTalkSearch();
			event.preventDefault();
		};
	});
	
	/*스크랩 검색하기 via 엔터*/
	$('#scrapedSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			myScrapSearch();
			event.preventDefault();
		}
	});
	
	/*모든 코멘트 검색하기 via 엔터*/
	$('#comSearchInMy').on('keydown', function(event){
		if(event.keyCode == 13){
			myAllComSearch();
			event.preventDefault();
		}
	})
	
}

function searchButtonClick(){
	$('#btnChefSearchInMy').on('click', function(){
		chefSearch();
	});
	
	$('#btnTalkSearchInMy').on('click', function(){
		myTalkSearch();
	});
	
	$('#btnScrapedSearchInMy').on('click', function(){
		myScrapSearch();
	});
	
	$('#btnComSearchInMy').on('click', function(){
		myAllComSearch();
	});
}

function chefSearch(){
	var key = $('#chefSearchInMy').val(); /*쉐프 검색 키워드*/
	console.log("key:"+key);
	
	
	$.ajax({
		type : "POST",
		url : "/searchMyFollow",
		data : { followChef : key},
			
		success : function(data){
			
			var result = $('#myFrequent');
			$('#myChefMain').remove();
			var searchedChef = '<div id="myChefMain">';
			console.log(data);
			$.each(data, function(index, value){
				console.log(data);
				searchedChef = searchedChef+value;
			});
			
			result.append(searchedChef+'</div>');
			
		},
		error : function(){
			alert("ChefSearch Error");
		}
	});
}

function myTalkSearch(){
	var key = $('#talkSearchInMy').val(); /*토크 검색 키워드*/
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

function myScrapSearch(){
	var key = $('#scrapedSearchInMy').val(); /*스크랩 검색 키워드*/
	console.log("key:"+key);
	
	$.ajax({
		type : "POST",
		url : "/searchMyScrap",
		data : {rcpTitle : key},
		success : function(data) {
			
			var result = $('#myFrequent');
			$('#myScrapededMain').remove();
			var searchedScrap = '<div id="myScrapededMain">';
			console.log(data);
			$.each(data, function(index, value){
				console.log(data);
				searchedScrap = searchedScrap+value;
			});
			
			result.append(searchedScrap+'</div>');
			
		},
		error : function(){
			alert("ScrapSearch Error");
		}
	});
}


function myAllComSearch(){
	var key = $('#comSearchInMy').val(); /*쉐프 검색 키워드*/
	console.log("key:"+key);
	
	
	$.ajax({
		type : "POST",
		url : "/searchMyAllCom",
		data : { talkCom : key},
			
		success : function(data){
			
			var result = $('#myActivity');
			$('#myAllComMain').remove();
			var searchedAllCom = '<div id="myAllComMain">';
			console.log(data);
			$.each(data, function(index, value){
				console.log(data);
				searchedAllCom = searchedAllCom+value+'<br>';
			});
			
			result.append(searchedAllCom+'</div>');
			
		},
		error : function(){
			alert("searchedAllCom Error");
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