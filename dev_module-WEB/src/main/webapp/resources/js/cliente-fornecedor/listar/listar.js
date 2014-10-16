$(document).ready(function() {

$("#choice-1").click(function(){
	
	hideMsgs();
	
	$("#tbl-main").block({ message: "Carregando..." });
		$.ajax({
			type : "get",
			url : '/dev_module-WEB/cliente/find-all',
			statusCode : {
				200 : function(data) {
					console.log("cjaso: " + data.length);
					var t = $('#tbl-main').DataTable();
					t.clear().draw();
					
					for(var i = 0; i < data.length; i++){
						console.log("cjaso: " + data[i].id);																						 
							
					        t.row.add( [
					            identifierTypeOfTpPessoa(data[i]),
					            checkTypeOfRegistry(data[i]),
					            checkTypeOfDocument(data[i]),
					            data[i].telefone,
					            "<a href='/dev_module-WEB/cliente/editar/"+ data[i].id +"' class='ui twitter mini right pointing dropdown icon button'>"+
								"<i class='hide icon'></i>"	+
								"</a>",
								"<div class='ui mini primary right pointing dropdown icon button desativar' onclick='removerregistro(this)' idcliente='"+ data[i].id +"' >" +
								"<i class='remove icon'></i>"+
								"</div>"
					        ] ).draw();
					};
					$('#tbl-main').unblock(); 
				},																																																																	
				404 : function(data) {
					$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
					$("#message-error").show(200);
				},
				400 : function(data) {
					$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
					$("#message-error").show(200);
				},
				500 : function(data) {
					$("#message-error").text("Ocorreu um problema no servidor ao pesquisar registros recentes!")
					$("#message-error").show(200);
				}
			}
		}).done(function() {

		});
		
	});
	
	$("#choice-2").click(function(){
		
		hideMsgs();
		
		$("#tbl-main").block({ message: "Carregando..." });
		$.ajax({
			type : "get",
			url : '/dev_module-WEB/cliente/find-clientes',
			statusCode : {
				200 : function(data) {
					console.log("cjaso: " + data.length);
					var t = $('#tbl-main').DataTable();
					t.clear().draw();
					
					for(var i = 0; i < data.length; i++){
						console.log("cjaso: " + data[i].id);
							
					        t.row.add( [
					            "<i class='user icon popup' data-content='Pessoa Fisíca'></i>",
					            data[i].nome,
					            data[i].cpf,
					            data[i].telefone,
								"<a href='/dev_module-WEB/cliente/editar/"+ data[i].id +"'' class='ui twitter mini right pointing dropdown icon button'>"+
								"<i class='hide icon'></i>"	+ 
								"</a>",
								"<a href='#' class='ui mini primary right pointing dropdown icon button'>" +
								"<i class='remove icon'></i>"+
								"</a>"
					        ] ).draw();
					};
					$('#tbl-main').unblock(); 
				},
				404 : function(data) {
					$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
					$("#message-error").show(200);
				},
				400 : function(data) {
					$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
					$("#message-error").show(200);
				},
				500 : function(data) {
					$("#message-error").text("Ocorreu um problema no servidor ao pesquisar registros recentes!")
					$("#message-error").show(200);
				}
			}
		}).done(function() {

		});
		
	});
	
	
$("#choice-3").click(function(){
	
	hideMsgs();
	
	$("#tbl-main").block({ message: "Carregando..." });
	
		$.ajax({
			type : "get",
			url : '/dev_module-WEB/cliente/find-empresas',  
			statusCode : {
				200 : function(data) {
					console.log("cjaso: " + data.length);
					var t = $('#tbl-main').DataTable();
					t.clear().draw();
					
					for(var i = 0; i < data.length; i++){
							
					        t.row.add( [
					            "<i class='building icon popup' data-content='Pessoa Jurídica'></i>",
					            data[i].fantasia,
					            data[i].cnpj, 
					            data[i].telefone,
								"<a href='/dev_module-WEB/cliente/editar/"+ data[i].id +"'' class='ui twitter mini right pointing dropdown icon button'>"+
								"<i class='hide icon'></i>"	+ 
								"</a>",
								"<a href='#' class='ui mini primary right pointing dropdown icon button'>" +
								"<i class='remove icon'></i>"+
								"</a>"
					        ] ).draw();
					};
					$('#tbl-main').unblock(); 
					
					
				},
				404 : function(data) {
					$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
					$("#message-error").show(200);
				},
				400 : function(data) {
					$("#message-error").text("Ocorreu um problema ao pesquisar registros recentes!")
					$("#message-error").show(200);
				},
				500 : function(data) {
					$("#message-error").text("Ocorreu um problema no servidor ao pesquisar registros recentes!")
					$("#message-error").show(200);
				}
			}
		}).done(function() {

		});
		
	});
	
	$(".desativar").click(function() {

		console.log("ksdnjsdfn");
		
		hideMsgs();
		
		$("#tbl-main").block({ message: "Carregando..." });
		
		var idRow;
		var table = $('#tbl-main').DataTable();

		$('#tbl-main tbody').on('click', 'tr', function() {
			idRow = table.row(this).index();
		});

		var id = $(this).attr('id');

		disableRegistry(id);

	});
	
	$(".editar").click(function() {

		$("#tbl-main").block({ message: "Carregando..." });
		
		var idRow;
		var table = $('#tbl-main').DataTable();

		$('#tbl-main tbody').on('click', 'tr', function() {
			idRow = table.row(this).index();
		});

		var id = $(this).attr('id');

		$.ajax({
			type : "get",
			url : '/cliente/editar/' + id,
		})

	});
	
	$("#btn-find-by-name").click(function(){
		
		$("#tbl-main").block({ message: "Carregando..." });
		
		var value = $("#inp-value-find").val();
		
		$.ajax({
			type : "get",
			url : '/dev_module-WEB/cliente/find-by-name/' + value,
			statusCode : {
				200 : function(data) {
					
					var t = $('#tbl-main').DataTable();
					t.clear().draw();
					
					for(var i = 0; i < data.length; i++){
							
					        t.row.add( [
					            "<i class='user icon popup' data-content='Pessoa Fisíca'></i>",
					            data[i].nome,
					            data[i].cpf,
					            data[i].telefone,
								"<a href='/dev_module-WEB/cliente/editar/"+ data[i].id +"'' class='ui twitter mini right pointing dropdown icon button'>"+
								"<i class='hide icon'></i>"	+ 
								"</a>",
								"<a href='#' class='ui mini primary right pointing dropdown icon button'>" +
								"<i class='remove icon'></i>"+
								"</a>"
					        ] ).draw();
					};
					
					$('#tbl-main').unblock(); 
					
				},
				404 : function(data) {
					$('#tbl-main').unblock(); 
					$("#message-error").text("Ocorreu um erro ao pesquisar o registro!").show(200);
				},
				400 : function(data) {
					$('#tbl-main').unblock(); 
					$("#message-error").text("Ocorreu um erro ao pesquisar o registro!").show(200);
				},
				500 : function(data) {
					$('#tbl-main').unblock(); 
					$("#message-error").text("Ocorreu um erro no servidor ao pesquisar o registro!").show(200);
				}
			}
		
	});

});
});

