$(document).ready(function(){
	
	BSBaseComboBox.getDepartment({method:'department'} ,function(data){
	   	$("div select[name=departmentList]").html(data).selectpicker('refresh');
	});
	
	
	
	
   	    	BSBaseTable.callFiterTable();
   	    	searchFunction();
	    });
	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/departmentdetail.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json, function(index, value) {
			            		  data.push('<tr depDetailId="'+value.depDetailId+'"><td>'+
						                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.depDetailId+'")> '+
												 '<span class="glyphicon glyphicon-pencil"></span> '+
												'</button> '+
												'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.depDetailId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span>'+
												'</button> '+
											'</td> '+
					                        '<td name=departmentCode>'+value.departmentCode+'</td> '+
					                        '<td name=depDetailName>'+value.depDetailName+'</td> '+
					                        '<td name=Salary>'+value.Salary+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			  
			        	}
			        });
		    }
		 
		 function save(){
		
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=depDetailName]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=Salary]').val())){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'save')){
					params.method = 'save';
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'edit')){
					params.method = 'edit';
					params.depDetailId = $('div[name=addEditData] input[name=depDetailName]').attr('depDetailId');
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.departmentId = $('div[name=addEditData] select[name="departmentList"]').val();
					params.depDetailName = $('div[name=addEditData] input[name=depDetailName]').val();
					params.Salary = $('div[name=addEditData] input[name=Salary]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/departmentdetail.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction();
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
		    	var params = {method: 'searchDepartmentforUpdate', depDetailId: value};
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/departmentdetail.html"
		        	, data: params
		        	, success: function(result){
		            	var json = $.parseJSON(result);
		            	$("div[name='addEditData'] input[name='Salary']").val(json[0].Salary);
		            	$("div[name='addEditData'] input[name='depDetailName']").val(json[0].depDetailName);
		            	$("div[name='addEditData'] select[name='departmentList']").val(json[0].departmentId).selectpicker('refresh');
		                $('div[name=addEditData] input[name=depDetailName]').attr('depDetailId', value);
		        	}
		        });
		    }
			 
			 
			 
			 
			
		
		 
		 
		 function deleteRow(value){
			 if(BeanUtils.isNotEmpty(value)){
				 var params = {method: 'delete', depDetailId: value};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/departmentdetail.html"
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
					$("div[name='addEditData'] select[name='departmentList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='depDetailName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='Salary']").prop('disabled', false);
				}else if(BeanUtils.equals(param,'edit')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='departmentList']").prop('disabled', false).selectpicker('refresh');
					$("div[name='addEditData'] input[name='depDetailName']").prop('disabled', false);
					$("div[name='addEditData'] input[name='Salary']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] select[name='departmentList']").prop('disabled',true).selectpicker('refresh');
					$("div[name='addEditData'] input[name='depDetailName']").prop('disabled', true);
					$("div[name='addEditData'] input[name='Salary']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
				$("div[name='addEditData'] select[name='departmentList']").prop('disabled', false).selectpicker('refresh');
			 $("div[name='addEditData'] input[name='depDetailName']").val('');
			 $("div[name='addEditData'] input[name='Salary']").val('');
			 if(BeanUtils.equals(param, 'save')){
				 $("div[name='statusSave']").attr('mode', 'save');
			 }else if(BeanUtils.equals(param, 'edit')){
				 $("div[name='statusSave']").attr('mode', 'edit');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	