<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
  <head>
   <meta charset="utf-8">
    <title>Sign in &middot; Riddler</title>
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">


    <!-- Os Estilos -->
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="css/base_index.css" rel="stylesheet">

    <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="bootstrap/ico/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="bootstrap/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="bootstrap/ico/apple-touch-icon-72-precomposed.png">
                  <link rel="apple-touch-icon-precomposed" href="bootstrap/ico/apple-touch-icon-57-precomposed.png">
                                 <link rel="shortcut icon" href="bootstrap/ico/favicon.png">
  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="j_spring_security_check" method="post">
        <h2 class="form-signin-heading">Login</h2>
        <input type="text" name="j_username" class="input-block-level" placeholder="Login">
        <input type="password" name="j_password" class="input-block-level" placeholder="Senha">
<!--         <label class="checkbox"> -->
<!--           <input type="checkbox" value="remember-me"> Lembre-me -->
<!--         </label> -->
        <button class="btn btn-large btn-success" type="submit">Entrar</button>
      </form>

    </div> <!-- /container -->

 <jsp:include page="footer.jsp"></jsp:include>


  </body>
</html>
