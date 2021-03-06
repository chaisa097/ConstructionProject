<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<!-- <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
  <link rel="stylesheet" href="metisMenu/metisMenu.min.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="metisMenu/metisMenu.min.js"></script>
  <script src="dist/js/sb-admin-2.js"></script> -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
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
  <!-- bootstrap wysihtml5 - text editor -->
  <link rel="stylesheet" href="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
  <!-- Google Font -->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

    <body  class="hold-transition skin-yellow-light sidebar-mini">
  <header class="main-header">
    <!-- Logo -->
    <a href="#" class="logo">
    <span class="logo-mini"><b>C</b>M</span>
       <span class="logo-lg"><b>MANAGE CONS.</span>
    </a> 
    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>

      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">  
          <!-- User Account: style can be found in dropdown.less -->
          <li class="dropdown user user-menu">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <img src="images/construction.jpg" class="user-image" alt="User Image">
              <span class="hidden-xs">${userNameUserSystem}</span>
            </a>
            <ul class="dropdown-menu">
              <!-- User image -->
              <li class="user-header">
                <img src="images/construction.jpg"  class="img-circle" alt="User Image">
                <p>
                  ${userNameUserSystem}
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-right">
                  <a href="${domainSystem}logoutpage.html" class="btn btn-default btn-flat">Sign out</a>
                </div>
              </li>
            </ul>
          </li>
          <!-- Control Sidebar Toggle Button -->
          <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="images/construction.jpg" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p> ${roleUserSystem}</p>
          <a href="#"><i class="fa fa-circle text-success"></i>Online</a>
        </div>
      </div>
        
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu" data-widget="tree" >
				<li class="header">MAIN MENU</li>
				
				<c:if test="${roleUserSystem eq 'admin'}">
				<li><a href="${domainSystem}home.html"> <i
						class="fa fa-dashboard"></i> <span>Home</span>
				</a></li>
				<li><a href="${domainSystem}manageRole.html"> <i
						class="fa fa-user-secret"></i> <span>Manage Role</span>
				</a></li>
				<li><a href="${domainSystem}register.html"> <i
						class="fa fa-user-plus"></i> <span>Manage User</span>

				</a></li>

				<li><a href="${domainSystem}province.html"> <i
						class="fa fa-folder"></i> <span>Manage Province</span>

				</a></li>

				<li><a href="${domainSystem}listProject.html"> <i
						class="fa fa-folder"></i> <span>Manage Project</span>

				</a></li>
                 <li><a href="${domainSystem}projectHistory.html"> <i
						class="fa fa-folder"></i> <span>Project History</span>

				</a></li>
				<li class="treeview" ><a href="#"> <i class="fa fa-folder"></i>
						<span>Manage Employee</span> <span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="${domainSystem}department.html"><i
								class="fa fa-circle-o"></i> Department</a></li>
						<li><a
							href="${domainSystem}departmentdetail.html"><i
								class="fa fa-circle-o"></i> Position</a></li>
						<li><a href="${domainSystem}employee.html"><i
								class="fa fa-circle-o"></i> Employee</a></li>
					</ul></li>

				<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
						<span>Manage Material</span> <span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="${domainSystem}type.html"><i
								class="fa fa-circle-o"></i> MaterialType</a></li>
						<li><a href="${domainSystem}unit.html"><i
								class="fa fa-circle-o"></i> Unit</a></li>
						<li><a href="${domainSystem}material.html"><i
								class="fa fa-circle-o"></i> Material</a></li>
					</ul></li>
					</c:if>
					      <c:if test="${roleUserSystem eq 'pm'}">
					      <li><a href="${domainSystem}home.html"> <i
						class="fa fa-dashboard"></i> <span>Home</span>
				</a></li>
					      	<li><a href="${domainSystem}listProjectPM.html"> <i
						class="fa fa-folder"></i> <span>Manage Project</span>

				     </a></li>
				       	<li><a href="${domainSystem}stock.html"> <i
						class="fa fa-cubes"></i> <span>Stock</span>

				</a></li>
				  	
					      </c:if>
					      
					         <c:if test="${roleUserSystem eq 'eng'}">
					      	<li><a href="${domainSystem}importMaterial.html"> <i
						class="fa fa-folder"></i> <span>Own Project</span>
	       
				     </a></li>
				       	<li><a href="${domainSystem}stock.html"> <i
						class="fa fa-cubes"></i> <span>Stock</span>
						
			
				</a></li>
				
					<li><a href="${domainSystem}listOrder.html"><i
						class="fa fa-opencart"></i> <span>Order Material</span>
						
			
				</a></li>
					<li class="treeview"><a href="#"> <i class="fa fa-calendar-minus-o"></i>
						<span>History</span> <span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="${domainSystem}listRequestMaterial.html"><i
								class="fa fa-circle-o"></i>Request Material</a></li>
						<li><a href="${domainSystem}exportMaterialConfirm.html"><i
								class="fa fa-circle-o"></i>Import  Material </a></li>
					</ul></li>
				  	<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
						<span>Manage Material</span> <span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
					</span>
				</a>
					<ul class="treeview-menu">
						<li><a href="${domainSystem}type.html"><i
								class="fa fa-circle-o"></i> MaterialType</a></li>
						<li><a href="${domainSystem}unit.html"><i
								class="fa fa-circle-o"></i> Unit</a></li>
						<li><a href="${domainSystem}material.html"><i
								class="fa fa-circle-o"></i> Material</a></li>
					</ul></li>
					      </c:if>
					      
					 <c:if test="${roleUserSystem eq 'st'}">
					 <li><a href="${domainSystem}home.html"> <i
						class="fa fa-dashboard"></i> <span>Home</span>
				</a></li>
					 
	         	<li><a href="${domainSystem}stock.html"> <i
						class="fa fa-cubes"></i> <span>Stock</span>
						
			
				</a></li>
				<li><a href="${domainSystem}listOrder.html"><i
						class="fa fa-opencart"></i> <span>Order Material</span>
						</a>
						</li>
				
	           <li><a href="${domainSystem}listOrderPM.html"> <i
						class="fa fa-check-square-o"></i> <span>Approve OrderMaterial</span>

				</a></li>
				
				
	          <li><a href="${domainSystem}receiveMaterial.html"><i
						class="fa fa-truck"></i> <span>Receive Material</span>
						
			
				</a></li>
				
				 <li><a href="${domainSystem}requestMaterialStock.html"><i
						class="fa fa-file"></i> <span>Export Material</span>
						
			
				</a></li>
	    
	     </c:if>
			</ul>
		</section>
    <!-- /.sidebar -->
  </aside> 
</body>
<!-- jQuery 3 -->
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<!-- jQuery UI 1.11.4 -->
<script src="bower_components/jquery-ui/jquery-ui.min.js"></script>
<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
<script>
  $.widget.bridge('uibutton', $.ui.button);
</script>
<!-- Bootstrap 3.3.7 -->
<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Morris.js charts -->
<script src="bower_components/raphael/raphael.min.js"></script>
<script src="bower_components/morris.js/morris.min.js"></script>
<!-- Sparkline -->
<script src="bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
<!-- jvectormap -->
<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
<!-- jQuery Knob Chart -->
<script src="bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<!-- Slimscroll -->
<script src="bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<!-- FastClick -->
<script src="bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="dist/js/adminlte.min.js"></script>

</html>