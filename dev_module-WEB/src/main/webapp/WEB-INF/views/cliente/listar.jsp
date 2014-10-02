<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>



<div class="ui form segment">
	<div class="ui teal  ribbon label">Visualizar Clientes</div>
	<c:if test="${msg != null}">
		<div class="ui green message">${msg}</div>
	</c:if>



	<table class="ui sortable table segment" id="tb_clientes">
		<thead>
			<tr>
				<th width="30%">Nome</th>
				<th width="10%">Tipo</th>
				<th width="10%">Telefone</th>
				<th width="10%">RG</th>
				<th width="13%">CPF</th>
				<th width="10%">Email de cobrança</th>
				<th width="10%">Facebook</th>
				<th width="1%">Opção</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.nome}</td>
					<td>${cliente.tipoPessoa}</td>
					<td>${cliente.telefone}</td>
					<td>${cliente.rg}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.emailCobranca}</td>
					<td>${cliente.facebook}</td>
					<td>
						<div class="ui red  pointing dropdown icon button">
							<i class="settings icon"></i>
							<div class="menu">
								<a class="item" href="/dev_module-WEB/cliente/editar/${cliente.id}">
									<i class="edit icon"></i>Editar
								</a>
								<a class="item" href="/dev_module-WEB/cliente/remover/${cliente.id}">
									<i class="delete icon"></i>Remover
								</a>
								<div class="item">
									<i class="hide icon"></i>Esconder
								</div>
							</div>
						</div>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>


	<div class="two fields">
		<div class="field"></div>
		<div class="field"></div>
	</div>
	<div class="ui section divider"></div>
	<div class="ui center aligned three column grid">
		<div class="ui teal button entrada" id="send-form">
			<i class="user icon"></i> Salvar Cliente
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#send-form").click(function() {
		$("#form-cliente").submit();
	});
	
	$(document).ready( function () {
	    $('#tb_clientes').DataTable();
	} );
	
</script>