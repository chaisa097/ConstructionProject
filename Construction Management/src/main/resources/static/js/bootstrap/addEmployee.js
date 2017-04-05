$(document).ready(function(){

	
	BSBaseComboBox.getEmployee({method:'employee'} ,function(data){
	   	$("div select[name=employeeList]").html(data).selectpicker('refresh');
	});
	     
	$.ajax({
	  	type: 'POST'
	  	, url: application.contextPath+"/addEmployee.html"
	  	, data: {method:'search', projectId:headerId}
	  	, success: function(result){
	    	var json = $.parseJSON(result);
	      	$("input[name='projectName']").val(json[0].projectName);
	          
	  	}
	  });

	 		
	seachWorker(); 
    BSBaseTable.callFiterTable();

});

//function searchFunction(){
//	
//	var params = {method: 'searchWorker'};
//	params.projectId = headerId;
//	$.ajax({
//    	type: 'POST'
//    	, url: application.contextPath+"/addEmployee.html"
//    	, data: params
//    	, success: function(result){
//        	var json = $.parseJSON(result);
//        	var data = [];
//        	$.each(json, function(index, value) {
//        	
//        		  data.push('<tr workingId="'+value.workingId+'"><td>'+
//		                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.workingId+'")> '+
//								 '<span class="glyphicon glyphicon-pencil"></span> Edit '+
//								'</button> '+
//								'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.workingId+'")> '+
//									'<span class="glyphicon glyphicon-trash"></span> Delete '+
//								'</button> '+
//							'</td> '+	   
//							 '<td >'+value.empFirstName+'</td>'+
//							 '<td >'+value.empLastName+'</td>'+
//							 '<td >'+value.employeeCode+'</td>'+
//	                        '<td >'+value.amountOfMonth+'</td></tr>');
//        	});
//        	$('table.table tbody').html(data.join());	
//        	
//    	}
//    });
//}

   function seachWorker(){
		
	$.ajax({
     	type: 'POST'
     	, url: application.contextPath+"/addEmployee.html"
     	, data: {method: 'searchWorker', projectId:headerId}
       
     	, success: function(result){
         	var json = $.parseJSON(result);
         	var data = [];
         	$.each(json, function(index, value) {
         	   
         		  data.push('<tr workingId="'+value.workingId+'"><td>'+
 		                    	'<button type="button" class="btn btn-primary btn-xs" onclick=editRow("'+value.workingId+'")> '+
 								 '<span class="glyphicon glyphicon-pencil"></span> Edit '+
 								'</button> '+
 								'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.workingId+'")> '+
 									'<span class="glyphicon glyphicon-trash"></span> Delete '+
 								'</button> '+
 							 '</td> '+	   
 							 '<td  id="empName" >'+value.empFirstName+' '+value.empLastName+'</td>'+
 							 '<td  id="employeeCode">'+value.depDetailName+'</td>'+
 							 '<td  id="salary">'+value.Salary+'</td>'+
 							 '<td  id="amountOfMonth">'+value.amountOfMonth+'</td>'+
 	                         '<td  id="totalSalary">'+(value.amountOfMonth*value.Salary)+'</td></tr>');
         		
         		  
         		  
         	});
         	$('table.table tbody').html(data.join());
         	calculate();
     	}
     }); 
	
	
}



function saveFunction(){
          
			 if( BeanUtils.isNotEmpty($('div[name=addEditData] select[name="employeeList').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] input[name=amountOfMonth]').val())){				                                                     		
				var params = {};
				var message = ""
						
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'create')){
					params.method = 'save';
					message = "AddEmployee success!!"
					
				}else if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					message = "updateEmployee success!!"
				}
				
				  	
				if(BeanUtils.isNotEmpty(params.method)){			
					params.projectId = headerId
					params.amountOfMonth = $('div[name=addEditData] input[name=amountOfMonth]').val();
					params.employeeId = $('div[name=addEditData] select[name="employeeList"]').val();
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/addEmployee.html"
			        	, data: params
			        	, success: function(result){
			        		alert(message);
			        		seachWorker()
			        	
			        					        		
			        	}
			    	      
			        });
				}
			 }
		 }


function deleteRow(value){
	 confirm("Delete!");
	 if(BeanUtils.isNotEmpty(value)){
		 var params = {method: 'delete', workingId: value};
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/addEmployee.html"
	        	, data: params
	        	, success: function(result){
	        		seachWorker(); 
	        	}
	        });
	 }
}


    
 function calculate(){		 
	 var totalSalary = 0;
		$("table.table tbody tr").each(function(){
			var value = $(this).find("#totalSalary").html();
			 totalSalary += (value*1);						
		});

		var params = {method: 'UpdateTotalSalary',projectId:headerId};
		
		if(BeanUtils.isNotEmpty(params.method)){			
			params.totalHireEmployee  = totalSalary
	    	$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/addEmployee.html"
	        	, data: params
	        	, success: function(result){	        			
	        		alert("calcuate Success");
	        					        		
	        	}
	        });
		}
	 
 }


 


function backFunction(){
	location.href = "listProjectPM.html";
	
	
}

function addRow(){			 
	 disAndEnInputField('create');
}

function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'create')){
		 	createOrUpdateMode(param);
			
			$("div[name='addEditData'] select[name='employeeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='amountOfMonth']").prop('disabled', false);
		
		}else if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
		
			
			$("div[name='addEditData'] select[name='employeeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='amountOfMonth']").prop('disabled', false);
		
		}else{
			createOrUpdateMode(param);
		
			$("div[name='addEditData'] select[name='employeeList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='amountOfMonth']").prop('disabled', false);
		
		}
}

function createOrUpdateMode(param){
	  
		$("div[name='addEditData'] select[name='employeeList']").val('').selectpicker('refresh');
		$("div[name='addEditData'] input[name='amountOfMonth']").val('');

	 if(BeanUtils.equals(param, 'create')){
		 $("div[name='statusSave']").attr('mode', 'create');
	 }else if(BeanUtils.equals(param, 'update')){
		 $("div[name='statusSave']").attr('mode', 'update');
	 }else{
		 $("div[name='statusSave']").attr('mode', '');
	 }
}



