	$(document).ready(function(){
     
		 var params = {method:'province'};
	    	BSBaseComboBox.getprovince(params,function(data){
	      	$("div select[name=provinceList]").html(data).selectpicker('refresh');
		
   	
    	});
   	    	    
	    	
	    	 var params = {method:'projectManger'};
	 	     BSBaseComboBox.getProjectManager(params,function(data){
	 	   	$("div select[name=employeeList]").html(data).selectpicker('refresh');
	   	
	   	
	   	
	    	});
	 		 if( BeanUtils.isNotEmpty(headerId)){				     
	 	    var params = {method: 'searchData'};
			 disAndEnInputField('update');
			params.projectId = headerId;
	  	$.ajax({
	      	type: 'POST'
	      	, url: application.contextPath+"/createProject.html"
	      	, data: params
	      	, success: function(result){
	        	var json = $.parseJSON(result);
	        	
	        	
	        	var d = new Date(json[0].startDate),
	            month = '' + (d.getMonth() + 1),
	            day = '' + d.getDate(),
	            year = d.getFullYear();

	        if (month.length < 2) month = '0' + month;
	        if (day.length < 2) day = '0' + day;

	        var startDate = [year, month, day].join('-');
	        
	        var d2 = new Date(json[0].finishDate),
	        month = '' + (d2.getMonth() + 1),
	        day = '' + d2.getDate(),
	        year = d2.getFullYear();

	    if (month.length < 2) month = '0' + month;
	    if (day.length < 2) day = '0' + day;

	    var finishdate = [year, month, day].join('-');
		$("#projectName").html(json[0].projectName); 
		$("#Status").html(json[0].percentStatus);
		  var  TotalEx =json[0].totalExpense.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
		$("#Expense").html(TotalEx);
	  	$("div[name='addEditData'] textarea[name='description']").val(json[0].description);
	  	$("div[name='addEditData'] textarea[name='address']").val(json[0].address);
	  	$("div[name='addEditData'] select[name='provinceList']").val(json[0].provinceId).selectpicker('refresh');
	  	$("div[name='addEditData'] select[name='employeeList']").val(json[0].employeeId).selectpicker('refresh');
	  	$("div[name='addEditData'] input[name='percentStatus']").val(json[0].percentStatus);
	  	$("div[name='addEditData'] input[name='startDate']").val(startDate);
	  	$("div[name='addEditData'] input[name='finishDate']").val(finishdate);
	  	$("div[name='addEditData'] input[name='customerName']").val(json[0].customerName);
	  	$("div[name='addEditData'] input[name='customerPhone']").val(json[0].customerPhone);
	  	$("div[name='addEditData'] input[name='budget']").val(json[0].budget);
	  	$("div[name='addEditData'] input[name='totalHireEmployee']").val(json[0].totalHireEmployee);
	  	$("div[name='addEditData'] input[name='totalUseMaterial']").val(json[0].totalUseMaterial);
	  	$("div[name='addEditData'] input[name='totalExpense']").val(json[0].totalExpense);
	  	$("div[name='addEditData'] input[name='criticalBudget']").val(json[0].criticalBudget);   		
	          
	      	}
	      });
	 	     
	 	     
	 	     
	 		 }
	 	     
	 	     
	 	     
	 	     
	   });
	
	
	
	function show_value(x)
	{
	 document.getElementById("slider_value").innerHTML=x;
	}
	

 function Save(){
	 if( BeanUtils.isNotEmpty($('div[name=addEditData] input[name=percentStatus]').val())){
	                var params = {};
                	var message = ""
			if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					params.projectId = headerId
					message = "update Status Completed!!"
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
				
					params.percentStatus =  $('div[name=addEditData] input[name=percentStatus]').val();
							
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/editStatusProject.html"
			        	, data: params
			        	, success: function(result){
			        		alert(message);
			        		back();
			        		
			        	}
			        });
				}
			 }
		 

 }

       
  
   function back(){
	location.href = "listProjectPM.html";

    }
	 
		 function disAndEnInputField(param){
			if(BeanUtils.equals(param, 'update')){
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='projectName']").prop('disabled', true);
					$("div[name='addEditData'] textarea[name='description']").prop('disabled', true);
					$("div[name='addEditData'] select[name='provinceList']").prop('disabled',true).selectpicker('refresh');
					$("div[name='addEditData'] textarea[name='address']").prop('disabled', true);
					$("div[name='addEditData'] select[name='employeeList']").prop('disabled',true).selectpicker('refresh');
					$("div[name='addEditData'] input[name='percentStatus']").prop('disabled', false);
					$("div[name='addEditData'] input[name='startDate']").prop('disabled', true);
					$("div[name='addEditData'] input[name='finishDate']").prop('disabled', true);
					$("div[name='addEditData'] input[name='customerName']").prop('disabled',true);
					$("div[name='addEditData'] input[name='customerPhone']").prop('disabled', true);
					$("div[name='addEditData'] input[name='budget']").prop('disabled', true);
					$("div[name='addEditData'] input[name='totalHireEmployee']").prop('disabled', true);
					$("div[name='addEditData'] input[name='totalUseMaterial']").prop('disabled', true);
					$("div[name='addEditData'] input[name='totalExpense']").prop('disabled', true);
					$("div[name='addEditData'] input[name='criticalBudget']").prop('disabled', true);
				}else{
					createOrUpdateMode(param);
					$("div[name='addEditData'] input[name='projectName']").prop('disabled', true);
					$("div[name='addEditData'] textarea[name='description']").prop('disabled', true);
					$("div[name='addEditData'] select[name='provinceList']").prop('disabled', true).selectpicker('refresh');
					$("div[name='addEditData'] textarea[name='address']").prop('disabled', true);
					$("div[name='addEditData'] select[name='employeeList']").prop('disabled', true).selectpicker('refresh');
					$("div[name='addEditData'] input[name='percentStatus']").prop('disabled', true);
					$("div[name='addEditData'] input[name='startDate']").prop('disabled', true);
					$("div[name='addEditData'] input[name='finishDate']").prop('disabled', true);
					$("div[name='addEditData'] input[name='customerName']").prop('disabled', true);
					$("div[name='addEditData'] input[name='customerPhone']").prop('disabled', true);
					$("div[name='addEditData'] input[name='budget']").prop('disabled', true);
					$("div[name='addEditData'] input[name='totalHireEmployee']").prop('disabled', true);
					$("div[name='addEditData'] input[name='totalUseMaterial']").prop('disabled', true);
					$("div[name='addEditData'] input[name='totalExpense']").prop('disabled', true);
					$("div[name='addEditData'] input[name='criticalBudget']").prop('disabled', true);
				}
		 }
		 
		 function createOrUpdateMode(param){
			    $("div[name='addEditData'] input[name='projectName']").val('');
			    $("div[name='addEditData'] textarea[name='description']").val('');	 
			    $("div[name='addEditData'] select[name='provinceList']").val('').selectpicker('refresh');
				$("div[name='addEditData'] textarea[name='address']").val('');
				$("div[name='addEditData'] select[name='employeeList']").val('').selectpicker('refresh');
				$("div[name='addEditData'] input[name='status']").val('');
				$("div[name='addEditData'] input[name='startDate']").val('');
				$("div[name='addEditData'] input[name='finishDate']").val('');
				$("div[name='addEditData'] input[name='customerName']").val('');
				$("div[name='addEditData'] input[name='customerPhone']").val('');
				$("div[name='addEditData'] input[name='budget']").val('');
				$("div[name='addEditData'] input[name='totalHireEmployee']").val('');
				$("div[name='addEditData'] input[name='totalUseMaterial']").val('');
				$("div[name='addEditData'] input[name='totalExpense']").val('');
				$("div[name='addEditData'] input[name='criticalBudget']").val('');
			 if(BeanUtils.equals(param, 'create')){
				 $("div[name='statusSave']").attr('mode', 'create');
			 }else if(BeanUtils.equals(param, 'update')){
				 $("div[name='statusSave']").attr('mode', 'update');
			 }else{
				 $("div[name='statusSave']").attr('mode', '');
			 }
		 }