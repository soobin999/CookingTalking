$(function(){
	enterkey();
	answer();
})

function answer(){
	
	var ans = $('#answer').val();
	
	if(ans != null){
		$('#answer').append("답변완료");
	} else 
		$('#answer').append("답변미등록");
}


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

function deleteMyRcp(){
	var button = document.getElementsByName('deleteMyRcpBtn');

	
	//var a = document.getElementById('deleteMyRcpBtn');
	console.log(button);
	var key = a.value;
	console.log("key : " + key);
	/*$.ajax({
		type : "POST",
		url : "/deleteRcp",
		data : {rcpCode : key},
		success : function(data){
			
		}
	})*/
	
}

function chefSearch(){
	var key = $('#chefSearchInMy').val(); /*토크 검색 키워드*/

	$.ajax({
		type : "POST",
		url : "/searchMyFollow",
		data : {followChef : key},
		success : function(data) {
			var searchedChef;
			var result = $('#myFrequent');
			$('#myChefMain').remove();
			$.each(data, function(index, value){
				searchedChef = '<tr id="myChefMain"><td>' + data[index].nickName
				+ '</td><td>' + data[index].followC
				+ '</td></tr><br>'
				console.log("data.nickName:"+value.nickName);
				console.log("data.followC:"+value.followC);
				result.append(searchedChef);
			});
		},
		error : function(){
			alert("chefSearch Error");
		}
	});
}

function myTalkSearch(){
	var key = $('#talkSearchInMy').val(); /*토크 검색 키워드*/

	$.ajax({
		type : "POST",
		url : "/searchMyTalk",
		data : {talkCont : key},
		success : function(data) {
			var searchedTalk;
			var result = $('#myActivity');
			$('#myTalkMain').remove();
			$.each(data, function(index, value){
				searchedTalk = '<tr id="myTalkMain"><td>' + data[index].talkCont
				+ '</td><td>' + data[index].talkDate
				+ '</td></tr><br>'
				console.log("data.talkCont:"+value.talkCont);
				console.log("data.talkDate:"+value.talkDate);
				result.append(searchedTalk);
			});
		},
		error : function(){
			alert("TalkSearch Error");
		}
	});
}

function myScrapSearch(){
	var key = $('#scrapedSearchInMy').val(); /*스크랩 검색 키워드*/

	$.ajax({
		type : "POST",
		url : "/searchMyScrap",
		data : {rcpTitle : key},
		success : function(data) {
			var searchedScrap;
			var result = $('#myFrequentSub');
			$('#myScrapededMain').remove();
			$.each(data, function(index, value){
				console.log(data);
				searchedScrap = '<tr id="myScrapededMain"><td>' + data[index].rcpTitle
				+ '</td><td>' + data[index].scrapDate
				+ '</td></tr><br>'
				console.log("data.rcpTitle:"+value.rcpTitle);
				console.log("data.scrapDate:"+value.scrapDate);
				result.append(searchedScrap);
			});
		},
		error : function(){
			alert("myScrapSearch Error");
		}
	});
}


function myAllComSearch(){
	var key = $('#comSearchInMy').val(); /*스크랩 검색 키워드*/

	var selectedV = document.getElementById("comSelect").options[document.getElementById("comSelect").selectedIndex].value;
	
	if(selectedV == "onlyTalk"){
		$.ajax({
			type : "POST",
			url : "/searchMyTalkCom",
			data : {talkCom : key},
			success : function(data) {
				var searchedTalkCom;
				var result = $('#myActivity');
				$('#myAllComMain').remove();
				$.each(data, function(index, value){
					console.log(data);
					searchedTalkCom = '<tr id="myAllComMain"><td>' + data[index].talkCom
					+ '</td><td>' + data[index].talkComDate
					+ '</td></tr><br>'
					console.log("data.talkCom:"+value.talkCom);
					console.log("data.talkComDate:"+value.talkComDate);
					result.append(searchedTalkCom);
				});
			},
			error : function(){
				alert("searchedTalkCom Error");
			}
		});
	} else if(selectedV == "onlyRcp") {
	
		$.ajax({
			type : "POST",
			url : "/searchMyRcpCom",
			data : {rcpCom : key},
			success : function(data) {
				var searchedRcpCom;
				var result = $('#myActivity');
				$('#myAllComMain').remove();
				$.each(data, function(index, value){
					console.log(data);
					searchedRcpCom = '<tr id="myAllComMain"><td>' + data[index].rcpCom
					+ '</td><td>' + data[index].rcpComDate
					+ '</td></tr><br>'
					console.log("data.rcpCom:"+value.rcpCom);
					console.log("data.rcpComDate:"+value.rcpComDate);
					result.append(searchedRcpCom);
				});
			},
			error : function(){
				alert("searchedRcpCom Error");
			}
		});
		
	} else {
	
	$.ajax({
		type : "POST",
		url : "/searchMyAllCom",
		data : {talkCom : key},
		success : function(data) {
			var searchedAllCom;
			var result = $('#myActivity');
			$('#myAllComMain').remove();
			$.each(data, function(index, value){
				console.log(data);
				searchedAllCom = '<tr id="myAllComMain"><td>' + data[index].talkCom
				+ '</td><td>' + data[index].talkComDate
				+ '</td></tr><br>'
				console.log("data.talkCom:"+value.talkCom);
				console.log("data.talkComDate:"+value.talkComDate);
				result.append(searchedAllCom);
			});
		},
		error : function(){
			alert("myAllComSearch Error");
		}
	});
	
	}
}

function myRecipe(){
	
	/*$('.mypageMain').remove();*/
	$('#mypageMain').load("/mypage/myRecipeIng");
}

function myFrequent(){
	$('#mypageSubMain').remove();
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

function showAns(){
	
	$('#myQnATitle').on('click', function(){
		
		var myQnACont = $('#myQnACont').innerText();
		var answer = $('#answer').val();
		
		
	})
}