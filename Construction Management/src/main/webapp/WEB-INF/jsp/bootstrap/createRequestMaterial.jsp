<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">

		<div class="panel panel-warning">
			<div class="panel-heading">
				<lable class="headPanal">Request Material</lable>			
			<div class="container">
			
			<div class="row" style="margin-top: 10px; margin-bottom: -5px"name="addEditData">
               <div class="col-md-2" style="margin-top: 10px; margin-bottom: 5px">
			 
             </div>
  
             <div class="col-md-1" style="margin-top: 20px; margin-bottom: 5px">
				 	<input type="image" src="images/add.png"  onclick="addRow()"   width="80" height="48">
		     </div>

				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
			
					<label>Use MaterialDate:</label>
					<input type="date" class="form-control" name="useMaterialDate"
									id="UseMaterialDate" disabled>
				</div>
                   	
     <div class="col-md-12" style="margin-top: 5px; margin-bottom: 0px">
              </div>
               <div class="col-md-3" style="margin-top: 5px; margin-bottom: 0px">
			 
             </div>
				<div class="col-md-4" style="margin-top: 10px; margin-bottom: 5px">
					<label>Contact RequestOwner</label>
					<textarea id="contactOwner" class="form-control"
						placeholder="Address/Phone" rows="3" cols="10" name="contactOwner"
						disabled></textarea>
				</div>
                   <div class="col-md-1" style="margin-top: 20px; margin-bottom: 5px">
                  	<input type="image" src="images/Save2.png"  onclick="Save()"   width="40" height="40">
                  	</div>  
			</div>

        </div>
		</div>
		</div>   
		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">

				<div class="panel panel-default filterable">
					<div class="panel-heading">
						<h3 class="panel-title">Request List</h3>
						
					</div>
					<table class="table">
						<thead>
							<tr class="filters">
								<th><input type="text" class="form-control"
									placeholder="" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="RequestNo" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="status" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="RquestDate" disabled></th>

							</tr>
						</thead>
						<tbody>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>
</div>
</html>