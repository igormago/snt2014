<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.example:before {
	content: '' !important;
}
</style>
<div class="margin20">
	<div class="content">
		<div class="grid">
			<div class="row bg-lightGreen">
				<c:if test="${mensagem != null}">
					<p class="margin10 fg-white">${mensagem}</p>
				</c:if>
			</div>
			<div class="row">
				<div class="span4">
					<form action="<c:url value='/login/loga'/>" id="login"
						method="POST">
						<div>
							<h2>Entrar</h2>
						</div>
						<div>
							<span class="error" style="color: red">${errors.from('erro.loga')}</span>
						</div>
						<div>
							<div>
								<label>E-mail:</label>
							</div>
							<div class="input-control text" style="width: 280px">
								<input type="email" name="usuario.email"
									value="${usuario.email}" required />
								<button class="btn-clear"></button>
							</div>
						</div>
						<div>
							<div>
								<label>Senha:</label>
							</div>
							<div class="input-control password" style="width: 280px">
								<input type="password" name="usuario.senha" size="30" required />
							</div>
						</div>
						<div style="padding-top: 10px;">
							<input style="height: 30px;" class="bg-darkGreen fg-white"
								type="submit" value="Logar" />
						</div>
					</form>
				</div>
				<div class="span7"
					style="border-left: 1px solid #DDDDDD; padding-left: 30px;">
					<div>
						<h2>Cadastrar Novo Usuário</h2>
					</div>
					<form action="<c:url value='/usuario'/>" id="cadastro"
						method="POST">
						<input type="hidden" name="usuario.perfil.id" value="3" required />
						<div>
							<span class="error" style="color: red">${errors.from('erro.cadastra')}</span>
						</div>
						<div>
							<div>
								<label>Nome:</label>
							</div>
							<div class="input-control text" style="width: 500px">
								<input type="nome" name="usuario.nome" value="${usuario.nome}"
									required />
								<button class="btn-clear"></button>
							</div>
						</div>
						<!-- 
						<div class="input-control radio default-style"
							name="usuario.perfil">
							
							<div>
								<label>Perfil:</label>
							</div>
							
							<div>
								<label> <input type="radio" value="1" checked/> <span
									class="check"></span> Ministrante
								</label> <label> <input type="radio" value="2" disabled /> <span
									class="check"></span> Aluno
								</label>
							</div>  
						</div>-->
						<div>
							<div>
								<label>E-mail:</label>
							</div>
							<div class="input-control text" style="width: 500px">
								<input type="email" name="usuario.email"
									value="${usuario.email}" required />
							</div>
						</div>
						<div>
							<div>
								<label>Senha:</label>
							</div>
							<div class="input-control password" style="width: 250px">
								<input type="password" name="usuario.senha" required />
							</div>
						</div>
						<div>
							<div>
								<label>Confirmar Senha:</label>
							</div>
							<div class="input-control password" style="width: 250px">
								<input type="password" name="confirmarSenha" required />
							</div>
						</div>
						<div style="padding-top: 10px;">
							<input style="height: 30px;" class="bg-darkGreen fg-white"
								type="submit" value="Cadastrar" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>