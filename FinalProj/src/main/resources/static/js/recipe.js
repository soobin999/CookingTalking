$(function() {
   selectedIngr();
   searchedIngr();
   chosung();
   $('#ingrSearchInRefri').on('change', ingrSearch);
   $('#btnIngrSearch').on('click', ingrSearch);
   enterkey();
   clickOffVer1();
   clickOffVer2();
})

function chosung() {

   $(".chosung").click(function() {
      var value = $(this).attr('value');
      console.log(value);
      
      $.ajax({
         type : "POST",
         url : "/chosung",
         data : {cs : value},
         success : function(data) {
            console.log(data);
            var result = $('#chosungNum');
            $('#searchedIngr').remove();
            $('#ingrList').remove();
				var list = '<div id="ingrList">'
				$.each(data, function(index, value) {
					list = list + '<button class="ingrButton" value="'+value+'">' + value + '</button>';
				});
				list = list + '</div>';
				result.append(list);
			},
			error : function() {
				alert("Chosung Error");
			}
		});
	});
}

function enterkey() {
   $('#ingrSearchInRefri').on('keydown',function(event){
      var thirteen = event.keyCode;
      if (thirteen == 13) {
         ingrSearch();
         event.preventDefault();
      };
   })
   
}


function searchButtonClick(){
	$('#btnIngrSearch').on('click', function(){
		ingrSearch();
	})
}


function ingrSearch() {
		var key = $('#ingrSearchInRefri').val();
		console.log("key:" + key);
		
		$.ajax({
			type : "POST",
			url : "/searched",
			data : {ingrName : key},
			success : function(data) {
				
				var result = $('#chosungNum');
				$('#ingrList').remove();
				var list='<div id="ingrList">';
				$.each(data, function(index, value){
					list = list+'<button class="ingrButton" value="'+value+'">' + value + '</button>';
				});
				
				result.append(list+'</div>');
			},
			error : function() {
				alert("Search Error");
			}
		});
}


function selectedIngr() {
	$('body').on('click','.ingrButton', function(){
		console.log("choosing ingr from list");
		var chosen = $(event.target);
		
		console.log(chosen);
		
		$('#selectedIngr').append(chosen);
		$('#selectedIngrForm').append(
				'<input type="hidden" id="myIngr" name="selectedIngr" value="'+$(event.target).val()+'">'
		);		
	})
}

function searchedIngr() {
   $('#searchedIngr').on('click', function(){
      console.log("choosing ingr from search");
      var chosen = $(event.target);
      console.log(chosen);
      
      $('#selectedIngr').append(chosen);
      
   })
}

function clickOffVer1(){
	$('.selectedIngr').on('click', function(){
		console.log("back to list on chosung");
		var goBack = $(event.target);
		
		console.log(goBack)
		$('#chosungNum').append(goBack);
		$('#selectedIngr').remove();
	});
	
}

function clickOffVer2(){
	$('.selectedIngr').on('click', function(){
		console.log("back to list on searching");
		var goBack = $(event.target);
		console.log(goBack);
		
		$('#searchedIngr').append(goBack);
		$('#selectedIngr').remove();
	})
}

function sendRcmm(){
	$('.goToRcmmRecipe').on('click',function(event){
		
		console.log($('input[name="selectedIngr"]').val());
	})
	
	
	
	
//	$('.ingrButton').on('click',function(event){
//		$('#selectedIngrForm').append(
//				'<input type="hidden" id="myIngr" name="selectedIngr" value="'+$(event.target).val()+'">'
//		);
//	})
		//var selectedIngr = $('.selectedIngr .ingrButton').val();
		//console.log(selectedIngr);
		//$('#myIngr').val(selectedIngr);	

	
}


