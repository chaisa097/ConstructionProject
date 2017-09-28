$(document).ready(function(){
     
		 var params = {method:'Project'};
	    	BSBaseComboBox.getProject(params,function(data){
	      	$("div select[name=projectList]").html(data).selectpicker('refresh');
		
   	
    	});
	    	
	    	
	    	
	    	
	    	BSBaseTable.callFiterTable();  	
});

function search(){
	
	if(BeanUtils.isNotEmpty($('div#roleHeader select[name="projectList"] option:selected').val())){
	
	var params = {method: 'searchRequest',projectId: $('div#roleHeader select[name="projectList"] option:selected').val()};
	//param.projectId = headerId
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/requestMaterialStock.html"
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
        				  '<a href='+domainSystem+'/ExportMaterial.html?requestMaterialId='+value.requestMaterialId+' class="btn btn-Success btn-xs"> '+
						  'Export  Material '+
						   '</a> '+	
	                        '<td name=projectName>'+value.projectName+'</td> '+
	                        '<td name=projectName>'+value.requestMaterialNo+'</td> '+
	                        '<td name=status>'+value.status+'</td>'+
	                        '<td name=requestDate>'+date+'</td></tr>');
        	});
        	$('table.table tbody').html(data.join());	
        
    	}
    });
   }
}