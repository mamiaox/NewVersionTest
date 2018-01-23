function check(form) {
    /*判断是否有空内容*/
    for(var i = 0; i < form.length; i++) {
        if (form.elements[i].value == "") { //form的属性elements的首字母e要小写
            alert("很抱歉," + form.elements[i].title + "不能为空!");
            form.elements[i].focus(); //当前元素获取焦点
            return false;
        }
    }

    var idnumber = document.getElementById("idnumber").value;
    var regExpression = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$|^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;
    var objExp = new RegExp(regExpression);			//创建正则表达式对象
    if(objExp.test(idnumber) == false) {
        alert("您输入的身份证号码格式有误！");
        document.getElementById("idnumber").focus();
        return false;
    }

    var controldate = document.getElementById("birth").value;
	var day = new Date();
	var Year = 0;
	var Month = 0;
	var Day = 0;
	var CurrentDate = "";
	// 初始化时间
	Year = day.getFullYear();
	Month = day.getMonth() + 1;
	Day = day.getDate();

	CurrentDate += Year + "-";

	if (Month >= 10) {
		CurrentDate += Month + "-";
	} else {
		CurrentDate += "0" + Month + "-";
	}
	if (Day >= 10) {
		CurrentDate += Day;
	} else {
		CurrentDate += "0" + Day;
	} // alert(CurrentDate);//当前日期

	var startDate = new Date(CurrentDate.replace("-", ",")).getTime();
	var endDate = new Date(controldate.replace("-", ",")).getTime();
	if (startDate < endDate) {
		alert('选择日期不能大于当前日期！');
		document.getElementById("birth").focus();
		return false;
	} else {
		return true;
	} 
}