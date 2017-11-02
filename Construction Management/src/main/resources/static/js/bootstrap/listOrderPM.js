$(document).ready(function(){
			
	    	searchFunction();
	    	 BSBaseTable.callFiterTable();
    });
		
	    
		 function searchFunction(){
		    		var params = {method: 'searchOrder'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/listOrderPM.html"
			        	, data: params
			        	, success: function(result){			        		
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	
			            	$.each(json, function(index, value) {
			            		
			            		var d2 = new Date(value.orderMaterialDate),
				    	        month = '' + (d2.getMonth() + 1),
				    	        day = '' + d2.getDate(),
				    	        year = d2.getFullYear();

				            	if (month.length < 2) month = '0' + month;
				            	if (day.length < 2) day = '0' + day;

				            	var date = [day, month, year].join('/');
			         			            		
			            		  data.push('<tr orderMaterialId="'+value.orderMaterialId+'"><td>'+
			            				     '<a href='+domainSystem+'/confirmOrder.html?orderMaterialId='+value.orderMaterialId+' class="btn btn-warning btn-xs"> '+
		    								    '<span class="glyphicon glyphicon-eye-open"></span> Approve or Reject '+
		    							      	'</a> '+
					                        '<td name=orderMaterialNo>'+value.orderMaterialNo+'</td> '+
					                        '<td name=employeeName>'+value.empFirstName+' '+value.empLastName+ '</td> '+
					                        '<td name=status>'+value.status+'</td> '+
					                        '<td name=orderMaterialDate>'+(date)+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            
			        	}
			        });
		    }