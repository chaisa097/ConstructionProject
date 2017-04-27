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
	<div class="form-group"> 		
		          <div class="panel panel-info">
		            <div class="panel-heading">
		                <h3 class="panel-title">  Information of Construction Project </h3>
		                
		            </div>
		            <table class="table">
		                <thead>
		                    <tr>
		                                       		                    		                   
		                    </tr>
		                </thead>
		                <tbody>
		                
		                     <tr>
                             <td>ProjectName</td>
                             <td><p id="projectName"></p></td>                                    
                            </tr>
                          
		                   <tr>
                             <td>Description</td>
                              <td><p id="description"></p> </td>                            
                          </tr>                                                                            
		                  <tr>
                             <td>Address</td>
                              <td><p id="address"></p></td>                            
                          </tr>
		               
		                    <tr>
                             <td>CompleteStatus(1-100%) </td>
                         
                              <td><p id="percentStatus" ></p></td>                            
                          </tr>
		                						
				          
		                   <tr>
                             <td>StartDate</td>
                              <td><p id="startDate"></p> </td>                            
                          </tr>
                          
                          <tr>
                             <td>FinishDate</td>
                              <td><p id="finishDate"></p> </td>                            
                          </tr>
                          
                           <tr>
                             <td>CustomerName</td>
                              <td><p id="customerName"></p> </td>                            
                          </tr>
                              <tr>
                          
                              <tr>
                             <td>CustomerPhone</td>
                              <td><p id="customerPhone"></p></td>                            
                          </tr>
                          
                          
                            <tr>
                             <td>Budget</td>
                              <td><p id="budget"></p></td>                            
                          </tr>
                                                
                              <tr>
                             <td>TotalHireEmployee/Baht</td>
                              <td><p id="totalHireEmployee"></p> </td>                            
                             </tr>
                            <tr>                          
                             <td>TotalUsedMaterial/Baht</td>
                              <td><p id="totalUseMaterial"></p> </td>                            
                          </tr>
                           <tr>                                                           
                             <td>TotalExpenseInConstruction/Baht</td>
                              <td><p id="totalExpense"></p></td>                            
                          </tr>
                          <tr>                                                           
                             <td>Critical Budget(1-100%)</td>
                              <td><p id="criticalBudget"></p> </td>                            
                          </tr>
                          
                                        
		                </tbody>
		            </table>
		        </div>
		       
			   			 				
		    		  
		 </div>
	</div>
	
</html>