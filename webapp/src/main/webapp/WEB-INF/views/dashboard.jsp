<%@ page language="java" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="prefix" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    
    <title>Dashboard EHR</title>

    <!-- Bootstrap Core CSS -->
    <link href="${prefix}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${prefix}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${prefix}/resources/css/fontawesome/font-awesome.min.css" rel="stylesheet" type="text/css">

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <div class="navbar-brand">SB Admin</div>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#"><span class="label label-default">INFO</span>You have new appointments</a>
                        </li>
                        <li>
                            <a href="#"><span class="label label-danger">WARN</span>Patient Anderson checked in ward 102</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li class="active">
                        <a href="forms.html"><i class="fa fa-fw fa-edit"></i> Book an Appointment</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Dashboard <small>Statistics Overview</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="/doctor/dashboard">Dashboards</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="/doctor/appointments/book">Book an Appointment</a>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <div class="panel panel-default">
                          <div class="panel-heading">
                              <h3 class="panel-title"><i class="fa fa-money fa-fw"></i> Upcoming appointments</h3>
                          </div>
                          <div class="panel-body">
                              <div class="table-responsive">
                                  <table class="table table-bordered table-hover table-striped">
                                      <thead>
                                          <tr>
                                              <th>Order #</th>
                                              <th>Appointment Date</th>
                                              <th>Time</th>
                                              <th>Patient</th>
                                          </tr>
                                      </thead>
                                      <tbody>
                                          <tr>
                                              <td>3326</td>
                                              <td>10/21/2013</td>
                                              <td>3:29 PM</td>
                                              <td>$321.33</td>
                                          </tr>
                                          <tr>
                                              <td>3325</td>
                                              <td>10/21/2013</td>
                                              <td>3:20 PM</td>
                                              <td>$234.34</td>
                                          </tr>
                                          <tr>
                                              <td>3324</td>
                                              <td>10/21/2013</td>
                                              <td>3:03 PM</td>
                                              <td>$724.17</td>
                                          </tr>
                                          <tr>
                                              <td>3323</td>
                                              <td>10/21/2013</td>
                                              <td>3:00 PM</td>
                                              <td>$23.71</td>
                                          </tr>
                                          <tr>
                                              <td>3322</td>
                                              <td>10/21/2013</td>
                                              <td>2:49 PM</td>
                                              <td>$8345.23</td>
                                          </tr>
                                          <tr>
                                              <td>3321</td>
                                              <td>10/21/2013</td>
                                              <td>2:23 PM</td>
                                              <td>$245.12</td>
                                          </tr>
                                          <tr>
                                              <td>3320</td>
                                              <td>10/21/2013</td>
                                              <td>2:15 PM</td>
                                              <td>$5663.54</td>
                                          </tr>
                                          <tr>
                                              <td>3319</td>
                                              <td>10/21/2013</td>
                                              <td>2:13 PM</td>
                                              <td>$943.45</td>
                                          </tr>
                                      </tbody>
                                  </table>
                              </div>

                          </div>
                      </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
    <!-- jQuery -->
    <script src="js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
