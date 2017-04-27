		$(document).ready(function(){
			
			 var params = {method:'Type'};
		    	BSBaseComboBox.getType(params,
		    			 function(data){
		      	$("div select[name=typeList]").html(data).selectpicker('refresh');
			
   	   	
   	    	});
   	   	    	    
		    	
		    	 var params = {method:'Unit'};
		 	     BSBaseComboBox.getUnit(params,
		 	    			 function(data){
		 	   	$("div select[name=unitList]").html(data).selectpicker('refresh');
	   	   	
	   	   	
	   	   	
	   	    	});
   	      		BSBaseTable.callFiterTable();
   	      		
   	      	search()
		   });
	      
   	   	
		  
		
		
	    function search(){
	    		var params = {method:'search'};
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/material.html"
		        	, data: params
		        	, success: function(result){
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr><td>'+
					                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.materialId+'")> '+
												'<span class="glyphicon glyphicon-pencil"></span>'+
											'</button> '+
											'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.materialId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> '+
											'</button> '+
										'</td> '+
										'<td>'+value.typeName+'</td> '+	
				                        '<td>'+value.materialName+'</td> '+
				                        '<td>'+value.description+'</td> '+	
				                        '<td>'+value.unitName+'</td></tr>');
		            	});
		            	$('table.table tbody').html(data.join());		  
		        	}
		        });
	    
	    }
	    
	    function save(){
	    	var params = {};
	    	 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=materialCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=materialName]').val())){
	    		 
	    			var params = {};
					var message = ""
							
					if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
						params.method ='save';
						message = "add success!!"
						
					}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
						params.method = 'edit';	
						params.materialId = $('div[name=addEditData] input[name=materialName]').attr('materialId');
						message = "update success!!"
					}
					
	    			if(BeanUtils.isNotEmpty(params.method)){
	    		    params.typeId = $("div[name='addEditData'] select[name='typeList']").val();
	    			params.unitId = $("div[name='addEditData'] select[name='unitList']").val(); 
	    			params.description = $("div[name='addEditData'] textarea[name='description']").val();
	    			params.materialCode = $("div[name='addEditData'] input[name='materialCode']").val();
	    			params.materialName = $("div[name='addEditData'] input[name='materialName']").val();
		    		$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/material.html"
			        	, data: params
			        	, success: function(result){		        
			        		alert(message);
			        		search();
			        		$('div[name=addEditData] input[name=materialName]').attr('materialId', '')
			        		disAndEnInputField(param);
			        	}
			        });
	    		}
	    }
	    }

	    function editRow(value){
	    	disAndEnInputField('update');
	    	var params = {method: 'searchMaterialforUpdate', materialId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/material.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	$("div[name='addEditData'] input[name='materialCode']").val(json[0].materialCode);
	            	$("div[name='addEditData'] input[name='materialName']").val(json[0].materialName);
	            	$("div[name='addEditData'] textarea[name='description']").val(json[0].description);
	            	$("div[name='addEditData'] select[name='unitList']").val(json[0].unitId).selectpicker('refresh');
	            	$("div[name='addEditData'] select[name='typeList']").val(json[0].typeId).selectpicker('refresh');
	            	$('div[name=addEditData] input[name=materialName]').attr('materialId', value);
	        	}
	        });
	    }
	    
		function deleteRow(value){
			var params = {method: 'delete', materialId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/material.html"
	        	, data: params
	        	, success: function(result){
	        		search();
	        	}
	        });
	    }
		
		function addRow(){			 
			 disAndEnInputField('create');
		}

		function disAndEnInputField(param){
			 if(BeanUtils.equals(param, 'create')){
				 	createOrUpdateMode(param);
					
					$("div[name='addEditData'] select[name='unitList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='materialCode']").prop('disabled', false);
					$("div[name='addEditData'] textarea[name='description']").prop('disabled', false);
					$("div[name='addEditData'] input[name='materialName']").prop('disabled', false);
				}else if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
				
					
					$("div[name='addEditData'] select[name='unitList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='materialCode']").prop('disabled', false);
					$("div[name='addEditData'] textarea[name='description']").prop('disabled', false);
					$("div[name='addEditData'] input[name='materialName']").prop('disabled', false);
				
				}else{
					createOrUpdateMode(param);
				
					$("div[name='addEditData'] select[name='unitList']").prop('disabled', true).selectpicker('refresh');
					$("div[name='addEditData'] select[name='typeList']").prop('disabled', true).selectpicker('refresh');
					$("div[name='addEditData'] input[name='materialCode']").prop('disabled', true);
					$("div[name='addEditData'] textarea[name='description']").prop('disabled', true);
					$("div[name='addEditData'] input[name='materialName']").prop('disabled', true);
				
				}
		}

		function createOrUpdateMode(param){
				$("div[name='addEditData'] select[name='unitList']").val('').selectpicker('refresh');
				$("div[name='addEditData'] select[name='typeList']").val('').selectpicker('refresh');
				$("div[name='addEditData'] input[name='materialCode']").val('');
				$("div[name='addEditData'] textarea[name='description']").val('');
				$("div[name='addEditData'] input[name='materialName']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		}
	