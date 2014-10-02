$(document).ready(function() {

	$("#btn-salvar-registro").click(function() {

		var Cliente = new Object();

		Cliente.tipoPessoa = $("#slc-tp-pessoa").val();
		Cliente.cnpj = $("#inp-cnpj").val();
		Cliente.cpf = $("#inp-cpf").val();
		Cliente.inscricaoEstadual = $("#inp-inscricao-estadual").val();
		Cliente.rg = $("#inp-rg").val();
		Cliente.razaoSocial = $("#inp-razao-social").val();
		Cliente.fantasia = $("#inp-fantasia").val();
		Cliente.inscricaoMunicipal = $("#inp-inscricao-municipal").val();
		Cliente.nome = $("#inp-nome").val();
		Cliente.cep = $("#find-cep").val();
		Cliente.endereco = $("#inp-endereco").val();
		Cliente.numero = $("#inp-numero").val();
		Cliente.bairro = $("#inp-bairro").val();
		Cliente.complemento = $("#inp-complemento").val();
		Cliente.cidade = $("#inp-cidade").val();
		Cliente.estado = $("#slc-estado").val();
		Cliente.email = $("#inp-email").val();
		Cliente.telefone = $("#inp-telefone").val();
		
		$.ajax({
			type : "post",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(Cliente),
			url : '/dev_module-WEB/cliente/salvar',
			statusCode : {
				200 : function(data) {
				},
				404 : function(data) {
				}
			}
		}).done(function() {

		});
		
	});
});
