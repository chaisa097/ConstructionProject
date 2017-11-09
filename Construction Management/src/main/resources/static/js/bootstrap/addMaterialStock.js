	$(document).ready(function(){
		
		 var params = {method:'Type'};
	    	BSBaseComboBox. getType(params,function(data){
	      	$("div select[name=typeList]").html(data).selectpicker('refresh');
		
	
 	});
	    	
		  
		    	    var params2 = {method:'Allmaterial'};
		    	    BSBaseComboBox.getOrderMaterial(params2,function(data){
		    	    	$("div select[name=materialList]").html(data).selectpicker('refresh');
		    
		    	  });
             
		    	   
		    	    
		    	    
		            searchMaterialReceive();
		            searchOrder();
		            
		        	$('#requantity').on('input', function() {
		    			
		    			var numInput = document.querySelector('#requantity');

		    			// Listen for input event on numInput.
		    			numInput.addEventListener('input', function(){
		    			    // Let's match only digits.
		    			    var num = this.value.match(/^\d+$/);
		    			    if (num === null) {
		    			        // If we have no match, value will be empty.
		    			        this.value = "";
		    			    }
		    			}, false)
		    			
		     			var input=$(this);
		     			var is_name=input.val();
		     			if(is_name){input.removeClass("invalid").addClass("valid");}
		     			else{input.removeClass("valid").addClass("invalid");}
		     			
		     	    
		     			
		     		});
		        	$('#rePrice').on('input', function() {
		        		
		        		var numInput = document.querySelector('#rePrice');

		        		// Listen for input event on numInput.
		        		numInput.addEventListener('input', function(){
		        		    // Let's match only digits.
		        		    var num = this.value.match(/^\d+$/);
		        		    if (num === null) {
		        		        // If we have no match, value will be empty.
		        		        this.value = "";
		        		    }
		        		}, false)
		        		
		        			var input=$(this);
		        			var is_name=input.val();
		        			if(is_name){input.removeClass("invalid").addClass("valid");}
		        			else{input.removeClass("valid").addClass("invalid");}
		        			
		        	    
		        			
		        		});
		          
			   
    });
	
	
	
	
	
	function searchOrder(){
    	$.ajax({
        	type: 'POST'
        	, url: application.contextPath+"/AddMaterialStock.html"
        	, data: {method: 'searchOrder', orderMaterialId:headerId}
        	, success: function(result){			        		
            	var json = $.parseJSON(result);
            	var data = [];		         
            		$.each(json, function(index, value) {
	            		  data.push('<tr><td>'+
								  '<button type="button" id="button'+value.materialId+'" class="btn btn-success btn-xs" onclick=selectRow("'+value.materialId+'")> '+
									'<span class="glyphicon glyphicon-plus"></span>'+
							     	'</button> '+
							      '</td> '+
	            				  '<td name=materialName>'+value.typeName+'</td> '+
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
	
	
	
	
	
			
function  searchMaterialReceive(){
	
	var params = {method: 'searchReceiveMaterial',orderMaterialId:headerId};
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/AddMaterialStock.html"
    	, data: params
    	, success: function(result){			        		
        	var json = $.parseJSON(result);
        	var data = [];
        	
        	$.each(json, function(index, value) {        		          		
        		  data.push('<tr>'+
        				  '<td></td>'+
	                        '<td name=materialName>'+value.materialName+'</td> '+
	                        '<td name=description>'+value.description+'</td> '+
	                        '<td name=receiveQuantity>'+value.receiveQuantity+'</td> '+
	                        '<td name=unitName>'+value.unitName+'</td> '+	      
	                        '<td name=receivePrice>'+value.receivePrice+'</td></tr>');
        	});
        	$('table.table-condensed  tbody').html(data.join());	
        
    	}
    });
	
}
	
	function Save(){
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
		        		 searchMaterialReceive();
		        	
		        					        		
		        	}
		    	      
		        });
			}
		 }
	 }
	
	function selectRow(value){
    	disAndEnInputField('create');
    	var params = {method: 'searchMaterial', materialId:value};
    	$.ajax({
        	type: 'POST'
        	, url: application.contextPath+"/AddMaterialStock.html"
        	, data: params
        	, success: function(result){
            	var json = $.parseJSON(result);
            	$("div[name='addEditData'] select[name='typeList']").val(json[0].typeId).selectpicker('refresh'); 
            	$("div[name='addEditData'] select[name='materialList']").val(json[0].materialId).selectpicker('refresh');
            	  document.getElementById("button"+value).style.visibility = "hidden";

        	}
        });
    	var params = {method: 'searchPrice', materialId:value};
    	$.ajax({
        	type: 'POST'
        	, url: application.contextPath+"/AddMaterialStock.html"
        	, data: params
        	, success: function(result){
            	var json = $.parseJSON(result);
            
            	$("div[name='addEditData'] input[name='receivePrice']").val(json[0].price);
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


function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'create')){
		 	createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', true).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  true).selectpicker('refresh');
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