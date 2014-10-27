<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!-- First grid -->
<div class="ui grid">
	<div class="four wide column">
		<div class="ui segment">
			<div class="field">
				<h4 class="ui inverted teal block header">Menu</h4>

				<a href="<c:url value="/account-receivable/new" />"
					class="fluid ui mini green button">Nova Receita</a>

				<div class="ui horizontal divider">*</div>

				<div class="fluid ui action input">
					<input type="text" id="inp-value-find" placeholder="Procurar...">
					<div class="ui icon button" id="btn-find-by-name">
						<i class="search icon"></i>
					</div>
				</div>
				<div class="ui horizontal divider">*</div>

				<!-- Summary finance -->

				<div class="ui divided list">
					<div class="item">
						<i class="info icon"></i>
						<div class="content">
							<div class="header">Conta(s) á receber</div>
							<div class="description">12</div>
						</div>
					</div>
					<div class="item">
						<i class="info icon"></i>
						<div class="content">
							<a class="header">Recebimentos atrasados</a>
							<div class="description">
								<i class="dollar icon"></i>46,00
							</div>
						</div>
					</div>
					<div class="item">
						<i class="info icon"></i>
						<div class="content">
							<a class="header">Recebimentos para hoje</a>
							<div class="description">
								<i class="dollar icon"></i>3,00
							</div>
						</div>
					</div>
					<div class="item">
						<i class="info icon"></i>
						<div class="content">
							<a class="header">Recebimentos futuros</a>
							<div class="description">
								<i class="dollar icon"></i>322,00
							</div>
						</div>
					</div>
					<div class="item">
						<br> <i class="info icon"></i>
						<div class="content">
							<a class="header">Total a receber</a>
							<div class="description">
								<i class="dollar icon"></i>342,90
							</div>
						</div>
					</div>
				</div>

				<!-- END -->

			</div>
		</div>
	</div>
	<div class="twelve wide column">
		<div class="ui segment">
			<div class="field">
				<h4 class="ui inverted teal block header">Contas a Receber</h4>

				<div class="ui red message" style="display: none;">Red</div>
				<div class="ui green message" style="display: none;">Green</div>

				<!-- Begin table -->

				<table class="ui table segment account-table">
					<thead>
						<tr>
							<th>Data</th>
							<th>Lançamento</th>
							<th>Valor</th>
							<th>Forma Pag.</th>
							<th>Situação</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${accounts}" var="account">

							<tr>
								<td>${account.dataVencimento}</td>
								<td>${account.descricao}</td>
								<td>${account.valor}</td>
								<td>${account.formaPagamento}</td>
								<td></td>
							</tr>

						</c:forEach>
					</tbody>
				</table>

				<!-- END -->


			</div>
		</div>
	</div>


</div>

<script>
	$(document).ready(function() {

		$('.account-table').DataTable();
	});
</script>

