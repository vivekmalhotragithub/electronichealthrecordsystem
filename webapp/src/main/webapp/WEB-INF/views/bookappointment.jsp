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
                <div class="navbar-brand">Welcome, ${name}</div>
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
                            <a href="<c:url value="/logout" />"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="${prefix}/admin/home"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
                    </li>
                    <li class="active">
                        <a href="#"><i class="fa fa-fw fa-edit"></i> Book an Appointment</a>
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
                            New Appointment
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-dashboard"></i>  <a href="${prefix}/admin/home">Dashboards</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="#">Book an Appointment</a>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">

                        <form role="form">

                            <div class="form-group">
                                <label>Patient</label>
                                <input class="form-control" type="text" placeholder="Enter text" required="required">
                                <p class="help-block">Start by searching for patient here.</p>
                            </div>

                            <div class="form-group">
                                <label>Address</label>
                                <p class="form-control-static">plot-3, palam vihar, gurgaon, Haryana</p>
                            </div>

                            <div class="form-group">
                                <label>Internal ID</label>
                                <p class="form-control-static">PAT-IND-10001</p>
                            </div>

                            <div class="form-group">
                                <label>Date of Birth</label>
                                <p class="form-control-static">23 January 1988</p>
                            </div>

                            <div class="form-group">
                                <label>Blood group</label>
                                <p class="form-control-static">B +</p>
                            </div>

                            <div class="form-group">
                                <label>Contact details</label>
                                <p class="form-control-static">9654615544</p>
                            </div>

                            <div class="form-group">
                                <label>Appointment Date</label>
                                <input type="datetime-local">
                            </div>

                            <div class="form-group">
                                <label>Comments</label>
                                <textarea class="form-control" rows="3"></textarea>
                            </div>
                            
                            <div class="form-group">
                                <label>Doctor</label>
                                <select class="form-control">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-default">Submit Button</button>
                            <button type="reset" class="btn btn-default">Reset Button</button>
                        </form>
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
    <script src="${prefix}/resources/js/jquery.js"></script>
    <!-- Bootstrap Core JavaScript -->
    <script src="${prefix}/resources/js/bootstrap.min.js"></script>

</body>

</html>
