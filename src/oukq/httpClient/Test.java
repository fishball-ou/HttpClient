package oukq.httpClient;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.http.HttpClientConnection;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import oukq.httpClient.Thread.RequestThread;
import oukq.httpClient.vo.HttpRequestGetVo;
import oukq.init.StaticProperty;
import oukq.jsoup.adapter.For1024ImgUriAdapter;
import oukq.jsoup.adapter.For163ImgUriAdatper;
import oukq.jsoup.adapter.ImgUriAdapter;
import oukq.jsoup.filter.GedListFilter;
import oukq.tools.FileUtils;
import oukq.tools.ShowPict;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String path = "http://184.154.178.130/thread0806.php?fid=16&search=&page=1";
		String path = "D://1024.txt";
		String fpath = "D://1024List.txt";
//		ExecutorService pool = Executors.newFixedThreadPool(10);
		//从url获取页面信息
//		String content = HttpClientStaticMethod.getHtmlByUrl(path);
		//从本地文件读取信息
		String content = FileUtils.LoadFile(path);
//		Document doc;
//		try {
//			doc = Jsoup.connect(path).get();
//		} catch (IOException e) {
//			e.printStackTrace();
//			return ;
//		}
		List<String> urisList = GedListFilter.filterUrl(content);
		PoolingHttpClientConnectionManager cmsg = new PoolingHttpClientConnectionManager();
		//最大连接数
		cmsg.setMaxTotal(10);
		//创建httpClient有连接池管理
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cmsg).build();
		
		for(int i=0 ;i<=10||i<=urisList.size();i++){
			HttpRequestGetVo httpRequestGetVo = new HttpRequestGetVo();
			httpRequestGetVo.setHttpClient(httpClient);
			httpRequestGetVo.setHttpGet(new HttpGet(urisList.get(i)));
			Thread t = new RequestThread(httpRequestGetVo);
			t.start();
		}
//		StringBuffer list = new StringBuffer();
//		System.out.println(urisList.size());
		//列表链接输出到文件
//		for(String uris:urisList){
//			list.append(uris).append("\r\n");
//		}
//		//
//		FileUtils.outToNewFile(fpath, list.toString()/*doc.toString()*/);
		
//		ImgUriAdapter a = new For1024ImgUriAdapter();
//		List<String> uris = a.getUris(content);
//		for(String uri : uris){
//			HttpClientStaticMethod.downLoadPictFromUri(uri,a.getDir());
//		}
		System.out.println("完成");
		
//		if(null == content || content.isEmpty()){
//			System.out.println("空字符串");
//		} else {
//			String res = FileUtils.outToNewFile(fpath,content);
//			if(!res.isEmpty()){
//				System.out.println("success!");
//				return;
//			}
//			
//		}
//		System.out.println("fail!");
//		String res = HttpClientStaticMethod.getPictFromUri(path);
//		if(null == res || res.isEmpty()){
//			System.out.println("无法获取图片");
//			return;
//		} else {
//			System.out.println("成功！");
//		}
//		new ShowPict(res).setVisible(true);
	}
	
	public void test(){
	}

}
