<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
	<title>添加客户信息</title>
	<link rel="stylesheet" type="text/css" href="skin/css/base.css">

	<!-- 1. 导入CSS的全局样式 -->
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<!-- 2. jQuery导入，建议使用1.9以上的版本 -->
	<script src="js/jquery-2.1.0.min.js"></script>
	<!-- 3. 导入bootstrap的js文件 -->
	<script src="js/bootstrap.min.js"></script>
</head>
<body leftmargin="8" topmargin="8" background='skin/images/allbg.gif'>

<!--  快速转换位置按钮  -->
<table width="98%" border="0" cellpadding="0" cellspacing="1" bgcolor="#D1DDAA" align="center">
	<tr>
		<td height="26" background="skin/images/newlinebg3.gif">
			<table width="58%" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td >
						当前位置:客户信息管理>>添加客户信息
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<form name="form2">

	<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
		<tr bgcolor="#E7E7E7">
			<td height="24" colspan="2" background="skin/images/tbg.gif">&nbsp;添加客户&nbsp;</td>
		</tr>
		<from  action="${pageContext.request.contextPath}/addUserServlet" method="post">
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司名称：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司联系人：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司地址：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input size="60"/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">联系电话：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">座机：</td>
			<td  align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><input/></td>
		</tr>
		<tr >
			<td align="right" bgcolor="#FAFAF1" height="22">公司简介：</td>
			<td align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22"><textarea rows=15 cols=130></textarea></td>
		</tr>

		<tr >
			<td align="right" bgcolor="#FAFAF1" >备注：</td>
			<td colspan=3 align='left' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='#FCFDEE';" onMouseOut="javascript:this.bgColor='#FFFFFF';" >
				<textarea rows=10 cols=130></textarea>
			</td>
		</tr>


		<tr bgcolor="#FAFAF1">
			<td height="28" colspan=4 align=center>
				&nbsp;
				<a href="customer.html" class="coolbg">保存</a>
				<a href="customer.html" class="coolbg">返回</a>
			</td>
		</tr>
		</from>
	</table>

</form>


</body>
</html>