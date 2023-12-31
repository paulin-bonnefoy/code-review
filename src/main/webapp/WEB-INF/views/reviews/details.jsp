<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Code review n°${codeReview.id}</title>

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
                <h1 class="page-header">Ajouter une code review</h1>
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
                                <table class="table table-striped table-bordered">
                                    <thead class="thead-dark">
                                    <tr>
                                        <th>Name</th>
                                        <th>Description</th>
                                        <th>Date/Time</th>
                                        <th>Promo ID</th>
                                        <th>Actions</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${codeReview.name}</td>
                                        <td>${codeReview.description}</td>
                                        <td>${codeReview.datetime}</td>
                                        <td>${codeReview.promo_id}</td>
                                        <td>
                                            <a href="review/delete?id=${codeReview.id}" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Delete</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
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