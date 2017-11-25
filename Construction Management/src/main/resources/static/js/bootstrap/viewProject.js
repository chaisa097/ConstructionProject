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
      	 var  percentStatus =json[0].percentStatus.toString().replace(/\B(?=(\d{3})+(?!\d))/g, "%");	
      	$("#percentStatus").html(percentStatus);
      	$("#startDate").html(date);
      	$("#finishDate").html(date2);
      	$("#customerName").html(json[0].customerName);
      	 var  customerPhone =json[0].customerPhone.toString().replace(/(\d{3})(\d{3})(\d{4})/, '$1-$2-$3');	
      	$("#customerPhone").html(customerPhone);
   	     var  budget =json[0].budget.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#budget").html(budget);
      	 var  totalHire =json[0].totalHireEmployee.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#totalHireEmployee").html(totalHire);
      	 var  totalUseMaterial =json[0].totalUseMaterial.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#totalUseMaterial").html(totalUseMaterial);
      	 var  totalExpense =json[0].totalExpense.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#totalExpense").html(totalExpense);
      	$("#criticalBudget").html(json[0].criticalBudget);    		
      
  	}
  });
	
	searchworker();

});

function back(){
	location.href = "listProjectPM.html";
		
}
function searchworker(){
$.ajax({
 	type: 'POST'
 	, url: application.contextPath+"/viewProject.html"
 	, data: {method: 'searchWorker',projectId:headerId}
   
 	, success: function(result){
     	var json = $.parseJSON(result);
     	var data = [];
     	$.each(json, function(index, value) {
     		  data.push('<tr>'+
							 '<td  id="empName" >'+value.empFirstName+' '+value.empLastName+'</td>'+
							 '<td  id="employeeCode">'+value.depDetailName+'</td>'+
							 '<td  id="salary">'+value.Salary+'</td>'+
     		                 '<td  id="amountOfMonth">'+value.amountOfMonth+'/'+'month' + '</td>'+
	                         '<td  id="totalSalary" style="text-align:right" >'+(value.amountOfMonth*value.Salary)+'</td></tr>');
	  
     	});
     	
     	$('table.table tbody').html(data.join());
 	}
 	
 	
 	
 }); 


}
