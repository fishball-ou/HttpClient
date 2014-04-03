package oukq.httpClient.vo;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

public class HttpRequestGetVo {
	private CloseableHttpClient httpClient;
	private HttpGet httpGet;
	//图片存放地址
	private String pic_dir;
	
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}
	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}
	public HttpGet getHttpGet() {
		return httpGet;
	}
	public void setHttpGet(HttpGet httpGet) {
		this.httpGet = httpGet;
	}
 
	public String getPic_dir() {
		return pic_dir;
	}
	public void setPic_dir(String pic_dir) {
		this.pic_dir = pic_dir;
	}
}
