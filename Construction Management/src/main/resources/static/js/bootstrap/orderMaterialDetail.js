		$(document).ready(function(){
			
			
			
			
			 var params = {method:'Type'};
		    	BSBaseComboBox. getType(params,function(data){
		      	$("div select[name=typeList]").html(data).selectpicker('refresh');
			
	   	
	    	});
	 
		    	
		    	
			    	$('.typeList').on('change', function(event){
			    	    var params2 = {method:'Material', TypeId: event.currentTarget.value};
			    	    BSBaseComboBox.getOrderMaterial(params2,function(data){
			    	    	$("div select[name=materialList]").html(data).selectpicker('refresh');
			    	 	

			    	 });
			    	  });
			    	
			    	searchFunction();
    });
		 function searchFunction(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/orderMaterialDetail.html"
		        	, data: {method: 'search', orderMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr orderMaterialDatailId="'+value.orderMaterialDatailId+'"><td>'+
											'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.orderMaterialDatailId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span>'+
											'</button> '+
										'</td> '+
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
		
		function Save(){

			 if( BeanUtils.isNotEmpty($('div[name=addEditData] select[name=typeList]').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] input[name=quantityOrder]').val())){				                                                     		
				var params = {};
				var message = ""
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'save';
					message = "add material success!!"
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					message = "update success!!"
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.materialId = $('div[name=addEditData] select[name="materialList"]').val();
					params.quantityOrder = $('div[name=addEditData]  input[name=quantityOrder]').val();
					params.anotation = $('div[name=addEditData]  input[name=anotation]').val();
					params.orderMaterialId = headerId
						
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/orderMaterialDetail.html"
			        	, data: params
			        	
			        	, success: function(result){
			        		alert(message);			        	
			        		searchFunction();
			        	}
			        });
				}
			 }
		 }

		 function deleteRow(value){
				if( confirm("Delete!")== true){
				 if(BeanUtils.isNotEmpty(value)){
					 var params = {method: 'delete', orderMaterialDatailId: value};
				    	$.ajax({
				        	type: 'POST'
				        	, url: application.contextPath+"/orderMaterialDetail.html"
				        	, data: params
				        	, success: function(result){
				        		searchFunction();
				        	}
				        });
				 }
				}
			 }
		
		
		
		
		
		
		

		function backFunction(){
			location.href = "OrderMaterial.html";
		
		}
	

		function addRow(){			 
			 disAndEnInputField('create');
		}

		function disAndEnInputField(param){
			 if(BeanUtils.equals(param, 'create')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='quantityOrder']").prop('disabled', false);
					$("div[name='addEditData'] input[name='anotation']").prop('disabled', false);
					
							
				
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='quantityOrder']").prop('disabled',  false);
					$("div[name='addEditData'] input[name='anotation']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', true);
					$("div[name='addEditData'] select[name='materialList']").prop('disabled', true);
					$("div[name='addEditData'] input[name='quantityOrder']").prop('disabled',  true);
					$("div[name='addEditData'] input[name='anotation']").prop('disabled', true);
				}
		}

		function createOrUpdateMode(param){	
			   	
				$("div[name='addEditData'] select[name='typeList']").val('');
				$("div[name='addEditData'] select[name='materialList']").val('');
				$("div[name='addEditData'] input[name='quantityOrder']").val('');
				$("div[name='addEditData'] input[name='anotation']").val('');
				 
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		}

		
		function back(){
			location.href = "OrderMaterial.html";

		}
		
		
		