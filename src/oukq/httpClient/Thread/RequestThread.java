package oukq.httpClient.Thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import oukq.httpClient.HttpClientStaticMethod;
import oukq.httpClient.vo.HttpRequestGetVo;
import oukq.init.StaticProperty;
import oukq.jsoup.Factory.AdapterFactory;
import oukq.jsoup.adapter.For1024ImgUriAdapter;
import oukq.jsoup.adapter.ImgUriAdapter;


public class RequestThread extends Thread{
	private HttpRequestGetVo httpRequestGetVo;
	public RequestThread(HttpRequestGetVo httpRequestGetVo){
		this.httpRequestGetVo = httpRequestGetVo;
	}
//	
	@Override
	public void run(){
		CloseableHttpClient httpClient = httpRequestGetVo.getHttpClient();
		HttpGet httpGet = httpRequestGetVo.getHttpGet();
		String dir = httpRequestGetVo.getPic_dir();
		StringBuffer html1 = new StringBuffer();
		try {
			CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
			int resStatus = httpResponse.getStatusLine().getStatusCode();
			if(HttpStatus.SC_OK == resStatus){
				HttpEntity httpEntity = httpResponse.getEntity();
				//toString
//				html = EntityUtils.toString(httpEntity);
				BufferedReader reader = new BufferedReader(new InputStreamReader(httpEntity.getContent(),"gbk"));
				String lineMessage;
				while((lineMessage = reader.readLine())!=null){
					html1.append(lineMessage);
				}
				reader.close();
				EntityUtils.consume(httpEntity);
				httpResponse.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		AdapterFactory af = new AdapterFactory();
		ImgUriAdapter adapter =  af.getImgUriAdapter(StaticProperty.TYPE_1024);
		List<String> uris = adapter.getUris(html1.toString());
		String dirPath = adapter.getDir();
		for(String uri:uris){
			HttpClientStaticMethod.downLoadPictFromUri(uri, dirPath);
		}
		
	}
}
