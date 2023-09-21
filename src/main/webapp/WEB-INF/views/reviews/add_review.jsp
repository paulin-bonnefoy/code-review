<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%--
  Created by IntelliJ IDEA.
  User: takima
  Date: 15/09/2023
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>When Is My Code Review?</title>

  <!-- Bootstrap CSS -->
  <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom CSS -->
  <link href="./resources/css/style.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
</head>

<body>

<div id="wrapper">

  <!-- Navigation -->
  <nav class="navbar navbar-default navbar-static-top container-fluid" role="navigation" style="margin-bottom: 0; background-color: #edecec">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a href="home"><img src="./resources/img/MyCodeReview.png" class="logo" alt=""  style="max-width: 200px"></a>

    </div>
    <!-- /.navbar-header -->

    <ul class="nav navbar-top-links navbar-right">
      <li class="dropdown">
        <a class="dropdown-toggle navlink" data-toggle="dropdown" href="#">
          <i class="fa fa-gear fa-fw"></i> Gérer les code reviews <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
          <li><a href="add_promotion.html"><i class="fa fa-users fa-fw"></i> Ajouter une promotion</a>
          </li>
          <li><a href="add_member.html"><i class="fa fa-user fa-fw"></i> Ajouter un membre</a>
          </li>
          <li><a href="add_event.html"><i class="fa fa-calendar fa-fw"></i> Créer un rendez-vous</a>
          </li>
        </ul>
      </li>
    </ul>
  </nav>

  <div id="page-wrapper" class="container-fluid">
    <div class="row">
      <div class="col-lg-12">
        <div style="display:flex; justify-content: center;">
          <img src="./resources/img/review.jpg" style="max-width: 400px; ">
        </div>
        <h1 class="page-header" style="display:flex; justify-content: center; color: #43009C">Créer une promotion</h1>
      </div>
      <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
      <div class="col-lg-10 col-lg-offset-1">
        <!-- /.panel -->
        <div class="panel panel-default">
          <div class="panel-body">
            <div class="row">
              <div class="col-xs-12">
                <form action="/code-review-1.0-SNAPSHOT/add_review" method="post" class="">
                  <div class="form-group">
                    <label for="name">Nom</label>
                    <input type="text" class="input-lg form-control" name="name" id="name" placeholder="Nom">
                  </div>
                  <div class="form-group">
                    <label for="description">Description du travail à effectuer</label>
                    <input type="textarea" class="input-lg form-control" name="description" id="description" placeholder="Description du travail ...">
                  </div>
                  <div class="form-group">
                    <label for="start">Date</label>
                    <input type="date" class="input-lg form-control" name="start" id="start" placeholder="Date du Code Review">
                  </div>
                  <div class="form-group">
                    <label for="promotion">Promotion</label>
                    <select class="input-lg form-control" id="promotion" name="promotion">
                      <c:forEach items="${listPromotions}" var="promotion">
                        <option value="${promotion.id}">${promotion.name}</option>
                      </c:forEach>
                    </select>
                  </div>

                  <div class="text-right">
                    <button type="submit" class="btn btn-lg btn-primary">Enregistrer</button>
                  </div>
                </form>
              </div>
            </div>
            <!-- /.row -->
          </div>
          <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
      </div>
      <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
  </div>
  <!-- /#page-wrapper -->

</div>
<!-- /#wrapper -->
<footer class="footer">
  <div class="container">
    <div class="row text-center">
      <img src="./resources/img/logo_takima_horizontal.png" class="logo" alt="">
      <h4>2023</h4>
    </div>
  </div>
</footer>


<!-- jQuery -->
<script src="./resources/js/jquery-3.1.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="./resources/js/bootstrap.min.js"></script>

</body>

</html>