		$(document).ready(function(){
   	    	BSBaseTable.callFiterTable();
   	    	searchFunction();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/unit.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr unitId="'+value.unitId+'"><td>'+
						                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.unitId+'")> '+
												 '<span class="glyphicon glyphicon-pencil"></span> '+
												'</button> '+
												'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.unitId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span>'+
												'</button> '+
											'</td> '+
					                        '<td name=unitCode>'+value.unitCode+'</td> '+
					                        '<td name=unitName>'+value.unitName+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function save(){
		
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=unitCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=unitName]').val())){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'save')){
					params.method = 'save';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'edit')){
					params.method = 'edit';
					params.typeId = $('div[name=addEditData] input[name=typeCode]').attr('typeId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.unitCode = $('div[name=addEditData] input[name=unitCode]').val();
					params.unitName = $('div[name=addEditData] input[name=unitName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/unit.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=unitCode]').attr('unitId', '')
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
			 $('div[name=addEditData] input[name=unitCode]').val($('tbody tr[unitId="'+value+'"] td[name=unitCode]').html());
			 $('div[name=addEditData] input[name=unitName]').val($('tbody tr[unitId="'+value+'"] td[name=unitName]').html());
			 $('div[name=addEditData] input[name=unitCode]').attr('unitId', value);
		 }
		 
		 
		 function deleteRow(value){
			 if(BeanUtils.isNotEmpty(value)){
				 var params = {method: 'delete', unitId: value};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/unit.html"
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
					$("div[name='addEditData'] input[name='unitCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='unitName']").prop('disabled', false);
				}else if(BeanUtils.equals(param,'edit')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='unitCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='unitName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='unitCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='unitName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='unitCode']").val('');
			 $("div[name='addEditData'] input[name='unitName']").val('');
			 if(BeanUtils.equals(param, 'save')){
				 $("div[name='statusSave']").attr('mode', 'save');
			 }else if(BeanUtils.equals(param, 'edit')){
				 $("div[name='statusSave']").attr('mode', 'edit');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	