$(function() {
	  ingrSearch();
	  ingrSearch1();
	  $('#ingrSearchInRefri').on('change', ingrSearch);
	  $('#btnIngrSearch').on('click', ingrSearch);
/*	selectedIngr();
	enterkey();  도대체 여기는 왜자꾸 콘솔에서 에러 뜨냐구.. 
	chosung();*/
})

/* 엔터쳤을 때 페이지이동 없이 처리하기 위해  but 지금 엔터키 안먹힘*/
function enterkey() {
	if (event.keyCode == 13) {
		ingrSearch();
		event.preventDefault();
	};
}
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
	$('#btnIngrSearch').on('click', function(){
		var key = $('#ingrSearchInRefri').val();
		console.log("key:" + key);
		
		$.ajax({
			type : "POST",
			url : "/searched",
			data : {ingrName : key},
			/*dataType : 'JSON',*/
			success : function(data) {
				
				var result = $('#ingrList');
				$('#ingrList').remove();
				$.each(data, function(index, value){
					var list = '<button>' + value + '</button><br><br>';
					if(index == 0) result.html(list);
					else result.append(list);
				});
				
			},
			error : function() {
				alert("Search Error");
			}
		});
	})

}

function chosung(){
	
/*	$('.chosung').click(function(){
		alert("dfs")
	
		console.log("r");
		$.ajax({
			type : "GET",
			url : "/chosung",
			data : {ingrList : ('#ingrList').val()}
			dataType : 'JSON',
			success : function(data){
				$('#ingrList').text();
				console.log(('#ingrList').text());
			},
			error : function(){
				alert("Chosung Error");
			}
		});
		)
	}*/	
}

function selectedIngr() {
	$()
			.on(
					"click",
					"",
					function(event) {
						var ingrName = $(event.target).text();

						var target = $(event.target);

						if (target.hassClass()) {
							target.removeClass();

							$('#selectedIngr>?:contains(' + ingrName + ')')
									.remove();
							$('input[value"' + ingrName + '"]').remove();
						} else {
							$(this).addClass('');
							$("#selectedIngr")
									.append(
											'<p>'
													+ ingrName
													+ '</p>'
													+ '<input type="hidden" name="ingrName" value="'
													+ ingrName + '">')
						}

					})
}
