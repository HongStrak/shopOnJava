<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/">
<meta charset="utf-8" />
<title>Insert title here</title>
<link href="AmazeUI-2.4.2/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="AmazeUI-2.4.2/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="css/personal.css" rel="stylesheet" type="text/css">
		<link href="css/addstyle.css" rel="stylesheet" type="text/css">
		<script src="AmazeUI-2.4.2/assets/js/jquery.min.js" type="text/javascript"></script>
		<script src="AmazeUI-2.4.2/assets/js/amazeui.js"></script>
		<script src="js/jquery-2.2.3.min.js"></script>

</head>
<body>
<div class="nav-table">
			<div class="long-title"><span class="all-goods">全部分类</span></div>
			<div class="nav-cont">
				<ul>
					<li class="index"><a href="#">首页</a></li>
					<li class="qc"><a href="#">闪购</a></li>
					<li class="qc"><a href="#">限时抢</a></li>
					<li class="qc"><a href="#">团购</a></li>
					<li class="qc last"><a href="#">大包装</a></li>
				</ul>
				<div class="nav-extra">
					<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
					<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
				</div>
			</div>
		</div>
		<b class="line"></b>

		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-address">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">地址管理</strong> / <small>Address&nbsp;list</small></div>
						</div>
						<hr/>	
						<!--例子-->
						<div class="am-modal am-modal-no-btn" id="doc-modal-1">

							<div class="add-dress" id="app">

								<!--标题 -->
								<div class="am-cf am-padding">
									<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">新增地址</strong> / <small>Add&nbsp;address</small></div>
								</div>
								<hr/>

								<div class="am-u-md-12 am-u-lg-8" style="margin-top: 20px;">
									<form class="am-form am-form-horizontal" action="/addr/update.do?id=${id }" method="post">
										
										<div class="am-form-group">
											<label for="user-name" class="am-form-label">收货人</label>
											<div class="am-form-content">
												<input type="text" id="user-name" placeholder="收货人" name="receiver" value="${address.receiver }">
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-phone" class="am-form-label">手机号码</label>
											<div class="am-form-content">
												<input id="user-phone" placeholder="手机号必填" type="text" name="tel" value="${address.tel }">
											</div>
										</div>
										<div class="am-form-group" >
											<label for="user-address" class="am-form-label">所在地</label>
											<div class="am-form-content address" >
												<select   style="height:30px;overflow-y:auto" id="select1"  onChange="change1()"  name="sheng">
													<option value='' disabled selected hidden>选择省</option>
													<c:forEach items="${province}" var="item">
														<option value="${item}">${item}</option>
													</c:forEach>
												
												
												</select>
												<select style="height:30px;overflow-y:auto;display:none;" id="select2" onChange="change2()" name="shi" >
														
												</select>
												<select style="height:30px;overflow-y:auto;display:none;" id="select3" name="xian" >
												
												</select>
											</div>
										</div>

										<div class="am-form-group">
											<label for="user-intro" class="am-form-label">详细地址</label>
											<div class="am-form-content">
												<textarea class="" rows="3" id="user-intro" placeholder="输入详细地址" name="detail"></textarea>
												<small>100字以内写出你的详细地址...</small>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-u-sm-9 am-u-sm-push-3">
												<button  type="submit" class="am-btn am-btn-danger">保存</button>
												<a href=javascript:history.go(-1)" class=" am-btn am-btn-danger" data-am-modal-close style="color:white">取消</a>
											</div>
										</div>
									</form>
								</div>

							</div>

						</div>

					</div>

					<script type="text/javascript">
						$(document).ready(function() {							
							$(".new-option-r").click(function() {
								$(this).parent('.user-addresslist').addClass("defaultAddr").siblings().removeClass("defaultAddr");
							});
							
							var $ww = $(window).width();
							if($ww>640) {
								$("#doc-modal-1").removeClass("am-modal am-modal-no-btn")
							}
							
						})
					</script>

					<div class="clear"></div>

				</div>
				<!--底部-->
				

			<%@include file="footer.jsp"%>
			<%@include file="left.jsp"%>
		</div>



</body>
	<script>
	
	var sel1;
	function change1()
	{
		sel1=$('#select1 option:selected').text();
		$("#select2").css("display","none");
		$("#select3").css("display","none");
			$.ajax({
						url:"/user/city.do",
						type:"post",
						data:{'sel1':sel1},
						datatype:"text",
						
						success:function(result){
						$("#select2").css("display","block");
						console.log(result);
						$("#select2").find("option").remove();
						
						$('#select2').append("<option value='' disabled selected hidden>选择市或者区</option");
						$.each(result,function(index,item){
							
							$('#select2').append("<option value='"+item+"'>"+item+"</option");
							
							
						});
						},
						error:function()
						{
							alert("请求失败");
						}
						
					})
	}
	
	function change2()
	{
		var sel2=$('#select2 option:selected').text();
		
		console.log(sel2);
			$.ajax({
						url:"/user/xian.do",
						type:"post",
						data:{'sel1':sel1,'sel2':sel2},
						datatype:"text",
						success:function(result){
							console.log(result);
							if(result.length==0)
							{
							$("#select3").css("display","none");
							}
							else{
								$("#select3").css("display","block");
							}
							$("#select3").find("option").remove();
							$('#select3').append("<option value='' disabled selected hidden>选择区</option");
						$.each(result,function(index,item){
							
							$('#select3').append("<option value='"+item+"'>"+item+"</option");
							
							
						});
						},
						error:function()
						{
							alert("请求失败");
						}
						
					})
	}
	
	
	
	</script>
</html>