<script type="text/javascript">
// 공백 체크 정규식
var emp = /\s/g;
// 아이디 정규식
var id=/^[0-9a-zA-Z] ([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*[a-zA-Z]{2,3}$/i;
// 비밀번호 정규식
var pw=/^[A-Za-z0-9]{8,16}$/;

var birthJ=false;

// 아이디 확인
$(document).ready(function(){
	if($('#userId').var()==''){
		$('#userId').text('아이디를 입력하세요.');
		$('#userId').css('color','red');
		
	}else if (idJ.test($('userId'.val())!=true){
		$('#userId').text('아이디는 이메일 형식만 가능합니다.');
		$('#userId').css('color','red');
	}else if ($('userId').val()!=''{
	
		var userId=$('#userId').val();
		
	$.ajax({
		async:true,
		type:'POST',
		data: {id : $('#userId'.val()},// useId라는 이름으로 데이터를 @webServlet(/)에 보내겠다
		url: "/idCheck",
		dataType:'json',
		contextType:"application/json; charset=UTF-8",
		success:function(data){
			
			  if($.trim(data)=="YES"){
				  if($('#userId').val()!=''){
				$('#idCheck').text('중복된 아이디 입니다.');
				$('#idCheck').css('color', 'red'); 
				$("#usercheck").attr("disabled", true);
				  }
				  
			}else {
				if(idJ.test(userId)){ 
					$('#idCheck').text('사용가능한 아이디 입니다.');
					$('#idCheck').css('color', 'blue'); 
					$("#usercheck").attr("disabled", false); 
					} else if
					(mem_id==''){ 
						$('#idCheck').text('아이디를 입력해주세요.'); 
						$('idCheck').css('color', 'red'); 
						$("#usercheck").attr("disabled", true); 
						} else{
							$('#idCheck').text("아이디는 이메일형식만 가능합니다."); 
							$('#idCheck').css('color', 'red'); 
							$("#usercheck").attr("disabled", true);
							}
						}
					}
	});// ajax///
	}// else if

			});// blur
	$('form').on('submit',function(){ 
		var inval_Arr = new Array(8).fill(false); 
		if (idJ.test($('#userId').val())) {
			
			inval_Arr[0] = true;
			} else {
				inval_Arr[0] = false; 
			alert('아이디를 확인하세요.'); 
			return false; } // 비밀번호가 같은 경우 && 비밀번호 정규식
		if (($('#userPw').val() == ($('#userPw').val())) 
				&& pwJ.test($('#userPw').val())) { 
			inval_Arr[1] = true; 
			} else { 
				inval_Arr[1] = false; 
				alert('비밀번호를 확인하세요.'); 
				return false; }

		)// 성별 확인
		if(UserVO.gender[0].checked==false&& UserVO.gender[1].checked==false){
			inval_Arr[6] = false; 
			alert('성별을 확인하세요.'); 
			return false; 
			} else{
				inval_Arr[6] = true; 
				}
	// 전체 유효성 검사
	var validAll = true; 
	for(var i = 0; i < inval_Arr.length; i++){ 
		if(inval_Arr[i] == false){ 
			validAll = false; 
			} 
		} 
	if(validAll == true){ // 유효성 모두 통과
		alert('회원가입을 축하합니다.'); 
		} else{ 
			alert('정보를 다시 확인하세요.') 
			} 
	});
	
	$('#userId').blur(function() {
		if (idJ.test($('#userId').val())) { 
			console.log('true'); 
			$('#idCheck').text(''); 
			} else { 
				console.log('false'); 
				$('#idCheck').text('5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.'); 
				$('#idCheck').css('color', 'red');
				} 
		}); 
	$('#userPw').blur(function() {
		if (pwJ.test($('#userPw').val())) {
			console.log('true'); 
			$('#pwCheck').text(''); 
			} else { 
				console.log('false'); 
				$('#pwCheck').text('4~12자의 숫자 , 문자로만 사용 가능합니다.'); 
				$('#pwCheck').css('color', 'red'); 
				} 
		}); // 1~2 패스워드 일치 확인
	$('#pw2Check').blur(function() {
		if ($('#userPw').val() != $(this).val()) {
			$('#pw2Check').text('비밀번호가 일치하지 않습니다.'); 
			$('#pw2Check').css('color', 'red'); 
			} else { 
				$('#pw2Check').text('');
				} 
		});
	// 생일 유효성 검사
	var birthJ = false; 
	// 생년월일 birthJ 유효성 검사
	$('#birth').blur(function(){ 
		var dateStr = $(this).val(); 
		var year = Number(dateStr.substr(0,4)); 
		// 입력한 값의 0~4자리까지 (연)
		var month = Number(dateStr.substr(4,2)); 
		// 입력한 값의 4번째 자리부터 2자리 숫자 (월)
		var day = Number(dateStr.substr(6,2)); 
		// 입력한 값 6번째 자리부터 2자리 숫자 (일)
		var today = new Date(); 
		// 날짜 변수 선언
		var yearNow = today.getFullYear(); 
		// 올해 연도 가져옴
		if (dateStr.length <=8) { 
			// 연도의 경우 1900 보다 작거나 yearNow 보다 크다면 false를 반환합니다.
			if (year > yearNow || year < 1900 ){
				$('#birthcheck').text('생년월일을 확인해주세요'); 
				$('#birthcheck').css('color', 'red');
			}

	
		}
	}
	$('#join_btn').on('click', function(event) {
		event.preventDefault();
		if (is == 'true') {
			alert('회원가입이 완료 되었습니다. 로그인 해 주세요!');
			joinForm.action = "join.do";
			joinForm.method = "POST";
			joinForm.submit();
		} else if (is == 'false') {
			alert('조건에 맞지 않는 항목이 있습니다.');
		}}



