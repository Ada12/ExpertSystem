<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

  <!-- CSS Files -->
  <link href="../style/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="../style/css/animate.css" rel="stylesheet" media="screen">
  <link href="../style/css/style.css" rel="stylesheet" media="screen">

  <!-- Colors -->
  <link href="../style/css/css-index.css" rel="stylesheet" media="screen">

  <!-- Google Fonts -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />
</head>
<body data-spy="scroll" data-target="#navbar-scroll">
  <!-- /.preloader -->
  <div id="preloader"></div>
  <div id="top"></div>

  <!-- /.parallax full screen background image -->
  <div class="fullscreen landing parallax" style="background-image:url('../style/images/bg.jpg');" data-img-width="2000" data-img-height="1333" data-diff="100">

    <div class="overlay">
      <div class="container">
        <header id="header_area">
          <div class="row">
            <div class="col-sm-5">
              <div class="logo">
                <h2><a href="">Automotive Institute of NVH</a></h2>
              </div>
            </div>
            <div class="col-sm-7">
              <div class="mainmenu">
                <div class="navbar navbar-nobg">
                  <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                      <span class="sr-only">Toggle navigation</span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                      <span class="icon-bar"></span>
                    </button>
                  </div>

                  <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav navbar-right">
                      <li><a href="#">Home</a>
                      </li>
                      <li><a href="#">Design</a>
                      </li>
                      <li><a href="#">History</a>
                      </li>
                      <!--<li><a href="#">Portfolio</a>-->
                      <!--</li>-->
                      <!--<li><a href="#">Contact</a>-->
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </header>
        <div class="row" id="main-area">
          <div class="col-md-7 welcome-text">

            <!-- /.logo -->
            <!--<div class="logo wow fadeInDown"> <a href=""><img src="images/logo.png" alt="logo"></a></div>-->

            <!-- /.main title -->
            <h1 class="wow fadeInLeft">
              Welcome To Brake System Designing!
            </h1>

            <!--/.header paragraph-->
            <div class="landing-text wow fadeInUp">
              <p>This system is designed to help you make a ideal brake system design plan of your automobile. Try now!</p>
            </div>

            <!-- /.header button -->
            <!--<div class="head-btn wow fadeInLeft">-->
            <!--<a href="#feature" class="btn-primary">Features</a>-->
            <!--<a href="#download" class="btn-default">Download</a>-->
            <!--</div>-->



          </div>

          <!-- /.signup form -->
          <div class="col-md-5">

            <div class="signup-header fadeInUp">
              <h3 class="form-title text-center">GET STARTED</h3>
              <form class="form-header" role="form">
                <div class="form-group">
                  <input class="form-control input-lg" name="username" id="username" type="text" placeholder="Your name" required>
                </div>
                <div class="form-group">
                  <input class="form-control input-lg" name="password" id="password" type="password" placeholder="Password" required>
                </div>
                <div class="form-group last">
                  <input type="button" class="btn btn-warning btn-block btn-lg" value="LOGIN" id="login">
                </div>
                <!--<div class="form-group last" style="display: none;">-->
                  <!--<input type="submit" class="btn btn-warning btn-block btn-lg" value="LOGIN" id="hehe">-->
                <!--</div>-->
                <p class="privacy text-center" id="login-note">Please enter username and password</p>
              </form>
            </div>

          </div>
        </div>
      </div>
    </div>
  </div>


  <!-- /.javascript files -->
  <script src="../js/jquery.js"></script>
  <script src="../style/bootstrap/js/bootstrap.min.js"></script>
  <script src="../js/login-cookie.js"></script>
  <script src="../js/login-check.js"></script>
  <script src="../js/custom.js"></script>

</body>
</html>