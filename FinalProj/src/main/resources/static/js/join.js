<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx = false;
		
		$('#signUp').click(function(){
			if($.trim($('#userId').val()) == ''){
				alert("아이디 입력.");
				$('#userId').focus();
				return;
			}else if($.trim($('#userPw').val()) == ''){
				alert("패스워드 입력.");
				$('#userPw').focus();
				return;
			}
			//패스워드 확인
			else if($('#userPw').val() != $('#passCheck').val()){
				alert('패스워드가 다릅니다.');
				$('#userPw').focus();
				return;
			}
			
			if(idx==false){
				alert("아이디 중복체크를 해주세요.");
				return;
			}else{
				$('#signFrm').submit();
			}
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/idCheck.do",
				type: "GET",
				data:{
					"userId":$('#userId').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#userId').val()) != '' ){
						idx=true;
						$('#userId').attr("readonly",true);
						var html="<tr><td colspan='3' style='color: green'>사용가능</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}else{

						var html="<tr><td colspan='3' style='color: red'>사용불가능한 아이디 입니다.</td></tr>";
						$('#idCheck').empty();
						$('#idCheck').append(html);
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
			

		});
		
	});
</script>