	$(document).ready(function(){
			
		
   	   	    	    
   	      		BSBaseTable.callFiterTable();
		   });
	
	
//	 function searchFunction(){
//	    	if(BeanUtils.isNotEmpty($('div#roleHeader select[name="typeList"] option:selected').val())){
//	    		var params = {method:'search', roleId: $('div#roleHeader select[name="roleList"] option:selected').val()};
//		    	$.ajax({
//		        	type: 'POST'
//		        	, url: application.contextPath+"/register.html"
//		        	, data: params
//		        	, success: function(result){
//		            	var json = $.parseJSON(result);
//		            	var data = [];
//		            	$.each(json, function(index, value) {
//		            		  data.push('<tr><td>'+
//					                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.userId+'")> '+
//												'<span class="glyphicon glyphicon-pencil"></span> Edit '+
//											'</button> '+
//											'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.userId+'")> '+
//												'<span class="glyphicon glyphicon-trash"></span> Delete '+
//											'</button> '+
//										'</td> '+
//				                        '<td>'+value.userName+'</td> '+
//				                        '<td>'+value.role+'</td> '+	
//				                        '<td>'+value.empFirstName+'</td> '+	
//				                        '<td>'+value.empLastName+'</td></tr>');
//		            	});
//		            	$('table.table tbody').html(data.join());		  
//		        	}
//		        });
//	    	}
//	    }
	
	
	
	
	
	
	
	
	
	
	
	