	//이전, 다음, 목록 버튼
	function history.go() {
			window.history.go();
	}
	
	function goPage() {
		
	location.href="/recipe/newList";
	}

// youtube API 불러옴
var tag = document.createElement('script');
tag.src = "https://www.youtube.com/player_api";
var firstScriptTag = document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag, firstScriptTag);

// 플레이어변수 설정
var youTubePlayer1;

function onYouTubeIframeAPIReady() {
    youTubePlayer1 = new YT.Player('youTubePlayer1', {
        width: '1000',
        height: '563',
        videoId: '0Ui6uGHmiks',
        playerVars: {rel: 0},// 추천영상 안보여주게 설정
        events: {
          'onReady': onPlayerReady, // 로딩할때 이벤트 실행
          'onStateChange': onPlayerStateChange // 플레이어 상태 변화시 이벤트실행
        }
    });// youTubePlayer1셋팅
}

function onPlayerReady(event) {
    event.target.playVideo();// 자동재생
    // 로딩할때 실행될 동작을 작성한다.
}

function onPlayerStateChange(event) {
    if (event.data == YT.PlayerState.PLAYING) {
        // 플레이어가 재생중일때 작성한 동작이 실행된다.
    }
  }
 
$(document).ready(function () {
    $(".btn_play").on("click", function () {
        youTubePlayer1.playVideo();// 재생
    });
    $(".btn_stop").on("click", function () {
        youTubePlayer1.stopVideo();// 정지
    });
    $(".btn_pause").on("click", function () {
        youTubePlayer1.pauseVideo();// 일시정지
    });
});