<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		<input type="image" src="images/back.jpg" onclick="back()"  width="48" height="48">		 		
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