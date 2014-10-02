$(document).ready(function() {
	
	$("#msg-success-plan").hide();
	$("#msg-novo-registro").hide();
	
	// funcao de adicionar um novo caixa
	$("#novo_caixa").click(function() {
		$("#msg-success-plan").hide();

		var Caixa = {
			"nome" : $(".testee").dropdown('get value'),
			"numConta" : $("#conta-banco").val(),
			"numAgencia" : $("#agencia-banco").val(),
			"numDigito" : $("#digito-banco").val(),
			"saldoInicial" : $("#saldo-banco").val(),
			"nomeAgencia" : $("#nome-agencia").val(),
			"saldo" : {"saldoDisponivel" : $("#saldo-banco").val(),
					   "saldoCredito" : 0.0,
					   "saldoDebito" : 0.0}
		};

		$.ajax({
			type : "post",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(Caixa),
			url : 'planejamento/novo-caixa',
			statusCode : {
				200 : function(data) {
					$("#msg-success-plan").show(150);
					clearModal();
					addCaixa(data);
				},
				404 : function(data) {
					alert(JSON.stringify(data));
				}
			}
		}).done(function() {

		});
	});
	// fim

});

function addCaixa(data) {
	$(".list-caixas")
			.append(
					"<div class='item'>"
							+ "<div class='right floated mini positive mini ui button' id='" + data.id + "' onclick='getIdCaixa(this.id)'>Fluxo</div>"
							+ "<img class='ui avatar image' src='"
							+ data.urlIcone + "'>" + "<div class='content'>"
							+ "<div class='header'>" + data.nome + "</div>"
							+ "R$ " + data.saldo.saldoDisponivel + " </div>" + "</div>");
}

function clearModal() {
	$("#conta-banco").val("");
	$("#agencia-banco").val("");
	$("#digito-banco").val("");
	$("#saldo-banco").val("");
	$("#nome-agencia").val("");
}

function addNewRowRegistro(data) {
	var t = $('#table_id').DataTable();
	var counter = 1;

	t.row.add([ data.data, data.descricao, data.valor, data.saldo.saldoDisponivel]).draw();
	
	counter++;
}

