	$(document).ready(function(){
		
		            searchHeader();
		            searchDetail();
			   
    });
	
	
	
	
function searchHeader(){
	$.ajax({
	  	type: 'POST'
	  	, url: application.contextPath+"/viewExportMaterial.html"
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
		  	$("input[name='exportDate']").val(date);
	      	$("input[name='exportMaterialNo']").val(json[0].exportMaterialNo);
	      	$("input[name='status']").val(json[0].status); 
	     	$("input[name='projectName']").val(json[0].projectName); 
	  	}
	  });
}
	
	
function searchDetail(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/viewExportMaterial.html"
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
function backFunction(){
	location.href = "OrderMaterial.html";

}

function confirmExport(){
		 var params = {method: 'ok', exportMaterialId:headerId};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/viewExportMaterial.html"
	        	, data: params
	        	, success: function(result){
	        		
	        		back();
	        	}
	        });
	
 }
function back(){
	location.href = "exportMaterialConfirm.html";

}

function backFunction(){
	location.href = "OrderMaterial.html";

}