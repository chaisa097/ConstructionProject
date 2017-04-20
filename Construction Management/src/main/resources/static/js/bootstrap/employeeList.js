$(document).ready(function(){
     
	BSBaseTable.callFiterTable();
	search()
   	
    	});


function search(){
	
	var params = {method: 'search'};
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/employee.html"
    	, data: params
    	, success: function(result){
        	var json = $.parseJSON(result);
        	var data = [];
        	$.each(json, function(index, value) {
        		  data.push('<tr employeeId="'+value.employeeId+'"><td>'+
        				  '<button type="button" class="btn btn-info btn-xs" onclick=viewRow("'+value.employeeId+'")> '+
							'<span class="glyphicon glyphicon-eye-open"></span>'+
						'</button> '+
						'<a href='+domainSystem+'/createProject.html?projectId='+value.employeeId+' class="btn btn-primary btn-xs"> '+
						  '<span class="glyphicon glyphicon-pencil"></span> '+
						'</a> '+				
					   '<button type="button" class="btn btn-danger btn-xs"  onclick=deleteRow("'+value.employeeId+'")> '+
					   '<span class="glyphicon glyphicon-trash"></span>'+
				       '</button> '+
	                        '<td name=employeeName>'+value.empFirstName+' '+value.empLastName+'</td> '+
	                        '<td name=depDetailName>'+value.depDetailName+'</td></tr>');
        	});
        	$('table.table tbody').html(data.join());	
        
    	}
    });
  
}

function createEmployee(){
	location.href = "createEmployee.html";
}

