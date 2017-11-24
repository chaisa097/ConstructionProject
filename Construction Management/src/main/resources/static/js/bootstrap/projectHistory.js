	$(document).ready(function(){
     
		 var params = {method:'province'};
	    	BSBaseComboBox.getprovince(params,function(data){
	      	$("div select[name=provinceList]").html(data).selectpicker('refresh');
		
   	
    	});
   	    	    
	    	
	    	 var params = {method:'employee'};
	 	     BSBaseComboBox.getEmployee(params,function(data){
	 	   	$("div select[name=employeeList]").html(data).selectpicker('refresh');
	   	
	   	
	   	
	    	});
      		
	 	    var params = {method: 'search'};
    		//param.projectId = headerId
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/listProject.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		
	     			   var d2 = new Date(value.startDate),
				        month = '' + (d2.getMonth() + 1),
				        day = '' + d2.getDate(),
				        year = d2.getFullYear();

				    if (month.length < 2) month = '0' + month;
				    if (day.length < 2) day = '0' + day;

				    var date1 = [day, month, year].join('/');
				    
				    var d2 = new Date(value.finishDate),
			        month = '' + (d2.getMonth() + 1),
			        day = '' + d2.getDate(),
			        year = d2.getFullYear();

			    if (month.length < 2) month = '0' + month;
			    if (day.length < 2) day = '0' + day;

			    var date2 = [day, month, year].join('/');
			    
	            		  data.push('<tr projectId="'+value.projectId+'"><td>'+
	            				     '<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
								       '<span class="glyphicon glyphicon-eye-open"></span> '+
								     '</a> '+
										'<a href='+domainSystem+'/createProject.html?projectId='+value.projectId+' class="btn btn-primary btn-xs"> '+
										  '<span class="glyphicon glyphicon-pencil"></span> '+
										'</a> '+				
									'<button type="button" class="btn btn-danger btn-xs"  onclick=deleteRow("'+value.projectId+'")> '+
									'<span class="glyphicon glyphicon-trash"></span>'+
								   '</button> '+
								   
					
									
			                        '<td name=projectName>'+value.projectName+'</td> '+
			                        '<td name=provinceName>'+value.provinceName+'</td> '+
			                        '<td name=startDate>'+(date1)+'</td> '+
			                        '<td name=finishDate>'+(date2)+'</td> '+
			                        '<td name=budget>'+value.budget.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'</td> '+
			                        '<td name=totalHireEmployee>'+value.totalHireEmployee.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'</td> '+
			                        '<td name=totalUseMaterial>'+value.totalUseMaterial.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'</td> '+
			                        '<td name=totalExpense style="text-align:right">'+value.totalExpense.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            
	        	}
	        });
	 	     
	 	   	 
	
	
	BSBaseTable.callFiterTable();
	
	
});