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
	            		  data.push("<option title="+value.empFirstName+" value="+value.employeeId+" data-subtext="+value.depDetailName+">"+value.empFirstName +" "+ value.empLastName+"</option>");
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
        
        getUnit: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.unitName+" value="+value.unitId+" >"+value.unitName+"</option>");
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
	            		  data.push("<option title="+value.materialName+'/' +value.totalQuatity+''+value.unitName+  " value="+value.materialId+ " data-subtext="+value.totalQuatity+""+value.unitName+" >"+value.materialName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        
        getOrderMaterial: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.materialName+  " value="+value.materialId+ " data-subtext="+value.materialCode+" >"+value.materialName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getExportMaterial: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.materialName+  " value="+value.materialId+ " data-subtext="+value.materialCode+" >"+value.materialName+"</option>");
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
        },
        
        getProject: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.projectName+" value="+value.projectId+" data-subtext="+value.provinceName +">"+value.projectName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getDepartmentDetail: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.depDetailName+" value="+value.depDetailId+">"+value.depDetailName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getDepartmentDetailByEdit: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.depDetailName+" value="+value.depDetailId+">"+value.depDetailName+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        },
        
        getDepartment: function (params, callBack) {
    		$.ajax({
	        	type: 'GET'
	        	, url: application.contextPath+"/combobox.html"
	        	, data: params
	        	, success: function(result){
	            	var json = $.parseJSON(result);
	            	var data = ['<option></option>'];
	            	$.each(json, function(index, value) {
	            		  data.push("<option title="+value.departmentCode+" value="+value.departmentId+" data-subtext="+value.departmentName+">"+value.departmentCode+"</option>");
	            	});
	            	callBack(data.join());
	        	}
	        });
        }

    };	
}();