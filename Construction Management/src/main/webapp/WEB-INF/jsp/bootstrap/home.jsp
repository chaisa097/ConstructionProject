<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<!-- <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
<link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet"
	href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
<script src="webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="metisMenu/metisMenu.min.js"></script>
<script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script> -->
	  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
       <script type="text/javascript"></script>
 <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.7 -->
  <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="bower_components/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="bower_components/Ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
  <!-- Morris chart -->
  <link rel="stylesheet" href="bower_components/morris.js/morris.css">
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
   
</head>
<body>

<div class="content-wrapper" style="margin-top:-89px;">
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <h1> 
        HOME
        <small>Control panel</small>
      </h1>
        
    </section>
 <!-- Notifications: style can be found in dropdown.less -->
         
    
    <!-- Main content -->
    <section class="content">
      <!-- Small boxes (Stat box) -->
        <c:if test="${roleUserSystem eq 'admin'}">
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3 id="projectId"></h3>

              <p>Project</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i  class="fa fa-building-o"></i>
            </div>
            <a href="${domainSystem}listProject.html" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
         <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3 id="employeeId"></h3>

              <p>Employee</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="ion ion-person-add"></i>
            </div>
            <a href="${domainSystem}employee.html" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3 id="budget"><sup style="font-size: 20px"></sup></h3>

              <p>Budget</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="  fa fa-btc"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
       
        <!-- ./col -->
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3 id="totalExpense"></h3>

              <p>TotalExpense</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="ion ion-pie-graph"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
      </c:if>
    

    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <footer class="main-footer">
    
  </footer>
			
</body>
</html>
