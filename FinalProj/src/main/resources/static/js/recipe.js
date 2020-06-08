$(function(){
	selectedIngr();
	ingrSearch();
	$('#ingrSearchInRefri').on('change', ingrSearch);
	 $('#btnSearch').on('click',ingrSearch);
})

function ingrSearch(){
		    var key = $('#ingrSearchInRefri').val();
		    console.log("key : "+key);
		   
		    var ingrList = $('#ingrList > li');

		    $.each(ingrList, function(index, item){	
		        var title = $(this).find(".tit-area .tit").text();
		        console.log("title :  "+title);
		       
		        if( title.includes(key) ){
		            $(this).show();
		        }else{
		            $(this).hide();
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
