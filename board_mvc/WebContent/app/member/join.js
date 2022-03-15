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

let check = false;

function formSubmit() {
	var form = document.joinForm;
	
	if(!form.memberId.value || !check){
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
	check = false;
	
	if(id == ""){
		$("#idCheck_text").text("");
		return;
	}
	
	$.ajax({
		url:contextPath + "/member/MemberCheckIdOk.me?memberId=" + id,
		type:"get",
		dataType: "json",
		success:function(result){
			if(result.status == 'ok'){
				$("#idCheck_text").text("사용가능");
				$("#idCheck_text").css("color", "blue");
				check = true;
			} else{
				$("#idCheck_text").text("사용불가");
				$("#idCheck_text").css("color", "red");							
			}
		},
		error:function(){
			console.log("오류");
		}
	});
}

$("input[name='memberId']").keyup(function() {
	checkId($(this).val());
})