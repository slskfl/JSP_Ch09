alert("Hi");
function joinCheck(){
	 var input=document.frm;
	   if(!input.name.value){
	      alert("이름 입력하세요.");
	      input.name.focus();
	      return false;
	   
	   }else if(!input.userid.value){
	      alert("아이디를 입력하세요.");
	      input.userid.focus();
	      return false;
	   }else if(input.userid.value.length<4){
	      alert("아이디는 4글자 이상 입력해주세요.");
	      input.userid.focus();
	      return false;
	   } else if(!input.pwd.value){
		   alert("암호는 반드시 입력해야합니다.");
		   input.pwd.focus();
		   return false; 
	   } else if(input.pwd.value != input.pwd_check.value ){
		   alert("암호가 일지하지 않습니다.");
		   input.pwd.focus();
		   return false; 
	   }
	   return true;
	   
	   /*if(document.frm.name.value.length == 0){ 
		   alert("이름을 입력하세요."); 
		   document.frm.name.focus(); 
		   return false; 
	   }*/
}
