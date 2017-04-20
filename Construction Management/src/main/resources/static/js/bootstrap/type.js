		$(document).ready(function(){
   	    	BSBaseTable.callFiterTable();
   	    	searchFunction();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/type.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr typeId="'+value.typeId+'"><td>'+
						                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.typeId+'")> '+
												 '<span class="glyphicon glyphicon-pencil"></span> '+
												'</button> '+
												'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.typeId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span>'+
												'</button> '+
											'</td> '+
					                        '<td name=typeCode>'+value.typeCode+'</td> '+
					                        '<td name=typeName>'+value.typeName+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function save(){
		
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=typeCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=typeName]').val())){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'save')){
					params.method = 'save';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'edit')){
					params.method = 'edit';
					params.typeId = $('div[name=addEditData] input[name=typeCode]').attr('typeId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.typeCode = $('div[name=addEditData] input[name=typeCode]').val();
					params.typeName = $('div[name=addEditData] input[name=typeName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/type.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=typeCode]').attr('typeId', '')
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
			 $('div[name=addEditData] input[name=typeCode]').val($('tbody tr[typeId="'+value+'"] td[name=typeCode]').html());
			 $('div[name=addEditData] input[name=typeName]').val($('tbody tr[typeId="'+value+'"] td[name=typeName]').html());
			 $('div[name=addEditData] input[name=typeCode]').attr('typeId', value);
		 }
		 
		 
		 function deleteRow(value){
			 if(BeanUtils.isNotEmpty(value)){
				 var params = {method: 'delete', typeId: value};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/type.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        	}
			        });
			 }
		 }
		 
		
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param,'save')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='typeCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='typeName']").prop('disabled', false);
				}else if(BeanUtils.equals(param,'edit')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='typeCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='typeName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='typeCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='typeName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='typeCode']").val('');
			 $("div[name='addEditData'] input[name='typeName']").val('');
			 if(BeanUtils.equals(param, 'save')){
				 $("div[name='statusSave']").attr('mode', 'save');
			 }else if(BeanUtils.equals(param, 'edit')){
				 $("div[name='statusSave']").attr('mode', 'edit');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	