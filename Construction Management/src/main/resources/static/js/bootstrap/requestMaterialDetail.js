		$(document).ready(function(){
			
			
			
			
			 var params = {method:'Type'};
		    	BSBaseComboBox. getType(params,function(data){
		      	$("div select[name=typeList]").html(data).selectpicker('refresh');
			
	   	
	    	});			    	
			   $('.typeList').on('change', function(event){
			   var params2 = {method:'MaterialStock', TypeId: event.currentTarget.value};
			   BSBaseComboBox.getMaterial(params2,function(data){
			   $("div select[name=materialList]").html(data).selectpicker('refresh');
			    			    	    	
			    	 });
		    	    
			    	  });
			    	
			    	searchFunction();
    });
		 function searchFunction(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/requestMaterialDetail.html"
		        	, data: {method: 'search', requestMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr requestMaterialDetailId="'+value.requestMaterialDetailId+'"><td>'+
											'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.requestMaterialDetailId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span>'+
											'</button> '+
										'</td> '+
				                        '<td name=materialName>'+value.materialName+'</td> '+
				                        '<td name=descrition>'+value.description+'</td> '+
				                        '<td >'+value.quantityRequest+' '+ value.unitName+'</td></tr>');
		            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }
		
		function Save(){

			 if( BeanUtils.isNotEmpty($('div[name=addEditData] select[name=typeList]').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] input[name=quantityRequest]').val())){				                                                     		
				var params = {};
				var message = ""
				
					params.method = 'save';
					message = "add material success!!"
				 if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					message = "update success!!"
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.requestMaterialId = headerId
					params.materialId = $('div[name=addEditData] select[name="materialList"]').val();
					params.quantityRequest = $('div[name=addEditData]  input[name=quantityRequest]').val();
						
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/requestMaterialDetail.html"
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
					 var params = {method: 'delete', requestMaterialDetailId: value};
				    	$.ajax({
				        	type: 'POST'
				        	, url: application.contextPath+"/requestMaterialDetail.html"
				        	, data: params
				        	, success: function(result){
				        		searchFunction();
				        	}
				        });
				 }
				}
			 }
		
		
		
		
		
		
		

	
	

		function addRow(){			 
			 disAndEnInputField('create');
		}

		function disAndEnInputField(param){
		 if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='quantityRequest']").prop('disabled',  false);
				
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', true);
					$("div[name='addEditData'] select[name='materialList']").prop('disabled', true);
					$("div[name='addEditData'] input[name='quantityRequest']").prop('disabled',  true);
				
				}
		}

		function createOrUpdateMode(param){	
			   	
				$("div[name='addEditData'] select[name='typeList']").val('');
				$("div[name='addEditData'] select[name='materialList']").val('');
				$("div[name='addEditData'] input[name='quantityRequest']").val('');
				 
			 if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		}

		
		function back(){
			location.href = "createRequestMaterial.html";

		}
		function Send(){
			location.href = "viewRequestMaterial.html?requestMaterialId="+headerId+" ";

		}
		
		