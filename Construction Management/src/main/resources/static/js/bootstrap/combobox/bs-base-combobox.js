var BSBaseComboBox = function () {   
    return { getRole: function (params, callBack) {
    		$.ajax({
	        	type: 'POST'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.roleCode+" value="+value.roleId+" data-subtext="+value.roleName+">"+value.roleCode+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
            
        getEmployee: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.empFirstName+" value="+value.employeeId+" data-subtext="+value.empFirstName + value.empLastName+">"+value.depDetailName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getAllEmployee: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.empFirstName+" value="+value.employeeId+" data-subtext="+value.empFirstName + value.empLastName+">"+value.depDetailName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        
        
        
        getProjectManager: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.empFirstName+" value="+value.employeeId+" data-subtext="+value.empFirstName + value.empLastName+">"+value.depDetailName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getType: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.typeName+" value="+value.typeId+" >"+value.typeName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getMaterial: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.materialName+" value="+value.materialId+" data-subtext="+value.materialCode+" >"+value.materialName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        
        
        
        getprovince: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.provinceCode+" value="+value.provinceId+" data-subtext="+value.provinceName+">"+value.provinceCode+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        }
        
        
        
        
    };	
}();