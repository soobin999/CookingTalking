$(function() {
	/*abcd();*/
	searchedIngr();
   chosung();
   $('#ingrSearchInRefri').on('change', ingrSearch);
   $('#btnIngrSearch').on('click', ingrSearch);
   enterkey();
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
            var result = $('#chosungNum');
            $('#searchedIngr').remove();
            $('#ingrList').remove();
				var list = '<div id="ingrList" class="result-area">'
				$.each(data, function(index, value) {
					if(!$('#selectedIngr > .'+value).val())
						list = list + '<button class="ingrButton '+value+'" value="'+value+'">' + value + '</button>　';
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


	

	
	
	
	