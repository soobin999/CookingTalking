$(function(){
	selectedIngr();
	ingrSearch();
	$('#ingrSearchInRefri').on('change', ingrSearch);
	$('#btnSearch').on('click',ingrSearch);
	enterkey(); /*도대체 여기는 왜자꾸 콘솔에서 에러 뜨냐구..*/
})

/*엔터쳤을 때 페이지이동 없이 처리하기 위해*/
function enterkey() {
	if (event.keyCode == 13) {
		ingrSearch();
		event.preventDefault();
	};
}

function ingrSearch(){

	var key = $('#ingrSearchInRefri').val();
	console.log("key:"+key);
	
	$.ajax({
		type: "POST",
		url: "/searched",
		data: {ingrName:key},
		dataType : 'TEXT',
		success : function(data){
			console.log(data);
			$('#searchedIngr').text(data);
		},
		error: function(){
			alert("Error");
		}
	});
	
}

function selectedIngr(){
	$().on("click","", function(event){
		var ingrName = $(event.target).text();
		
		var target = $(event.target);
		
		if(target.hassClass()){
			target.removeClass();
			
			$('#selectedIngr>?:contains('+ingrName+')').remove();
			$('input[value"'+ingrName+'"]').remove();
		} else{
			$(this).addClass('');
			$("#selectedIngr").append(
					'<p>'+ingrName+'</p>'
					+'<input type="hidden" name="ingrName" value="'+ingrName+'">'
			)
		}
		
	})
}
