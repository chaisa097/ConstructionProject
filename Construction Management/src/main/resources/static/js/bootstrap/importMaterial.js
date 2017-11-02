	$(document).ready(function(){
	
	 	    var params = {method: 'search'};
    		//param.projectId = headerId
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/importMaterial.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		  data.push('<tr projectId="'+value.projectId+'"><td>'+
										
										'<ul style="margin-top:1px;" class="nav navbar-nav">'+
	    						        '<li class="dropdown">'+
	    						          '<a href="#" class="dropdown-toggle" data-toggle="dropdown" >'+'<span style="font-size:10px;margin-top:-10px;" class="glyphicon glyphicon-menu-down pull-right"></span>' +'Manage' +'</a>'+
	    						          '<ul class="dropdown-menu">'+
	    						          '<li>'+ '<a href='+domainSystem+'/createRequestMaterial.html?projectId='+value.projectId+' > '+
	    								  '<span class="glyphicon glyphicon-folder-open"></span>Request Material '+
	    								'</a> '+'</li>'+
    						             ' <li class="divider">'+'</li>'+
    						             '<li>'+ '<a href='+domainSystem+'/listExportMaterialEngineer.html?projectId='+value.projectId+' > '+
	    								  '<span class="glyphicon glyphicon glyphicon-import"></span>Check Import Material '+
	    								'</a> '+'</li>'+
	    						          '</ul>'+
	    						        '</li>'+
	    						      '</ul>'+
										
										
			                        '<td name=projectName>'+value.projectName+'</td> '+
			                        '<td name=budget>'+value.budget.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'</td> '+
			                        '<td name=totalUseMaterial>'+value.totalUseMaterial.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",")+'  </td> '+
			                        '<td name=percentStatus>'+value.percentStatus+'%'+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            
	        	}
	        });	 	     
	 	   	 	
	BSBaseTable.callFiterTable();	
	
});
	
	
//		 function searchFunction(){
//		    		var params = {method: 'search'};
//		    		//param.projectId = headerId
//			    	$.ajax({
//			        	type: 'POST'
//			        	, url: application.contextPath+"/listProject.html"
//			        	, data: params
//			        	, success: function(result){
//			            	var json = $.parseJSON(result);
//			            	var data = [];
//			            	$.each(json, function(index, value) {
//			            		  data.push('<tr projectId="'+value.projectId+'"><td>'+
//						                    	'<button type="button" class="btn btn-info btn-xs" onclick=viewRow("'+value.projectId+'")> '+
//													'<span class="glyphicon glyphicon-eye-open"></span> viewInfor '+
//												'</button> '+
//												'<a href='+domainSystem+'/createProject.html?projectId='+value.projectId+' class="btn btn-primary btn-xs"> '+
//												  '<span class="glyphicon glyphicon-pencil"></span> Edit '+
//												'</a> '+				
//											'<button type="button" class="btn btn-danger btn-xs"  onclick=deleteRow("'+value.projectId+'")> '+
//											'<span class="glyphicon glyphicon-trash"></span> Delete '+
//										   '</button> '+
//											
//											
//					                        '<td name=projectName>'+value.projectName+'</td> '+
//					                        '<td name=provinceName>'+value.provinceName+'</td></tr>');
//			            	});
//			            	$('table.table tbody').html(data.join());	
//			            
//			        	}
//			        });
//		    }
		 
//		 function deleteRow(value){
//			if( confirm("Delete!")== true){
//			 if(BeanUtils.isNotEmpty(value)){
//				 var params = {method: 'delete', projectId: value};
//			    	$.ajax({
//			        	type: 'POST'
//			        	, url: application.contextPath+"/listProject.html"
//			        	, data: params
//			        	, success: function(result){
//			        	
//			        	}
//			        });
//			 }
//			}
//		 }
//		 
//		 function viewRow(value){		
//			 if(BeanUtils.isNotEmpty(value)){
//				 var params = {method: 'view', projectId: value};
//			    	$.ajax({
//			        	type: 'POST'
//			        	, url: application.contextPath+"/listproject.html"
//			        	, data: params
//			        	, success: function(result){
//			        		
//			        	}
//			        });
//			 }
//		 }
		
	function listRequestMaterial(){
		location.href = "listRequestMaterial.html";

	    }
		 
	
	function exportMaterialConfirm(){
		location.href = "exportMaterialConfirm.html";

	    }
		  