function hideMsgs(){
	$("#message-success").hide();
	$("#message-error").hide();
}

function identifierTypeOfTpPessoa(data){
	if(data.tipoPessoa == "FISICA"){
    	return "<i class='user icon popup' data-content='Pessoa Fisíca'></i>"
    };
    if(data.tipoPessoa == "JURIDICA"){
    	return "<i class='building icon popup' data-content='Pessoa Jurídica'></i>"
    };
    return null;
}

function showModalRemove(link) { 
	var id =  $(link).attr("idcliente");
	
	$("#inp-idcliente-mdl").val(id);
	
	$('#modal-remove-rgt')
	  .modal('show')
	;
	
	$("#lbl-msg-modal").text("Você tem certeza que deseja desativar este registro ?");

	disableRegistry(id);
	
}

//request to disable registry
function disableRegistry(id){
	$.ajax({
		type : "get",
		url : '/dev_module-WEB/cliente/desativar/' + id,
		statusCode : {
			200 : function(data) {
				table.row(idRow).remove().draw();
				$('#tbl-main').unblock(); 
				$("#message-success").text("Registro desativado com sucesso!").show(200);
			},
			404 : function(data) {
				$('#tbl-main').unblock(); 
				$("#message-error").text("Ocorreu um erro ao desativar o registro!").show(200);
			},
			400 : function(data) {
				$('#tbl-main').unblock(); 
				$("#message-error").text("Ocorreu um erro ao desativar o registro!").show(200);
			},
			500 : function(data) {
				$('#tbl-main').unblock(); 
				$("#message-error").text("Ocorreu um erro no servidor ao desativar o registro!").show(200);
			}
		}
	}).done(function() {

	});
}

function checkTypeOfRegistry(data){
	if(data.tipoPessoa == 'FISICA'){
		return data.nome;
	}else if(data.tipoPessoa == 'JURIDICA'){
		return data.fantasia;
	}
}

function checkTypeOfDocument(data){
	if(data.tipoPessoa == 'FISICA'){
		return data.cpf;
	}else if(data.tipoPessoa == 'JURIDICA'){
		return data.cnpj;
	}
}
