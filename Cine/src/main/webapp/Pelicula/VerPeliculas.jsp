
<%@include file = "../principal/Header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section class="home home--bg">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <h1 class="home__title"><b>EN CARTELERA</b></h1>

                <button class="home__nav home__nav--prev" type="button">
                    <i class="icon ion-ios-arrow-round-back"></i>
                </button>
                <button class="home__nav home__nav--next" type="button">
                    <i class="icon ion-ios-arrow-round-forward"></i>
                </button>
            </div>
            <div class="col-12">
                <div class="owl-carousel home__carousel" >
                    <c:forEach var="peliculas" items="${peliculas}">
                        <div class="item">
                            <!-- card -->
                            <div class="card card--big">
                                <div class="card__cover">
                                    <img src="${peliculas.cartelera}" alt="spiderman">
                                    <a href="#" class="card__play">
                                        <i class="icon ion-ios-play"></i>
                                    </a>
                                </div>
                                <div class="card__content">
                                    <h3 class="card__title"><a href="#">a</a></h3>
                                    <span class="card__category">
                                        <a href="#">Action</a>
                                        <a href="#">Triler</a>
                                    </span>
                                    <span class="card__rate"><i class="icon ion-ios-star"></i>8.4</span>
                                </div>
                            </div>
                            <!-- end card -->

                        </div>
                        <!-- end home -->
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</section>
        <script src="${pageContext.request.contextPath}/principal/js/jquery-3.3.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/bootstrap.bundle.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/jquery.mousewheel.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/jquery.mCustomScrollbar.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/wNumb.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/nouislider.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/plyr.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/jquery.morelines.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/s/photoswipe.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/photoswipe-ui-default.min.js"></script>
        <script src="${pageContext.request.contextPath}/principal/js/main.js"></script>

