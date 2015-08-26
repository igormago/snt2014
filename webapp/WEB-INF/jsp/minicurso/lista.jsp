<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div>Meus Minicursos</div>
<script>

	function defineId(id) {
		var minicurso = document.getElementById("minicurso");
		minicurso.value = id;
	};
</script>
<form id="listaMinicursos" action="<c:url value='/minicurso'/>" method="post">
	<input name="minicurso.id" value="5" type="hidden" id="minicurso" />
	<c:forEach items="${minicursos}" var="minicurso">

		<table border="1" style="width: 100%">
			<tr>
				<td width="70%">${minicurso.titulo}</td>
				<!-- 
				<td>
					<button type="submit" name="_method" value="DELETE" onclick="defineId(${minicurso.id})">EXCLUIR</button>
					<button type="submit" name="_method" value="DELETE" onclick="defineId(${minicurso.id})">EDITAR</button>
				</td>
				 -->
			</tr>
		</table>
	</c:forEach>
</form>