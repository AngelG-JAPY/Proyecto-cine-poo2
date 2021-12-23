<%@include file="/principal/Header.jsp" %>

<!-- page title -->
<section class="section section--first section--bg" data-bg="${pageContext.request.contextPath}/principal/img/section/section.jpg">
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="section__wrap">
                    <!-- section title -->
                    <h2 class="section__title">¡Próximos estrenos!</h2>
                    <!-- end section title -->

                    <!-- breadcrumb -->
                    <ul class="breadcrumb">
                        <li class="breadcrumb__item"><a href="${pageContext.request.contextPath}/peliculas">Inicio</a></li>
                        <li class="breadcrumb__item breadcrumb__item--active">Próximos estrenos</li>
                    </ul>
                    <!-- end breadcrumb -->
                </div>
            </div>
        </div>
    </div>
</section>
<!-- end page title -->

<!-- filter -->
<div class="filter">

</div>
<!-- end filter -->

<!-- catalog -->
<div class="catalog">
    <div class="container">
        <div class="row">
            <c:forEach var="peliculas" items="${peliculas}">
                <!-- card -->
                <div class="col-6 col-sm-4 col-lg-3 col-xl-2">
                    <div class="card">
                        <div class="card__cover">
                            <img src="${peliculas.cartelera}" alt="">
                            <a href="#" class="card__play">
                                <i class="icon ion-ios-play"></i>
                            </a>
                        </div>
                        <div class="card__content">
                            <h3 class="card__title"><a href="#">${peliculas.nombre}</a></h3>
                            <span class="card__category">
                                <a href="#">Action</a>
                                <a href="#">Triler</a>
                            </span>
                            <span class="card__rate"><i class="icon ion-ios-star"></i>8.4</span>
                        </div>
                    </div>
                </div>
                <!-- end card -->
            </c:forEach>



            <!-- paginator -->
            <div class="col-12">
                <ul class="paginator">
                    <li class="paginator__item paginator__item--prev">
                        <a href="#"><i class="icon ion-ios-arrow-back"></i></a>
                    </li>
                    <li class="paginator__item"><a href="#">1</a></li>
                    <li class="paginator__item paginator__item--active"><a href="#">2</a></li>
                    <li class="paginator__item"><a href="#">3</a></li>
                    <li class="paginator__item"><a href="#">4</a></li>
                    <li class="paginator__item paginator__item--next">
                        <a href="#"><i class="icon ion-ios-arrow-forward"></i></a>
                    </li>
                </ul>
            </div>
            <!-- end paginator -->
        </div>
    </div>
</div>
<!-- end catalog -->

<%@include file="/principal/footer.jsp" %>