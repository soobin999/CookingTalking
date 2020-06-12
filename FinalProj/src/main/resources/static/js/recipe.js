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
					list = list + '<button>' + value + '</button>';
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

function ingrSearch1(){
	 $(".a").click(function(){
		    $(this).hide();
		  });
	  $(".chosung").click(function(){
		  var value = $(this).attr('value');
		  console.log(value);
			$.ajax({
				type : "POST",
				url : "/chosung",
				data : {cs :value},
				/*dataType : 'JSON',*/
				success : function(data){
					console.log(data);
					
					var result = $('#aaaaaa');
					$('#ingrList').remove();
					var list='<div id="ingrList">'
					$.each(data, function(index, value){
						list = list+'<button>' + value + '</button><br><br>';
					});
						list=list+'</div>';
						result.append(list);
				},
				/*	$('#ingrList').text();
					console.log(('#ingrList').text());*/
				
				error : function(){
					alert("Chosung Error");
				}
			});
		  });
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
					list = list+'<button>' + value + '</button>';
				});
				
				result.append(list+'<div>');
			},
			error : function() {
				alert("Search Error");
			}
		});
}


function selectedIngr() {
	$('#chosungNum').on('click', function(){
		console.log("choosing ingr from list");
		var chosen = $(event.target);
		console.log(chosen);
		
		$('#selectedIngr').append(chosen);
		
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
		
		$('#chosungNum').append(goBack);
	})
	
}

function clickOffVer2(){
	$('.selectedIngr').on('click', function(){
		console.log("back to list on searching");
		var goBack = $(event.target);
		console.log(goBack);
		
		$('#searchedIngr').append(goBack);
	})
}
