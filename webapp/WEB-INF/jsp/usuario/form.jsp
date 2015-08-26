<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Página inicial</title>
</head>
<body>
	<form action="<c:url value='/usuarios'/>" method="POST">

		<div>
			<div><label>Nome:</label><span class="error">${errors.from('usuario.nome')}</span> </div>
			<div>
				<input type="text" name="usuario.nome" value="${usuario.nome}" required/>
			</div>
		</div>
		<div>
			<div><label>E-mail:</label></div>
			<div>
				<input type="email" name="usuario.email" value="${usuario.email}" required/>
			</div>
		</div>
		<div>
			<div><label>Senha:</label><span class="error">${errors.from('usuario.senha')}</span></div>
			<div>
				<input type="password" name="usuario.senha" required/>
			</div>
		</div>
		<div>
			<div><label>Confirmar Senha:</label><span class="error">${errors.from('confirmarSenha')}</span></div>
			<div>
				<input type="password" name="confirmarSenha" required/>
			</div>
		</div>
		<div>
			<input type="submit" value="Salvar" />
		</div>
	</form>
</body>
</html>