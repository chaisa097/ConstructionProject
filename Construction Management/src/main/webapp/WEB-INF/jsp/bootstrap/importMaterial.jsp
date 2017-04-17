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

				<div class="panel panel-info filterable">
					<div class="panel-heading">
						<h3 class="panel-title">Own Project</h3>
					</div>
					<table class="table">
						<thead>
							<tr class="filters">
								<th></th>
								<th><input type="text" class="form-control"
									placeholder="ProjectName" disabled></th>
							<th><input type="text" class="form-control"
									placeholder="BudgetofProject" disabled></th>
								<th><input type="text" class="form-control"
									placeholder="UsedMaterial/Bath" disabled></th>	
								<th><input type="text" class="form-control"
									placeholder="StatusProject" disabled></th>
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