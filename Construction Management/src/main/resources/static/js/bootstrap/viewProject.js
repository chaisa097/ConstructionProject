$(document).ready(function(){

var params = {method: 'search'};
	params.projectId = headerId;
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/viewProject.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
    	
    	
    	var d = new Date(json[0].startDate)
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;

    var date = [day, month, year].join('/');
    
    var d2 = new Date(json[0].finishDate),
    month = '' + (d2.getMonth() + 1),
    day = '' + d2.getDate(),
    year = d2.getFullYear();

if (month.length < 2) month = '0' + month;
if (day.length < 2) day = '0' + day;

var date2 = [ day, month, year].join('/');
    	
      	$("#projectName").html(json[0].projectName);
      	$("#description").html(json[0].description);
      	$("#address").html(json[0].address);      
      	$("#percentStatus").html(json[0].percentStatus);
      	$("#startDate").html(date);
      	$("#finishDate").html(date2);
      	$("#customerName").html(json[0].customerName);
      	$("#customerPhone").html(json[0].customerPhone);
      	$("#budget").html(json[0].budget);
      	$("#totalHireEmployee").html(json[0].totalHireEmployee);
      	$("#totalUseMaterial").html(json[0].totalUseMaterial);
      	$("#totalExpense").html(json[0].totalExpense);
      	$("#criticalBudget").html(json[0].criticalBudget);    		
      
  	}
  });
	
	
	
});



function back(){
	location.href = "listProjectPM.html";
		
}


