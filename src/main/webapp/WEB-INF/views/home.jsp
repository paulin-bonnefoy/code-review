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



    <!-- Bootstrap CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet" type="text/css">

    <!-- Custom CSS -->
    <link href="./resources/css/style.css" rel="stylesheet" type="text/css">

    <!-- Custom Fonts -->
    <script src="./resources/js/bootstrap.min.js"></script>
</head>

<body>

<div id="wrapper">​
219


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
                    <li><a href="promotions"><i class="fa fa-users fa-fw"></i> Ajouter une promotion</a>
                    </li>
                    <li><a href="members"><i class="fa fa-user fa-fw"></i> Ajouter un membre</a>
                    </li>
                    <li><a href="codereviews"><i class="fa fa-calendar fa-fw"></i> Créer un rendez-vous</a>
                    </li>
                </ul>
            </li>
        </ul>
    </nav>

    <div id="page-wrapper" class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">Panneau d'administration</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-4 col-md-4">
                <div class="panel" style="background-color: #43009C; color: white">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-users fa-5x"></i>
                                <img src="./resources/img/promotion_icon.png" style="max-height: 80px">
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">4</div>
                                <div class="huge-label">Promotions</div>
                            </div>
                        </div>
                    </div>
                    <a href="promotions">
                        <div class="panel-footer">
                            <span class="pull-left">Ajouter une promotion</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4">
                <div class="panel"  style="background-color: #CB1567; color: white">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-user fa-5x"></i>
                                <img src="./resources/img/member_icon.png" style="max-height: 80px">
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">46</div>
                                <div class="huge-label">Membres inscrits</div>
                            </div>
                        </div>
                    </div>
                    <a href="members">
                        <div class="panel-footer">
                            <span class="pull-left">Ajouter un membre</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4">
                <div class="panel "  style="background-color: #F196BF; color: white">
                    <div class="panel-heading">
                        <div class="row">
                            <div class="col-xs-3">
                                <i class="fa fa-calendar fa-5x"></i>
                                <img src="./resources/img/codereview_icon.png" style="max-height: 80px">
                            </div>
                            <div class="col-xs-9 text-right">
                                <div class="huge">3</div>
                                <div class="huge-label">Code reviews programmées</div>
                            </div>
                        </div>
                    </div>
                    <a href="codereviews">
                        <div class="panel-footer">
                            <span class="pull-left">Ajouter une code review</span>
                            <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                            <div class="clearfix"></div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <!-- /.row -->
        <div class="row">
            <div class="col-lg-8">
                <!-- /.panel -->
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-user fa-fw"></i> Gestion des membres
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="table-responsive">
                                    <table class="table table-hover table-striped">
                                        <thead>
                                        <tr>
                                            <th>Nom</th>
                                            <th>Email</th>
                                            <th>Promotion</th>
                                            <th class="text-right">Action</th>
                                        </tr>
                                        </thead>
                                        <tbody>

                                        <c:forEach items="${listMembers}" var="member">
                                            <tr>
                                                <td>${member.name}</td>
                                                <td>${member.email}</td>
                                                <td>${member.promo_id}</td>
                                                <td  class="text-right">
                                                    <a href="#" class="btn btn-sm btn-warning"><i class="fa fa-pencil"></i> Modifier</a>
                                                    <a href="#" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Supprimer</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <div class="text-center">
                                        <ul class="pagination">
                                            <li><a href="#">1</a></li>
                                            <li><a href="#">2</a></li>
                                            <li><a href="#">3</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <!-- /.table-responsive -->
                            </div>
                        </div>
                        <!-- /.row -->
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-8 -->
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-calendar fa-fw"></i> Codes reviews programmées
                    </div>
                    <div class="panel-body">
                        <table class="table table-striped">

                            <c:forEach var="code_review"  items="${requestScope['listCodeReviews']}" >
                                <tr>
                                    <td>${code_review.id}</td>
                                    <td>${code_review.promotion.name}</td>
                                    <td>${code_review.datetime}</td>

                                    <td  class="text-right">
                                        <a href="#" class="btn btn-sm btn-warning"><i class="fa fa-pencil"></i> Modifier</a>
                                        <a href="#" class="btn btn-sm btn-danger"><i class="fa fa-trash"></i> Supprimer</a>
                                    </td>
                                </tr>
                            </c:forEach>

                        </table>
                        <a href="#" class="btn btn-default btn-block">Programmer une code review</a>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <i class="fa fa-users fa-fw"></i> Gestion des promotions
                    </div>
                    <!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="list-group">
                            <c:forEach items="${listPromotions}" var="promotion">
                                <a href="#" class="list-group-item">
                                    <i class="fa fa-users fa-fw"></i> ${promotion.id}
                                    <span class="pull-right text-muted small"><em>${promotion.name}</em>
                                    </span>
                                </a>
                            </c:forEach>
                        </div>
                        <!-- /.list-group -->
                        <a href="#" class="btn btn-default btn-block">Créer une nouvelle promotion</a>
                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-4 -->
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