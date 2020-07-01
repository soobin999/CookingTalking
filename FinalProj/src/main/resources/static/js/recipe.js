$(function() {
  /* selectedIngr();*/
	abcd();
	searchedIngr();
   chosung();
   $('#ingrSearchInRefri').on('change', ingrSearch);
   $('#btnIngrSearch').on('click', ingrSearch);
   enterkey();
/*   clickOffVer1();*/
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
            //console.log(data);
            var result = $('#chosungNum');
            $('#searchedIngr').remove();
            $('#ingrList').remove();
				var list = '<div id="ingrList" class="result-area">'
					//console.log($('#selectedIngr > ingrButton').val);
				$.each(data, function(index, value) {
					if(!$('#selectedIngr > .'+value).val())
						list = list + '<button class="ingrButton '+value+'" value="'+value+'">' + value + '</button>';
				});
				
				list = list + '</div>';
				result.append(list);
			},
			error : function() {
				alert("Chosung Error");
			}
		}).done(function(){
			$('input[name="selectedIngr"]').each(function(index,item){
				var target = $('.ingrButton:contains("'+item.value+'")');
				target.each(function(idx,val){
					console.log($(this));
					if($(this).val() == item.value){
						$(this).addClass('ingrButton--selected')
					}
				})
			})
		})
	});
}
function searchedIngr() {
	   $('#searchedIngr').on('click', function(){
	      console.log("choosing ingr from search");
	      var chosen = $(event.target);
	      console.log(chosen);
	      
	      $('#selectedIngr').append(chosen);
	      
	   })
	}
/*function selectedIngr() {
	$('#chosungNum').on('click','.ingrButton', function(){
		var chosen = $(event.target);
		$('#selectedIngr').append(chosen);
		$('#selectedIngrForm').append(
				'<input type="hidden" id="'+$(event.target).val()+'" name="selectedIngr" value="'+$(event.target).val()+'">'
		);		
	})
}*/

/*$(function(){
	var ingrName = $('.ingrButton').value;
	var selectedIngr = $('#myIngr').value;
	
	console.log(selectedIngr);
	
	$.each(ingrName, function(index, value){
		console.log($(this));
		if(ingrName == selectedIngr){
			console.log($(this));
			$(this).addClass('ingrButton--selected');
			
			
			
		}
	});
	

});*/

function abcd(){
	
	var ingrName = $('.ingrButton').text();
	var selectedIngr = $('#myIngr').text();
	
	
	$.each(ingrName, function(index, value){
		console.log($(this));
		if(ingrName == selectedIngr){
			console.log($(this));
			$(this).addClass('ingrButton--selected');
			
			
			
		}
	});
}



$(document).on("click",".ingrButton", function(event){
	
	var a = $(this).text();
	
	if($(event.target).hasClass('ingrButton--selected')){
		var ingrName = $(event.target).text();
		$(event.target).removeClass('ingrButton--selected');
		$('#selectedIngr > input[name="selectedIngr"]').each(function(index, item){
			if(item.value == ingrName){
				$(this).remove();
				$('#selectedIngr > p:contains('+ingrName+')').remove();
			}
		})
	} else {
		$(this).prop('checked', false);
		$(this).addClass('ingrButton--selected');
		$('#selectedIngr').append(
		'<p id="myIngr">'+$(event.target).text()+'</p>'
		+'<input type="hidden" id="'+$(event.target).text()+'" name="selectedIngr" value="'+$(event.target).text()+'">'
		
		);
		
		
	}
	
});





/*function clickOffVer1(){
	$('.selectedIngr').on('click','.ingrButton', function(){
		var goBack = $(this).text();
		var list ='<button class="ingrButton '+goBack+'" value='+goBack+'>'+goBack+'</button>';
		$('#ingrList').append(list);
		$('.selectedIngr > .'+goBack).remove();
		$('#selectedIngrForm > #'+goBack).remove();
	});
	
}*/
/*
function clickOffVer2(){
	$('.selectedIngr').on('click', function(){
		console.log("back to list on searching");
		var goBack = $(event.target);
		console.log(goBack);
		var list ='<button class="ingrButton1 '+i+++'" value="'+value+'">' + value + '</button>';
		$('#ingrList').append(list);
	})
}*/

/*function sendRcmm(){
	$('.goToRcmmRecipe').on('click',function(event){
		
		console.log($('input[name="selectedIngr"]').val());
	})
}*/


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
					var i=1;
					$.each(data, function(index, value){
						console.log(i);
						list = list+'<button class="ingrButton '+i+++'" value="'+value+'">' + value + '</button>';
					});
					
					result.append(list+'</div>');
				},
				error : function() {
					alert("Search Error");
				}
			}).done(function(){
				$('input[name="selectedIngr"]').each(function(index,item){
					var target = $('.ingrButton:contains("'+item.value+'")');
					target.each(function(idx,val){
						console.log($(this));
						if($(this).val() == item.value){
							$(this).addClass('ingrButton--selected')
						}
					})
				})
			})
	}


	


	
	
	
//	$('.ingrButton').on('click',function(event){
//		$('#selectedIngrForm').append(
//				'<input type="hidden" id="myIngr" name="selectedIngr" value="'+$(event.target).val()+'">'
//		);
//	})
		//var selectedIngr = $('.selectedIngr .ingrButton').val();
		//console.log(selectedIngr);
		//$('#myIngr').val(selectedIngr);	

	



