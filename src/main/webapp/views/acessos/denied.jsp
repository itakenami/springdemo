<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="MacRoman"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Acesso Negado</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- Le styles -->
        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resource/stylesheets/bootstrap.css">
        <style type="text/css">
            body {
                padding-top: 40px;
                padding-bottom: 40px;
                background-color: #f5f5f5;
            }

            .form-signin {
                max-width: 300px;
                padding: 19px 29px 29px;
                margin: 0 auto 20px;
                background-color: #fff;
                border: 1px solid #e5e5e5;
                -webkit-border-radius: 5px;
                -moz-border-radius: 5px;
                border-radius: 5px;
                -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
            }
            .form-signin .form-signin-heading,
            .form-signin .checkbox {
                margin-bottom: 10px;
            }
            .form-signin input[type="text"],
            .form-signin input[type="password"] {
                font-size: 16px;
                height: auto;
                margin-bottom: 15px;
                padding: 7px 9px;
            }

        </style>
        <link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resource/stylesheets/bootstrap-responsive.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="../assets/js/html5shiv.js"></script>
        <![endif]-->

        <script src="${pageContext.request.contextPath}/resource/javascripts/jquery-1.9.0.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resource/javascripts/bootstrap.min.js" type="text/javascript"></script>

    </head>

    <body>

        

        <div class="container">


            <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post" class="form-signin">
                <h2 class="form-signin-heading">Acesso Negado!!!</h2>
                <p>
                Voc� n�o tem permiss�o para acessar este recurso
                </p>
                <p align="center"><button class="btn btn-large btn-primary" onclick="history.back()" type="button">Voltar</button></p>
            </form>

        </div> <!-- /container -->


    </body>
</html>