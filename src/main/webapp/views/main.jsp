<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html" pageEncoding="MacRoman"%>

<!DOCTYPE html>
<html>
    <head>
        <title>SpringDemo - LAB</title>

        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resource/stylesheets/bootstrap.css">
        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resource/stylesheets/main.css">

        <script src="${pageContext.request.contextPath}/resource/javascripts/jquery-1.9.0.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resource/javascripts/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>


        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a style="color: white" class="brand" href="/">SpringDemo</a>
                    <div class="nav-collapse collapse">
                        <ul class="nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Menu <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li class="nav-header">Menu</li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/contatos">Contatos</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/acesso/logout">Logout</a>
                                    </li>
                                </ul>
                            </li>
                            <tiles:useAttribute id="menu" name="menu" classname="String" ignore="true"/>

                            <li <c:if test="${menu == 'contato'}">class="active"</c:if>>
                                <a href="${pageContext.request.contextPath}/contatos">Contatos</a>
                            </li>

                        </ul>
                    </div><!--/.nav-collapse -->
                </div>
            </div>
        </div>

        <div class="container">

            <div class="content">

                <div class="page-header">
                    <h1><tiles:getAsString name="titulo" /> <small><tiles:getAsString name="subtitulo" /></small></h1>
                </div>

                <c:if test="${message != null}">
                    <script>
                        window.onload = function() {
                            setInterval("document.getElementById('msginfo').style.display='none'", 5000);
                        }
                    </script>

                    <div id="msginfo" class="alert alert-success">
                        <button type="button" class="close" data-dismiss="alert">&times;</button>
                        <strong>OK :)</strong> ${message}.
                    </div>
                </c:if>

                <div class="row-fluid">
                    <tiles:insertAttribute name="conteudo"/>
                </div>

            </div>

            <footer>
                <p>
                    <br/>
                    <a href="http://www.github.com/itakenami">www.github.com/itakenami</a>
                </p>
            </footer>

        </div>

    </body>
</html>
