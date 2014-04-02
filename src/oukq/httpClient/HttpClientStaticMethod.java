package oukq.httpClient;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.util.EntityUtils;

import oukq.init.StaticProperty;
import oukq.tools.FileUtils;

public class HttpClientStaticMethod {
	@SuppressWarnings("deprecation")
	/**
	 * 根据地址获取页面源码
	 */
	public static String getHtmlByUrl(String Path){
		String html = null;
		//地址必须是http://开头
		if(!Path.startsWith("http://")){
			Path = "http://" + Path;
		}
		//httpclient 对象
		HttpClient httpClient = new DefaultHttpClient();
		//Get方式请求
		HttpGet httpGet = new HttpGet(Path);
//	    HttpPost httpPost = new HttpPost(Path);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			//获取状态码
			int resStatus = httpResponse.getStatusLine().getStatusCode();
			if(HttpStatus.SC_OK == resStatus){
				//获取结果entity
				HttpEntity httpEntity = httpResponse.getEntity();
				//toString
				html = EntityUtils.toString(httpEntity);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return html;
	}
	/**
	 * 
	 * @param uri 图片uri
	 * @return filePath 图片本地地址
	 */
	public static String downLoadPictFromUri(String uri,String dirPath){
		String filePath = "";
		HttpClient httpClient = new DefaultHttpClient();
		httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, StaticProperty.TIME_OUT);
		HttpGet get = new HttpGet(uri);
		get.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, StaticProperty.TIME_OUT);
		try {
			HttpResponse res = httpClient.execute(get);
			if(res.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
				HttpEntity entity = res.getEntity();
				byte[] pic = EntityUtils.toByteArray(entity);
				if(pic.length < 0){
					return null;
				}
				filePath = dirPath + uri.substring(uri.lastIndexOf('/'));
				filePath = FileUtils.saveFile(pic, filePath);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return filePath;
	}
	
}
