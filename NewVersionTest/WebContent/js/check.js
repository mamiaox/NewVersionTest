function check(form) {
    /*判断是否有空内容*/
    for(var i = 0; i < form.length; i++) {
        if (form.elements[i].value == "") { //form的属性elements的首字母e要小写
        	if(document.getElementById("marrage").value == "unmarried" || document.getElementById("marrage").value == "unexplainedmaritalstatus"){	//满足条件则跳出配偶姓名不为空的校验
        		continue;
        	}
            alert("很抱歉," + form.elements[i].title + "不能为空!");
            form.elements[i].focus(); //当前元素获取焦点
            return false;
        }
    }

    var idnumber = document.getElementById("idnumber").value;
    var tmpStr = "";
    var regExpression = /^(([1][1-5])|([2][1-3])|([3][1-7])|([4][1-6])|([5][0-4])|([6][1-5])|([7][1])|([8][1-2]))\d{4}(([1][9]\d{2})|([2]\d{3}))(([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|([3][0-1]))\d{3}[0-9xX]$/;
    
    var objExp = new RegExp(regExpression);			// 创建正则表达式对象
    if(objExp.test(idnumber) == false) {
        alert("您输入的身份证号码格式有误！");
        document.getElementById("idnumber").focus();
        return false;
    }
    // substring截取身份证号码出生日期部分
    if(idnumber.length == 18){
    	tmpStr = idnumber.substring(6, 14);//19960803 ====> 1996-08-03 substring含头不含尾，下标从0开始
        tmpStr = tmpStr.substring(0, 4) + "-" + tmpStr.substring(4, 6) + "-" + tmpStr.substring(6);
    }

    var controlDate = document.getElementById("birth").value;
	var date = new Date();
	var year = 0;
	var month = 0;
	var day = 0;
	var currentDate = "";
	// 初始化时间
	year = date.getFullYear();
	month = date.getMonth() + 1;
	day = date.getDate();

	currentDate += year + "-";

	if (month >= 10) {
		currentDate += month + "-";
	} else {
		currentDate += "0" + month + "-";
	}
	if (day >= 10) {
		currentDate += day;
	} else {
		currentDate += "0" + day;
	} // alert(CurrentDate);//当前日期

	var startDate = new Date(currentDate.replace("-", ",")).getTime();
	var endDate = new Date(controlDate.replace("-", ",")).getTime();
	if (startDate < endDate) {
		alert('选择日期不能大于当前日期！');
		document.getElementById("birth").focus();
		return false;
	} 
	// 判断身份证信息中生日部分与选择的出生日期是否一致
	if (controlDate != tmpStr) {
		alert("出生日期与身份证信息不一致！");
		return false;
	}
	else {
		return true;
	} 
}