<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<div class="ui celled grid">
	<div class="seven wide middle column">
		<div class="ui ribbon teal label">Planejamento Financeiro</div>

		<div class="ui divided list">
			<div class="item">
				<div class="right floated mini positive mini ui button">Fluxo</div>
				<img class="ui avatar image" src="images/bancos/brasil.jpg">
				<div class="content">
					<div class="header">Banco do Brasil</div>
					R$ 740,30
				</div>
			</div>
			<div class="item">
				<div class="right floated mini positive ui button">Fluxo</div>
				<img class="ui avatar image" src="images/bancos/itau.jpg">
				<div class="content">
					<div class="header">Banco Itaú</div>
					A poodle, its pretty basic
				</div>
			</div>
			<div class="item">
				<div class="right floated mini positive ui button">Fluxo</div>
				<img class="ui avatar image" src="/images/demo/avatar3.jpg">
				<div class="content">
					<div class="header">Paulo</div>
					He's also a dog
				</div>
			</div>
		</div>

		<div class="ui icon button teal novo-caixa">
			<i class="add icon"></i>
		</div>

	</div>
	<div class="nine wide right column">
		<div class="ui icon message">
			<i class="dollar icon"></i>
			<div class="content">
				<div class="header">Fluxo de caixa referente ao Banco do
					Brasil</div>
				<p>
					Lançamentos dos último 30 dias. Para ver mais lançamentos clique <a
						href="#">aqui</a>.
				</p>
			</div>
		</div>
		<table class="ui basic table">
			<thead>
				<tr>
					<th>Resumo</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Crédito</td>
					<td class="positive">R$ 23.049,00</td>
				</tr>
				<tr>
					<td>Débito</td>
					<td class="negative">R$ 19.049,00</td>
				</tr>
				<tr>
					<td><b>Saldo</b></td>
					<td class="positive">R$ 3.049,00</td>
				</tr>
			</tbody>
		</table>

		<div class="ui horizontal divider">
			<i class="ellipsis horizontal icon"></i>
		</div>

		<div class="ui green message">Registro inserido com sucesso!</div>

		<table class="ui sortable table segment">
			<thead>
				<tr>
					<th>Data</th>
					<th>Descrição</th>
					<th>Valor</th>
					<th>Saldo</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>4/7/2014</td>
					<td>parcelamento imposto</td>
					<td>None</td>
					<td class="warning">Requires call</td>
				</tr>
				<tr>
					<td>4/7/2014</td>
					<td>parcelamento imposto</td>
					<td class="positive">Approved</td>
					<td class="warning">Requires call</td>
				</tr>
				<tr>
					<td>4/7/2014</td>
					<td class="negative">Denied</td>
					<td>None</td>
				</tr>
				<tr>
					<td>4/7/2014</td>
					<td>No Action</td>
					<td>None</td>
				</tr>
				<tr>
					<td>4/7/2014</td>
					<td class="positive">Approved</td>
					<td class="warning">Requires call</td>
				</tr>
				<tr>
					<td>Jill</td>
					<td class="negative">Denied</td>
					<td>None</td>
				</tr>
				<tr>
					<td>John</td>
					<td>No Action</td>
					<td>None</td>
				</tr>
				<tr>
					<td>Jamie</td>
					<td class="positive">Approved</td>
					<td class="warning">Requires call</td>
				</tr>
				<tr>
					<td>Jill</td>
					<td class="negative">Denied</td>
					<td>None</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th>3 People</th>
					<th>2 Approved</th>
					<th></th>
				</tr>
			</tfoot>
		</table>
		<form action="logout" method="post">
			<input type="submit" value="sair"><input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>
</div>
<div class="ui large modal">
	<i class="close icon"></i>
	<div class="header">Adicionar fluxo de caixa</div>
	<div class="content">
		<div class="left">Some content to the left, usually an image or
			icon</div>
		<div class="right">Some content to the right</div>
	</div>
	<div class="actions">
		<div class="ui buttons">
			<div class="ui button">Cancelar</div>
			<div class="or"></div>
			<div class="ui positive button">Salvar</div>
		</div>
	</div>

</div>
<script>
	$(".novo-caixa").click(function() {
		$('.large.modal').modal('show');
	});
</script>