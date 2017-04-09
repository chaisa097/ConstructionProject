<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
  <script src="webjars/jquery/2.1.1/jquery.min.js"></script>
  <script src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
 
    <body>
    <a download id="downloadFile" hidden></a>
    <div class="nav-div-header-menu" style="position:fixed; width:100%; z-index:300" >
    <nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		    <span class="sr-only">Toggle navigation</span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		    <span class="icon-bar"></span>
		     <span class="icon-bar"></span>
		  </button>
	      <a class="navbar-brand" href="${domainSystem}">CONSTRUCTION MANAGEMENT</a>
	    </div>
	   <div class="collapse navbar-collapse">
	    <ul class="nav navbar-nav">
	     <c:if test="${roleUserSystem eq 'admin'}">
	    <li class="dropdown">
	        <a class="dropdown-toggle"  id="manageUser" data-toggle="dropdown" href="#">Manage User and Role
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}register.html">Register</a></li>
	        	<li><a href="${domainSystem}manageRole.html">Manage Role</a></li>
	        </ul>
	      </li>
	      
	      <li class="dropdown">
	        <a class="dropdown-toggle" id="manageData" data-toggle="dropdown" href="#">ManageData
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	       		<li><a href="${domainSystem}department.html">Department</a></li>
	       		<li><a href="${domainSystem}departmentdetail.html">Department Detail</a></li>
	        	<li><a href="${domainSystem}province.html">Province</a></li>
	            <li><a href="${domainSystem}createProject.html">CreateProject</a></li>
	        	<li><a href="${domainSystem}listProject.html">ListProject</a></li>
	  	      
	        
	        </ul>
	      </li>
	      </c:if>
	      <c:if test="${roleUserSystem eq 'pm'}">
	       <li class="dropdown">
	        <a class="dropdown-toggle" id="manageProject"  data-toggle="dropdown" href="#">ManageProject
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}listProjectPM.html">Own Project</a></li>
	        </ul>
	      </li>
	      	  <li class="dropdown">
	        <a class="dropdown-toggle" id="manageProject"  data-toggle="dropdown" href="#">ManageOrder
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">	     
	        	<li><a href="${domainSystem}stock.html">viewStock</a></li>
	            <li><a href="${domainSystem}listOrderPM.html">Confirm OderMaterial</a></li>
	        </ul>
	      </li>
	      	  
	      	  
	      	  
	      	      
	     </c:if>
	      <c:if test="${roleUserSystem eq 'st'}">
	       <li class="dropdown">
	        <a class="dropdown-toggle" id="manageProject"  data-toggle="dropdown" href="#">ManageStock
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	            <li><a href="${domainSystem}stock.html">viewStock</a></li>
	        	<li><a href="${domainSystem}receiveMaterial.html">ReceiveMaterial</a></li>
	            <li><a href="${domainSystem}ListOwnnerMaterial.html">confirm ExportMaterial</a></li>
	        </ul>
	      </li>
	     </c:if>
	      
	      	 <c:if test="${roleUserSystem eq 'eng'}">      
	         <li class="dropdown">
	        <a class="dropdown-toggle" id="manageProject"  data-toggle="dropdown" href="#">Stock
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}stock.html">viewStock</a></li>
	         
	        </ul>
	      </li>
	      
	       <li class="dropdown">
	        <a class="dropdown-toggle" id="manageProject"  data-toggle="dropdown" href="#">OrderMaterial
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}OrderMaterial.html">Order</a></li>
	        	<li><a href="${domainSystem}listOrder.html">List Order</a></li>
	        </ul>
	      </li>
	      
	      
	      
	      
	      
	      <li class="dropdown">
	        <a class="dropdown-toggle" id="manageProject"  data-toggle="dropdown" href="#">ImportMaterial
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	        	<li><a href="${domainSystem}importMaterial.html">Requisition</a></li>
	            <li><a href="${domainSystem}ListOwnnerMaterial.html">View OwnRequisition</a></li>
	        </ul>
	      </li>	      
	      </c:if>
	     
	    </ul>
	    
	    
	  <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="	glyphicon glyphicon-user"></i>
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a>User Name : ${userNameUserSystem}</a></li>
	           <li><a>User Role : ${roleUserSystem}</a></li>
	        </ul>
	      </li>
	       <li><a href="${domainSystem}logoutpage.html"> <img class="img-responsive img-circle" width="30" height="30" src="images/IconLogout.jpg"></a></li>
      </ul>
      <!--    <ul class="nav navbar-nav navbar-right">
        <li class="dropdown">
	        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Language
	        <span class="caret"></span></a>
	        <ul class="dropdown-menu">
	          <li><a href="?lang=en">English</a></li>
	          <li><a href="?lang=th">Thai</a></li>
	        </ul>
	      </li>
      </ul>
	 -->
	  </div>
	  </div>
	</nav>
</div>
    </body>
</html>