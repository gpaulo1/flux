$(document).ready(function() {
	
	$("#btn-send-form").click(function() {

		var con1 = $("#inp-descricao-receita").val();
		var con2 = $("#inp-vencimento").val();
		var con3 = $("#inp-valor").val();

		var op = false;
		
		if (con1.length == 0) {
			$("#class-descricao-receita").addClass("error");
			op = false;
		}else{
			$("#class-descricao-receita").removeClass("error");
			op = true;
		}

		if (con2.length == 0) {
			$("#class-vencimento").addClass("error");
			op = false;
		}else{
			$("#class-vencimento").removeClass("error");
			op = true;
		}

		if (con3.length == 0) {
			$("#class-valor").addClass("error");
			op = false;
		}else{
			$("#class-valor").removeClass("error");
			op = true;
		}
		
		if(op == true){
			$("#form-id").submit();
		}else{
			$("#bar-one").addClass("active");
		}
		
	});
});