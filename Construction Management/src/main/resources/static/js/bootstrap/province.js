		$(document).ready(function(){
   	    	BSBaseTable.callFiterTable();
   	    	var params = {method: 'search'};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/province.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		  data.push('<tr provinceId="'+value.provinceId+'"><td>'+
				                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.provinceId+'")> '+
										 '<span class="glyphicon glyphicon-pencil"></span> Edit '+
										'</button> '+
										'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.provinceId+'")> '+
											'<span class="glyphicon glyphicon-trash"></span> Delete '+
										'</button> '+
									'</td> '+
			                        '<td name=provinceCode>'+value.provinceCode+'</td> '+
			                        '<td name=provinceName>'+value.provinceName+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            	disAndEnInputField('');
	        	}
	        });
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/province.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr provinceId="'+value.provinceId+'"><td>'+
						                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.provinceId+'")> '+
												 '<span class="glyphicon glyphicon-pencil"></span> Edit '+
												'</button> '+
												'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.provinceId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span> Delete '+
												'</button> '+
											'</td> '+
					                        '<td name=provinceCode>'+value.provinceCode+'</td> '+
					                        '<td name=provinceName>'+value.provinceName+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function saveFunction(){
		
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=provinceCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=provinceName]').val())){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'save')){
					params.method = 'save';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'edit')){
					params.method = 'edit';
					params.provinceId = $('div[name=addEditData] input[name=provinceCode]').attr('provinceId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.provinceCode = $('div[name=addEditData] input[name=provinceCode]').val();
					params.provinceName = $('div[name=addEditData] input[name=provinceName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/province.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=provinceCode]').attr('provinceId', '')
			        	}
			        });
				}
			 }
		 }
		 
		 function addRow(){
			 disAndEnInputField('save');
		 }
		 
		 function editRow(value){
			 disAndEnInputField('edit');
			 $('div[name=addEditData] input[name=provinceCode]').val($('tbody tr[provinceId="'+value+'"] td[name=provinceCode]').html());
			 $('div[name=addEditData] input[name=provinceName]').val($('tbody tr[provinceId="'+value+'"] td[name=provinceName]').html());
			 $('div[name=addEditData] input[name=provinceCode]').attr('provinceId', value);
		 }
		 
		 
		 function deleteRow(value){
			 if(BeanUtils.isNotEmpty(value)){
				 var params = {method: 'delete', provinceId: value};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/province.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        	}
			        });
			 }
		 }
		 
		 function backFunction(){
				location.href = "home.html";
		 }
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param,'save')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='provinceCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='provinceName']").prop('disabled', false);
				}else if(BeanUtils.equals(param,'edit')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='provinceCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='provinceName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='provinceCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='provinceName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='provinceCode']").val('');
			 $("div[name='addEditData'] input[name='provinceName']").val('');
			 if(BeanUtils.equals(param, 'save')){
				 $("div[name='statusSave']").attr('mode', 'save');
			 }else if(BeanUtils.equals(param, 'edit')){
				 $("div[name='statusSave']").attr('mode', 'edit');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	


