$(function(){
   enterkey();
   answer();
})

 Date.prototype.yyyymmdd = function() {
      var yyyy = this.getFullYear().toString();
      var mm = (this.getMonth() + 1).toString();
      var dd = this.getDate().toString();
      return  yyyy + "-" + (mm[1] ? mm : "0" + mm[0]) + "-" + (dd[1] ? dd : "0" + dd[0]);
  }

function answer(){
   

   $('.qnaAns').each(function(index){

      var ans = $(this).data('answer');
      var ansId = $(this).data('id');
      console.log(ans)
      
      if(ans != null){
         $('#' + ansId).append("답변완료");
      }
      
      showAns('#' + ansId)
   })
   
}

function showAns(showTarget){
   $(showTarget).on('click', function(e){
      var showItem = $(e.target).closest('.myInq-list').find('#showAns');
      showItem.text($(e.target).data('answer'))
   })
}


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

function chefSearch(){
   var key = $('#chefSearchInMy').val(); /*토크 검색 키워드*/
   console.log("chefSearCH")
   $.ajax({
      type : "POST",
      url : "/searchMyFollow",
      data : {followChef : key},
      success : function(data) {
         var searchedChef;
         var result = $('#myFrequent');
         $('#myChefMain').remove();
         $.each(data, function(index, value){
        	console.log("dk"+data);
           /* searchedChef = '<tr id="myChefMain"> <td>'
            + '<a href="/chefInfo/1/'+ data[index].nickName+ '">'
            + data[index].nickName + '</a>'
            + '</td> <td>' + data[index].followC
            + '</td> </tr><br>'
            console.log("data.nickName:"+value.nickName);
            console.log("data.followC:"+value.followC);
            result.append(searchedChef);*/
         });
      },
      error : function(){
         alert("chefSearch Error");
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
        	 
       	  var scrap_date = (new Date(data[index].scrapedDate)).yyyymmdd();
    	  console.log(scrap_date);
        	 
            console.log("dk"+data);
            searchedScrap = '<tr id="myScrapededMain"><td>'
            + '<a href="/recipe/view?rcpCode='
            + data[index].rcpCode + '">'
            + data[index].rcpPic + '</a>'
            + '</td><td>' + '<a href="/recipe/view?rcpCode=' 
            + data[index].rcpCode + '">'
            + data[index].rcpTitle + '</a>' 
            + '</td><td>' + scrap_date
            + '</td></tr><br>'
            console.log("data.rcpTitle:"+value.rcpTitle);
            console.log("data.scrapDate:"+scrap_date);
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
	  /* $('#myAllComMain').remove();*/
	   
      $.ajax({
         type : "POST",
         url : "/searchMyTalkCom",
         data : {talkCom : key},
         success : function(data) {
            var searchedTalkCom;
            var result = $('#myActivity');
            $('#myAllComMain').remove();
            /*result.remove();*/
            $.each(data, function(index, value){
            	
            	var com_date = (new Date(data[index].TalkComDate)).yyyymmdd();
            	console.log(com_date);
            	
               console.log(data);
               searchedTalkCom = '<tr id="myAllComMain"><td>' 
               + '<a href="/talk/detail/'
               + data[index].talkCode + '">'
               + data[index].talkCom + '</a>'
               + '</td><td>' + com_date
               + '</td></tr><br>'
               console.log("data.talkCom:"+value.talkCom);
               console.log("data.talkComDate:"+com_date);
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
            	
            	var com_date = (new Date(data[index].TalkComDate)).yyyymmdd();
            	console.log(com_date);
            	
               console.log(data);
               searchedRcpCom = '<tr id="myAllComMain"><td>' + data[index].rcpCom
               + '</td><td>' + com_date
               + '</td></tr><br>'
               console.log("data.rcpCom:"+value.rcpCom);
               console.log("data.rcpComDate:"+com_date);
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
        	 
         	var com_date = (new Date(data[index].TalkComDate)).yyyymmdd();
        	console.log(com_date);
        	 
            console.log(data);
            searchedAllCom = '<tr id="myAllComMain"><td>' + data[index].talkCom
            + '</td><td>' + com_date
            + '</td></tr><br>'
            console.log("data.talkCom:"+value.talkCom);
            console.log("data.talkComDate:"+com_date);
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