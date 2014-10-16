<div class="three fields">
	<div class="field">
		<label>Tipo de pessoa</label>
		<div class="ui fluid mini selection dropdown">
			<div class="text" data-value="JURIDICA">Jur�dica</div>
			<i class="dropdown icon"></i>
			<form:input type="hidden" name="gender" path="tipoPessoa"
				id="slc-tp-pessoa"></form:input>
			<div class="menu">
				<div class="item" data-value="JURIDICA">Jur�dica</div>
				<div class="item" data-value="FISICA">F�sica</div>
			</div>
		</div>
	</div>
	<div class="field fl-cpf-IP">

		<label>CPF</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Cadastro de pessoa fis�ca"
				class="inp-cpf" path="cpf"></form:input>
			<i class="info letter icon"></i>
		</div>
	</div>
	<div class="field fl-cnpj-IP">

		<label>CNPJ</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Cadastro de CNPJ"
				class="inp-cnpj" path="cpf"></form:input>
			<i class="info letter icon"></i>
		</div>
	</div>
	<div class="field fl-insc_estadual-IP">

		<label>Inscri��o Estadual</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Inscri��o Estadual"
				class="inp-inscricao-estadual" path="cpf"></form:input>
			<i class="info letter icon"></i>
		</div>
	</div>
	<div class="field fl-rg-IP">

		<label>RG</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Registro Geral" path="rg"></form:input>
			<i class="info letter icon"></i>
		</div>
	</div>
</div>
<div class="two fields">
	<div class="field fl-razao_social-IP">

		<label>Raz�o Social</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Nome completo"
				class="inp-inscricao-estadual" path="cpf"></form:input>
			<i class="info letter icon"></i>
		</div>
	</div>

	<div class="field fl-razao_social-IP">

		<label>Raz�o Social</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Nome completo"
				class="inp-inscricao-estadual" path="cpf"></form:input>
			<i class="info letter icon"></i>
		</div>
	</div>
	<div class="field fl-nome-IP">

		<label>Nome</label>
		<div class="ui mini left labeled icon input">
			<form:input path="nome" type="text" value="${cliente.nome}"
				placeholder="Nome do cliente"></form:input>
			<i class="user icon"></i>
			<div class="ui corner label">
				<i class="icon asterisk"></i>
			</div>
		</div>
	</div>

	<div class="field">
		<label>Email</label>
		<div class="ui mini left labeled icon input">
			<form:input path="email" type="text"
				placeholder="Endere�o eletr�nico"></form:input>
			<i class="mail icon"></i>
			<div class="ui corner label">
				<i class="icon asterisk"></i>
			</div>
		</div>
	</div>
</div>
<div class="three fields">
	<div class="field">
		<label>Cep</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Cep" class="inp-cep"
				path="endereco.cep"></form:input>
			<i class="location arrow icon"></i>
		</div>
	</div>
	<div class="field">
		<label>Endere�o</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Logradouro"
				path="endereco.logradouro"></form:input>
			<i class="location arrow icon"></i>
		</div>
	</div>
	<div class="field">
		<label>N�mero</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="N�mero do logradouro"
				path="endereco.numero"></form:input>
			<i class="location arrow icon"></i>
		</div>
	</div>
</div>
<div class="two fields">
	<div class="field">
		<label>Cidade</label>
		<div class="ui mini left labeled icon input">
			<form:input type="text" placeholder="Cidade" path="endereco.cidade"></form:input>
			<i class="location arrow icon"></i>
		</div>
	</div>
	<div class="field">
		<label>Estado</label>
		<div class="ui fluid selection dropdown">
			<div class="text">Selecione</div>
			<i class="dropdown icon"></i>
			<form:input type="hidden" name="gender" path="endereco.estado"></form:input>
			<div class="menu">
				<div class="item" data-value="ACRE">Acre</div>
				<div class="item" data-value="ALAGOAS">Alagos</div>
				<div class="item" data-value="AMAPA">Amap�</div>
				<div class="item" data-value="AMAZONAS">Amazonas</div>
				<div class="item" data-value="BAHIA">Bahia</div>
				<div class="item" data-value="CEARA">Cear�</div>
				<div class="item" data-value="DISTRITO_FEDERAL">Distrito
					Federal</div>
				<div class="item" data-value="ESPIRITO_SANTO">Esp�rito Santo</div>
				<div class="item" data-value="GOIAS">Goi�s</div>
				<div class="item" data-value="MARANHAO">Maranh�o</div>
				<div class="item" data-value="MATO_GROSSO">Mato Grosso</div>
				<div class="item" data-value="MATO_GROSSO_DO_SUL">Mato Grosso
					do Sul</div>
				<div class="item" data-value="MINAS_GERAIS">Minas Gerais</div>
				<div class="item" data-value="PARA">Par�</div>
				<div class="item" data-value="PARAIBA">Para�ba</div>
				<div class="item" data-value="PARANA">Paran�</div>
				<div class="item" data-value="PERNAMBUCO">Pernambuco</div>
				<div class="item" data-value="PIAUI">Piau�</div>
				<div class="item" data-value="RIO_DE_JANEIRO">Rio de Janeiro</div>
				<div class="item" data-value="RIO_GRANDE_DO_NORTE">Rio Grande
					do Norte</div>
				<div class="item" data-value="RIO_GRANDE_DO_SUL">Rio Grande do
					Sul</div>
				<div class="item" data-value="RONDONIA">Rond�nia</div>
				<div class="item" data-value="RORAIMA">Roraima</div>
				<div class="item" data-value="SANTA_CATARINA">Santa Catarina</div>
				<div class="item" data-value="SAO_PAULO">S�o Paulo</div>
				<div class="item" data-value="SERGIPE">Sergipe</div>
				<div class="item" data-value="TOCANTINS">Tocantins</div>
			</div>
		</div>
	</div>
</div>