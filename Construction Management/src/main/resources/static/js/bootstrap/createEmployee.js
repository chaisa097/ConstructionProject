
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
			    	
			           
			   
    });


function save(){
	

			 if( BeanUtils.isNotEmpty($('div[name=addEditData] input[name=empFirstName]').val())&& BeanUtils.isNotEmpty($('div[name=addEditData] input[name=empLastName]').val())){				                                                     		
				var params = {};
				var message = ""
					params.method = 'save';
					message = "create employee success!!"
				if(BeanUtils.equals($("div[name='statusSave']").attr('mode'), 'update')){
					params.method = 'edit';				
					params.employeeId = headerId
					message = "update success!!"
				}
				
				if(BeanUtils.isNotEmpty(params.method)){
					params.empFirstName = $('div[name=addEditData] input[name=empFirstName]').val();				
					params.empLastName = $('div[name=addEditData] input[name=empLastName]').val();
					params.citizenId = $('div[name=addEditData] input[name=citizenId]').val();
					params.birthDay  = $('div[name=addEditData] input[name=birthDay]').val();
					params.departmentDetailId = $('div[name=addEditData] select[name="positionList"]').val();
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
	   location.href = "employee.html";

    }





