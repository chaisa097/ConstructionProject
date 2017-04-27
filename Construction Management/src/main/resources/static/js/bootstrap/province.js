		
			var lastPage = "";
			var currentPage = 0;	
				$(document).ready(function(){   	    	
					   	     $('div #page-selection').bootpag({
					   	     total: 5,
					   	     page: 1,
					   	     maxVisible: 5,
					   	     leaps: true,
					   	     firstLastUse: true,
					   	     first: '←',
					   	     last: '→',
					   	     wrapClass: 'pagination',
					   	     activeClass: 'active',
					   	     disabledClass: 'disabled',
					   	     nextClass: 'next',
					   	     prevClass: 'prev',
					   	     lastClass: 'last',
					   	     firstClass: 'first'
						   	 }).on("page", function(event, page){
						   		 searchFunction(page-1,0);
						   		currentPage = page-1
						     });
							   	     
							   
							   	     
							   	  BSBaseTable.callFiterTable();
							   	  searchFunction(0,0);
								    });
			
	
	    
		 function searchFunction(page, frag){
		    		var params = {method: 'search',gridStore_start: (page*limitPerPage) , gridStore_limit: limitPerPage};
		    		
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/province.html"
			        	, data: params
			        	, success: function(result){
			            	var json = $.parseJSON(result);
			            	var data = [];
			            	$.each(json.records, function(index, value) {
			            		  data.push('<tr provinceId="'+value.provinceId+'"><td>'+
						                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.provinceId+'")> '+
												 '<span class="glyphicon glyphicon-pencil"></span> '+
												'</button> '+
												'<button type="button" id="btnDeleteProvince" class="btn btn-danger btn-xs"   data-toggle="modal" data-target=".bs-example-modal-sm" data-id="'+value.provinceId+'")> '+
													'<span class="glyphicon glyphicon-trash"></span>'+
												'</button> '+
											'</td> '+
					                        '<td name=provinceCode>'+value.provinceCode+'</td> '+
					                        '<td name=provinceName>'+value.provinceName+'</td></tr>');
			            	});
			            	
			            	/*Paging*/
			            	if(BeanUtils.isNotEmpty(json.totalRecord)){
			            		console.log(json.totalRecord);
			            		
			            		$('div #page-selection').bootpag({total: Math.ceil(json.totalRecord/limitPerPage), maxVisible: 5});
			            		
			            		lastPage = Math.ceil(json.totalRecord/limitPerPage)-1;
			            		if((json.totalRecord/limitPerPage) % 1 ==0){
			    
			            			lastPage = lastPage+1
			            		}
			            		
			            	}
			            	if(frag == 1){
			            		 $('div #page-selection').bootpag({page: page+1});
			            	}
			            	if(frag == 2){
			            		 $('div #page-selection').bootpag({page: 1});
			            	}
			            	
			            	
			            	
			            	$('table.table tbody').html(data.join());	
			            	disAndEnInputField('');
			        	}
			        });
		    }
		 
		 function save(){
		
			 if(BeanUtils.isNotEmpty($('div[name=addEditData] input[name=provinceCode]').val()) && BeanUtils.isNotEmpty($('div[name=addEditData] input[name=provinceName]').val())){
				var params = {};
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'save')){
					params.method = 'save';
				
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.provinceCode = $('div[name=addEditData] input[name=provinceCode]').val();
					params.provinceName = $('div[name=addEditData] input[name=provinceName]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/province.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction(lastPage,1);
			        		$('div[name=addEditData] input[name=provinceCode]').attr('provinceId', '')
			        		$("div#save").modal();
			        	}
			        });
			    	
			    	
			    	
			    	
				}
				
				}
				
				else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'edit')){
					params.method = 'edit';
					params.provinceId = $('div[name=addEditData] input[name=provinceCode]').attr('provinceId');
					
					if(BeanUtils.isNotEmpty(params.method)){
						params.provinceCode = $('div[name=addEditData] input[name=provinceCode]').val();
						params.provinceName = $('div[name=addEditData] input[name=provinceName]').val();
				    	$.ajax({
				        	type: 'POST'
				        	, url: application.contextPath+"/province.html"
				        	, data: params
				        	, success: function(result){
				        		searchFunction(currentPage,1);
				        		$('div[name=addEditData] input[name=provinceCode]').attr('provinceId', '')
				        		$("div#save").modal();
				        	}
				        });
				    	
				    	
				    	
				    	
					}
					
				}
				
				
			 }
		 }
		 
		 function addRow(){
			 disAndEnInputField('save');
		 }
		 
		 function editRow(value){
			 disAndEnInputField('edit');
			 $('div[name=addEditData] input[name=provinceCode]').val($('tbody tr[provinceId="'+value+'"] td[name=provinceCode]').html());
			 $('div[name=addEditData] input[name=provinceName]').val($('tbody tr[provinceId="'+value+'"] td[name=provinceName]').html());
			 $('div[name=addEditData] input[name=provinceCode]').attr('provinceId', value);
		 }
		 
		 $(document).on("click", "#btnDeleteProvince", function () {
			    var idRow = $(this).data('id');
			    $("div #modalDelete").attr("rowId", idRow);
			});
		 
		 function deleteRow(value){
				 var params = {method: 'delete', provinceId: $("div #modalDelete").attr("rowId")};
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/province.html"
			        	, data: params
			        	, success: function(result){
			        		searchFunction(currentPage,1);
			        	}
			        });
			 }
		 
		 
		 function backFunction(){
				location.href = "home.html";
		 }
		 
		 function disAndEnInputField(param){
			 if(BeanUtils.equals(param,'save')){
				 	createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='provinceCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='provinceName']").prop('disabled', false);
				}else if(BeanUtils.equals(param,'edit')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='provinceCode']").prop('disabled', false);
					$("div[name='addEditData'] input[name='provinceName']").prop('disabled', false);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='provinceCode']").prop('disabled', true);
					$("div[name='addEditData'] input[name='provinceName']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			 $("div[name='addEditData'] input[name='provinceCode']").val('');
			 $("div[name='addEditData'] input[name='provinceName']").val('');
			 if(BeanUtils.equals(param, 'save')){
				 $("div[name='statusSave']").attr('mode', 'save');
			 }else if(BeanUtils.equals(param, 'edit')){
				 $("div[name='statusSave']").attr('mode', 'edit');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }
	


