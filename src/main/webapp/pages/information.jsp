<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/">
<meta charset="utf-8" />
<title>Insert title here</title>
<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet"
	type="text/css">

<link href="css/personal.css" rel="stylesheet" type="text/css">
<link href="css/infstyle.css" rel="stylesheet" type="text/css">
<script src="AmazeUI-2.4.2/assets/js/jquery.min.js"
	type="text/javascript"></script>
	<script src="js/jquery-2.2.3.min.js"></script>
<script src="AmazeUI-2.4.2/assets/js/amazeui.js" type="text/javascript"></script>

</head>
<body>
	<header>

	<div class="nav-table">
		<div class="long-title">
			<span class="all-goods">全部分类</span>
		</div>
		<div class="nav-cont">
			<ul>
				<li class="index"><a href="#">首页</a></li>
				<li class="qc"><a href="#">闪购</a></li>
				<li class="qc"><a href="#">限时抢</a></li>
				<li class="qc"><a href="#">团购</a></li>
				<li class="qc last"><a href="#">大包装</a></li>
			</ul>
			<div class="nav-extra">
				<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利 <i
					class="am-icon-angle-right" style="padding-left: 10px;"></i>
			</div>
		</div>
	</div>
	<b class="line"></b>
	<div class="center">
		<div class="col-main">
			<div class="main-wrap">
						<div class="user-info">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong> / <small>Personal&nbsp;information</small></div>
						</div>
						<hr/>

						<!--头像 -->
							<%@include file="userinfo.jsp"%>
						</div>
					
					<!--个人信息 -->
					<div class="info-main">
						<form class="am-form am-form-horizontal" action="/user/update.do" method="post">

							<div class="am-form-group">
								<label for="user-name2" class="am-form-label">昵称</label>
								<div class="am-form-content">
									<input type="text" id="user-name2" placeholder="username" name="username"
										value="${tbuser.username}">

								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-form-label">姓名</label>
								<div class="am-form-content">
									<input type="text" id="user-name2" placeholder="name" name="realname"
										 value="${tbuser.realname}">

								</div>
							</div>

							<div class="am-form-group">
								<label class="am-form-label">性别</label>
								<div class="am-form-content sex">
								<c:if test="${tbuser.sex=='男' }">
									<label class="am-radio-inline"> <input type="radio"
										 value="男"  data-am-ucheck checked name="sex"> 男 
									</label> <label class="am-radio-inline"> <input type="radio"
										name="sex" value="女" data-am-ucheck> 女
									</label> <label class="am-radio-inline"> <input type="radio"
										name="sex" value="保密" data-am-ucheck> 保密
									</label>
								</c:if>
								<c:if test="${tbuser.sex=='女' }">
									<label class="am-radio-inline"> <input type="radio"
										name="sex" value="男" data-am-ucheck > 男
									</label> <label class="am-radio-inline"> <input type="radio"
									" value="女" data-am-ucheck checked name="sex"> 女
									</label> <label class="am-radio-inline"> <input type="radio"
										name="sex" value="保密" data-am-ucheck> 保密
									</label>
								</c:if>
								<c:if test="${tbuser.sex=='保密' }">
									
									<label class="am-radio-inline"> <input type="radio"
										name="sex" value="男" data-am-ucheck > 男
									</label> <label class="am-radio-inline"> <input type="radio"
										name="sex" value="女" data-am-ucheck> 女
									</label> <label class="am-radio-inline"> <input type="radio"
									 value="保密" data-am-ucheck  checked name="sex"> 保密
									</label>
								</c:if>
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-birth" class="am-form-label"
									>生日</label>

								<div class="am-form-content">
									<input type="text" id="user-name2" value="${tbuser.birth }" name="birth"
										placeholder="birth">


								</div>

							</div>
							<div class="am-form-group">
								<label for="user-phone" class="am-form-label">电话</label>
								<div class="am-form-content">
									<input id="user-phone" placeholder="telephonenumber" type="tel"  name="phone"
										value="${tbuser.phone}">

								</div>
							</div>
							<div class="am-form-group">
								<label for="user-email" class="am-form-label" >电子邮件</label>
								<div class="am-form-content">
									<input id="user-email" placeholder="Email"  value="${tbuser.email }"  name="email"
										type="email">

								</div>
							</div>
					
							<div class="info-btn">
								<button class="am-btn am-btn-danger"  type="submit" >保存修改</button>
							</div>

						</form>
					</div>

				</div>

			</div>
			<%@include file="footer.jsp"%>
			<%@include file="left.jsp"%>
	</div>
</body>
<script>
		


</script>
</html>