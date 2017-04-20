<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">
                 <button type="button" class="btn btn-success" onclick="createProject()">
					<span class="glyphicon glyphicon-plus"></span> New Project
				   </button> 
				<div class="panel panel-info filterable">
					<div class="panel-heading">
						<h3 class="panel-title">List Project</h3>
						<div class="pull-right">
							<button class="btn btn-default btn-xs btn-filter">
								<span class="glyphicon glyphicon-filter"></span>Filter
							</button>
						</div>
					</div>
					<table class="table">
						<thead>
							<tr class="filters">
								<th></th>
								<th><input type="text" class="form-control"
									placeholder="ProjectName" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="Povince" disabled></th>

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