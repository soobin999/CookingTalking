var acc = document.getElementsByClassName("myAccordion");
var i;

for (i = 0; i < acc.length; i++) {
  acc[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var panel = this.nextElementSibling;
    if (panel.style.display === "block") {
      panel.style.display = "none";
    } else {
      panel.style.display = "block";
    }
  });
}










var sel_file;

$(document).ready(function(){
	$('#input_img').on("change", handleImgFileSelect);
});

function handleImgFileSelect(e){
	var files = e.target.files;
	var file = $('#input_img')[0].files[0];
	console.log(files);
	var filesArr = Array.prototype.slice.call(files);

		filesArr.forEach(function(f){
			if(!f.type.match("image.*")){
				alert("확장 가능한 이미지 파일이 아닙니다");
				return false;
				
			}
			sel_file = f;
			
			var reader = new FileReader();
			reader.onload = function(e){
				$('#img').attr("src", e.target.result);
				
			}
			reader.readAsDataURL(f);
		});
		
	
}


$(document).ready(function(){

	
	Date.prototype.yyyymmdd = function() {
		var yyyy = this.getFullYear().toString();
		var mm = (this.getMonth() + 1).toString();
		var dd = this.getDate().toString();
		return  yyyy + "-" + (mm[1] ? mm : "0" + mm[0]) + "-" + (dd[1] ? dd : "0" + dd[0]);
   
	
	}	
	
	
	
	
	

	$(document).ready(function(){
		
		   $('.qnaAns').each(function(index){

			      var ans = $(this).data('answer');
			      var ansId = $(this).data('id');
			      console.log(ans)
			      
			      if(ans != null){
			         $('#' + ansId).append("답변완료");
			      }
			      console.log(index)
			      showAns('#' + ansId)
			  })
		
	});
	
	
	
	
	
	
	
	function showAns(showTarget){
		   $(showTarget).on('click', function(e){
		      var showItem = $(e.target).closest('.myInq-list').find('#showAns');
		      showItem.text($(e.target).data('answer'))
		   })
		};
		
		
		

	$('#chefSearchInMy').on('keydown', function(event){ 
		if(event.keyCode == 13){
			chefSearch();
		    event.preventDefault();
		};
	});
	

   $('#btnChefSearchInMy').on('click', chefSearch);
		   
		   
function chefSearch(){
	   var inputSearchKey = $('#chefSearchInMy').val();
	   
	   $.ajax({
		      type : "POST",
		      url : "/searchMyFollow",
		      data : {followChef : inputSearchKey},
		      success : function(data) {
		      $('#myFollowResult').empty();
			  $('#myFollowResult').append('<table><br><tbody>');
			  
			  var searchedChef = new Array();
			  
			  var nickName, followC;

			  $.each(data, function(index, value){
				  
				  nickName = data[index].nickName;
				  followC = data[index].followC;
				  
				  searchedChef[index] = '<tr id="myFollowMain"><td><a href="/chefInfo/1/'+ nickName + '">' + nickName + '</a></td><td>' + followC
			            
		         });
			  $('#myFollowResult').append(searchedChef);
		      },
		      error : function(){
		         alert("chefSearch Error");
		      }
		   });
   }














$('#scrapedSearchInMy').on('keydown', function(event){
    if(event.keyCode == 13){
       myScrapedSearch();
       event.preventDefault();
    }
 });


   $('#btnScrapedSearchInMy').on('click', myScrapedSearch);
   
   
   function myScrapedSearch(){
	   var inputSearchKey = $('#scrapedSearchInMy').val();
	   
	   $.ajax({
		      type : "POST",
		      url : "/searchMyScrap",
		      data : {rcpTitle : inputSearchKey},
		      success : function(data) {
		      $('#myScrapedResult').empty();
			  $('#myScrapedResult').append('<table><br><tbody>');
			  
			  var searchedScrap = new Array();
			  
			  var rcpCode;

			  $.each(data, function(index, value){
				  
				  var scrap_date = (new Date(data[index].scrapDate)).yyyymmdd();
				  
				  rcpCode = data[index].rcpCode;
				  
				  searchedScrap[index] = '<tr id="myAllComMain"><td><a href="/recipe/view?rcpCode='+ rcpCode + '">' + data[index].rcpPic + '</a></td><td><a href="/recipe/view?rcpCode=' + 
				  rcpCode + '">' + data[index].rcpTitle + '</a></td><td>' + scrap_date
			            
		         });
			  $('#myScrapedResult').append(searchedScrap);
		      },
		      error : function(){
		         alert("scrapedSearch Error");
		      }
		   });
	   
   }
   
   
   
   
   
   
   
   $('#talkSearchInMy').on('keydown', function(event){
	    if(event.keyCode == 13){
	       talkSearch();
	       event.preventDefault();
	    }
	 });


	   $('#btnTalkSearchInMy').on('click', talkSearch);
	   
	   
	   function talkSearch(){
		   var inputSearchKey = $('#talkSearchInMy').val();
		   
		   $.ajax({
			      type : "POST",
			      url : "/searchMyTalk",
			      data : {talkCont : inputSearchKey},
			      success : function(data) {
			      $('#myTalkResult').empty();
				  $('#myTalkResult').append('<table><br><tbody>');
				  
				  var searchedTalk = new Array();
				  
				  $.each(data, function(index, value){
					  
					  var talk_date = (new Date(data[index].talkDate)).yyyymmdd();
					  
					  searchedTalk[index] = '<tr id="myTalkMain"><td><a href="/talk/detail/'+ data[index].talkCode + '">' + data[index].talkCont + '</a></td><td>' + talk_date;
				            
			         });
				  $('#myTalkResult').append(searchedTalk);
			      },
			      error : function(){
			         alert("talkSearch Error");
			      }
			   });
		   
	   }
   
   
   
   
   
   
   
   
   
   
   
   
   
	$('#comSearchInMy').on('keydown', function(event){ 
		if(event.keyCode == 13){
			allComSearch();
		    event.preventDefault();
		};
	});
   

   $('#btnComSearchInMy').on('click', allComSearch);
		
		
   
   function allComSearch(){

	   var inputSearchKey = $('#comSearchInMy').val(); 
	   var selectedV = document.getElementById("comSelect").options[document.getElementById("comSelect").selectedIndex].value;
	   
	 
	  
	   var  ctrlUrl="/searchMyAllCom";
	   var  paramData={talkCom : inputSearchKey};
	
	   
	   if(selectedV == "onlyTalk"){
		  
		   ctrlUrl="/searchMyTalkCom";
		 
	   }else if(selectedV == "onlyRcp"){
		   
		   ctrlUrl="/searchMyRcpCom";
		   paramData={rcpCom : inputSearchKey};
		   
	   }
		   
	  $.ajax({
	     type : "POST",
	     url : ctrlUrl,
	     data : paramData,
	     success : function(data) {
	    	 $('#myComResult').empty();
	    	 $('#myComResult').append('<table><br><tbody>'); 
	    	 
	    	 var searchedCom = new Array();
	           
	         var talkCode,talkCom;
	         $.each(data, function(index, value){
	        	 
	         	var com_date = (new Date(data[index].talkComDate)).yyyymmdd();
	         	
	            talkCode = data[index].talkCode;
	            talkCom = data[index].talkCom;
	            
	            if(selectedV == "onlyTalk"){
	            	searchedCom[index] = '<tr id="myAllComMain"><td><a href="/talk/detail/' + talkCode + '">'  + talkCom + '</a></td><td>' + com_date;

	            }else if(selectedV == "onlyRcp"){
	     		   com_date =  (new Date(data[index].rcpComDate)).yyyymmdd();
	     		   searchedCom[index] = '<tr id="myAllComMain"><td><a href="/recipe/view?rcpCode=' + data[index].rcpCode + '">'  + data[index].rcpCom + '</a></td><td>' + com_date;
	     	   
	            } else{
	            	if(talkCode.startsWith("T")){
	            		searchedCom[index] = '<tr id="myAllComMain"><td><a href="/talk/detail/' + talkCode + '">'  + talkCom + '</a></td><td>' + com_date;
	            		}else if(talkCode.startsWith("R")){
	            			searchedCom[index] = '<tr id="myAllComMain"><td><a href="/recipe/view?rcpCode=' + talkCode + '">'  + talkCom + '</a></td><td>' + com_date;
	            			} 
	            	}
	            }); 
	           
	         $('#myComResult').append(searchedCom);
	     },//success
	     error : function(){
	        alert("searchedTalkCom Error");
	         }
	    });
   };

   
   
   
   
 
function deleteMyRcp(){
	var button = document.getElementsByName('deleteMyRcpBtn');
	console.log(button);
	var key = a.value;
	console.log("key : " + key);
}





$('.myRecipeBtn').on('click', function(){
	$('#mypageMain').load("/mypage/myRecipeIng");
	console.log("myRecipeIng");
});



$('.myFrequentBtn').on('click', function(){
   $('#mypageMain').load("/mypage/myFollow");
   console.log("myFrequentBtn");
});



$('.myActivityBtn').on('click', function(){
	$('#mypageMain').load("/mypage/myTalk");
	console.log("myActivityBtn");
});


$('.myInquiryBtn').on('click', function(){
	$('#mypageMain').load("/mypage/myInquiry");
	console.log("myInquiryBtn");
});


$('.myComBtn').on('click', function(){
	$('#mypageMain').load("/mypage/myCom");
	console.log("myComBtn");
});



$('.myInquiryList').on('click', function(){
	$('#mypageMain').load("/mypage/myInquiryList");
	console.log("myInquiryList");
});


$('.myWrittenBtn').on('click', function(){
	$('#mypageMain').load("/mypage/myWritten");
	console.log("myWritten");
});


$('.myScrapedBtn').on('click', function(){
	$('#mypageMain').load("/mypage/myScraped");
	console.log("myScraped");
});




$(document).ready(function(){
	
	 $('#sendInq').click(function(){
	      
	      var myInqTitle = $('#qnaTitle').val();
	      var myInqCont = $('#qnaCont').val();
	      
	      if(myInqTitle && myInqCont != null){
	    	  alert("정상적으로 접수되었습니다");
	    	  return true
	      } else{
	    	  alert("제목과 내용 모두 입력해주세요");
	    	  return false
	      }
	   });
	
})



});

