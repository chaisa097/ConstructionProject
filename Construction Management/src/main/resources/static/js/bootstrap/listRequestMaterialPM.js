$(document).ready(function(){

	BSBaseTable.callFiterTable();
	    	searchFunction();
    });



function searchFunction(){
		    		var params = {method: 'searchPM', projectId:headerId };
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/listRequestMaterialPM.html"
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
				            	
				            	var d1 = new Date(value.useMaterialDate),
				    	        month = '' + (d1.getMonth() + 1),
				    	        day = '' + d1.getDate(),
				    	        year = d1.getFullYear();

				            	if (month.length < 2) month = '0' + month;
				            	if (day.length < 2) day = '0' + day;

				            	var date1 = [day, month, year].join('-');
			         			            		
			            		  data.push('<tr requestMaterialId="'+value.requestMaterialId+'"><td>'+
			            				    '<a href='+domainSystem+'/confirmRequestMaterial.html?requestMaterialId='+value.requestMaterialId+' class="btn btn-warning btn-xs"> '+
	    								   ' Approve Or Reject'+
	    								   '</a> '+	
					                        '<td name=orderMaterialNo>'+value.requestMaterialNo+'</td> '+
					                        '<td name=name>'+value.empFirstName+'  '+value.empLastName+'</td> '+
					                        '<td name=status>'+value.status+'</td> '+
					                        '<td name=status>'+date1+'</td> '+
					                        '<td name=requestDate>'+(date)+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            
			        	}
			        });
		    }

function back(){
	location.href = "listProjectPM.html";
}