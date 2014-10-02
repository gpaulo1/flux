var id;
var saldoId;
var buttonEntradaSaida = true;

$(document).ready(function() {

	// aceitar apenas numeros
	jQuery('.numbersOnly').keyup(function() {
		this.value = this.value.replace(/[^0-9\.]/g, '');
	});

	// mascara de moeda
	$("#valor-registro").maskMoney();

	// validar formulario
	$('.ui.form').form({
		firstName : {
			identifier : 'registro-descricao',
			rules : [ {
				type : 'empty',
				prompt : 'Please enter a password'
			} ]
		},
		lastName : {
			identifier : 'registro-valor',
			rules : [ {
				type : 'empty',
				prompt : 'Please enter your last name'
			} ]
		},
		username : {
			identifier : 'username',
			rules : [ {
				type : 'empty',
				prompt : 'Please enter a username'
			} ]
		},
		password : {
			identifier : 'password',
			rules : [ {
				type : 'empty',
				prompt : 'Please enter a password'
			}, {
				type : 'length[6]',
				prompt : 'Your password must be at least 6 characters'
			} ]
		},
		terms : {
			identifier : 'terms',
			rules : [ {
				type : 'checked',
				prompt : 'You must agree to the terms and conditions'
			} ]
		}
	}, {
		inline : true,
		on : 'blur',
		transition : 'fade down',
		onSuccess : function() {
			cadastrarRegistro();
		}
	});

});

function cadastrarRegistro() {

	//objeto para gravar novo registro
	var Fluxo = {
			"descricao" : $("#descricao-registro").val(),
			"valor" : $("#valor-registro").val(),
			"tpEntrada" : buttonEntradaSaida,
			"caixa" : {"id" : id},
			"saldo" : {"id" : saldoId}
		};
	console.log("id do caixa: " + Fluxo.caixa.id);
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(Fluxo),
		url : 'planejamento/novo-registro',
		statusCode : {
			200 : function(data) {
				addNewRowRegistro(data);
				console.log("fjojsdof: " + JSON.stringify(data.id));
				$("#msg-novo-registro").show(150);
				$('.modal-entrada').modal('hide');
				atualizarResumoFinanceiro(data);
			},
			404 : function(data) {
				alert(JSON.stringify(data));
			}
		}
	});
};

//funcao de selecionar caixa
function getRegistrosCaixaSelecionado(id){
	$('#table_id').DataTable().clear().draw();
	$.ajax({
		type : "post",
		dataType : "json",
		contentType : "application/json",
		data : JSON.stringify(id),
		url : 'planejamento/buscar-fluxo',
		statusCode : {
			200 : function(data) {
				$(".saldo-credito").text("R$ " + data.saldoCredito);
				$(".saldo-debito").text("R$ " + data.saldoDebito);
				$(".saldo-disponivel").text("R$ " + data.saldoDisponivel);
				saldoId = data.id;
			},
			404 : function(data) {
			}
		}
	});
}

function atualizarResumoFinanceiro(data){
	$(".saldo-credito").text("R$ " + data.saldo.saldoCredito);
	$(".saldo-debito").text("R$ " + data.saldo.saldoDebito);
	$(".saldo-disponivel").text("R$ " + data.saldo.saldoDisponivel);
}

function getIdCaixa(idFluxo){
	disabledButtonClicked();
	id = idFluxo;
	activeButtonClicked();
	getRegistrosCaixaSelecionado(id);
};

function activeButtonClicked(){
	$("#"+id).addClass("disabled").removeClass("positive").addClass("orange").text("ATIVO");
}

function disabledButtonClicked(){
	$("#"+id).removeClass("disabled").removeClass("orange").addClass("positive").text("FLUXO");
}

function botaotpRegistro(id){
	if(id == 'btn-entrada'){
		$("#btn-saida").removeClass("active");
		$("#btn-entrada").addClass("active");
		
		buttonEntradaSaida = true;
		console.log("fjsofaij: " + buttonEntradaSaida);
	}else if(id == 'btn-saida'){
		$("#btn-entrada").removeClass("active");
		$("#btn-saida").addClass("active");
		buttonEntradaSaida = false;
		console.log("fjsofaij: " + buttonEntradaSaida);
	}
};
