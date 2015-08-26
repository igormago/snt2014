<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navigation-bar">
	<nav class="navigation-bar-content bg-green">
		<a href="<c:url value='/'/>" class="element"> Home</a>
		<item class="element-divider"></item>
		<a href="<c:url value='/minicurso/form'/>" class="element">Cadastrar
			Minicurso</item>
		</a>
		<c:if test="${sessao.ehMinistrante() == true}">
			<item class="element-divider"></item>
			<a href="<c:url value='/minicurso'/>" class="element" >Meus Minicursos</item>
			</a>
		</c:if>
		<c:if test="${sessao.ehMinistrante() == false}">
			<div style="float: right; margin-right: 30px" class="bg-darkGreen">
				<item class="element-divider"></item>
				<a href="<c:url value='/login'/>" class="element"> Entrar</a>
				<item class="element-divider"></item>
			</div>
		</c:if>
		<c:if test="${sessao.estaLogado() == true}">
			<div style="float: right"> 
				<div class="element"><i class="icon-user" style="padding-right: 10px"></i>${sessao.getUsuario().getEmail()}</div>
				<div style="float: right; margin-right: 30px">
					<div class="bg-darkGreen">
						<item class="element-divider"></item>
						<a href="<c:url value='/logout'/>" class="element"> Sair</a>
						<item class="element-divider"></item>
					</div>
				</div>
			</div>
		</c:if>
	</nav>
</nav>
