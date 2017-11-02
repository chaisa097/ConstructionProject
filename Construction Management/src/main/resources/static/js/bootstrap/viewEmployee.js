$(document).ready(function(){

var params = {method: 'search'};
	params.employeeId = headerId;
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/viewEmployee.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
    	
    	
    	var d = new Date(json[0].birthDay)
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    var date = [day, month, year].join('/');
    
      	$("#empFirstName").html(json[0].empFirstName);
      	$("#empLastName").html(json[0].empLastName);
      	$("#citizenId").html(json[0].citizenId);      
      	$("#birthDay").html(date);
      	$("#provinceName").html(json[0].provinceName);
    	$("#district").html(json[0].district);
    	$("#subDistrict").html(json[0].subDistrict);
    	$("#gender").html(json[0].gender);
    	$("#depDetailName").html(json[0].depDetailName);
    	$("#departmentName").html(json[0].departmentName);
      	 var  Salary =json[0].Salary.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#Salary").html(Salary);
  	  }
  });
	
	
	
});

