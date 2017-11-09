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
	      	$("#projectName").html(json[0].projectName);
	      	 var  totalHire =json[0].totalHireEmployee.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");	
	      	$("#totalHireEmployee").html(totalHire);  
	  	}
	  });
	$('#amountOfmonth').on('input', function() {
		
		var numInput = document.querySelector('#amountOfmonth');

		// Listen for input event on numInput.
		numInput.addEventListener('input', function(){
		    // Let's match only digits.
		    var num = this.value.match(/^\d+$/);
		    if (num === null) {
		        // If we have no match, value will be empty.
		        this.value = "";
		    }
		}, false)
		
			var input=$(this);
			var is_name=input.val();
			if(is_name){input.removeClass("invalid").addClass("valid");}
			else{input.removeClass("valid").addClass("invalid");}
			
	    
			
		});
	searchFunction();
    BSBaseTable.callFiterTable();

});

function searchFunction(){
	
$.ajax({
 	type: 'POST'
 	, url: application.contextPath+"/addEmployee.html"
 	, data: {method: 'searchWorker',projectId:headerId}
   
 	, success: function(result){
     	var json = $.parseJSON(result);
     	var data = [];
     	$.each(json, function(index, value) {
     		  data.push('<tr workingId="'+value.workingId+'"><td>'+
								'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.workingId+'")> '+
									'<span class="glyphicon glyphicon-trash"></span>'+
								'</button> '+
							 '</td> '+	   
							 '<td  id="empName" >'+value.empFirstName+' '+value.empLastName+'</td>'+
							 '<td  id="employeeCode">'+value.depDetailName+'</td>'+
							 '<td  id="salary">'+value.Salary+'</td>'+
							 '<td  id="amountOfMonth">'+value.amountOfMonth+'/'+'month' + '</td>'+
	                         '<td  id="totalSalary" style="text-align:right" >'+(value.amountOfMonth*value.Salary)+'</td></tr>');
	  
     	});
     	
     	$('table.table tbody').html(data.join());
    	calculate();
 	}
 }); 

}

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
 								'<button type="button" class="btn btn-danger btn-xs" onclick=deleteRow("'+value.workingId+'")> '+
 									'<span class="glyphicon glyphicon-trash"></span> '+
 								'</button> '+
 							 '</td> '+	   
 							 '<td  id="empName" >'+value.empFirstName+' '+value.empLastName+'</td>'+
 							 '<td  id="employeeCode">'+value.depDetailName+'</td>'+
 							 '<td  id="salary">'+value.Salary+'</td>'+
 							 '<td  id="amountOfMonth">'+value.amountOfMonth+'</td>'+
 	                         '<td  id="totalSalary" style="text-align:right">'+(value.amountOfMonth*value.Salary)+'</td></tr>');
         		
         		  
         		  
         	});
         	$('table.table tbody').html(data.join());calculate();
         	
         	location.reload();
       
     	}
     }); 
	
	
}



function save(){
          
			 if( BeanUtils.isNotEmpty($('div[name=addEditData] select[name=employeeList]').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] input[name=amountOfMonth]').val())){				                                                     		
				var params = {};
				var message = ""
						
				
					params.method ='save';
					message = "AddEmployee success!!"
					
			 if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
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
			        		seachWorker(); 
			        	
			        					        		
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
			        		
	        	}
	        });
		}
	 
 }


 


function back(){
	location.href = "listProjectPM.html";
	
	
}



function disAndEnInputField(param){
    if(BeanUtils.equals(param, 'update')){
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


