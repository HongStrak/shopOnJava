package com.lanqiao.controler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.lanqiao.config.AlipayConfig;
import com.lanqiao.domain.OrderForm;
import com.lanqiao.domain.Wen;
import com.lanqiao.mapper.JayceMapper;
import com.lanqiao.service.serviceImpl.Ijayce;

import lombok.extern.slf4j.Slf4j;

/**
 * 支付宝通用接口.
 * <p>
 * detailed description
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2018/6/13
 */
@Slf4j
@Controller
@RequestMapping("/alipay")
public class AlipayController {

	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private JayceMapper jayce;
	
	@RequestMapping("/pay")
	public void pay(HttpServletRequest httpRequest, HttpServletResponse httpResponse)
			throws ServletException, IOException, AlipayApiException {

		AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
				AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key,
				AlipayConfig.sign_type); // 获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
		// 商户订单号，商户网站订单系统中唯一订单号，必填
		alipayRequest.setReturnUrl(AlipayConfig.notify_url);
		alipayRequest.setNotifyUrl(AlipayConfig.return_url);// 在公共参数中设置回跳和通知地址

		String out_trade_no = getOrderIdByUUId();
		// 付款金额，必填
		String total_amount = httpRequest.getParameter("WIDtotal_amount");
		// 订单名称，必填
		String subject = "订单商品";
		// 商品描述，可空
		String body = httpRequest.getParameter("WIDbody");
		

		alipayRequest.setBizContent("{\"out_trade_no\":\"" + out_trade_no + "\"," + "\"total_amount\":\"" + total_amount
				+ "\"," + "\"subject\":\"" + subject + "\"," + "\"body\":\"" + body + "\","
				+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
		String form = "";

		form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单

		httpResponse.setContentType("text/html;charset=" + AlipayConfig.charset);
		httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}

	@PostMapping("/return")
	@ResponseBody
	public void notify_url(HttpServletRequest request, HttpServletResponse response)
			throws IOException, AlipayApiException {

		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		// ——请在这里编写您的程序（以下代码仅作参考）——

		/*
		 * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
		 * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）， 3、校验通知中的seller_id（或者seller_email)
		 * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
		 * 4、验证app_id是否为该商户本身。
		 */
		if (signVerified) {// 验证成功
			// 商户订单号
			String out_trade_no = request.getParameter("out_trade_no");

			// 支付宝交易号
			String trade_no = request.getParameter("trade_no");

			// 交易状态
			String trade_status = request.getParameter("trade_status");

			if (trade_status.equals("TRADE_FINISHED")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序
				response.getWriter().println("success");
				// 注意：
				// 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
			} else if (trade_status.equals("TRADE_SUCCESS")) {
				// 判断该笔订单是否在商户网站中已经做过处理
				// 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
				// 如果有做过处理，不执行商户的业务程序

				// 注意：
				// 付款完成后，支付宝系统发送该交易状态通知
				String body = request.getParameter("body");
				String[] keys = body.split("_");
				if(keys.length > 1) {
					for (int i=1;i<keys.length;i++) {
						OrderForm order = (OrderForm)redisTemplate.opsForHash().get(keys[0], keys[i]);
						Integer gid = order.getShoppingCart().getGid();
						redisTemplate.opsForHash().delete(keys[0], keys[i]);
						jayce.updateWen(new Wen(Integer.parseInt(keys[0]), gid, 5));
					}
				}else {
					String[] keys2 = body.split("\\|");
					if(keys2.length>1) {
						jayce.updateWen(new Wen(Integer.parseInt(keys2[0]), Integer.parseInt(keys2[1]), 5));
					}
				}
				
			}

		} else {// 验证失败
			response.getWriter().println("fail");

			// 调试用，写文本函数记录程序运行情况是否正常
			// String sWord = AlipaySignature.getSignCheckContentV1(params);
			// AlipayConfig.logResult(sWord);
		}

	}

	@GetMapping("/notify")
	public void return_url(HttpServletRequest request, HttpServletResponse response)
			throws IOException, AlipayApiException, ServletException {
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		// ——请在这里编写您的程序（以下代码仅作参考）——
		if (signVerified) {
			/*// 商户订单号
			String out_trade_no = request.getParameter("out_trade_no");
			// 支付宝交易号
			String trade_no = request.getParameter("trade_no");

			// 付款金额
			String total_amount = request.getParameter("total_amount");

			response.getWriter().println(
					"trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);*/
			response.sendRedirect("https://www.baidu.com/");
		} else {
			response.getWriter().println("验签失败");
		}

	}

	/**获取唯一id*/
	public String getOrderIdByUUId() {
		int machineId = 1;
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if(hashCodeV < 0) {
			hashCodeV = -hashCodeV;
		}
		return machineId + String.format("%015d", hashCodeV);
	}


}
