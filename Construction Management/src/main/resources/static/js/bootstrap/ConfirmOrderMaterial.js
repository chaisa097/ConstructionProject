
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

	    var date = [day, month, year].join('-');
	     	$("#address").html(json[0].address);  
	     	$("#orderMaterialNo").html(json[0].orderMaterialNo);  
	     	$("#orderMaterialDate").html(date); 
	     	$("#status").html(json[0].status); 
	    
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
					                        '<td name=descrition>'+value.description+'</td> '+
					                        '<td name=quantityOrder>'+value.quantityOrder+'</td> '+
					                        '<td name=unitName>'+value.unitName+'</td>'+
					                        '<td name=anotation>'+value.anotation+'</td></tr>');
			            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }

function ConfirmRequest(){
		 var params = {method:'ConfirmOrder', orderMaterialId:headerId};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/confirmOrder.html"
	        	, data: params
	        	, success: function(result){
	        		alert("confirmOrder Success");
	        		backFunction();
	        	}
	    	
	        });
		
 }
function rejectOrderMaterial(){
	 var params = {method:'rejectOrder', orderMaterialId:headerId};
  	$.ajax({
      	type: 'POST'
      	, url: application.contextPath+"/confirmOrder.html"
      	, data: params
      	, success: function(result){
      		alert("Reject!!");
 		backFunction();
      	}
      });
}


function backFunction(){
	location.href = "listOrder.html";
}

function exportPDF(){
 
    var doc = new jsPDF();
    
    $.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/confirmOrder.html"
    	, data: {method: 'search', orderMaterialId:headerId}
    	, success: function(result){			        		
        	var json = $.parseJSON(result);
               
        json.forEach(function(employee, i){
        doc.text(20, 10 + (i * 10), 
            "First Name: " + employee.materialName +
            "Last Name: " + employee.description);
    });
        
    doc.save('Test.pdf');
    
    	}
    });
}



    
