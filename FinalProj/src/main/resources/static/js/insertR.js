	//저장, 완료버튼
	$(document).ready(function(){
 	$("input.submit").click(function(){
    $('#registerStatus').val( ($(this).val()=='등록') ? true : false);
    alert("완료되었습니다!");
    	
    $('#insertRecipe').submit();
   			//document.location.href = 'recipe/newList'; //위치 잘 모르겠음
    	})
	});

	//취소 버튼
 	$(document).ready(function(){
		$("input.cancel").click(function(){
			var result = confirm('취소하시겠습니까?');
			
			if(result) {
				//예
				location.replace('newList'); //글목록 페이지로 이동
			} else {
				//아니오
			}
		});
	}); 
 	
 	//이미지 미리보기
 	var sel_file;
 	
 	$(document).ready(function() {
 		$("#input_img").on("change", handleImgFileSelect);
 	});
 	
 	function handleImgFileSelect(e) {
 		var files = e.target.files;
 		var filesArr = Array.prototype.slice.call(files);
 		
 		filesArr.forEach(function(f) {
 			if(!f.type.match("image.*")) {
 				alert("확장자는 이미지 확장자만 가능합니다.");
 				return;
 			}
 			
 			sel_file = f;
 			
 			var reader = new FileReader();
 			reader.onload = function(e) {
 				$("#img").attr("src", e.target.result);
 			}
 			reader.readAsDataURL(f);
 		});

 	}
