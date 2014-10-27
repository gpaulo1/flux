$(document).ready(function() {

	$("#inp-cliente").keydown(function() {

		var i = $("#inp-cliente").val();

		if (i.length > 0) {
			
			$.ajax({ 
				type : 'get',
				url : '/dev_module-WEB/account-receivable/buscar-cliente/' +  i,
				statusCode : {
					200 : function(data) {
						
						var availableClientes;
						
						for(var i = 0; i < data.length; i++){
							console.log("fiuuu: " + data[0].nome);
							
							
							
						}
						
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
			
		}
	});

});