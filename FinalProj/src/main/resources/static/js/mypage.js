
$(document).ready(function(){

	
	Date.prototype.yyyymmdd = function() {
		var yyyy = this.getFullYear().toString();
		var mm = (this.getMonth() + 1).toString();
		var dd = this.getDate().toString();
		return  yyyy + "-" + (mm[1] ? mm : "0" + mm[0]) + "-" + (dd[1] ? dd : "0" + dd[0]);
   
	
	}	
	
   $('#comSearchInMy').on('keydown', function(event){
	   if(event.keyCode == 13){
		   myAllComSearch();
		   event.preventDefault();
		}
	});

   /*쉐프 검색하기 via 엔터*/
   $('#chefSearchInMy').on('keydown', function(event){
      if(event.keyCode == 13){
         chefSearch();
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
    	 /*$('#myAllComMain').remove();*/
         myAllComSearch();
         event.preventDefault();
      }
   })
   



   $('#btnChefSearchInMy').on('click', function(){
      chefSearch();
   });
   
   $('#btnScrapedSearchInMy').on('click', function(){
      myScrapSearch();
   });
   
   $('#btnComSearchInMy').on('click', function(){

	  
	   
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
		   
	   console.dir(paramData);
	  
	  $.ajax({
	     type : "POST",
	     url : ctrlUrl,
	     data : paramData,
	     success : function(data) {
	    	 $('#myMainResult').empty();
	    	 $('#myMainResult').append('<table><br><tbody>'); 
	    	 
	    	 var temp = new Array();
	           
	         var talkCode,talkCom;
	         $.each(data, function(index, value){
	        	 
	         	var com_date = (new Date(data[index].talkComDate)).yyyymmdd();
	         	
	        	console.log(com_date);
	        	 
	            console.log(data);
	            
	            talkCode = data[index].talkCode;
	            talkCom = data[index].talkCom;
	            console.log( data[index].talkCode+"==      talkCode=====>"+talkCode+"  type  "+(typeof selectedV));
	            
	            if(selectedV == "onlyTalk"){
	            	 console.log("onlyTalk========>");
	            	 temp[index] = '<tr id="myAllComMain"><td><a href="/talk/detail/' + talkCode + '">'  + talkCom + '</a></td><td>' + com_date ;
	     		 
	            	 
	     	   }else if(selectedV == "onlyRcp"){
	     		  console.log("onlyRcp========>");
	     		 com_date =  (new Date(data[index].rcpComDate)).yyyymmdd(); 
	     		     temp[index] = '<tr id="myAllComMain"><td><a href="/recipe/view?rcpCode=' + data[index].rcpCode + '">'  + data[index].rcpCom + '</a></td><td>' + com_date ;
	     	   } else{
	     		  if(talkCode.startsWith("T")){
	     			 console.log("T========>");
	     			 temp[index] = '<tr id="myAllComMain"><td><a href="/talk/detail/' + talkCode + '">'  + talkCom + '</a></td><td>' + com_date ;
		          }else if(talkCode.startsWith("R")){
		        	  console.log("R========>");
		        	 temp[index] = '<tr id="myAllComMain"><td><a href="/recipe/view?rcpCode=' + talkCode + '">'  + talkCom + '</a></td><td>' + com_date ;	
		          } 
	     	   }
	     		   
	         }); 
	           
	            
	          
	         $('#myMainReslut').append(temp);
	     },//success
	     error : function(){
	        alert("searchedTalkCom Error");
	         }
	    });
	  
			  
   });// $('#btnComSearchInMy').on('click', function(){   end


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



$('.myInquiryList').on(click, function(){
	$('#mypageMain').load("/mypage/myInquiryList");
	console.log("myInquiryList");
})


function myWritten(){
   $('#mypageMain').load("/mypage/myWritten");
   console.log("myWritten");
}

function myScraped(){
   $('#mypageMain').load("/mypage/myScraped");
   console.log("myScraped");
}




function removeFunc(){
	console.log("removeFunc");
	$('#myAllComMain').remove();
}


});

