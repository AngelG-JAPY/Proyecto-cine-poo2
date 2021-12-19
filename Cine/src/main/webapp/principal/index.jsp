
<%@include file = "/principal/Header.jsp" %>
        <!-- home -->
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

                            <%--<%@include file="../Pelicula/VerPeliculas.jsp" %>--%>
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
                                            <h3 class="card__title"><a href="#">${peliculas.nombre}</a></h3>
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
        <!-- end home -->

        <!-- content -->
        <section class="content">
            <div class="content__head">
                <div class="container">
                    <div class="row">
                        <div class="col-12">
                            <!-- content title 
                            <h2 class="content__title">New items</h2>-->
                            <!-- end content title -->

                            <!-- content tabs nav -->
                            <ul class="nav nav-tabs content__tabs" id="content__tabs" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true">Cartelera</a>
                                </li>

                                <li class="nav-item">
                                    <a class="nav-link" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false">Proximos estrenos</a>
                                </li>
                            </ul>
                            <!-- end content tabs nav -->

                            <!-- content mobile tabs nav -->
                            <div class="content__mobile-tabs" id="content__mobile-tabs">
                                <div class="content__mobile-tabs-btn dropdown-toggle" role="navigation" id="mobile-tabs" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <input type="button" value="New items">
                                    <span></span>
                                </div>

                                <div class="content__mobile-tabs-menu dropdown-menu" aria-labelledby="mobile-tabs">
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="nav-item"><a class="nav-link active" id="1-tab" data-toggle="tab" href="#tab-1" role="tab" aria-controls="tab-1" aria-selected="true">NEW RELEASES</a></li>

                                        <li class="nav-item"><a class="nav-link" id="2-tab" data-toggle="tab" href="#tab-2" role="tab" aria-controls="tab-2" aria-selected="false">MOVIES</a></li>
                                    </ul>
                                </div>
                            </div>
                            <!-- end content mobile tabs nav -->
                        </div>
                    </div>
                </div>
            </div>

            <div class="container">
                <!-- content tabs -->
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade  show active" id="tab-1" role="tabpanel" aria-labelledby="1-tab">
                        <div class="row">

                            <c:forEach var="peliculas" items="${peliculas}">
                                <!-- card -->
                                <div class="col-6 col-sm-12 col-lg-6">
                                    <div class="card card--list">
                                        <div class="row">
                                            <div class="col-12 col-sm-4">
                                                <div class="card__cover">
                                                    <!-- ${pageContext.request.contextPath} -->
                                                    <img src="${peliculas.cartelera}" alt="">
                                                    <a href="#" class="card__play">
                                                        <i class="icon ion-ios-play"></i>
                                                    </a>
                                                </div>
                                            </div>

                                            <div class="col-12 col-sm-8">
                                                <div class="card__content">
                                                    <h3 class="card__title"><a href="#">${peliculas.nombre}</a></h3>
                                                    <span class="card__category">
                                                        <a href="#">Action</a>
                                                        <a href="#">Triler</a>
                                                    </span>

                                                    <div class="card__wrap">
                                                        <span class="card__rate"><i class="icon ion-ios-star"></i>8.4</span>

                                                        <ul class="card__list">
                                                            <li>HD</li>
                                                            <li>${peliculas.clasificacion}</li>
                                                        </ul>
                                                    </div>

                                                    <div class="card__description">
                                                        <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English.</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- end card -->
                            </c:forEach>
                            <div class="col-12">
                                <a href="#" class="section__btn">Show more</a>
                            </div>
                        </div>
                    </div>
                    <!-<!-- proximos estrenos -->
                    <div class="tab-pane fade" id="tab-2" role="tabpanel" aria-labelledby="2-tab">
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
                            <div class="col-12">
                                <a href="#" class="section__btn">Show more</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- end content tabs -->
            </div>
        </section>
        <!-- end content --> 

<%@include file = "/principal/footer.jsp" %>