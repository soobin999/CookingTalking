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
   
}

function searchButtonClick(){
   $('#btnChefSearchInMy').on('click', function(){
      chefSearch();
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


function myRecipe(){
   
   /*$('#mypageMain').remove();*/
   $('#mypageMain').load("/mypage/myRecipeIng");
   console.log("myRecipeIng");
}

function myFrequent(){
   /*$('.mypageMain').remove();*/
   $('#mypageMain').load("/mypage/myFollow");
   console.log("myFollow");
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

