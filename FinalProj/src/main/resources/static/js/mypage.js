$(function(){
	
})

function myRecipe(){
	
	$('#').remove();
	$('#myPageMain').load("mypage/mypage");
}

function myFrequent(){
	$('#').remove();
	$('#myPageMain').load("mypage/myFrequent");
}

function myActivity(){
	$('#').remove();
	$('#myPageMain').load("mypage/myActivity");
}

function myInquiry(){
	$('#').remove();
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