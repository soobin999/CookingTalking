	//저장, 완료버튼
	$(document).ready(function(){
 	$("input.submit").click(function(){
    $('#registerStatus').val( ($(this).val()=='등록') ? true : false);
    alert("완료되었습니다!");
    	
    $('#insertRecipe').submit();

    	})
	});

	// 취소 버튼
 	$(document).ready(function(){
		$("input.cancel").click(function(){
			var result = confirm('취소하시겠습니까?');
			
			if(result) {
				// 예
				location.replace('newList'); // 글목록 페이지로 이동
			} else {
				// 아니오
			}
		});
	}); 
 	
	// 이미지 미리보기
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
 
	
/*	//요리순서 append
 $(document).ready(function() {
 		$("#btn_add").click(function() {
 			$("ul").append(
 		"<li>
 		<input type="text" name="cok_material_nm_1[]" id="cok_material_nm_1_1" class="form-control"
	style="width: 330px;" th:field="*{rcpIngrVO.userIngr}" placeholder="예) 돼지고기"/> 
	<input type="text" name="cok_material_amt_1[]" id="cok_material_amt_1_1" class="form-control"
	style="width: 280px;" th:field="*{rcpIngrVO.ingrWeigh}" placeholder="예) 300g"/>
	</li>");	
 			
 		});
 	}); */
 	
 	
 	
 	function fn_addFile() {
 		var str = "<p><input type='file' name='file_"+(gfv_count++)+"'>" +
 				"<a href='#this' class='btn' name='delete'>삭제</a></p>"; 
 		$("#fileDiv").append(str); 
 		$("a[name='delete']").on("click", function(e){ //삭제 버튼 
 			e.preventDefault(); 
 			fn_deleteFile($(this)); 
 			});
 		}
