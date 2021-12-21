<%@include file="/principal/Header.jsp" %>

<!-- details -->
<section class="section details">
    <!-- details background -->
    <div class="details__bg" data-bg="${pageContext.request.contextPath}/principal/img/home/home__bg.jpg"></div>
    <!-- end details background -->

    <!-- details content -->
    <div class="container">
        <div class="row">
            <!-- title -->
            <div class="col-12">
                <h1 class="details__title">${pelicula.nombre}</h1>
            </div>
            <!-- end title -->

            <!-- content -->
            <div class="col-12 col-xl-6">
                <div class="card card--details">
                    <div class="row">
                        <!-- card cover -->
                        <div class="col-12 col-sm-4 col-md-4 col-lg-3 col-xl-5">
                            <div class="card__cover">
                                <img src="${pelicula.cartelera}" alt="">
                            </div>
                        </div>
                        <!-- end card cover -->

                        <!-- card content -->
                        <div class="col-12 col-sm-8 col-md-8 col-lg-9 col-xl-7">
                            <div class="card__content">
                                <div class="card__wrap">
                                    <span class="card__rate"><i class="icon ion-ios-star"></i>8.4</span>

                                    <ul class="card__list">
                                        <li>HD</li>
                                        <li>${pelicula.clasificacion}</li>
                                    </ul>
                                </div>

                                <ul class="card__meta">
                                    <li><span>Genero:</span> <a href="#">${pelicula.genero}</a>
                                    <li><span>Director:</span> ${pelicula.director}</li>
                                    <li><span>Duración:</span> ${pelicula.duracion} min</li>
                                </ul>

                                <div class="card__description card__description--details">
                                    ${pelicula.sinopsis}
                                </div>
                            </div>
                        </div>
                        <!-- end card content -->
                    </div>
                </div>
            </div>
            <!-- end content -->

            <!-- player -->
            <div class="col-12 col-xl-6">
                <iframe width="560" height="315" src="${pelicula.trailer}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
            </div>
            <!-- end player -->
        </div>
    </div>
    <!-- end details content -->
</section>
<!-- end details -->

<%@include file="/principal/footer.jsp" %>