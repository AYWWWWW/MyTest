package com.oth.httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

/**
 * by anyanwen
 * 2017/5/23.
 */
public class HttpClientImp {
	public static void main(String[] args) throws Exception {
		String postBody = "5D34D22873D252501C2AA1D35716F19D\u001DvLQeKJyez4LZMOQtZDuyehUJ1/l" +
				"rxWz4/L/aL2B8kqRqJvzyPqQ7Y+8D7r3z9QyNj0N7rxG8kobHXw2G4ntqE+4gzy2Bhph1N8n9" +
				"ACKFSQfC/KddpOLg/kBUiWRFCEICtznapCxhiJpqfS7bfVLwhMB1BokV73bbcFqnnFj7S3DH8Yjv" +
				"1jP9P/M5GujgAWEvjOXXN/LK+SM9a8wo/6eR1onl7axHsuqPcYtKLYDtYORz+aEqhM15HaFDKktNP" +
				"PofQlZUiuofTGVM1UxwXPw+HQ==\u001DJQ3ZcKVZr4lxMCyC1xdxu4SU6UcxjpdwOy0Yt4DffuYU3VPD" +
				"Y7l4IrTau9lsWFHvHYhk1pJOu7KcekYdUE6XhPWqq6d6Is28YoqCojQUBqjoFZNJy8sQ/tBIMka6k8lQ6o" +
				"FLw6o/Mz5glanvQb5X7EKssxc0UxWsAVwmfrd+Lxg=";

		String uriStr = "https://fshl.zj96596.com/mfs/channel/http.do";
		String agent = "andriod";

		URI uri = new URI(uriStr);

		HttpRequestBase request = new HttpPost(uri);
		request.addHeader("user-agent", agent);
		request.addHeader("Connection", "Keep-Alive");
		request.addHeader("Accept-Encoding", "gzip");
		request.addHeader("Content_Type", "application/json;charset=utf-8");

		CloseableHttpClient client = HttpClientBuilder.create().build();
//		((HttpPost) request).setEntity(new StringEntity(postBody, Charset.defaultCharset()));
		CloseableHttpResponse response = client.execute(request);
	}
}
