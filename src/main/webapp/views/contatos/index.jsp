<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<script>
    function showModal(url) {
        $('#modal1-sim').attr('href', url);
        $('#modal1').modal();
    }
</script>

<div id="modal1" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Excluir Registro</h3>
    </div>
    <div class="modal-body">
        <p>Deseja Realmente Excluir?</p>
    </div>
    <div class="modal-footer">
        <button class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Cancelar</button>
        <a id="modal1-sim" class="btn btn-success" href="">Sim</a>
    </div>
</div>

<p>
<div id="actions">
    <a class="btn btn-primary" id="add" href="contatos/form">Adicionar Contato</a>
</div>
</p>

<table class="table table-striped table-bordered table-hover table-condensed">

    <thead>
        <tr>
            <th class="headerSortUp">Nome</th>
            <th class="headerSortUp">Email</th>
            <th width="60px" class="headerSortUp">&nbsp;</th>
        </tr>
    </thead>

    <tbody>

        <c:forEach items="${contatos}" var="c">
            <tr>
                <td><a href="${pageContext.request.contextPath}/contatos/form/${c.id}">${c.nome}</a></td>
                <td>${c.email}</td>
                <td>
                    <a class="btn btn-info btn-mini" href="${pageContext.request.contextPath}/contatos/form/${c.id}"><i class="icon-edit icon-white"></i></a>
                    <button class="btn btn-danger btn-mini" onclick="showModal('${pageContext.request.contextPath}/contatos/delete/${c.id}')" data-toggle="modal"><i class="icon-trash icon-white"></i></button>
                </td>
            </tr>
        </c:forEach>

    </tbody>

</table>