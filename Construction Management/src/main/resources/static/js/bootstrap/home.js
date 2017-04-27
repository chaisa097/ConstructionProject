$(document).ready(function(){

var params = {method: 'search'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#projectId").html(json[0].projectId); 
      var  Bud =json[0].budget.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
     	$("#budget").html(Bud); 
        var  TotalEx =json[0].totalExpense.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
    	$("#totalExpense").html(TotalEx); 
     	
  	}
  });
	
	var params = {method: 'searchEmployee'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#employeeId").html(json[0].employeeId);  		
      
  	}
  });	
	
	
});