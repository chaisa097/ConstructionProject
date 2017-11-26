	$(document).ready(function(){
			
	    	searchFunction();
	    	 BSBaseTable.callFiterTable();
    });
		
	    
		 function searchFunction(){
		    		var params = {method: 'search',projectId:headerId};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/listExportMaterialEngineer.html"
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
			            		
			            		  data.push('<tr exportMaterialId="'+value.exportMaterialId+'"><td>'+			
		    								'<a href='+domainSystem+'/viewExportMaterial.html?exportMaterialId='+value.exportMaterialId+' class="btn btn-warning btn-xs"> '+
		    								  ' View Detail '+
		    								'</a> '+	
					                        '<td name=exportMaterialNo>'+value.exportMaterialNo+'</td> '+
					                        '<td name=exportDate>'+date+'</td> '+
					                        '<td id="totalExport">'+value.totalExport+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());
			            
			            
			        	}
			        });
		    }
		 
		 function back(){
				location.href = "importMaterial.html";

			}