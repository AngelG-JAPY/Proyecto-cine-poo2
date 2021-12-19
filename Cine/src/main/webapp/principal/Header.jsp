
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="es">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600%7CUbuntu:300,400,500,700" rel="stylesheet">

        <!-- CSS -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/bootstrap-reboot.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/bootstrap-grid.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/jquery.mCustomScrollbar.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/nouislider.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/ionicons.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/plyr.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/photoswipe.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/default-skin.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/principal/css/main.css">


        <!-- Favicons -->
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/principal/icon/favicon-32x32.png" sizes="32x32">
        <link rel="apple-touch-icon" href="icon/favicon-32x32.png">
        <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/principal/icon/apple-touch-icon-72x72.png">
        <link rel="apple-touch-icon" sizes="114x114" href="${pageContext.request.contextPath}/principal/icon/apple-touch-icon-114x114.png">
        <link rel="apple-touch-icon" sizes="144x144" href="${pageContext.request.contextPath}/principal/icon/apple-touch-icon-144x144.png">

        <meta name="description" content="">
        <meta name="keywords" content="">
        <meta name="author" content="Dmitry Volkov">
        <title>Tolima's Cine</title>

    </head>
    <body class="body">

        <!-- header -->
        <header class="header">
            <div class="header__wrap">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="header__content">
                                <!-- header logo -->
                                <a href="index.html" class="header__logo">
                                    <img src="${pageContext.request.contextPath}/principal/img/logo.svg" alt="">
                                </a>
                                <!-- end header logo -->

                                <!-- header nav -->
                                <ul class="header__nav">
                                    <!-- dropdown -->
                                    <li class="header__nav-item">
                                        <a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuHome" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">inicio</a>
                                    </li>
                                    <!-- end dropdown -->

                                    <!-- dropdown -->
                                    <li class="header__nav-item">
                                        <a class="dropdown-toggle header__nav-link" href="#" role="button" id="dropdownMenuCatalog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">peliculas</a>

                                        <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuCatalog">
                                            <li><a href="catalog2.html">Cartelera</a></li>
                                            <li><a href="catalog1.html">Proximos Estrenos</a></li>
                                        </ul>
                                    </li>
                                    <!-- end dropdown -->

                                    <li class="header__nav-item">
                                        <a href="pricing.html" class="header__nav-link">membresÃ­a</a>
                                    </li>


                                    <li class="header__nav-item">
                                        <a href="signup.html" class="header__nav-link">Registrarse</a>
                                    </li>

                                    <!-- dropdown -->
                                    <li class="dropdown header__nav-item">
                                        <a class="dropdown-toggle header__nav-link header__nav-link--more" href="#" role="button" id="dropdownMenuMore" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><i class="icon ion-ios-more"></i></a>

                                        <ul class="dropdown-menu header__dropdown-menu" aria-labelledby="dropdownMenuMore">
                                            <li class="header__nav-item">
                                                <a href="faq.html" >ayuda</a>
                                            </li>

                                            <li class="header__nav-item">
                                                <a href="about.html">Nosotros</a>
                                            </li>
                                        </ul>
                                    </li>
                                    <!-- end dropdown -->
                                </ul>
                                <!-- end header nav -->

                                <!-- header auth -->
                                <div class="header__auth">
                                    <button class="header__search-btn" type="button">
                                        <i class="icon ion-ios-search"></i>
                                    </button>
                                    <a href="signin.html" class="header__sign-in">
                                        <i class="icon ion-ios-log-in"></i>
                                        <span>Iniciar Sesión</span>
                                    </a>
                                </div>
                                <!-- end header auth -->

                                <!-- header menu btn -->
                                <button class="header__btn" type="button">
                                    <span></span>
                                    <span></span>
                                    <span></span>
                                </button>
                                <!-- end header menu btn -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- header search -->
            <form action="#" class="header__search">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <div class="header__search-content">
                                <input type="text" placeholder="Search for a movie, TV Series that you are looking for">

                                <button type="button">buscar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </form>
            <!-- end header search -->
        </header>
        <!-- end header -->

