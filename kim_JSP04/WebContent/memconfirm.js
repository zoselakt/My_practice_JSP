/**
 * 
 */

function mem_check() {
	if(document.join_frm.id.value.length == 0){
		alert("아이디를 입력해주세요");
		join_frm.id.focus();
		return;
	}
	if(document.join_frm.id.value.length < 6){
		alert("아이디는 최소 6글자 이상이어야 합니다.")
		join_frm.id.focus();
		return;
	}
	if(document.join_frm.pw.value != document.join_frm.pw_confirm.value){
		alert("비밀번호를 입력하세요")
		join_frm.pw.focus();
		return;
	}
	if(document.join_frm.name.value.length == 0){
		alert("이름을 입력하세요")
		join_frm.name.focus();
		return;
	}
	if(document.join_frm.email.value.length == 0){
		alert("이메일을 입력하세요")
		join_frm.email.focus();
		return;
	}
	document.join_frm.submit();
}

function updateInfo() {
	
	if(document.modify_frm.pw.value == ""){ // 입력한값이  빈값과 같다면 오류출력
		alert("패스워드를 입력하세요.")
		document.modify_frm.pw.focus();
		return;
	}
	if(document.modify_frm.pw.value != document.pw_confirm.value){ //입력한 값이 pw_comfirm의 값과 다르다면
		alert("패스워드가 일치하지않습니다.")
		document.modify_frm.pw.focus();
		return;
	}
	document.modify_frm.submit();
}