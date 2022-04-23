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