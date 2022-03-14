/**
 * 회원가입
 */

$("#term").on("click", function(){
	if($(this).is(":checked")){
		$(".terms").prop("checked", true);
	} else{
		$(".terms").prop("checked", false);
	}
})

$(".term-detail a").on("click", function(e) {
	e.preventDefault();
	$("#" + $(this).attr("href")).show();
})

function formSubmit() {
	var form = document.joinForm;
	
	if(!form.memberId.value){
		alert("아이디를 확인해주세요.");
		return;
	}
	
	check = false;
	$.each($(".terms"), function(index, item) {
		if(!$(item).is(":checked")){
			check = true;
		}
	});
	
	if(check){
		alert("이용약관 동의가 필요합니다.");
		return;
	}	
	form.submit();
}

function checkId(id) {
	if(id == ""){
		$("#idCheck_text").text("");
	}
	
	$.ajax({
		url:contextPath + "/member/MemberCheckIdOk.me?id=" + id,
		type:"get",
		dataType: "json",
		success:function(result){
			
		},
		error:function(){
			console.log("오류");
		}
	});
}