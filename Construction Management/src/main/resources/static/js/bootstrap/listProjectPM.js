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
	    		                    	'<button type="button" class="btn btn-primary btn-xs" onclick=viewRow("'+value.projectId+'")> '+
	    									'<span class="glyphicon glyphicon-pencil"></span> Edit '+
	    								'</button> '+
	    								'<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
	    								  '<span class="glyphicon glyphicon-eye-open"></span> View '+
	    								'</a> '+				
	    								'<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' class="btn btn-Success btn-xs"> '+
	    								  '<span class="glyphicon glyphicon-plus"></span> Add Employee '+
	    								'</a> '+	
	    							
	    							
	    	                        '<td name=projectName>'+value.projectName+'</td> '+
	    	                        '<td name=provinceName>'+value.provinceName+'</td></tr>');
	            	});
	            	$('table.table tbody').html(data.join());	
	            
	        	}
	        });
	    		    	
	    		 	   	 	     	
	BSBaseTable.callFiterTable();
	
	
});



function searchFunction(){
	
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
		                    	'<button type="button" class="btn btn-primary btn-xs" onclick=viewRow("'+value.projectId+'")> '+
									'<span class="glyphicon glyphicon-pencil"></span> Edit '+
								'</button> '+
								'<a href='+domainSystem+'/viewProject.html?projectId='+value.projectId+' class="btn btn-info btn-xs"> '+
								  '<span class="glyphicon glyphicon-eye-open"></span> View '+
								'</a> '+				
								'<a href='+domainSystem+'/addEmployee.html?projectId='+value.projectId+' class="btn btn-Success btn-xs"> '+
								  '<span class="glyphicon glyphicon-plus"></span> Add Employee '+
								'</a> '+	
							
							
	                        '<td name=projectName>'+value.projectName+'</td> '+
	                        '<td name=provinceName>'+value.provinceName+'</td></tr>');
        	});
        	$('table.table tbody').html(data.join());	
        
    	}
    });
}
}