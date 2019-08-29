package com.lanqiao.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101200669402";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCpZe/U1xSm7kwYc38b/vWoVwHO1IScbV9hIUD7XwVI9GDE6PUohAT7KznkYvoiYFy79ONCbs7GdRuzc1PODjKY4iPkS4rY5SZM2XjYw06ZMOOlOAn9QlmxPKnEWLoGGcm4rX/W+k4fELZFOkcNeVYlqnBPa6H67jyuN0/OrtgmI76+csULLVzYpfoUxRPidLJYngDSQOVS6lPCRakYsQ1U/JEzpMyqU6tF2HZah6qbVWUUqngK+uWE3FtKLmeYRpGFGiJnwEcSKLtmW7SvpVqSTc5qfoBgrCCJ+6Ufpc1juRyFwP21aUm3Nw6pYkuJqA7tht/WxvCM9LEFDtGGVp8/AgMBAAECggEAU6VTNMzzlK4sgxJc3I0b7oDwEppb1QYox8Rs2vMDoA+TzQefLt9pukCQ+JZrHxhoEiONKFug3NwszoKPCjt2fomD4ZHvwMP+Eop8IsTmBbzfW9D9FcJymZLz3VFWofaP5hI+AwBcHPjal/p75UpZ4IV1qbHjLQ4AhqInVU5+yu2jCgq6XUl5NcD8S5XTczrXKL2x74Jb1GqBKAFLETov3xu+M7PwMaStK0hdD104Ekv1bfwtzfpc/x1UY7wY/qUXSdUq5yi2H9Gf5yn3sRZIfcEBZnlUtFiOMczjyDDTCU5dl3iZAIChPEGu6wNwuEtg4irV809uDWvP1nt4XhiRsQKBgQDk3FVJrdlH0nG744794c7m5Bm7QnhgzDx0IId7qQxZC/YpY88+JEh4HHoVr4LYg+BSOAphpWn/btFjGPuYN/legxxK9+7r1DmKz5TQEXp2cM+D0myF5OzTcZjJa+o+HPJir5vyp1gZlu0zGW2LEXTwtfgmptseQu/MA75oZOYtCQKBgQC9fHa6U38k9GdASLiY6s3Bvnm6r8u4BuLc+kjQG9nCyo8NsGFC8pKL5ZnVB46BApy7gv3c/ruV3gQrkGqZTuWwAZmvgC4nvyKCUxfwnDCnS/xpTsVyyOomQi+ZjTvvAuwrGJn562GicgPiuVWa93ukd1YU2RTwTcEKvLOg6a1EBwKBgQDQOA54rG0lRTgpA86S+iDuPNWUY9N17huKZBYf0hvj4FgkLCTfms88SFxi4n4fU0yCQW5gjMi1lzN1/8LYKQT+kjbplk2PzlRUEKyJ6X0LyXNjscz+vNsjPRUPHNnPjTKRysgNq2ciUQiaFyZtAoLshgKx19k/3RKjATz5aeNpUQKBgQCQhtV8KuGIi04RryX1pOqJg0IPzbRhygbRq6lL6mI+/Ab+1vBoguKaB+c8oEXmStrG/xOoszbbCXs+yykzhAUXKTFStj7+HAAzTTOuV0OY5xFANU/OzEYkJkluIlZ7aExAVsRi5lES+UnTba9Iwskw2cDzp9wbqgK6sNGFw5ZfkwKBgQCWiZMQfV0D3vo1dKk8cL2eHI5Qs3ihfhjvY7qkpxdvbKKa97xwpzUBH8Wr/KX/vTa0i5Q9nI14PTrw+sk5vlUNCGN9oc1dfFs3ZBu7J9FYeVHuIerXCLabJLUlQ4p0HDH6nVUXQykdqedlsUEWYJHBRlpRGvnBiNrO36uKpSjCIg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAhyWXDOpQkakLN+FfdDv/aE4bxsIGOUmOYKACGix1wFWTXDFD2sty/8QuTQUgH2nEQ23lCkdnaKNfMuGgquQ90LN7RQex9tN1LgWQgQoLEHrRlJaoZU8kscUpNpky7XAe67vEmLZpZGOZLgVbjIote7HiZrMUH+SQrJHJw87KSzW1dNaTHmjUpvqdoDBUohT+BLVz++Fw7lEt/49qlyck0vPFYho+rOyQ1g0tCmZH0BEuerWd4ByJFLKB9pgYozRCQ/0GKZ5E/w/PKBcdgIZdR9KhWuZslUGEZAeRdwaAfCQNvFUrSz1BQpG2gZyKKyiifPpyFcgfXUiPV/iX8a57GwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://kaiy.free.idcfengye.com/alipay/notify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://kaiy.free.idcfengye.com/alipay/return";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

