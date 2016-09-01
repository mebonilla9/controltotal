<%-- 
    Document   : home
    Created on : 30-ago-2016, 14:36:31
    Author     : Lord_Nightmare
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700' rel='stylesheet' type='text/css'>
        <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <section id="sidebar"> 
            <div class="white-label">
            </div> 
            <div id="sidebar-nav">   
                <ul>
                    <li class="active f"><a href="#"><i class="fa fa-dashboard"></i> Dashboard</a></li>
                    <li><a href="#"><i class="fa fa-desktop"></i> My Website</a></li>
                    <li><a href="#"><i class="fa fa-usd"></i> Ecommerce</a></li>
                    <li><a href="#"><i class="fa fa-pencil-square-o"></i> My Blog</a></li>
                    <li><a href="#"><i class="fa fa-sitemap"></i> SEO Tools</a></li>
                    <li><a href="#"><i class="fa fa-line-chart"></i> Reporting</a></li>
                    <li><a href="#"><i class="fa fa-comments-o"></i>Social Marketing</a></li>
                    <li><a href="#"><i class="fa fa-map-marker"></i> Get Traffic</a></li>     
                    <li><a href="#"><i class="fa fa-users"></i> Employees</a></li>
                    <li><a href="#"><i class="fa fa-calendar-o"></i> Reservations</a></li>
                    <li><a href="#"><i class="fa fa-calendar"></i> Calendar</a></li>
                </ul>
            </div>
        </section>
        <section id="content">
            <div id="header">
                <div class="header-nav">
                    <div class="menu-button">
                        <i class="fa fa-navicon"></i>
                    </div>
                    <div class="nav">
                        <ul>
                            <li class="nav-settings">
                                <div class="font-icon"><i class="fa fa-tasks"></i></div>
                            </li>
                            <li class="nav-mail">
                                <div class="font-icon"><i class="fa fa-envelope-o"></i></div>
                            </li>
                            <li class="nav-calendar">
                                <div class="font-icon"><i class="fa fa-calendar"></i></div>
                            </li>
                            <li class="nav-chat">
                                <div class="font-icon"><i class="fa fa-comments-o"></i></div>
                            </li>
                            <li class="nav-profile">
                                <div class="nav-profile-image">
                                    <img src="img/usuario.png" alt="profile-img" alt="profile image">
                                    <div class="nav-profile-name">${sessionScope.nombre}<i class="fa fa-caret-down"></i></div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="content">
                <div class="content-header">
                    <h1>Proyecto de pruebas</h1>
                    <p>Pagina maestra para manejo de templates del lado del cliente</p>
                </div>
            </div>
        </section>
    </body>
</html>
