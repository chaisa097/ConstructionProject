		$(document).ready(function(){
			
			
			
			
			 var params = {method:'Type'};
		    	BSBaseComboBox. getType(params,function(data){
		      	$("div select[name=typeList]").html(data).selectpicker('refresh');
			
	   	
	    	});
	 
		    	
		    	
			    	$('.typeList').on('change', function(event){
			    	    console.log(event.currentTarget.value)
			    	    var params2 = {method:'Material', TypeId: event.currentTarget.value};
			    	    BSBaseComboBox.getMaterial(params2,function(data){
			    	    	$("div select[name=materialList]").html(data).selectpicker('refresh');
			    	 	

			    	 });
			    	  });

    });
		
		
		
			
		
		function saveFunction(){
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
			        	, url: application.contextPath+"/OrderMaterial.html"
			        	, data: params
			        	, success: function(result){
			        		alert(message);			        	
			        		
			        	}
			        });
				}
			 }
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

		
		
		
		
		