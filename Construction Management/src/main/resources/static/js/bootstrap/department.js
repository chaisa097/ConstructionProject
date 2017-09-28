		$(document).ready(function(){
   	    	BSBaseTable.callFiterTable();
   	    	searchFunction();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/department.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr departmentId="'+value.departmentId+'"><td>'+
						                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.departmentId+'")> '+
												 '<span class="glyphicon glyphicon-pencil"></span> '+
												'</button> '+
											'</td> '+
					                        '<td name=departmentCode>'+value.departmentCode+'</td> '+
					                        '<td name=departmentName>'+value.departmentName+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			           
			        	}
			        });
		    }
		 
		 function save(){
		
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=departmentCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=departmentName]').val())){
				var params = {};
					params.method = 'save';
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'edit')){
					params.method = 'edit';
					params.departmentId = $('div[name=addEditData] input[name=departmentCode]').attr('departmentId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.departmentCode = $('div[name=addEditData] input[name=departmentCode]').val();
					params.departmentName = $('div[name=addEditData] input[name=departmentName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/department.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
			        		$('div[name=addEditData] input[name=departmentCode]').attr('departmentId', '')
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
			 $('div[name=addEditData] input[name=departmentCode]').val($('tbody tr[departmentId="'+value+'"] td[name=departmentCode]').html());
			 $('div[name=addEditData] input[name=departmentName]').val($('tbody tr[departmentId="'+value+'"] td[name=departmentName]').html());
			 $('div[name=addEditData] input[name=departmentCode]').attr('departmentId', value);
		 }
		 
		 
		 function deleteRow(value){
			 if(BeanUtils.isNotEmpty(value)){
				 var params = {method: 'delete', departmentId: value};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/department.html"
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
		 if(BeanUtils.equals(param,'edit')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='departmentCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='departmentName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='departmentCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='departmentName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='departmentCode']").val('');
			 $("div[name='addEditData'] input[name='departmentName']").val('');
			 if(BeanUtils.equals(param, 'save')){
				 $("div[name='statusSave']").attr('mode', 'save');
			 }else if(BeanUtils.equals(param, 'edit')){
				 $("div[name='statusSave']").attr('mode', 'edit');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }