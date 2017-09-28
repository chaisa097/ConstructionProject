$(document).ready(function(){
		
		            searchHeader();
			    	searchFunction();
			   
    });
	
	
	
	
function searchHeader(){
	$.ajax({
	  	type: 'POST'
	  	, url: application.contextPath+"/confirmRequestMaterial.html"
	  	, data: {method:'searchHeader',requestMaterialId:headerId}
	  	, success: function(result){
	    	var json = $.parseJSON(result);

	        
	        var d2 = new Date(json[0].useMaterialDate),
	        month = '' + (d2.getMonth() + 1),
	        day = '' + d2.getDate(),
	        year = d2.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    var date = [year, month, day].join('-');
	    
	    $("#contactOwner").html(json[0].contactOwner);  
     	$("#requestMaterialNo").html(json[0].requestMaterialNo);  
     	$("#useMaterialDate").html(date); 
     	$("#status").html(json[0].status); 
	  	}
	  });
}
	
	
function searchFunction(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/confirmRequestMaterial.html"
		        	, data: {method: 'search', requestMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];		         
		            		$.each(json, function(index, value) {
			            		  data.push('<tr orderMaterialDatailId="'+value.orderMaterialDatailId+'">'+
					                        '<td name=materialName>'+value.materialName+'</td> '+
					                        '<td name=description>'+value.description+'</td> '+
					                        '<td name=quantityOrder>'+value.quantityRequest+'</td> '+
					                        '<td name=anotation>'+value.unitName+'</td></tr>');
			            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }
function backFunction(){
	location.href = "listProjectPM.html";
}

function ConfirmRequest(){
		 var params = {method:'confirmRequest', requestMaterialId:headerId};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/confirmRequestMaterial.html"
	        	, data: params
	        	, success: function(result){
	        		alert("confirmRequest Success");
       		backFunction();
	        	}
	        });
		
 }

function rejectRequest(){
	 var params = {method:'RejectRequest', requestMaterialId:headerId};
   	$.ajax({
       	type: 'POST'
       	, url: application.contextPath+"/confirmRequestMaterial.html"
       	, data: params
       	, success: function(result){
       		alert("Reject!!");
  		backFunction();
       	}
       });
}
