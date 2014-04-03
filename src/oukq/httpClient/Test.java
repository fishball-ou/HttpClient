package oukq.httpClient;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import oukq.httpClient.Thread.RequestThread;
import oukq.httpClient.vo.HttpRequestGetVo;
import oukq.jsoup.adapter.For1024ImgUriAdapter;
import oukq.jsoup.filter.GedListFilter;
import oukq.tools.FileUtils;



public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "http://184.154.178.130/thread0806.php?fid=16&search=&page=2";
//		String path = "D://1024.txt";
//		String fpath = "D://1024List.txt";
		ExecutorService pool = Executors.newFixedThreadPool(20);
		//从url获取页面信息
		String content = HttpClientStaticMethod.getHtmlByUrl(path);
		//从本地文件读取信息
//		String content = FileUtils.LoadFile(path);
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
		cmsg.setMaxTotal(100);
		//创建httpClient有连接池管理
		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cmsg).build();
		int num = urisList.size();
		CountDownLatch latch = new CountDownLatch(num);
		for(int i=0 ;i<num;i++){
			HttpRequestGetVo httpRequestGetVo = new HttpRequestGetVo();
			httpRequestGetVo.setHttpClient(httpClient);
			httpRequestGetVo.setHttpGet(new HttpGet(urisList.get(i)));
			httpRequestGetVo.setLatch(latch);
			Thread t = new RequestThread(httpRequestGetVo);
			pool.execute(t);
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		FileUtils.deletedUselessFiles(new For1024ImgUriAdapter().getDir());
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
