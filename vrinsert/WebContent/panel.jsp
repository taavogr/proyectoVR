<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0, user-scalable=no"/>
  <title>InsertVR - Panel de Correos</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="black" role="navigation">
    <div class="nav-wrapper container">
      <a id="logo-container" href="#" class="brand-logo light-green-text text-accent-3">InsertVR-Panel</a>
      
    </div>
  </nav>
  
  <div class= "container">
  <div class= "row">
  <h1>Vista de Correos</h1>
  </div>
  
  
  <div class="row">
    
    <table class="striped">
      <thead>
          <tr>
              <th data-field="id">ID</th>
              <th data-field="name">CORREO</th>
              
              
          </tr>
        </thead>

        <tbody>
        <c:forEach var="c" items="${requestScope.listcorreos}" >
        <tr>
        <td>${c.idcorreo }</td>
        <td>${c.nombrecorreo }</td>

        
        </tr>
        </c:forEach>
        </tbody>
    </table>
  </div>
  </div>
  
  

 

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

  </body>
</html>
    