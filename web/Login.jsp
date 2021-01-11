<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
	<title>Login</title>
	<!-- Meta tag Keywords -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta charset="UTF-8" />
	<meta name="keywords"
		content="Working Signin form Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
	<!-- //Meta tag Keywords -->
	<link href="//fonts.googleapis.com/css2?family=Karla:wght@400;700&display=swap" rel="stylesheet">
	<!--/Style-CSS -->
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
	<!--//Style-CSS -->
</head>

<body>

	 <!-- form section start -->
	 <section class="w3l-workinghny-form">
        <!-- /form -->
        <div class="workinghny-form-grid">
            <div class="wrapper">
                <div class="logo">
                    <h1><a class="brand-logo" href="index.html"><span>Ingresar</span></a></h1>
                    <!-- if logo is image enable this   
                        <a class="brand-logo" href="#index.html">
                            <img src="image-path" alt="Your logo" title="Your logo" style="height:35px;" />
                        </a> -->
                </div>
                <div class="workinghny-block-grid">
                    <div class="workinghny-left-img align-end">
                        <img src="images/2.png" class="img-responsive" alt="img" />
                    </div>
                    <div class="form-right-inf">
						
                        <div class="login-form-content">
                            <form action="ServletLogin" class="signin-form" method="POST">
								<div class="one-frm">

									<label>Nombre de usuario</label>
									<input type="text" name="username"  placeholder="" required="">
								</div>
								<div class="one-frm">
									<label>Contraseña</label>
									<input type="password" name="pass"  placeholder="" required="">
								</div>
                                <label class="check-remaind">
                                    <input type="checkbox">
                                    <span class="checkmark"></span>
                                    <p class="remember">Recordarme</p>

                                </label>
                                <button class="btn btn-style mt-3">Ingresar </button>
                                <p class="already">¿No tienes cuenta? <a href="Usuario.jsp">Registrarse</a></p>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- //form -->
        <!-- copyright-->
        
        <!-- //copyright-->
    </section>
    <!-- //form section start -->

</body>

</html>