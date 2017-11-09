$(document).ready(function(){
		
		            searchHeader();
		            searchDetail();
		            
        console.log(headerId);
			   
    });
	
	
	
	
function searchHeader(){
	$.ajax({
	  	type: 'POST'
	  	, url: application.contextPath+"/viewExportMaterialPM.html"
	  	, data: {method:'searchHeader', exportMaterialId:headerId}
	  	, success: function(result){
	    	var json = $.parseJSON(result);
	    	var d2 = new Date(json[0].exportDate),
	        month = '' + (d2.getMonth() + 1),
	        day = '' + d2.getDate(),
	        year = d2.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    var date = [day, month, year].join('/');
	     	$("#projectName").html(json[0].projectName);  
	     	$("#exportMaterialNo").html(json[0].exportMaterialNo);  
	     	$("#exportDate").html(date); 
	     	$("#status").html(json[0].status); 
	  	}
	  });
}
	
	
function searchDetail(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/viewExportMaterialPM.html"
		        	, data: {method: 'search', exportMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];		         
		            		$.each(json, function(index, value) {
			            		  data.push('<tr orderMaterialDatailId="'+value.orderMaterialDatailId+'">'+
					                        '<td name=materialName>'+value.materialName+'</td> '+
					                        '<td name=descrition>'+value.description+'</td> '+
					                        '<td name=exportQuantity>'+value.exportQuantity+'</td> '+
					                        '<td name=unitName>'+value.unitName+'</td></tr>');
			            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }

function back(){
	location.href = "listExportMaterial.html?projectId="+projectId+"";

}
