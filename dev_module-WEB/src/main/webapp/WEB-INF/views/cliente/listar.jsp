<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<script type="text/javascript"
	src="<c:url value="/js/cliente-fornecedor/listar/listar.js" />"></script>
<script type="text/javascript" src="<c:url value="/js/block-UI.js" />"></script>
<!-- DataTables CSS -->
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/jquery.dataTables.css" />" />

<!-- DataTables -->
<script type="text/javascript"
	src="<c:url value="/js/jquery.dataTables.js" />"></script>


<div class="ui grid">
	<div class="four wide column">
		<div class="ui segment">
			<div class="field">
				<h4 class="ui inverted teal block header">
					<i class="zoom in icon"></i> Pesquisa
				</h4>
				<div class="grouped inline fields">
					<div class="field">
						<div class="ui radio checkbox">
							<input id="choice-1" type="radio" name="fruit" checked="">
							<label for="choice-1">Registros Recentes</label>
						</div>
					</div>
					<div class="field">
						<div class="ui radio checkbox">
							<input id="choice-2" type="radio" name="fruit"> <label
								for="choice-2">Todos Clientes</label>
						</div>
					</div>
					<div class="field">
						<div class="ui radio checkbox">
							<input id="choice-3" type="radio" name="fruit"> <label
								for="choice-3">Todos Fornecedores</label>
						</div>
					</div>
				</div>
				<div class="ui horizontal divider">*</div>
					<div class="ui action input">
						<input type="text" id="inp-value-find" placeholder="Procurar...">
						<div class="ui icon button" id="btn-find-by-name">
							<i class="search icon"></i>
						</div>
					</div>
				<div class="ui horizontal divider">*</div>

				<a href="<c:url value="/cliente/novo"/>"
					class="fluid positive tiny ui down button"> <i
					class="add sign box icon"></i> Novo registro
				</a>

				<div class="ui horizontal divider">*</div>

				<div class="fluid purple tiny ui down button" id="registro-rapido">
					<i class="attachment icon"></i>Importar lista
				</div>

			</div>
		</div>
	</div>
	<div class="twelve wide column">
		<div class="ui segment">
			<div class="field">
				<h4 class="ui inverted teal block header">
					<i class="users icon"></i> Cliente/Fornecedor registrado no sistema
				</h4>

				<div class="ui green message" style="display: none;"
					id="message-success">
					<i class="close icon"></i>Registro cadastrado com sucesso no
					sistema!
				</div>
				<div class="ui red message" style="display: none;"
					id="message-error">
					<i class="close icon"></i>
				</div>

				<table class="ui table segment" id="tbl-main">
					<thead>
						<tr>
							<th width="5%">Tipo</th>
							<th width="20%">Nome/Fantasia</th>
							<th width="20%">Documento</th>
							<th width="30%">Telefone</th>
							<th width="2%" align="center">Ver</th>
							<th width="2%" align="center">Desat.</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td><c:choose>
										<c:when test="${cliente.tipoPessoa  == 'JURIDICA'}">
											<i class="building icon popup" data-content="Pessoa Jurídica"></i>
										</c:when>
										<c:otherwise>
											<i class="user icon popup" data-content="Pessoa Fisíca"></i>
										</c:otherwise>
									</c:choose></td>

								<td><c:choose>
										<c:when test="${cliente.tipoPessoa  == 'JURIDICA'}">${cliente.fantasia}</c:when>
										<c:otherwise>${cliente.nome}</c:otherwise>
									</c:choose></td>

								<td><c:choose>
										<c:when test="${cliente.tipoPessoa  == 'JURIDICA'}"> ${cliente.cnpj}</c:when>
										<c:otherwise> ${cliente.cpf}</c:otherwise>
									</c:choose></td>

								<td>${cliente.telefone}</td>
								<td><a
									href="<c:url value="/cliente/editar/${cliente.id}"/>"
									class="ui twitter mini right pointing icon button"> <i
										class="hide icon"></i>
								</a></td>
								<td><a href="#"
									class="ui mini primary right pointing dropdown icon button desativar"
									id="${cliente.id}"> <i class="remove icon"></i>
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>


<div class="ui small modal" id="modal-remove-rgt">
	<i class="close icon"></i>
	<div class="header">
		<i class="trash icon"></i> Desativar Registro
	</div>
	<div class="content">
		<div class="left" id="lbl-msg-modal"></div>
	</div>
	<input type="text" id="inp-idcliente-mdl">
	<div class="actions">
		<div class="ui secondary button">Cancelar</div>
		<div class="ui primary button">Desativar</div>
	</div>
</div>

<script type="text/javascript">
	$(document).ready(function() {

		$("#registro-rapido").click(function() {
			$('.modal-registro').modal('show');
		});

		$(".remove-registro").click(function() {
			$('.modal-remover').modal('show');
		});

		$('.popup').popup();

		$('#tbl-main').DataTable();
	});
</script>