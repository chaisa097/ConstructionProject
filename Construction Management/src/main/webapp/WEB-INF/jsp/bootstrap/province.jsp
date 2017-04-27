<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
 <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
 <link rel="stylesheet" href="dist/css/sb-admin-2.css">
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="metisMenu/metisMenu.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
</head>
<div name="statusSave" hidden="true"></div>
   <div class="container">
		      <div class="panel-body" style="margin-top:-25px;">  
		        <div class="row">	
		          <div class="panel panel-info">
		       <div class="panel-heading">
		                <h3 class="panel-title">Province</h3>
		              
		                </div>
		        
				
		       
			    	<div class="row" style="margin-top:10px; margin-bottom:5px" name="addEditData">
			    	
			    	<div class="col-md-1"style="margin-top:20px; margin-bottom:5px" >
						<input type="image" src="images/add.png"  data-toggle="modal" data-target="#newModal"  onclick="addRow()"   width="80" height="45">
					</div>
			    	
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px" >
					<label>ProvinceCode</label>
						<input type="text" id="provinceCode" class="form-control" placeholder="ProvinceCode" name="provinceCode" disabled>
					</div>
					<div class="col-md-3" style="margin-top:10px; margin-bottom:5px">
					<label>ProvinceName</label>
						<input type="text" id="provinceName" class="form-control" placeholder="ProvinceName" name="provinceName" disabled>
					 </div>
					  <div class="col-md-2" style="margin-top:30px; margin-bottom:10px">
		        	<input type="image" src="images/Save2.png"  data-toggle="modal" data-target="#save"  onclick="save()"   width="40" height="40">  
				   </div>
					 
					</div>
					
					
					
					
          </div>
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title">Province List</h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th></th>
		                        <th><input type="text" class="form-control" placeholder="ProvinceCode" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="ProvinceName" disabled></th>
		                    </tr>
		                </thead>
		                <tbody>
		                </tbody>
		            </table>
		            <div class="pull-right">
		              <div id="page-selection"></div>
		              </div>
		        </div>
		    </div>
		 </div>
		 </div>
		 <!-- delete alert modal box -->
<div class="modal fade bs-example-modal-sm" id="modalDelete" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" rowId="">
  <div class="modal-dialog modal-xs" role="document">
    <div class="modal-content">
      <div class="modal-header">
      	 <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Warning</h4>
      </div>
       <div class="modal-body" >
       <p>Do you really want to delete?</p>
      </div>
      <div class="modal-footer">
       <button type="button" class="btn-lg btn-danger" data-dismiss="modal" onclick="deleteRow()">Delete</button>
        <button type="button" class="btn-lg btn-warning" data-dismiss="modal">Cancel</button>
       
      </div>
    </div>
  </div>
</div>
		 <div class="modal fade" id="save" role="dialog">
    <div class="modal-dialog">

      <!-- Modal content-->
      <div class=" modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Warning</h4>
        </div>
        <div class="modal-body">
          <p>Province has been saved.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn-lg btn-primary" data-dismiss="modal">Close</button>
          </div>
       
      </div>
      
    </div>
  </div>
		
		
		

</html>