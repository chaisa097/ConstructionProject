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
		
		
		
		            searchMaterialReceive();
			    	searchFunction();
			   
    });
	
			
function  searchMaterialReceive(){
	
	var params = {method: 'searchReceiveMaterial'};
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/AddMaterialStock.html"
    	, data: params
    	, success: function(result){			        		
        	var json = $.parseJSON(result);
        	var data = [];
        	
        	$.each(json, function(index, value) {        		          		
        		  data.push('<tr receiveMateialDetialId="'+value.receiveMateialDetialId+'"><td>'+
        				   '<button type="button" class="btn btn-info btn-xs" onclick=deleteRow("'+value.receiveMateialDetialId+'")> '+
							'<span class="glyphicon glyphicon-trash"></span> Delete '+
						   '</button> '+
	                        '<td name=materialName>'+value.materialName+'</td> '+
	                        '<td name=descrition>'+value.descrition+'</td> '+
	                        '<td name=receiveQuantity>'+value.receiveQuantity+'</td> '+
	                        '<td name=unitName>'+value.unitName+'</td> '+
	                        '<td name=receivePrice>'+value.receivePrice+'</td></tr>');
        	});
        	$('table.table tbody').html(data.join());	
        
    	}
    });
	
}
	
	function saveFunction(){
		 if( BeanUtils.isNotEmpty($('div[name=addEditData] input[name=receiveQuantity]').val())){				                                                     		
			var params = {};
			var message = ""
					
			if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
				params.method = 'save';
				message = "AddMaterial success!!"
				
			}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
				params.method = 'edit';				
				message = "updateMaterial success!!"
			}
			if(BeanUtils.isNotEmpty(params.method)){
				params.orderMaterialId = headerId
				params.materialId = $('div[name=addEditData] select[name=materialList]').val();
				params.receivePrice = $('div[name=addEditData] input[name=receivePrice]').val();
				params.receiveQuantity = $('div[name=addEditData] input[name=receiveQuantity]').val();
				
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/AddMaterialStock.html"
		        	, data: params
		        	, success: function(result){
		        		alert(message);
		        
		        	
		        					        		
		        	}
		    	      
		        });
			}
		 }
	 }
	
	
	
	
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
			            				  '<td name=materialName>'+value.typeName+'</td> '+
					                        '<td name=materialName>'+value.materialName+'</td> '+
					                        '<td name=descrition>'+value.descrition+'</td> '+
					                        '<td name=quantityOrder>'+value.quantityOrder+'</td> '+
					                        '<td name=unitName>'+value.unitName+'</td>'+
					                        '<td name=anotation>'+value.anotation+'</td></tr>');
			            	});
		            	$('table.table1 tbody').html(data.join());	
		            
		        	}
		        });
	    }

function UpdateFinished(){
		 var params = {method: 'finishOrder', orderMaterialId:headerId};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/AddMaterialStock.html"
	        	, data: params
	        	, success: function(result){
	        		alert("Add MaterialOrder Success!!");
	        		back();
	        	}
	        });
	
 }
function back(){
	location.href = "receiveMaterial.html";

}

function addRow(){			 
	 disAndEnInputField('create');	 
	 	 
}

function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'create')){
		 	createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='receiveQuantity']").prop('disabled', false);
			$("div[name='addEditData'] input[name='receivePrice']").prop('disabled', false);

		}else if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='receiveQuantity']").prop('disabled',  false);
			$("div[name='addEditData'] input[name='receivePrice']").prop('disabled',  false);
		}else{
			createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', true);
			$("div[name='addEditData'] select[name='materialList']").prop('disabled', true);
			$("div[name='addEditData'] input[name='receiveQuantity']").prop('disabled',  true);
			$("div[name='addEditData'] input[name='receivePrice']").prop('disabled',  true);
		}
}

function createOrUpdateMode(param){	
	   	
		$("div[name='addEditData'] select[name='typeList']").val('');
		$("div[name='addEditData'] select[name='materialList']").val('');
		$("div[name='addEditData'] input[name='receiveQuantity']").val('');
		$("div[name='addEditData'] input[name='receivePrice']").val('');
		 
	 if(BeanUtils.equals(param, 'create')){
		 $("div[name='statusSave']").attr('mode', 'create');
	 }else if(BeanUtils.equals(param, 'update')){
		 $("div[name='statusSave']").attr('mode', 'update');
	 }else{
		 $("div[name='statusSave']").attr('mode', '');
	 }
}