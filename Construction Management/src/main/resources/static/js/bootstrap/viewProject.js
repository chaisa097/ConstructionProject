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

    var date = [year, month, day].join('-');
    
    var d2 = new Date(json[0].finishDate),
    month = '' + (d2.getMonth() + 1),
    day = '' + d2.getDate(),
    year = d2.getFullYear();

if (month.length < 2) month = '0' + month;
if (day.length < 2) day = '0' + day;

var date2 = [year, month, day].join('-');
    	
      	$("input[name='projectName']").val(json[0].projectName);
      	$(" textarea[name='description']").val(json[0].description);
      	$(" textarea[name='address']").val(json[0].address);      
      	$(" input[name='percentStatus']").val(json[0].percentStatus);
      	$(" input[name='startDate']").val(date);
      	$(" input[name='finishDate']").val(date2);
      	$(" input[name='customerName']").val(json[0].customerName);
      	$(" input[name='customerPhone']").val(json[0].customerPhone);
      	$(" input[name='budget']").val(json[0].budget);
      	$(" input[name='totalHireEmployee']").val(json[0].totalHireEmployee);
      	$(" input[name='totalUseMaterial']").val(json[0].totalUseMaterial);
      	$(" input[name='totalExpense']").val(json[0].totalExpense);
      	$(" input[name='criticalBudget']").val(json[0].criticalBudget);    		
      
  	}
  });
	
	
	
});



function back(){
	location.href = "listProjectPM.html";
		
}


