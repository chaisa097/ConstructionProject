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
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
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
        <c:if test="${roleUserSystem eq 'pm'}">
      <div class="row">
      
         <!-- ./col -->
         <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-orange">
            <div class="inner">
              <h3 id="totalHireEmployeePM"></h3>

              <p>Hire Employee Total</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="ion ion-person"></i>
            </div>
            <a href="${domainSystem}employee.html" class="small-box-footer">Employee<i class="fa fa-user"></i></a>
          </div>
        </div>
        <!-- ./col -->
       
       
       
           <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3 id="totalUseMaterialPM"></h3>

              <p>Used Material Total</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="ion ion-cube"></i>
            </div>
            <a href="#" class="small-box-footer">Material <i class="fa fa-cubes"></i></a>
          </div>
        </div>
        <!-- ./col -->
      
      
      
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3 id="projectPM"></h3>

              <p>Own project</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i  class="fa fa-building-o"></i>
            </div>
            <a href="${domainSystem}listProjectPM.html" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        
            <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-blue">
            <div class="inner">
              <h3 id="budgetPM"><sup style="font-size: 20px"></sup></h3>

              <p>Own Budget Total</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="  fa fa-btc"></i>
            </div>
            <a href="#" class="small-box-footer">Budget<i class="fa fa-btc"></i></a>
          </div>
        </div>
          <!-- ./col -->
        <div class="col-lg-6 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3 id="totalExpensePM"></h3>

              <p>Own Expense Total</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="ion ion-pie-graph"></i>
            </div>
            <a href="#" class="small-box-footer">Expense <i class="fa fa-area-chart"></i></a>
          </div>
        </div>
        <!-- ./col -->
            <div class="col-lg-6 col-xs-6">
       <!-- TO DO List -->
          <div class="box box-primary">
            <div class="box-header">
             
            
              <i class="ion ion-clipboard"></i>

              <h3 class="box-title">To Do Approve Request Material</h3>
             <div class="pull-right">
              <i style="font-size: 30px" class="fa fa-bell"></i>
            <h4 style="font-size: 12px"  class="label label-danger" id="requestMaterialNumber"></h4>
             </div>
         
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <table class="table">
						<thead>
							<tr class="filters">
								<th></th>
									<th>RequestNo</th>
										<th>EngineerName</th>
								<th>Using Material</th>
								<th>ProjectName</th>
									<th></th>
							</tr>
						</thead>
						<tbody>
						</tbody>

					</table>
            </div>
          
          </div>
          </div>
   
      </div>
      <!-- /.row -->
      
       <div class="col-lg-6 col-xs-6">
       <!-- TO DO List -->
          <div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">Graph</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
             <div id="piechart_Expense" style="width: 600px; height: 350px;"></div>
            </div>
          
          </div>
          </div>
      
      
      
           
  
          
          
     
          <!-- /.box -->    
      </c:if>
    
      <c:if test="${roleUserSystem eq 'admin'}">
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3 id="projecttotal"></h3>

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
          <div class="col-lg-6 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3 id="projectId"></h3>

              <p>Project Complete</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i  class="fa fa-building-o"></i>
            </div>
            <a href="${domainSystem}listProject.html" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
         <div class="col-lg-6 col-xs-6">
       <!-- TO DO List -->
          <div class="box box-primary">
            <div class="box-header">
              <h3 class="box-title">Graph</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
             <div id="piechart_Admin" style="width: 700px; height: 400px;"></div>
            </div>
          
          </div>
          </div>
        <div class="col-lg-6 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-blue">
            <div class="inner">
              <h3 id="budget"><sup style="font-size: 20px"></sup></h3>

              <p>Budget</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="  fa fa-btc"></i>
            </div>
            <a href="#" class="small-box-footer">Budget <i class="fa fa-money"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-lg-6 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-red">
            <div class="inner">
              <h3 id="totalExpense"></h3>

              <p>Expense Total</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="ion ion-pie-graph"></i>
            </div>
            <a href="#" class="small-box-footer">Expenses<i class="fa fa-money"></i></a>
          </div>
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
      </c:if>
       <c:if test="${roleUserSystem eq 'st'}">
      <div class="row">
        <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3 id="orderMaterialId"></h3>

              <p>Order Request</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i  class="fa fa-file-powerpoint-o"></i>
            </div>
            <a href="${domainSystem}receiveMaterial.html" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
         <div class="col-lg-3 col-xs-6">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3 id="requestMaterialId"></h3>

              <p>Request Material</p>
            </div>
            <div style="margin-top :20px" class="icon">
              <i class="fa fa-folder-open"></i>
            </div>
            <a href="${domainSystem}requestMaterialStock.html" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
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
