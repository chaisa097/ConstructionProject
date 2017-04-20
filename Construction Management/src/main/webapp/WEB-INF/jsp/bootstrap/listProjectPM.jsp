<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">	
		<div class="panel panel-warning">
		  <div class="panel-heading"><lable class="headPanal"> Own Project</lable>
		  
				<div class="row" id="roleHeader">
					<div class="col-md-2"></div>
					<div class="col-md-4">
						<label class="control-label-required">Province</label>
						<select class="selectpicker show-tick show-menu-arrow"  name="provinceList" data-live-search="true" data-size="5" data-header="Select Province" ></select>
						 <button type="button" class="btn btn-info" onclick="search()">
				     	<span class="glyphicon glyphicon-search"></span>
					  </button>
					</div>
				  	<div class="col-md-6"></div>
				</div>
         </div>
		 </div>
		 
		        <div class="panel panel-info filterable">
		            <div class="panel-heading">
		                <h3 class="panel-title"> List Project </h3>
		                <div class="pull-right">
		                    <button class="btn btn-default btn-xs btn-filter"><span class="glyphicon glyphicon-filter"></span>Filter</button>
		                </div>
		            </div>
		            <table class="table">
		                <thead>
		                    <tr class="filters">
		                    	<th>Manage</th>
		                        <th><input type="text" class="form-control" placeholder="ProjectName" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="Povince" disabled></th>
		                        <th><input type="text" class="form-control" placeholder="StatusProject" disabled></th>
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