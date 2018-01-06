/**
  ajaxPost提交JSON格式数据
  url:/login.do?p=isHasAccount
  paramData:{userAccount:account}
  callBack:yourCallBack
*/
//document.write("<script src='/static_resources/js/json2.js'></script>");
function ajaxPostJson(url,params,callBack){
	   $.ajax({
					type: "post", 
					url : url,  
					dataType:'json', 
					contentType: "application/json; charset=utf-8", 
					data:JSON.stringify(params),
					success: function(json){
						if(json.code==-1){
						  window.location="/Login.do?p=tologinSys";
						 }else if(json.code==-10){
						   	var title = json.result.title;
							var content = "<p>"+json.result.msg+"</p>";
							var btn_name = "确定";
							tip_window(title,content,btn_name);
						 }else{
							 if(callBack != null) callBack(json, true);
						 }
					},
					failure: function(json){
						    if(callBack != null) callBack(json, false);
					} 
				 });
	}

/**
  ajaxPost提交form数据
  url:/login.do?p=isHasAccount
  paramData:{userAccount:account}
  callBack:yourCallBack
*/
function ajaxPostForm(url,params,callBack){
	   $.ajax({
					type: "post", 
					url : url,  
					dataType:'json', 
					contentType: "application/x-www-form-urlencoded; charset=utf-8", 
					data:params,
					success: function(json){
						if(json.code==-1){
						  window.location="/Login.do?p=tologinSys";
						 }else if(json.code==-10){
						   	var title = json.result.title;
							var content = "<p>"+json.result.msg+"</p>";
							var btn_name = "确定";
							tip_window(title,content,btn_name);
						 }else{ 
						   if(callBack != null) callBack(json, true);
						 }
					},
					failure: function(json){
						   if(callBack != null) callBack(json, false);
					} 
				 });
	}