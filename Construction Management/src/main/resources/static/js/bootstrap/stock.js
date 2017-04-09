	$(document).ready(function(){
			
		 var params = {method:'Type'};
	    	BSBaseComboBox. getType(params,function(data){
	      	$("div select[name=typeList]").html(data).selectpicker('refresh');
		
	
 	});
   	      		BSBaseTable.callFiterTable();
		   });
	
	
	 function search(){
	    	if(BeanUtils.isNotEmpty($('div#roleHeader select[name="typeList"] option:selected').val())){
	    		var params = {method:'search', typeId: $('div#roleHeader select[name="typeList"] option:selected').val()};
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/stock.html"
		        	, data: params
		        	, success: function(result){
		            	var json = $.parseJSON(result);
		            	var data = [];
		            	$.each(json, function(index, value) {
		            		  data.push('<tr>'+
		            				   ' <td>'+value.typeName+'</td> '+	
				                        '<td>'+value.materialName+'</td> '+
				                        '<td>'+value.descrition+'</td> '+
				                        '<td>'+value.totalQuatity+'</td> '+	
				                        '<td>'+value.unitName+'</td></tr>');
		            	});
		            	$('table.table tbody').html(data.join());		  
		        	}
		        });
	    	}
	    }
	
	
	
	
	
	
	
	
	
	
	
	