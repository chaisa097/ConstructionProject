
	$(document).ready(function(){
			
		 var params = {method:'province'};
	    	BSBaseComboBox.getprovince(params,function(data){
	      	$("div select[name=provinceList]").html(data).selectpicker('refresh');
		
	
 	});	
	
		
			 var params = {method:'department'};
		    	BSBaseComboBox.getDepartment(params,function(data){
		      	$("div  select[name=departmentList]").html(data).selectpicker('refresh');
			
	   	
	    	});
		    	 
			           $('.depList').on('change', function(event){
			    	  var params2 = {method:'departmentDetial', departmentId: event.currentTarget.value};
			    	    BSBaseComboBox.getDepartmentDetail(params2,function(data){
			    	   $("div select[name=positionList]").html(data).selectpicker('refresh');
			    	 	

			    	 });    
			    	     	    
			   });
		    	
			         
			           
			         if(BeanUtils.isNotEmpty(headerId)){	
			        	 
				    	    var params1 = {method:'departmentDetailbyEdit'};
					    	BSBaseComboBox.getDepartmentDetailByEdit(params1,function(data){
					      	$("div select[name=positionList]").html(data).selectpicker('refresh');
						
					
				      	});	  
			        	 
			   	 	    var params = {method: 'searchData'};
			   			 disAndEnInputField('update');
			   			  params.employeeId = headerId;
			   			
			   	  	$.ajax({
			   	      	type: 'POST'
			   	      	, url: application.contextPath+"/createEmployee.html"
			   	      	, data: params
			   	      	, success: function(result){
			   	        var json = $.parseJSON(result);
			   	      	var d = new Date(json[0].birthDay),
			            month = '' + (d.getMonth() + 1),
			            day = '' + d.getDate(),
			            year = d.getFullYear();

			        if (month.length < 2) month = '0' + month;
			        if (day.length < 2) day = '0' + day;

			        var birthDay = [year, month, day,].join('-');	
			   	        	
			   		$("div[name='addEditData'] input[name='empFirstName']").val(json[0].empFirstName);
			   	  	$("div[name='addEditData'] input[name='empLastName']").val(json[0].empLastName);
			   	  	$("div[name='addEditData'] input[name='citizenId']").val(json[0].citizenId);
			   	  	$("div[name='addEditData'] select[name='provinceList']").val(json[0].provinceId).selectpicker('refresh');
			   	  	$("div[name='addEditData'] select[name='positionList']").val(json[0].depDetailId).selectpicker('refresh');
			   	  	$("div[name='addEditData'] input[name='birthDay']").val(birthDay);
			   	  	if('Male' == json[0].gender){
			   	  	 $("#input-gender-male").attr('checked', 'checked');
			   	  	 }
			   	  	else if('Female' == json[0].gender) {
			   	  	$("#input-gender-female").attr('checked', 'checked');
			   	  	}
			   	  	
			   	  	$("div[name='addEditData'] input[name='subDistrict']").val(json[0].subDistrict);
			   	  	$("div[name='addEditData'] input[name='district']").val(json[0].district);
			   	          
			   	      	}
			   	      });
			   	 	     
			   	 	     
			   	 }
			           
			        
			   
    });


function save(){
	  
			 if( BeanUtils.isNotEmpty($('div[name=addEditData] input[name=empFirstName]').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] input[name=empLastName]').val())
					 &&BeanUtils.isNotEmpty($('div[name=addEditData] input[name=citizenId]').val())&&BeanUtils.isNotEmpty($('div[name=addEditData] input[name=birthDay]').val()) 
					
			 ){				                                                     		
				var params = {};
				
				var message = ""
					params.method = 'save';
					message = "create employee success!!"
						
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					params.employeeId = headerId
					  console.log('#someButton was clicked');
					message = "update success!!"
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.empFirstName = $('div[name=addEditData] input[name=empFirstName]').val();				
					params.empLastName = $('div[name=addEditData] input[name=empLastName]').val();
					params.citizenId = $('div[name=addEditData] input[name=citizenId]').val();
					params.birthDay  = $('div[name=addEditData] input[name=birthDay]').val();
					params.depDetailId = $('div[name=addEditData] select[name="positionList"]').val();
					params.provinceId = $('div[name=addEditData] select[name="provinceList"]').val();
					params.gender =  $('div[name=addEditData] input[name=gender]').val();
					params.subDistrict = $('div[name=addEditData] input[name=subDistrict]').val();
					params.district = $('div[name=addEditData] input[name=district]').val();
								
			    	$.ajax({
			        	type: 'POST'
			        	, url: application.contextPath+"/createEmployee.html"
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
	   location.href ="employee.html";

 }


function disAndEnInputField(param){
	 if(BeanUtils.equals(param, 'update')){
			createOrUpdateMode(param);
			$("div[name='addEditData'] input[name='empFirstName']").prop('disabled', false);
			$("div[name='addEditData'] select[name='provinceList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='positionList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='departmentList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='empLastName']").prop('disabled', false);
			$("div[name='addEditData'] input[name='citizenId']").prop('disabled', false);
			$("div[name='addEditData'] input[name='birthDay']").prop('disabled', false);
			$("div[name='addEditData'] input[name='gender']").prop('disabled', false);
			$("div[name='addEditData'] input[name='subDistrict']").prop('disabled', false);
			$("div[name='addEditData'] input[name='district']").prop('disabled', false);
		
		}else{
			createOrUpdateMode(param);
			$("div[name='addEditData'] input[name='empFirstName']").prop('disabled', false);
			$("div[name='addEditData'] select[name='provinceList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='positionList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] select[name='departmentList']").prop('disabled', false).selectpicker('refresh');
			$("div[name='addEditData'] input[name='empLastName']").prop('disabled', false);
			$("div[name='addEditData'] input[name='citizenId']").prop('disabled', false);
			$("div[name='addEditData'] input[name='birthDay']").prop('disabled', false);
			$("div[name='addEditData'] input[name='gender']").prop('disabled', false);
			$("div[name='addEditData'] input[name='subDistrict']").prop('disabled', false);
			$("div[name='addEditData'] input[name='district']").prop('disabled', false);
		}
}

function createOrUpdateMode(param){
	    $("div[name='addEditData'] input[name='empFirstName']").val('');
	    $("div[name='addEditData'] select[name='provinceList']").val('').selectpicker('refresh');
		$("div[name='addEditData'] select[name='positionList']").val('').selectpicker('refresh');
		$("div[name='addEditData'] select[name='departmentList']").val('').selectpicker('refresh');
		$("div[name='addEditData'] input[name='empLastName']").val('');
		$("div[name='addEditData'] input[name='citizenId']").val('');
		$("div[name='addEditData'] input[name='birthDay']").val('');
		$("div[name='addEditData'] input[name='gender']").val('');
		$("div[name='addEditData'] input[name='subDistrict']").val('');
		$("div[name='addEditData'] input[name='district']").val('');
		
	 if(BeanUtils.equals(param, 'update')){
			 $("div[name='statusSave']").attr('mode', 'update');
		 }else{
			 $("div[name='statusSave']").attr('mode', '');
		 }
}










