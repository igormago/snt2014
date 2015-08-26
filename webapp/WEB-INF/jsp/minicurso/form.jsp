<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Página inicial</title>
</head>
<style>
.example:before {
	content: '' !important;
}
</style>
<script>
	function addMinistrante(cont) {

		proximo = cont + 1;
		$("#ministrante" + proximo).show();

	};
</script>
<body>
	<c:if test="${mensagem != null}">
		<div class="row bg-lightGreen">
			<p class="margin10 fg-white">${mensagem}</p>
		</div>
	</c:if>
	<c:if test="${mensagem == null}">
		<form action="<c:url value='/minicurso'/>" method="POST">
			<input type="hidden" name="minicurso.usuario.id"
				value="${sessao.usuario.id}" /> <br>
			<input type="hidden" name="minicurso.id"
				value="${minicurso.id}" /> <br>
			<h3>Dados dos Ministrantes</h3>
			<div class="example">
				<div id="ministrantes">
					<div class="ministrante1">
						<div>
							<h2>Ministrante 1</h2>
						</div>
						<div>
							<div>
								<label>Nome:</label><span class="error">${errors.from('minicurso.ministrantes[1].nome')}</span>
							</div>
							<div class="input-control text" style="width: 500px">
								<input type="text" name="minicurso.ministrantes[1].nome"
									value="${minicurso.ministrantes[1].nome}" />
								<button class="btn-clear"></button>

							</div>
						</div>
						<div>
							<div>
								<label>E-mail:</label><span class="error">${errors.from('minicurso.ministrantes[1].email')}</span>
							</div>
							<div class="input-control text" style="width: 500px">
								<input type="text" name="minicurso.ministrantes[1].email"
									value="${minicurso.ministrantes[1].email}" />
								<button class="btn-clear"></button>
							</div>
						</div>
						<div>
							<div>
								<label>Titulação:</label><span class="error">${errors.from('minicurso.ministrantes[1].titulacao')}</span>
							</div>
							<div class="input-control select">
								<select style="width: 300px"
									name="minicurso.ministrantes[1].titulacao">
									<option value="Médio Completo">Médio Completo</option>
									<option value="Graduado" selected="selected">Graduado</option>
									<option value="Especialista">Especialista</option>
									<option value="Mestre">Mestre</option>
									<option value="Doutor">Doutor</option>
									<option value="Pós-Doutor">Pós-Doutor</option>
								</select>
							</div>
						</div>
						<div>
							<div>
								<label>Dados sobre o ministrante:</label><span class="error">${errors.from('minicurso.ministrantes[1].biodata')}</span>
							</div>
							<div class="input-control textarea">
								<textarea type="text" name="minicurso.ministrantes[1].biodata"
									placeholder="Uma breve apresentação do ministrante"
									value="${minicurso.ministrantes[1].biodata}"
									style="width: 800px;" rows="5"></textarea>
							</div>
						</div>

						<div>
							<a href="javascript:addMinistrante(1)" id="addMinistrante"
								class="primary">Adicionar outro Minsitrante</a>
						</div>

					</div>
					<c:forEach begin="2" end="5" var="cont">
						<div id="ministrante${cont}" style="display: none">
							<hr></hr>
							<div>
								<h2>Ministrante ${cont}</h2>
							</div>
							<div>
								<div>
									<label>Nome:</label><span class="error">${errors.from('minicurso.ministrantes[cont].nome')}</span>
								</div>
								<div class="input-control text" style="width: 500px">
									<input type="text" name="minicurso.ministrantes[${cont}].nome"
										value="${minicurso.ministrantes[cont].nome}" />
									<button class="btn-clear"></button>
								</div>
							</div>
							<div>
								<div>
									<label>E-mail:</label><span class="error">${errors.from('minicurso.ministrantes[cont].email')}</span>
								</div>
								<div class="input-control text" style="width: 500px">
									<input type="text" name="minicurso.ministrantes[${cont}].email"
										value="${minicurso.ministrantes[cont].email}" />
									<button class="btn-clear"></button>
								</div>
							</div>
							<div>
								<div>
									<label>Titulação:</label><span class="error">${errors.from('minicurso.ministrantes[cont].titulacao')}</span>
								</div>
								<div class="input-control select">
									<select style="width: 300px"
										name="minicurso.ministrantes[cont].titulacao">
										<option value="Médio Completo">Médio Completo</option>
										<option value="Graduado" selected="selected">Graduado</option>
										<option value="Especialista">Especialista</option>
										<option value="Mestre">Mestre</option>
										<option value="Doutor">Doutor</option>
										<option value="Pós-Doutor">Pós-Doutor</option>
									</select>
								</div>
							</div>
							<div>
								<div>
									<label>Dados sobre o ministrante:</label><span class="error">${errors.from('minicurso.ministrantes[cont].biodata')}</span>
								</div>
								<div class="input-control textarea">
									<textarea type="text"
										name="minicurso.ministrantes[${cont}].biodata"
										placeholder="Uma breve apresentação do ministrante"
										value="${minicurso.ministrantes[cont].biodata}"
										style="width: 800px;" rows="5"></textarea>
								</div>
							</div>
							<c:if test="${cont < 5}">
								<div>
									<a href="javascript:addMinistrante(${cont})"
										id="addMinistrante" class="primary">Adicionar outro
										Minsitrante</a>
								</div>

							</c:if>
						</div>

					</c:forEach>

				</div>
			</div>
			<br>
			<h3>Dados do Minicurso</h3>
			<div class="example">
				<div>
					<div>
						<label>Título:</label><span class="error">${errors.from('minicurso.titulo')}</span>
					</div>
					<div class="input-control text" style="width: 500px">
						<input type="text" name="minicurso.titulo"
							value="${minicurso.titulo}" />
						<button class="btn-clear"></button>
					</div>
				</div>
				<div class="input-control radio default-style">
					<div>
						<label>Evento</label>
					</div>
					<div>
						<c:forEach items="${eventos}" var="evento">
							<label> <input type="radio" value="${evento.id}"
								name="minicurso.evento.id"
								<c:if test="${evento.id == 1}">checked</c:if> /> <span
								class="check"></span>${evento.nome}
							</label>
						</c:forEach>
					</div>
				</div>
				<div>
					<div>
						<label>Público-Alvo:</label><span class="error">${errors.from('minicurso.publicoAlvo')}</span>
					</div>
					<div class="input-control text" style="width: 500px">
						<input type="text" name="minicurso.publicoAlvo"
							value="${minicurso.publicoAlvo}" />
						<button class="btn-clear"></button>
					</div>
				</div>
				<div>
					<div>
						<label>Resumo do Minicurso:</label><span class="error">${errors.from('minicurso.resumo')}</span>
					</div>
					<div class="input-control textarea">
						<textarea type="text" name="minicurso.resumo"
							placeholder="Uma breve apresentação sobre o minicurso"
							value="${minicurso.resumo}" style="width: 800px;" rows="5"></textarea>
					</div>
				</div>
				<div>
					<div>
						<label>Número de Vagas:</label><span class="error">${errors.from('minicurso.vagas')}</span>
					</div>
					<div class="input-control text" style="width: 200px">
						<input type="text" name="minicurso.vagas"
							value="${minicurso.vagas}" />
						<button class="btn-clear"></button>
					</div>
				</div>
				<div class="input-control radio default-style">
					<div>
						<label>Carga Horária:</label>
					</div>
					<div>
						<label> <input name="minicurso.cargaHoraria" type="radio"
							value="2" /> <span class="check"></span> 2 horas
						</label> <label> <input name="minicurso.cargaHoraria" type="radio"
							value="4" checked /> <span class="check"></span> 4 horas
						</label> <label> <input name="minicurso.cargaHoraria" type="radio"
							value="8" /> <span class="check"></span> 8 horas
						</label>
					</div>
				</div>
				<div>
					<div>
						<label>Horário Disponível (Marque UM ou MAIS)</label><span
							class="error">${errors.from('ministrante.horarioDisponivel')}</span>
					</div>
					<div class="input-control checkbox">
						<c:forEach items="${horariosDisponiveis}" var="horario">
							<label> <input
								name="minicurso.horariosDisponiveis[${horario.id}].id"
								value="${horario.id}" type="checkbox" value= /> <span
								class="check"></span> ${horario.descricao}
							</label>
						</c:forEach>
					</div>
				</div>
				<div>
					<div>
						<label>Recursos Didáticos:</label><span class="error">${errors.from('ministrante.recursosDidaticos')}</span>
					</div>
					<div class="input-control textarea">
						<textarea type="text" name="minicurso.recursosDidaticos"
							placeholder="Informe tudo que for necessário para que o minicurso possa ser realizado"
							value="${ministrante.recursosDidaticos}" style="width: 800px;"
							rows="5"></textarea>
					</div>
				</div>
				<div>
					<div>
						<label>Observações:</label><span class="error">${errors.from('minicurso.observacoes')}</span>
					</div>
					<div class="input-control textarea">
						<textarea type="text" name="minicurso.observacoes"
							placeholder="Informe qualquer outra informação relevante para comissão organizadora"
							value="${ministrante.observacoes}" style="width: 800px;" rows="5"></textarea>
					</div>
				</div>
				<div>
					<input type="submit" value="Salvar" />
				</div>
			</div>

		</form>
	</c:if>
</body>
</html>