<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>修改信息</title>
    <script src="../js/check.js"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/UpdateServlet" name="Form1" method="post">
    <table border="1" bgcolor="#87ceeb" align="center" cellpadding="10" cellspacing="0">
    	<input type = "hidden" name = "id" value="${person.id} }">
        <tr>
            <td>姓名：<input type="text" name="name" title="姓名" placeholder="请输入姓名"></td>
        </tr>
        <tr>
            <td>身份证号码：<input type="text" id="idnumber" name="idnumber" title="身份证号码" placeholder="请输入身份证号码" maxlength="18"></td>
        </tr>
        <tr>
        <td>性别：<select name="sex" title="性别">
                <option value="">请选择</option>
                <option value="unknownsex">未知的性别</option>
                <option value="man">男</option>
                <option value="woman">女</option>
                <option value="unexplainedsex">未说明的性别</option>
            </select></td>
        </tr>
        <tr>
            <td>出生日期：<input type="date" title="出生日期" id="birth" name="birth"></td>
        </tr>
        <tr>
            <td>婚姻状况：<select name="marrage" id="marrage" title="婚姻状况">
                <option value="">请选择婚姻状况</option>
                <option value="unmarried">未婚</option>
                <option value="firstmarriage">初婚</option>
                <option value="remarriage">再婚</option>
                <option value="remarry">复婚</option>
                <option value="widowed">丧偶</option>
                <option value="divorce">离婚</option>
                <option value="unexplainedmaritalstatus">未说明的婚姻状况</option>
            </select></td>
        </tr>
        <tr>
            <td>配偶姓名：<input name="matename" id="matename" type="text" title="配偶姓名" placeholder="请输入配偶姓名"/></td>
        </tr>
        <tr>
            <td align="center">
                <input type="submit" value="提交" onclick="return check(Form1)"/>
                <input type="reset" value="重置"/>
                <input type="button" value="关闭" onClick="window.close()"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>