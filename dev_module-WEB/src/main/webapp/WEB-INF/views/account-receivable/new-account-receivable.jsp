<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>



<form:form action="/dev_module-WEB/account-receivable/save" 
	method="POST" modelAttribute="account">
	
	<input type="submit" value="click"/>
	
</form:form>


<script type="text/javascript">
	$(document).ready(
			function() {

				$("#inp-valor").maskMoney();

				$(function() {
					var availableTags = [ "Ajuste de Caixa",
							"Aplicações Financeiras",
							"Devolução de Adiantamento",
							"Financiamentos e Investimentos",
							"Outras Receitas", "Saldo Inicial", "Serviços",
							"Tranferência de Entrada", "Vendas", ];
					$("#tags").autocomplete({
						source : availableTags
					});
				});

			});
</script>
