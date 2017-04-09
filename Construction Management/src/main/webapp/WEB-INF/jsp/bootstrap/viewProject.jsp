<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
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
                             <td><input type="text" class="form-control"  name="projectName"  disabled></td>                                    
                            </tr>
                          
		                   <tr>
                             <td>Description</td>
                              <td> <textarea   class="form-control"  rows="3" cols="10"   name="description"  disabled></textarea> </td>                            
                          </tr>                                                                            
		                  <tr>
                             <td>Address</td>
                              <td> <textarea   class="form-control" rows="3" cols="10"   name="address"  disabled></textarea> </td>                            
                          </tr>
		               
		                    <tr>
                             <td>CompleteStatus(1-100%) </td>
                         
                              <td><input type ="text" min ="0" max="100" step ="10"  class="form-control"  name="percentStatus"  disabled > </td>                            
                          </tr>
		                						
				          
		                   <tr>
                             <td>StartDate</td>
                              <td><input type="date"  class="form-control"  name="startDate"   disabled  > </td>                            
                          </tr>
                          
                          <tr>
                             <td>FinishDate</td>
                              <td><input type="date"   class="form-control"  name="finishDate"   disabled > </td>                            
                          </tr>
                          
                           <tr>
                             <td>CustomerName</td>
                              <td><input type="text" class="form-control" name="customerName"  disabled> </td>                            
                          </tr>
                              <tr>
                          
                              <tr>
                             <td>CustomerPhone</td>
                              <td><input type="text" class="form-control" name="customerPhone" disabled></td>                            
                          </tr>
                          
                          
                            <tr>
                             <td>Budget</td>
                              <td><input type="text" class="form-control" name="budget" disabled></td>                            
                          </tr>
                                                
                              <tr>
                             <td>TotalHireEmployee/Baht</td>
                              <td><input type="number" class="form-control" name="totalHireEmployee"  disabled> </td>                            
                             </tr>
                            <tr>                          
                             <td>TotalUsedMaterial/Baht</td>
                              <td><input type="number" class="form-control" name="totalUseMaterial"  disabled> </td>                            
                          </tr>
                           <tr>                                                           
                             <td>TotalExpenseInConstruction/Baht</td>
                              <td><input type="number" class="form-control" name="totalExpense"  disabled> </td>                            
                          </tr>
                          <tr>                                                           
                             <td>Critical Budget(1-100%)</td>
                              <td><input type="number" class="form-control" name="criticalBudget"  disabled> </td>                            
                          </tr>
                          
                                        
		                </tbody>
		            </table>
		        </div>
		       
			   			 				
		    		  
		 </div>
	</div>
	
</html>