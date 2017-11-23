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
     	$("#budget").html(Bud+' THB'); 
        var  TotalEx =json[0].totalExpense.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
    	$("#totalExpense").html(TotalEx+' THB'); 
    		
    	 google.charts.load("current", {packages:["corechart"]});
         google.charts.setOnLoadCallback(drawChart);
         function drawChart() {
           var data = google.visualization.arrayToDataTable([
             ['Expense', 'ALL Project'],
             ['Budget',json[0].budget],
             ['Expenses', json[0].totalExpense]
             
           ]);

           var options = {
             title: 'Budget',
             is3D: true,
           };

           var chart = new google.visualization.PieChart(document.getElementById('piechart_Admin'));
           chart.draw(data, options);
         }
     	
  	}
  });
	
	
	var params = {method: 'countProjectTotal'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#projecttotal").html(json[0].projectId); 	
  	}
  });
	
	var params = {method: 'searchPM'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#projectPM").html(json[0].projectId); 
      var  Bud =json[0].budget.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
     	$("#budgetPM").html(Bud+' THB'); 
        var  TotalHire =json[0].totalHireEmployee.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
    	$("#totalHireEmployeePM").html(TotalHire +' THB'); 
    	  var  TotaluseMaterial =json[0].totalUseMaterial.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#totalUseMaterialPM").html(TotaluseMaterial+' THB'); 
    	  var  TotalEx =json[0].totalExpense.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
      	$("#totalExpensePM").html(TotalEx+' THB'); 
      
      	 google.charts.load("current", {packages:["corechart"]});
         google.charts.setOnLoadCallback(drawChart);
    /*     function drawChart() {
           var data = google.visualization.arrayToDataTable([
             ['Expense', 'ALL Own Project'],
             ['Budget',json[0].budget],
             ['Expense Total', json[0].totalExpense]
             
           ]);

           var options = {
             title: 'My Budget',
             is3D: true,
           };

           var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
           chart.draw(data, options);
         }*/
         function drawChart() {
             var data1 = google.visualization.arrayToDataTable([
               ['Expense', 'ALL Own Project'],
               ['HireEmployee',json[0].totalHireEmployee],
               ['Expense Total', json[0].totalExpense],
               ['Materaial Used',json[0].totalUseMaterial],
               
             ]);

             var options2 = {
               title: 'My  Expense proportion',
               is3D: true,
             };

             var chart = new google.visualization.PieChart(document.getElementById('piechart_Expense'));
             chart.draw(data1, options2);
          
         }
     	
  	}
  });
	
	
	
	var params = {method: 'searchOrder'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#orderMaterialId").html(json[0].orderMaterialId); 

  	}
  });
	
	var params = {method: 'searchRequest'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#requestMaterialId").html(json[0].requestMaterialId); 

  	}
  });
	var params = {method: 'searchRequestApprove'};
	$.ajax({
  	type: 'POST'
  	, url: application.contextPath+"/home.html"
  	, data: params
  	, success: function(result){
    	var json = $.parseJSON(result);
      	$("#requestMaterialNumber").html(json[0].requestMaterialNumber); 
    	
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
      	$("#employeeId").html(json[0].employeeId); 
      
      
  	}
  });	
	serarchApproveRequestList();
	
});


function serarchApproveRequestList(){
	
	var params = {method: 'SearchListRequestApprove'};
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/home.html"
    	, data: params
    	, success: function(result){
        	var json = $.parseJSON(result);
        	console.log(json);
        	var data = [];
        	
        	$.each(json, function(index, value) {
        		
 			   var d2 = new Date(value.useMaterialDate),
		        month = '' + (d2.getMonth() + 1),
		        day = '' + d2.getDate(),
		        year = d2.getFullYear();

		    if (month.length < 2) month = '0' + month;
		    if (day.length < 2) day = '0' + day;
      
		    var date1 = [day, month, year].join('/');
		    
		    data.push('<tr requestMaterialId="'+value.requestMaterialId+'"><td>'+
				     
				   '<td name=requestMaterialNo>'+value.requestMaterialNo+'</td> '+
 				   '<td name=name>'+value.empFirstName+' '+value.empLastName+'</td> '+
 				   '<td name=usedMaterialdate >'+date1+'</td> '+
 				  '<td name=projectName>'+value.projectName+'</td> '+
 				  '<td >'+ '<a href='+domainSystem+'/confirmRequestMaterial.html?requestMaterialId='+value.requestMaterialId+' class="btn btn-info btn-xs"> '+
			       '<span class="glyphicon glyphicon-eye-open"></span> '+
				     '</a> '   +'</td></tr>');
	});
	$('table.table tbody').html(data.join());	

}
	    
    });
}