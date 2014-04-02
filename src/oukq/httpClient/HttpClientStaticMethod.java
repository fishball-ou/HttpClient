package oukq.httpClient;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	 * 
	 */
	public static String getHtmlByUrl(String Path){
		StringBuffer html1 = new StringBuffer();
		String html = null;
		//
		if(!Path.startsWith("http://")){
			Path = "http://" + Path;
		}
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet httpGet = new HttpGet(Path);
		try {
			HttpResponse httpResponse = httpClient.execute(httpGet);
			int resStatus = httpResponse.getStatusLine().getStatusCode();
			if(HttpStatus.SC_OK == resStatus){
				HttpEntity httpEntity = httpResponse.getEntity();
				//toString
//				html = EntityUtils.toString(httpEntity);
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpEntity.getContent(),"GB18030"));
				String lineMessage;
				while((lineMessage = reader.readLine())!=null){
					html1.append(lineMessage);
				}
				reader.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		System.out.println(html1.toString());
		return html1.toString();
	}
	/**
	 * 
	 * @param uri ͼƬuri
	 * @return filePath ͼƬ���ص�ַ
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
