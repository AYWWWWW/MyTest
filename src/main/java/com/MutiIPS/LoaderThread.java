package com.MutiIPS;

import org.apache.http.*;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author OneAPM
 * @Date 2017/1/16.
 * @Description
 */
public class LoaderThread implements Runnable {

	private byte[] IP;

	private static List<BasicHeader> defaultHeaders = new ArrayList<BasicHeader>();

	protected LoaderThread(byte[] IP) {
		this.IP = IP;
		defaultHeaders.add(new BasicHeader("Connection", "Keep-Alive"));
	}

	@Override
	public void run() {
		HttpRequestBase get = new HttpGet("http://10.128.106.20:8082/");
		CloseableHttpClient client = null;
		try {
			client = createHttpClient(IP);
			for (int i = 0; i < 100; i++) {
				CloseableHttpResponse response = client.execute(get);
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					String str = EntityUtils.toString(entity, "UTF-8");
					System.out.println("请求ip为" + InetAddress.getByAddress(IP) +"的第 "+i+ " 次请求返回的结果是：" + str);
				} else {
					System.out.println("请求ip为" + InetAddress.getByAddress(IP) +"的第 "+i+ " 次请求返回的结果是:null");
				}
				Thread.sleep(500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (client != null) {
					client.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private CloseableHttpClient createHttpClient(byte[] IP) throws UnknownHostException {
		RequestConfig defaultRequestConfig = RequestConfig.custom()//
				.setSocketTimeout(2000)// socket 超时设置
				.setConnectTimeout(2000)// 链接超时设置
				.setCookieSpec(CookieSpecs.BROWSER_COMPATIBILITY)// 设置cookie标准，已在client级别禁用该功能，此处无需设置
				.setLocalAddress(InetAddress.getByAddress(IP))
				.build();

		// 设置连接参数
		ConnectionConfig connConfig = ConnectionConfig.custom().setCharset(Charset.forName("UTF-8"))
				.build();
		SocketConfig socketConfig = SocketConfig.custom().setSoReuseAddress(true).setSoLinger(-1)
				.setTcpNoDelay(true).setSoKeepAlive(false).setSoTimeout(20000).build();
		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder
				.<ConnectionSocketFactory>create();
		PlainConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
		registryBuilder.register("http", plainSF);
		Registry<ConnectionSocketFactory> registry = registryBuilder.build();

		// 设置连接管理器
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
		connManager.setDefaultConnectionConfig(connConfig);
		connManager.setDefaultSocketConfig(socketConfig);
		connManager.setMaxTotal(10000000);
		connManager.setDefaultMaxPerRoute(1000000);

		HttpClientBuilder builder = HttpClientBuilder.create()//
				.setConnectionManager(connManager)// 注册连接管理器
				// .disableCookieManagement()// 禁用cookie管理，我们自己管理cookie
				// .disableAutomaticRetries()// 禁用重发机制(禁用后出现了许多错误请求，如Connection
				// reset 等)
				.disableRedirectHandling()// 禁用重定向机制（从HttpClient的层次取消对自动重定向的支持）
				.setDefaultRequestConfig(defaultRequestConfig)// 注册默认的request配置
				.addInterceptorLast(METRICS_RESETTER)// 添加拦截器
				.addInterceptorFirst(REMOVE_HEADER)// 删除一下请求头
				.setUserAgent("default user-agent")// 设置默认的user agent
				.setDefaultHeaders(defaultHeaders);// 设置默认的请求头
		builder.disableContentCompression();
		return builder.build();
	}

	private static final HttpRequestInterceptor METRICS_RESETTER = new HttpRequestInterceptor() {
		@Override
		public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
			Header[] allHeaders = request.getAllHeaders();
			context.setAttribute("all_request_header", allHeaders);
		}
	};
	private static final HttpRequestInterceptor REMOVE_HEADER = new HttpRequestInterceptor() {
		@Override
		public void process(HttpRequest request, HttpContext context) throws HttpException, IOException {
			request.removeHeaders("Accept-Encoding");
		}
	};
}
