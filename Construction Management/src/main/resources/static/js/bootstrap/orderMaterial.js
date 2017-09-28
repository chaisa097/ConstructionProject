		$(document).ready(function(){

		
	 	BSBaseTable.callFiterTable();
	    	searchFunction();
	    	
	    	
	    	n =  new Date();
	    	y = n.getFullYear();
	    	m = n.getMonth() + 1;
	    	d = n.getDate();
	    	document.getElementById("date").innerHTML = d  + "/" + m + "/" + y;
	    	
	    	
    });


	    
		 function searchFunction(){
		    		var params = {method: 'search'};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/OrderMaterial.html"
			        	, data: params
			        	, success: function(result){			        		
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	
			            	$.each(json, function(index, value) {
			            		
			            		var d2 = new Date(value.orderMaterialDate),
				    	        month = '' + (d2.getMonth() + 1),
				    	        day = '' + d2.getDate(),
				    	        year = d2.getFullYear();

				            	if (month.length < 2) month = '0' + month;
				            	if (day.length < 2) day = '0' + day;

				            	var date = [day, month, year].join('/');
			         			            		
			            		  data.push('<tr orderMaterialId="'+value.orderMaterialId+'"><td>'+
                   
												 '<a href='+domainSystem+'/orderMaterialDetail.html?orderMaterialId='+value.orderMaterialId+' class="btn btn-success btn-xs"> '+
			    								    '<span class="glyphicon glyphicon-plus"></span>  Material'+
			    							      	'</a> '+
			    							      	
													'<a href='+domainSystem+'/viewOrder.html?orderMaterialId='+value.orderMaterialId+' class="btn btn-info btn-xs"> '+
			    							      	'<span class="glyphicon glyphicon-eye-open"></span> Send'+
			    							      	'</a> '+
											'</td> '+
					                        '<td name=orderMaterialNo>'+value.orderMaterialNo+'</td> '+
					                        '<td name=status>'+value.status+'</td> '+
					                        '<td name=orderMaterialDate>'+(date)+'</td> '+
					                        
					                        '<td>'+'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.orderMaterialId+'")> '+
											 '<span class="glyphicon glyphicon-pencil"></span> '+
												'</button> '+
												'<button type="button" class="btn btn-danger btn-xs"  onclick=deleteRow("'+value.orderMaterialId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span>'+
												'</button> '+'</td></tr>');
			            	});
			            	$('table.table tbody').html(data.join());	
			            
			        	}
			        });
		    }


function Save(){
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] textarea[name=address]').val())){				                                                     		
				var params = {};
				var message = ""
					params.method = 'save';
					message = "create success!!"
				 if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					message = "update success!!"
				}
				
				if(BeanUtils.isNotEmpty(params.method)){				
					params.address = $('div[name=addEditData] textarea[name=address]').val();
						
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/OrderMaterial.html"
			        	, data: params
			        	, success: function(result){
			        		alert(message);
			        		searchFunction();
			        		 disAndEnInputField('');
			        	}
			        });
				}
			 }
		 }




function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
			$("div[name='addEditData'] input[name='orderMaterialDate']").prop('disabled', false);
			$("div[name='addEditData'] input[name='orderMaterialNo']").prop('disabled', true);
			$("div[name='addEditData'] input[name='status']").prop('disabled', true);
			$("div[name='addEditData'] textarea[name='address']").prop('disabled', false);
		}else{
			createOrUpdateMode(param);
			$("div[name='addEditData'] input[name='orderMaterialDate']").prop('disabled', false);
			$("div[name='addEditData'] input[name='orderMaterialNo']").prop('disabled', true);
			$("div[name='addEditData'] input[name='status']").prop('disabled', true);
			$("div[name='addEditData'] textarea[name='address']").prop('disabled', false);
		}
}

function createOrUpdateMode(param){	
	   	
		$("div[name='addEditData'] input[name='orderMaterialDatel']").val('');
		$("div[name='addEditData'] input[name='orderMaterialNo']").val('');
		$("div[name='addEditData'] input[name='status']").val('');
	    $("div[name='addEditData'] textarea[name='address']").val('');	 
		 
 if(BeanUtils.equals(param, 'update')){
		 $("div[name='statusSave']").attr('mode', 'update');
	 }else{
		 $("div[name='statusSave']").attr('mode', '');
	 }
}

