	$(document).ready(function(){

		
	    	searchFunction();
    });



function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/listRequestMaterial.html"
			        	, data: params
			        	, success: function(result){			        		
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	
			            	$.each(json, function(index, value) {
			            		
			            		var d2 = new Date(value.requestDate),
				    	        month = '' + (d2.getMonth() + 1),
				    	        day = '' + d2.getDate(),
				    	        year = d2.getFullYear();

				            	if (month.length < 2) month = '0' + month;
				            	if (day.length < 2) day = '0' + day;

				            	var date = [day, month, year].join('-');
			         			            		
			            		  data.push('<tr requestMaterialId="'+value.requestMaterialId+'"><td>'+
											'</td> '+
					                        '<td name=orderMaterialNo>'+value.requestMaterialNo+'</td> '+
					                        '<td name=status>'+value.status+'</td> '+
					                        '<td name=requestDate>'+(date)+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            
			        	}
			        });
		    }

function backFunction(){
	location.href = "listProjectPM.html";
}