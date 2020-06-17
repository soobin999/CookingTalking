$(function(){
	
})

function myRecipe(){
	
	$('#myBasic').remove();
	$('#myPageMain').load("mypage/mypage");
}

function myFrequent(){
	$('#myBasic').remove();
	$('#myPageMain').load("mypage/myFrequent");
}

function myActivity(){
	$('#myBasic').remove();
	$('#myPageMain').load("mypage/myActivity");
}

function myInquiry(){
	$('#myBasic').remove();
	$('#myPageMain').load("mypage/myInquiry");
}

function writtenRecipe(){
	
	$(".writtenRecipe").click(function(){
		
		$.ajax({
			type : "POST",
			url : "/written",
			data : 
			success : function(){
				$('#').remove();
				
				$.each(data, function(index, value){
					
				});
				
			},
			error : function(){
				alert("Written Recipe Error");
			}
		})
	})
}

function myScrapedRecipe(){
	$(".scrapedRecipe").click(function(){
		
		$.ajax({
			type : "POST",
			url : "/scraped",
			data : 
			success : function(){
				$('#').remove();
				
				$.each(data, function(index, value){
					
				});
			},
			error : function(){
				alert("Scraped Recipe Error");
			}
		})
	})
}

fucntion myInqList(){
	
	$(".myInquiryList").click(function(){
		
		$(.ajax)({
			type : "POST",
			url : "/myInq",
			data : 
			succes : function(){
				$('#').remove();
				
				$.each(data, function(index, value){
					
				});
			},
			error : function(){
				alert("Inquiry List Error");
			}
		})
	})
	
}
