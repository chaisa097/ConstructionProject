		$(document).ready(function(){

		
	    	searchFunction();
    });


function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/createRequestMaterial.html"
			        	, data: params
			        	, success: function(result){			        		
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	
			            	$.each(json, function(index, value) {
			            		
			            		var d2 = new Date(value.requestDate),
				    	        month = '' + (d2.getMonth() + 1),
				    	        day = '' + d2.getDate(),
				    	        year = d2.getFullYear();

				            	if (month.length < 2) month = '0' + month;
				            	if (day.length < 2) day = '0' + day;

				            	var date = [day, month, year].join('-');
			         			            		
			            		  data.push('<tr requestMaterialId="'+value.requestMaterialId+'"><td>'+
			            				     '<a href='+domainSystem+'/requestMaterialDetail.html?requestMaterialId='+value.requestMaterialId+' class="btn btn-success btn-xs"> '+
	    								    '<span class="glyphicon glyphicon-plus"></span>  Material'+
	    							      	'</a> '+
	    							      	'<a href='+domainSystem+'/viewRequestMaterial.html?requestMaterialId='+value.requestMaterialId+' class="btn btn-info btn-xs"> '+
	    							      	'<span class="glyphicon glyphicon-eye-open"></span> Send '+
	    							      	'</a> '+						          
											'</td> '+
					                        '<td name=orderMaterialNo>'+value.requestMaterialNo+'</td> '+
					                        '<td name=status>'+value.status+'</td> '+
					                        '<td name=requestDate>'+(date)+'</td> '+
					                        '<td >'+
												'<button type="button" class="btn btn-danger btn-xs"  onclick=deleteRow("'+value.requestMaterialId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span>'+
												'</button> '+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            
			        	}
			        });
		    }

function Save(){
			 if( BeanUtils.isNotEmpty($('div[name=addEditData] input[name=useMaterialDate]').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] textarea[name=contactOwner]').val())){				                                                     		
				var params = {};
				var message = ""
					params.method = 'save';
					message = "create success!!"
			        if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					message = "update success!!"
				   }
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.projectId = headerId
					params.useMaterialDate = $('div[name=addEditData] input[name=useMaterialDate]').val();				
					params.contactOwner = $('div[name=addEditData] textarea[name=contactOwner]').val();
						
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/createRequestMaterial.html"
			        	, data: params
			        	, success: function(result){
			        		alert(message);
			        		searchFunction();
			        	
			        	}
			        });
				}
			 }
}
		 

function addRow(){			 
	 disAndEnInputField('create');
}

function deleteRow(value){
	 if(BeanUtils.isNotEmpty(value)){
		 var params = {method: 'delete', requestMaterialId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/createRequestMaterial.html"
	        	, data: params
	        	, success: function(result){
	        		searchFunction();
	        	}
	        });
	 }
}


function disAndEnInputField(param){
	
	 if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
			$("div[name='addEditData'] input[name='useMaterialDate']").prop('disabled', false);
			$("div[name='addEditData'] textarea[name='contactOwner']").prop('disabled', false);
		}else{
			createOrUpdateMode(param);
			$("div[name='addEditData'] input[name='useMaterialDate']").prop('disabled', false);
			$("div[name='addEditData'] input[name='requestNo']").prop('disabled', true);
			$("div[name='addEditData'] input[name='status']").prop('disabled', true);
			$("div[name='addEditData'] textarea[name='contactOwner']").prop('disabled', false);
		}
}

function createOrUpdateMode(param){	
	   	
		$("div[name='addEditData'] input[name='useMaterialDate']").val('');
		$("div[name='addEditData'] input[name='requestNo']").val('');
		$("div[name='addEditData'] input[name='status']").val('');
	    $("div[name='addEditData'] textarea[name='contactOwner']").val('');	 
		 
	  if(BeanUtils.equals(param, 'update')){
		 $("div[name='statusSave']").attr('mode', 'update');
	 }else{
		 $("div[name='statusSave']").attr('mode', '');
	 }
}
function back(){
	location.href = "importMaterial.html";

}
