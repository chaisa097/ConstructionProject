		$(document).ready(function(){
			
			$.ajax({
			  	type: 'POST'
			  	, url: application.contextPath+"/listExportMaterial.html"
			  	, data: {method:'searchTotalUseMaterial', projectId:headerId}
			  	, success: function(result){
			    	var json = $.parseJSON(result);
			      	$("#projectName").html(json[0].projectName);
			      	 var  UseMaterial =json[0].totalUseMaterial.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
			      	$("#totalUseMaterial").html(UseMaterial);  
			      	var totalExpense = json[0].totalUseMaterial + json[0].totalHireEmployee;
			      	var criticalBudget = (json[0].criticalBudget/100)*json[0].budget;
			         var profit = json[0].budget-criticalBudget;
			      	if (totalExpense>profit){
			      		alert("You should not import material into project because Expense Total more than your fix criticalBudget");
			      	}
			  	}
			  });

	    	 searchFunction();
	    	 BSBaseTable.callFiterTable();
    });
		
	    
		 function searchFunction(){
		    		var params = {method: 'search',projectId:headerId};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/listExportMaterial.html"
			        	, data: params
			        	, success: function(result){			        		
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	
			            	$.each(json, function(index, value) {
			            		var d2 = new Date(value.exportDate),
				    	        month = '' + (d2.getMonth() + 1),
				    	        day = '' + d2.getDate(),
				    	        year = d2.getFullYear();

				            	if (month.length < 2) month = '0' + month;
				            	if (day.length < 2) day = '0' + day;

				            	var date = [day, month, year].join('-');
			            		
			            		  data.push('<tr projectId="'+value.projectId+'"><td>'+			
		    								'<a href='+domainSystem+'/viewExportMaterialPM.html?exportMaterialId='+value.exportMaterialId+'&projectId='+headerId+' class="btn btn-info btn-xs"> '+
		    								  '<span class="glyphicon glyphicon-eye-open"></span> '+
		    								'</a> '+	
					                        '<td name=exportMaterialNo>'+value.exportMaterialNo+'</td> '+
					                        '<td name=employeeName>'+value.empFirstName+' '+value.empLastName+'</td> '+
					                        '<td name=exportDate>'+date+'</td> '+
					                        '<td id="totalExport">'+value.totalExport+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());
			            	calculate();
			        	}
			        });
		    }
		 
		 
		 function calculate(){		 
			 var totalExport = 0;
				$("table.table tbody tr").each(function(){
					var value = $(this).find("#totalExport").html();
					totalExport += (value*1);						
				});

				var params = {method: 'UpdateTotalExport',projectId:headerId};
				
				if(BeanUtils.isNotEmpty(params.method)){			
					params.totalUseMaterial  = totalExport
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/listExportMaterial.html"
			        	, data: params
			        	, success: function(result){
			        		
			        	}
			        });
				}
				
		 
		 }
		 
		 
		 
		 
		 
		 
		 
		 