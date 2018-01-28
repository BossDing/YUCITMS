	
	//获取对象
	$get = function(){
		var elements = new Array();
	  	for (var i = 0; i < arguments.length; i++) {
			var element = arguments[i];
			if (typeof element == 'string')
		  		element = document.getElementById(element);
			if (arguments.length == 1)
		  		return element;
			elements.push(element);
	  	}
	  	return elements;
	}

	//随机数
	function rnd(){
		return (new Date()).valueOf();
	}
	
	
	//配置当前应用路径
	function BasePath(act){
		return "ajax.do?action=" + act;
	}
	
	
	//数字判断
	function checkNumber(v){
		var pattern = /^[1-9][0-9]*$/;
		return v.match(pattern);
	}
	
	
	//查询字符串获取
	function queryStr(){
		var query = location.search.substring(1);
		var result = new Array();
		if(query){
			var arQuery = query.split("&");
			for(var i=0;i<arQuery.length;i++){
				var pos = arQuery[i].indexOf("=");
				var qName = arQuery[i].substring(0,pos);
				var qValue = arQuery[i].substring(pos+1);
				result[qName] = qValue;
			}
		}
		return result;
	}
	
	
	//打开窗口
	showWindow = function(url,w,h){
		var ret = window.showModalDialog(url,'ewin','dialogWidth='+w+'px;dialogHeight='+h+'px;top:0px');
		if(ret=="ok"){
			window.location.reload();
		}
	}
	
	//跳转
	gourl = function(url){
		window.location.href = url;
	}
	
	
	qTypeName = function(qtype){
		if("1"==qtype || 1==qtype){
			return "单选";
		}else if("3"==qtype || 3==qtype){
			return "判断";
		}else if("2"==qtype || 2==qtype){
			return "填空";
		}else if("4"==qtype || 4==qtype){
			return "问答";
		}else{
			return "未知";
		}
		
	}
	
	
	function selcheck(obj) {
  		var objs = document.getElementsByTagName("input");
  		for(var i=0; i<objs.length; i++) {
    		if(objs[i].type.toLowerCase() == "checkbox" ){
				if(objs[i].id != obj)
				objs[i].checked = $get(obj).checked;
			}
  		}
	}
