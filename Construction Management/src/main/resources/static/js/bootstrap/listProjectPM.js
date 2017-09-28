$(document).ready(function(){
     
		 var params = {method:'province'};
	    	BSBaseComboBox.getprovince(params,function(data){
	      	$("div select[name=provinceList]").html(data).selectpicker('refresh');
		
   	
    	});
   	    	    
	    	
	    	var params = {method: 'search',provinceId: $('div#roleHeader select[name="provinceList"] option:selected').val()};
	    	//param.projectId = headerId
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/listProjectPM.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = [];
	            	$.each(json, function(index, value) {
	            		  data.push('<tr projectId="'+value.projectId+'"><td>'+			
//	    								'<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' class="btn btn-Success btn-xs"> '+
//	    								  '<span class="glyphicon glyphicon-plus"></span>Employee '+
//	    								'</a> '+	
//	    								
//	    								'<a href='+domainSystem+'/listRequestMaterialPM.html?projectId='+value.projectId+' class="btn btn-warning btn-xs"> '+
//	    								  '<span class="glyphicon glyphicon-list-alt"></span> Approve RequestMaterial'+
//	    								'</a> '+	
//	    								'<a href='+domainSystem+'/editStatusProject.html?projectId='+value.projectId+' class="btn btn-primary btn-xs"> '+
//	    								'<span class="glyphicon glyphicon-hourglass"></span>Progress '+
//	    								'</a> '+
//	    								
//	    								'<a href='+domainSystem+'/listExportMaterial.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
//	    								  '<span class="glyphicon glyphicon-eye-open"></span> Material Used'+
//	    							    	'</a> '+	
//	    								
//	    								'<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
//	    								  '<span class="glyphicon glyphicon-eye-open"></span> Project'+
//	    								'</a> '+	
	    								'<ul style="margin-top:1px;" class="nav navbar-nav">'+
	    						        '<li class="dropdown">'+
	    						          '<a href="#" class="dropdown-toggle" data-toggle="dropdown" >'+'<span style="font-size:20px;margin-top:-10px;" class="glyphicon glyphicon-th-list pull-right"></span>'+'</a>'+
	    						          '<ul class="dropdown-menu">'+
	    						          '<li>'+ '<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' > '+
	    								  '<span class="glyphicon glyphicon-eye-open"></span>Project '+
	    								'</a> '+'</li>'+
    						             ' <li class="divider">'+'</li>'+
    						             '<li>'+ '<a href='+domainSystem+'/listExportMaterial.html?projectId='+value.projectId+' > '+
	    								  '<span class="glyphicon glyphicon-eye-open"></span>Material Used '+
	    								'</a> '+'</li>'+
   						              ' <li class="divider">'+'</li>'+
	    						            '<li>'+ '<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' > '+
		    								  '<span class="glyphicon glyphicon-plus"></span>Employee '+
		    								'</a> '+'</li>'+
	    						           ' <li class="divider">'+'</li>'+
	    						           '<li>'+ '<a href='+domainSystem+'/listRequestMaterialPM.html?projectId='+value.projectId+' > '+
		    								  '<span class="glyphicon glyphicon-check"></span>Approve RequestMaterial '+
		    								'</a> '+'</li>'+
		    								 ' <li class="divider">'+'</li>'+
		    						           '<li>'+ '<a href='+domainSystem+'/editStatusProject.html?projectId='+value.projectId+' > '+
			    								  '<span class="glyphicon glyphicon-hourglass"></span>Progress '+
			    								'</a> '+'</li>'+
	    						          '</ul>'+
	    						        '</li>'+
	    						      '</ul>'+
	    							  
	    	                        '<td name=projectName>'+value.projectName+'</td> '+
	    	                        '<td name=provinceName>'+value.provinceName+'</td>'+
	    	                        '<td name=percentStatus>'+value.percentStatus+'%'+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            
	        	}
	        });
	    		    	
	    		 	   	 	     	
	BSBaseTable.callFiterTable();
	
	
});



function search(){
	
	if(BeanUtils.isNotEmpty($('div#roleHeader select[name="provinceList"] option:selected').val())){
	
	var params = {method: 'search',provinceId: $('div#roleHeader select[name="provinceList"] option:selected').val()};
	//param.projectId = headerId
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/listProjectPM.html"
    	, data: params
    	, success: function(result){
        	var json = $.parseJSON(result);
        	var data = [];
        	$.each(json, function(index, value) {
        		  data.push('<tr projectId="'+value.projectId+'"><td>'+
        				  '<ul style="margin-top:-15px;" class="nav navbar-nav">'+
					        '<li class="dropdown">'+
					          '<a href="#" class="dropdown-toggle" data-toggle="dropdown">'+'<span style="font-size:20px;" class="glyphicon glyphicon-th-list pull-right"></span>'+'</a>'+
					          '<ul class="dropdown-menu">'+
					          '<li>'+ '<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' > '+
							  '<span class="glyphicon glyphicon-eye-open"></span>Project '+
							'</a> '+'</li>'+
				             ' <li class="divider">'+'</li>'+
				             '<li>'+ '<a href='+domainSystem+'/listExportMaterial.html?projectId='+value.projectId+' > '+
							  '<span class="glyphicon glyphicon-eye-open"></span>Material Used '+
							'</a> '+'</li>'+
				              ' <li class="divider">'+'</li>'+
					            '<li>'+ '<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' > '+
								  '<span class="glyphicon glyphicon-plus"></span>Employee '+
								'</a> '+'</li>'+
					           ' <li class="divider">'+'</li>'+
					           '<li>'+ '<a href='+domainSystem+'/listRequestMaterialPM.html?projectId='+value.projectId+' > '+
								  '<span class="glyphicon glyphicon-check"></span>Approve RequestMaterial '+
								'</a> '+'</li>'+
								 ' <li class="divider">'+'</li>'+
						           '<li>'+ '<a href='+domainSystem+'/editStatusProject.html?projectId='+value.projectId+' > '+
  								  '<span class="glyphicon glyphicon-hourglass"></span>Progress '+
  								'</a> '+'</li>'+
					          '</ul>'+
					        '</li>'+
					      '</ul>'+
							
							
	                        '<td name=projectName>'+value.projectName+'</td> '+
	                        '<td name=provinceName>'+value.provinceName+'</td>'+
	                        '<td name=provinceName>'+value.percentStatus+'%'+'</td></tr>');
        	});
        	$('table.table tbody').html(data.join());	
        
    	}
    });
   }
}