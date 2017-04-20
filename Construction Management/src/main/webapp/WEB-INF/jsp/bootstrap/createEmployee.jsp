<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<div name="statusSave" hidden="true"></div>
<div class="container">
	<div class="form-group">
		<input type="image" src="images/back4.ico" onclick="back()" width="48" height="48">
		<div class="panel panel-info">
			<div class="panel-heading">
				<lable class="headPanal">Employee</lable>
				<div style="margin-top: 10px; margin-bottom: 2px"></div>
			</div>
		</div>

		<div class="panel-body" style="margin-top: -25px;">
			<div class="row">
				<div class="panel panel-info">

					<div class="panel-heading">
						<lable class="headPanal"> Employee Information</lable>
					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container">

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>FirstName</lable>
								<input id="FirstName" type="text" class="form-control"
									placeholder="FirstName" name="empFirstName">
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>LastName</lable>
								<input id="LastName" type="text" class="form-control"
									placeholder="LastName" name="empLastName">
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>CitizenId</lable>
								<input id="citizenId" type="text" class="form-control"
									placeholder="CitizenId" name="citizenId">
							</div>

							<div class="col-md-4"
								style="margin-top: 20px; margin-bottom: 10px">
								<lable>Department</lable>
								<select class="depList" id="Department"
									name="departmentList" data-live-search="true" data-size="5"
									data-header="Select Department"></select>

							</div>

							<div class="col-md-4"
								style="margin-top: 20px; margin-bottom: 10px">
								<lable>Position</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="departmentList"
									name="positionList" data-live-search="true" data-size="5"
									data-header="Select position"></select>

							</div>





							<div class="col-md-4"
								style="margin-top: 5px; margin-bottom: 10px">
								<lable>BirthDay</lable>
								<input type="date" class="form-control" name="birthDay"
									id="BirthDay">
							</div>

                          <div class="col-md-1"
								style="margin-top: 10px; margin-bottom: 10px">
								<label >Gender:</label>
						</div>
							<div class="form-group">
								<div class="col-sm-1" style="margin-top: 10px; margin-bottom: 10px">
									<label class="radio-inline"> <input name="gender"
										id="input-gender-male" value="Male" type="radio" />Male
									</label>
								</div>
								<div class="col-sm-1" style="margin-top: 10px; margin-bottom: 10px">
									<label class="radio-inline"> <input name="gender"
										id="input-gender-female" value="Female" type="radio" />Female
									</label>
								</div>
							</div>
							
							
                        	

						

						</div>

					</div>

				</div>

				<div class="panel panel-info">
					<div class="panel-heading">
						<lable class="headPanal">Address</lable>
					</div>
					<div class="row" style="margin-top: 10px; margin-bottom: -5px"
						name="addEditData">
						<div class="container">
							<div class="col-md-4"
								style="margin-top: 20px; margin-bottom: 10px">
								<lable>Province</lable>
								<select class="selectpicker show-tick show-menu-arrow" id="pv"
									name="provinceList" data-live-search="true" data-size="5"
									data-header="Select Province"></select>

							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>Sub-District</lable>
								<input type="text" class="form-control"
									placeholder="Sub-District" name="subDistrict"
									id="subDistrict">
							</div>

							<div class="col-md-4"
								style="margin-top: 10px; margin-bottom: 10px">
								<lable>District</lable>
								<input type="text" class="form-control" placeholder="District"
									name="district" id="district">
							</div>


						</div>
					</div>

				</div>



			</div>
			<div class="pull-right">
				<input type="image" src="images/Save2.png" onclick="save()" width="48" height="48">
			</div>
		</div>

	</div>



</div>
</html>