		$(document).ready(function(){
			
			 var params = {method:'role'};
		    	BSBaseComboBox.getRole(params,
		    			 function(data){
		      	$("div select[name=roleList]").html(data).selectpicker('refresh');
			
   	   	
   	    	});
   	   	    	    
		    	
		    	 var params = {method:'Allemployee'};
		 	     BSBaseComboBox.getAllEmployee(params,
		 	    			 function(data){
		 	   	$("div select[name=employeeList]").html(data).selectpicker('refresh');
	   	   	
	   	   	
	   	   	
	   	    	});
   	      		BSBaseTable.callFiterTable();
		   });
	      
   	   	
		  
		
		
	    function search(){
	    	if(BeanUtils.isNotEmpty($('div#roleHeader select[name="roleList"] option:selected').val())){
	    		var params = {method:'search', roleId: $('div#roleHeader select[name="roleList"] option:selected').val()};
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/register.html"
		        	, data: params
		        	, success: function(result){
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr><td>'+
					                    	'<button type="button"  style="margin-top:5px;"class="btn btn-primary btn-xs" onclick=editRow("'+value.userId+'")> '+
												'<span class="glyphicon glyphicon-pencil"></span>'+
											'</button> '+
											'<button type="button" style="margin-top:5px;" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.userId+'")> '+
												'<span class="glyphicon glyphicon-trash"></span> '+
											'</button> '+
										'</td> '+
										'<td>'+value.empFirstName+'</td> '+	
				                        '<td>'+value.empLastName+'</td> '+
				                        '<td>'+value.userName+'</td> '+	
				                        '<td>'+value.role+'</td></tr>');
		            	});
		            	$('table.table tbody').html(data.join());		  
		        	}
		        });
	    	}
	    }
	    
	    function SaveFunction(){
	    	var params = {};
	    	if(BeanUtils.equals($("div[name='addEditData'] input[name='password']").val(), $("div[name='addEditData'] input[name='rePassword']").val())){	    		
	    		params.method = 'save';
	    		message = "create employee success!!"
	    	if(BeanUtils.equals($("div[name='statusSave']").attr('status'), 'update')){
	    				params.method = 'edit';
	    			
		    		}
	    			var roleId = $("div[name='addEditData'] select[name='roleList']").val();
	    			params.employeeId = $("div[name='addEditData'] select[name='employeeList']").val(); 
	    			params.userName = $("div[name='addEditData'] input[name='name']").val();
	    			params.password = $("div[name='addEditData'] input[name='password']").val();
	    			params.roleId = roleId;
	    		
	    			};
		    		$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/register.html"
			        	, data: params
			        	, success: function(result){		        
			        		$('div#roleHeader select[name="roleList"]').val(roleId).selectpicker('refresh');
			        		alert(message);
			        		clearValue();
			        		search();
			        		disAndEnInputField();
			        	}
			        });
	    		}
	    
	    function editRow(value){
	    	disAndEnInputField('update');
	    	var params = {method: 'search', userId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/register.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	$("div[name='addEditData'] input[name='name']").val(json[0].userName);
	            	$("div[name='addEditData'] input[name='password']").val(json[0].password);
	            	$("div[name='addEditData'] input[name='rePassword']").val(json[0].password);
	            	$("div[name='addEditData'] select[name='roleList']").val(json[0].roleId).selectpicker('refresh');
	            	$("div[name='addEditData'] select[name='employeeList']").val(json[0].employeeId).selectpicker('refresh');
	        	}
	        });
	    }
	    
		function deleteRow(value){
			var params = {method: 'delete', userId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/register.html"
	        	, data: params
	        	, success: function(result){
	        		search();
	        	}
	        });
	    }
		
		
		
		function backFunction(){
			location.href = "home.html";
		}
		
		function disAndEnInputField(param){
			clearValue();
			if(BeanUtils.equals(param, 'update')){
				$("div[name='statusSave']").attr('status', param);
				$("div[name='addEditData'] input[name='name']").prop('disabled', true);
				$("div[name='addEditData'] input[name='password']").prop('disabled', false);
				$("div[name='addEditData'] input[name='rePassword']").prop('disabled', false);
				$("div[name='addEditData'] select[name='roleList']").prop('disabled', false).selectpicker('refresh');
				$("div[name='addEditData'] select[name='employeeList']").prop('disabled', false).selectpicker('refresh');
			}
		}
		
		function clearValue(){
			$("div[name='statusSave']").attr('status', '');
			$("div[name='addEditData'] input[name='name']").val('');
        	$("div[name='addEditData'] input[name='password']").val('');
        	$("div[name='addEditData'] input[name='rePassword']").val('');
        	$("div[name='addEditData'] select[name='roleList']").val('').selectpicker('refresh');
        	$("div[name='addEditData'] select[name='employeeList']").val('').selectpicker('refresh');
		}
