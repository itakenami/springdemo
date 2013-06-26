<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>


<c:choose>
    <c:when test="${contato.id != null}">
        <c:url var="url" value="/contatos/update/${contato.id}"/>
    </c:when>
    <c:otherwise>
        <c:url var="url" value="/contatos/save"/>
    </c:otherwise>
</c:choose>



<sf:form action="${url}" method="POST" modelAttribute="contato">

        <fieldset>
            <div class="tabbable"> <!-- Only required for left/right tabs -->

                <ul class="nav nav-tabs">        
                    <li class="active"><a href="#tab0" data-toggle="tab">Informações de Contatos</a></li>

                </ul>

                <div class="tab-content">

                    <div class="tab-pane active" id="tab0">

                        <div class="control-group ">
                            <label class="control-label" for="nome">Nome</label>
                            <div class="controls">

                                <input type="text" id="nome" name="nome" value="${contato.nome}" >

                            <span class="errors badge badge-important"><sf:errors path="nome"/></span>
                            <span class="help-block helpbootstrap14"></span>
                        </div>
                    </div>

                    <div class="control-group ">
                        <label class="control-label" for="email">Email</label>
                        <div class="controls">

                            <input type="text" id="email" name="email" value="${contato.email}" >

                            <span class="errors badge badge-important"><sf:errors path="email"/></span>
                            <span class="help-block helpbootstrap14">Descreva resumidamente o projeto.</span>
                        </div>
                    </div>

                </div>

            </div>

        </div>


    </fieldset>

    <div class="form-actions">
        <input type="submit" class="btn btn-success" value="Salvar">
        <a href="${pageContext.request.contextPath}/contatos" class="btn">Cancelar</a>
    </div>

</sf:form>