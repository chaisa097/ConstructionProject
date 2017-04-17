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
	    								'<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' class="btn btn-Success btn-xs"> '+
	    								  '<span class="glyphicon glyphicon-plus"></span>Employee '+
	    								'</a> '+	
	    								
	    								'<a href='+domainSystem+'/listRequestMaterialPM.html?projectId='+value.projectId+' class="btn btn-warning btn-xs"> '+
	    								  '<span class="glyphicon glyphicon-list-alt"></span> Approve RequestMaterial'+
	    								'</a> '+	
	    								'<a href='+domainSystem+'/editStatusProject.html?projectId='+value.projectId+' class="btn btn-primary btn-xs"> '+
	    								'<span class="glyphicon glyphicon-hourglass"></span>Progress '+
	    								'</a> '+
	    								
	    								'<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
	    								  '<span class="glyphicon glyphicon-eye-open"></span>'+
	    								'</a> '+	
	    							
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
        				  '<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' class="btn btn-Success btn-xs"> '+
						  '<span class="glyphicon glyphicon-plus"></span>Employee '+
						'</a> '+	
						
						'<a href='+domainSystem+'/listRequestMaterialPM.html?projectId='+value.projectId+' class="btn btn-warning btn-xs"> '+
						  '<span class="glyphicon glyphicon-list-alt"></span> Approve RequestMaterial'+
						'</a> '+	
						'<a href='+domainSystem+'/editStatusProject.html?projectId='+value.projectId+' class="btn btn-primary btn-xs"> '+
						'<span class="glyphicon glyphicon-hourglass"></span>Progress '+
						'</a> '+
						
						   '<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
						  '<span class="glyphicon glyphicon-eye-open"></span>'+
					    	'</a> '+	
							
							
	                        '<td name=projectName>'+value.projectName+'</td> '+
	                        '<td name=provinceName>'+value.provinceName+'</td>'+
	                        '<td name=provinceName>'+value.percentStatus+'%'+'</td></tr>');
        	});
        	$('table.table tbody').html(data.join());	
        
    	}
    });
   }
}