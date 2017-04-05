	$(document).ready(function(){
		
		 var params = {method:'Type'};
	    	BSBaseComboBox. getType(params,function(data){
	      	$("div select[name=typeList]").html(data).selectpicker('refresh');
		
	
 	});
	    	
		    	$('.typeList').on('change', function(event){
		    	    var params2 = {method:'Material', TypeId: event.currentTarget.value};
		    	    BSBaseComboBox.getMaterial(params2,function(data){
		    	    	$("div select[name=materialList]").html(data).selectpicker('refresh');
		    	 	

		    	 });
		    	  });
		
		
		
//		            searchHeader();
			    	searchFunction();
			   
    });
	
			
//function searchHeader(){
//	$.ajax({
//	  	type: 'POST'
//	  	, url: application.contextPath+"/viewOrder.html"
//	  	, data: {method:'searchHeader',orderMaterialId:headerId}
//	  	, success: function(result){
//	    	var json = $.parseJSON(result);
//
//	        
//	        var d2 = new Date(json[0].orderMaterialDate),
//	        month = '' + (d2.getMonth() + 1),
//	        day = '' + d2.getDate(),
//	        year = d2.getFullYear();
//
//	    if (month.length < 2) month = '0' + month;
//	    if (day.length < 2) day = '0' + day;
//
//	    var date = [year, month, day].join('-');
//	    
//		  	$("textarea[name='address']").val(json[0].address);
//	      	$("input[name='orderMaterialNo']").val(json[0].orderMaterialNo);
//	      	$("input[name='orderMaterialDate']").val(date); 
//	     	$("input[name='status']").val(json[0].status); 
//	  	}
//	  });
//}
	
	
	
	
	
	
function searchFunction(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/AddMaterialStock.html"
		        	, data: {method: 'search', orderMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];		         
		            		$.each(json, function(index, value) {
			            		  data.push('<tr orderMaterialDatailId="'+value.orderMaterialDatailId+'">'+
					                        '<td name=materialName>'+value.materialName+'</td> '+
					                        '<td name=descrition>'+value.descrition+'</td> '+
					                        '<td name=quantityOrder>'+value.quantityOrder+'</td> '+
					                        '<td name=unitName>'+value.unitName+'</td>'+
					                        '<td name=anotation>'+value.anotation+'</td></tr>');
			            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }












//function backFunction(){
//	location.href = "OrderMaterial.html";
//
//}
//
//function SendOrder(){
//		 var params = {method: 'sendOrder', orderMaterialId:headerId};
//	    	$.ajax({
//	        	type: 'POST'
//	        	, url: application.contextPath+"/viewOrder.html"
//	        	, data: params
//	        	, success: function(result){
//	        		alert("Send Success");
//	        		back();
//	        	}
//	        });
//	
// }
//function back(){
//	location.href = "listOrder.html";
//
//}


function Save(){			 
	 disAndEnInputField('create');	 
}

function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'create')){
		 	createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='quantityOrder']").prop('disabled', false);


		}else if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='quantityOrder']").prop('disabled',  false);
		}else{
			createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', true);
			$("div[name='addEditData'] select[name='materialList']").prop('disabled', true);
			$("div[name='addEditData'] input[name='quantityOrder']").prop('disabled',  true);
		
		}
}

function createOrUpdateMode(param){	
	   	
		$("div[name='addEditData'] select[name='typeList']").val('');
		$("div[name='addEditData'] select[name='materialList']").val('');
		$("div[name='addEditData'] input[name='quantityOrder']").val('');

		 
	 if(BeanUtils.equals(param, 'create')){
		 $("div[name='statusSave']").attr('mode', 'create');
	 }else if(BeanUtils.equals(param, 'update')){
		 $("div[name='statusSave']").attr('mode', 'update');
	 }else{
		 $("div[name='statusSave']").attr('mode', '');
	 }
}