$(document).ready(function(){
		
	 var params = {method:'Type'};
 	BSBaseComboBox. getType(params,function(data){
   	$("div select[name=typeList]").html(data).selectpicker('refresh');
	

       });
 	
	  
	    	    var params2 = {method:'Allmaterial'};
	    	    BSBaseComboBox.getMaterial(params2,function(data){
	    	    	$("div select[name=materialList]").html(data).selectpicker('refresh');
	    
	    	  });
	    
	  searchFunction();
	  searchExportMaterial();
			   
    });




function searchFunction(){
		    	$.ajax({
		        	type: 'POST'
		        	, url: application.contextPath+"/ExportMaterial.html"
		        	, data: {method: 'search', requestMaterialId:headerId}
		        	, success: function(result){			        		
		            	var json = $.parseJSON(result);
		            	var data = [];		         
		            		$.each(json, function(index, value) {
		            			 data.push('<tr><td>'+
										  '<button type="button" id="button'+value.materialId+'" class="btn btn-default btn-xs" onclick=selectRow("'+value.materialId+'")> '+
											'<span class="glyphicon glyphicon-minus"></span> '+
									     	'</button> '+
									      '</td> '+
			            				    '<td name=typeName>'+value.typeName+'</td> '+
					                        '<td name=materialName>'+value.materialName+'</td> '+
					                        '<td name=descrition>'+value.descrition+'</td> '+
					                        '<td name=quantityOrder>'+value.quantityRequest+'</td> '+
					                        '<td name=anotation>'+value.unitName+'</td></tr>');
			            	});
		            	$('table.table tbody').html(data.join());	
		            
		        	}
		        });
	    }

function selectRow(value){
	disAndEnInputField('create');
	var params = {method: 'searchMaterial', materialId:value};
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/ExportMaterial.html"
    	, data: params
    	, success: function(result){
        	var json = $.parseJSON(result);
        	$("div[name='addEditData'] select[name='typeList']").val(json[0].typeId).selectpicker('refresh'); 
        	$("div[name='addEditData'] select[name='materialList']").val(json[0].materialId).selectpicker('refresh');
        	$("div[name='addEditData'] input[name='totalQuatity']").val(json[0].totalQuatity);
        	  document.getElementById("button"+value).style.visibility = "hidden";

    	}
    });
}	

function Save(){
	 if( BeanUtils.isNotEmpty($('div[name=addEditData] input[name=exportQuantity]').val())){				                                                     		
		var params = {};
		var message = ""
				
		if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
			params.method = 'save';
			message = "Export One Material!!"
			
		}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
			params.method ='edit';				
			message = "updateMaterial success!!"
		}
		if(BeanUtils.isNotEmpty(params.method)){
			params.requestMaterialId = headerId
			params.materialId = $('div[name=addEditData] select[name=materialList]').val();
			params.exportQuantity = $('div[name=addEditData] input[name=exportQuantity]').val();
			
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/ExportMaterial.html"
	        	, data: params
	        	, success: function(result){
	        		alert(message);
	        		 searchExportMaterial();
	        					        		
	        	}
	    	      
	        });
		}
	 }
}

function  searchExportMaterial(){
	
	var params = {method: 'searchExport',requestMaterialId:headerId};
	$.ajax({
    	type: 'POST'
    	, url: application.contextPath+"/ExportMaterial.html"
    	, data: params
    	, success: function(result){			        		
        	var json = $.parseJSON(result);
        	var data = [];
        	
        	$.each(json, function(index, value) {        		          		
        		  data.push('<tr>'+
        				  '<td></td>'+
	                        '<td name=materialName>'+value.materialName+'</td> '+
	                        '<td name=descrition>'+value.descrition+'</td> '+
	                        '<td name=exportQuantity>'+value.exportQuantity+'</td> '+      
	                        '<td name=unitName>'+value.unitName+'</td></tr>');
        	});
        	$('table.table-condensed  tbody').html(data.join());	
        
    	}
    });
	
}







function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'create')){
		 	createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', true).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  true).selectpicker('refresh');
			$("div[name='addEditData'] input[name='exportQuantity']").prop('disabled', false);

		}else if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='materialList']").prop('disabled',  false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='exportQuantity']").prop('disabled',  false);
		}else{
			createOrUpdateMode(param);
			$("div[name='addEditData'] select[name='typeList']").prop('disabled', true);
			$("div[name='addEditData'] select[name='materialList']").prop('disabled', true);
			$("div[name='addEditData'] input[name='exportQuantity']").prop('disabled',  true);
		}
	 
}

function createOrUpdateMode(param){	
	   	
		$("div[name='addEditData'] select[name='typeList']").val('');
		$("div[name='addEditData'] select[name='materialList']").val('');
		$("div[name='addEditData'] input[name='exportQuantity']").val('');

	 if(BeanUtils.equals(param, 'create')){
		 $("div[name='statusSave']").attr('mode', 'create');
	 }else if(BeanUtils.equals(param, 'update')){
		 $("div[name='statusSave']").attr('mode', 'update');
	 }else{
		 $("div[name='statusSave']").attr('mode', '');
	 }
}

