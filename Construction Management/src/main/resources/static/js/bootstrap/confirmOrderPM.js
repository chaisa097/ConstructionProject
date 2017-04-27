	$(document).ready(function(){
		
		            searchHeader();
			    	searchFunction();
			   
    });
	
	
	
	
function searchHeader(){
	$.ajax({
	  	type: 'POST'
	  	, url: application.contextPath+"/confirmOrder.html"
	  	, data: {method:'searchHeader',orderMaterialId:headerId}
	  	, success: function(result){
	    	var json = $.parseJSON(result);

	        
	        var d2 = new Date(json[0].orderMaterialDate),
	        month = '' + (d2.getMonth() + 1),
	        day = '' + d2.getDate(),
	        year = d2.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    var date = [year, month, day].join('-');
	    
		  	$("textarea[name='address']").val(json[0].address);
	      	$("input[name='orderMaterialNo']").val(json[0].orderMaterialNo);
	      	$("input[name='orderMaterialDate']").val(date); 
	     	$("input[name='status']").val(json[0].status); 
	  	}
	  });
}
	
	
function searchFunction(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/confirmOrder.html"
		        	, data: {method: 'search', orderMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];		         
		            		$.each(json, function(index, value) {
			            		  data.push('<tr orderMaterialDatailId="'+value.orderMaterialDatailId+'">'+
					                        '<td name=materialName>'+value.materialName+'</td> '+
					                        '<td name=description>'+value.description+'</td> '+
					                        '<td name=quantityOrder>'+value.quantityOrder+'</td> '+
					                        '<td name=unitName>'+value.unitName+'</td>'+
					                        '<td name=anotation>'+value.anotation+'</td></tr>');
			            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }
function back(){
	location.href = "listOrderPM.html";

}

function ConfirmOrder(){
		 var params = {method: 'ConfirmOrder', orderMaterialId:headerId};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/confirmOrder.html"
	        	, data: params
	        	, success: function(result){
	        		alert("confirm Success");
	        		back();
	        	}
	        });
	
 }
function rejectOrder(){
	 var params = {method: 'rejectOrder', orderMaterialId:headerId};
   	$.ajax({
       	type: 'POST'
       	, url: application.contextPath+"/confirmOrder.html"
       	, data: params
       	, success: function(result){
       		alert("reject Success");
       		back();
       	}
       });

}

function viewStock(){
	location.href = "stock.html";

}



function back(){
	location.href = "listOrderPM.html";

}
