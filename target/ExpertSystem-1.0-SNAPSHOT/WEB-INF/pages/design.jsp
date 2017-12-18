<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Designing</title>

  <!-- CSS Files -->
  <link href="../style/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="../style/css/paper-bootstrap-wizard.css" rel="stylesheet" />

  <link href="../style/css/design.css" rel="stylesheet" media="screen">

  <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
  <link href="../style/css/themify-icons.css" rel="stylesheet">

  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Google Fonts -->
  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Lato:100,300,400,700,900,100italic,300italic,400italic,700italic,900italic" />
</head>
<body>
  <!-- NAVIGATION -->
  <div id="menu">
    <nav class="navbar-wrapper navbar-inverse " role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-backyard">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand site-name" href="#top">Design Process</a>
        </div>

        <div id="navbar-scroll" class="collapse navbar-collapse navbar-backyard navbar-right">
          <ul class="nav navbar-nav">
            <li><a href="design.html">Home</a></li>
            <li><a href="design.html">Design</a></li>
            <li><a href="history.html">History</a></li>
            <li><a href="login.html" id="logout">Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>
  </div>
  <div id="main-area">
    <!--<div class="action fullscreen parallax" style="background-image:url('../style/images/bg.jpg');" data-img-width="2000" data-img-height="1333" data-diff="100">-->
      <!--   Big container   -->
      <div class="container">
        <div class="row">
          <div class="col-sm-12">

            <!--      Wizard container        -->
            <div class="wizard-container">

              <div class="card wizard-card" data-color="orange" id="wizardProfile">
                <form action="" method="">
                  <!--        You can switch " data-color="orange" "  with one of the next bright colors: "blue", "green", "orange", "red", "azure"          -->

                  <div class="wizard-header text-center">
                    <h3 class="wizard-title">Create your design plan</h3>
                  </div>

                  <div class="wizard-navigation">
                    <div class="progress-with-circle">
                      <div class="progress-bar" role="progressbar" aria-valuenow="1" aria-valuemin="1" aria-valuemax="3" style="width: 21%;"></div>
                    </div>
                    <ul>
                      <li>
                        <a href="#parameters" data-toggle="tab">
                          <div class="icon-circle">
                            <i class="ti-car"></i>
                          </div>
                          Parameters
                        </a>
                      </li>
                      <li id="model-li">
                        <a href="#model" data-toggle="tab">
                          <div class="icon-circle">
                            <i class="ti-direction-alt"></i>
                          </div>
                          Similar Model
                        </a>
                      </li>
                      <li>
                        <a href="#target" data-toggle="tab">
                          <div class="icon-circle">
                            <i class="ti-target"></i>
                          </div>
                          Optimization target
                        </a>
                      </li>
                      <li id="optimization-li">
                        <a href="#optimization" data-toggle="tab">
                          <div class="icon-circle">
                            <i class="ti-image"></i>
                          </div>
                          Optimization result
                        </a>
                      </li>
                    </ul>
                  </div>
                  <div class="tab-content">
                    <div class="tab-pane" id="parameters">
                      <div class="row">
                        <h5 class="info-text"> Please enter the parameters of the automobile.</h5>
                        <div class="col-sm-6 col-sm-offset-3" id="parameters-form">
                          <div class="form-group">
                            <label>Type</label>
                            <div class="checkbox">
                              <label class="radio-inline">
                                <input type="radio" name="flag" id="LVM" value="option1" checked="checked"> LVM
                              </label>
                              <label class="radio-inline">
                                <input type="radio" name="flag" id="GVM" value="option2"> GVM
                              </label>
                            </div>
                          </div>
                          <div class="form-group">
                            <label>GVW / LLVW</label>
                            <input name="w" type="text" class="form-control" placeholder="">
                          </div>
                          <div class="form-group">
                            <label>CG Height</label>
                            <input name="hg" type="text" class="form-control" placeholder="">
                          </div>
                          <div class="form-group">
                            <label>Front %</label>
                            <input name="wr" type="text" class="form-control" placeholder="">
                          </div>
                          <div class="form-group">
                            <label>Wheelbase Length</label>
                            <input name="car_l" type="text" class="form-control" placeholder="">
                          </div>
                          <div class="form-group">
                            <label>Tire Static Loaded Radius</label>
                            <input name="car_slr" type="text" class="form-control" placeholder="">
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane" id="model">
                      <h5 class="info-text"> Here is the similar model based on the parameters you enter</h5>
                      <div class="row">
                        <div class="col-sm-8 col-sm-offset-2">
                          <table id="model-table" class="table table-hover">
                            <thead>
                            <tr>
                              <th>Parameter</th>
                              <th>Value</th>
                            </tr>
                            </thead>
                            <tbody id="model-table-body"></tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane" id="target">
                      <div class="row">
                        <div class="col-sm-12">
                          <h5 class="info-text"> Please select your optimization target </h5>
                        </div>
                        <div class="col-sm-6 col-sm-offset-3" id="parameters-form1">
                          <div class="form-group">
                            <label>Optimization target</label>
                            <div class="checkbox" id="optimization-target">
                              <label class="radio-inline">
                                <input type="radio" name="target" id="quality" value="quality" checked="checked"> quality
                              </label>
                              <label class="radio-inline">
                                <input type="radio" name="target" id="price" value="price"> price
                              </label>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                    <div class="tab-pane" id="optimization">
                      <h5 class="info-text"> Here is optimization result</h5>
                      <div class="row">
                        <div class="col-sm-8 col-sm-offset-2" id="optimization-table-area">
                          <table id="instance" class="table table-hover">
                            <!--<thead>-->
                            <!--<tr>-->
                              <!--<th>Parameter</th>-->
                              <!--<th>Value</th>-->
                            <!--</tr>-->
                            <!--</thead>-->
                            <caption>Instance</caption>
                            <tbody id="instance-table-body"></tbody>
                          </table>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="wizard-footer">
                    <div class="pull-right">
                      <input type='button' class='btn btn-next btn-fill btn-warning btn-wd' name='next' value='Next' />
                      <a id="download-instance" target="_self">
                        <input type='button' class='download-plan btn btn-finish btn-fill btn-warning btn-wd' name='finish' value='Download'/>
                      </a>
                    </div>

                    <div class="pull-left">
                      <input type='button' class='btn btn-previous btn-default btn-wd' name='previous' value='Previous' />
                    </div>
                    <div class="clearfix"></div>
                  </div>
                </form>
              </div>
            </div> <!-- wizard container -->
          </div>
        </div><!-- end row -->
      </div> <!--  big container -->
    <!--</div>-->

  </div>

  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../style/bootstrap/js/bootstrap.min.js"></script>
  <script src="../js/jquery.bootstrap.wizard.js" type="text/javascript"></script>

  <script src="../js/paper-bootstrap-wizard.js" type="text/javascript"></script>
  <script src="../js/jquery.validate.min.js" type="text/javascript"></script>

  <script src="../js/login-cookie.js" type="text/javascript"></script>
  <script src="../js/design.js" type="text/javascript"></script>

</body>
</html>