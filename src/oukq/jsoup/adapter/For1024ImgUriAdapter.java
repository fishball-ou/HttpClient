package oukq.jsoup.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import oukq.init.StaticProperty;

public class For1024ImgUriAdapter implements ImgUriAdapter{
	public String for1024Path = StaticProperty.PIC_DIR + "1024";
	
	public For1024ImgUriAdapter(){
		File f = new File(for1024Path);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
	@Override
	public String getDir() {
		return for1024Path;
	}

	@Override
	public List<String> getUris(String html) {
		if(null == html||html.isEmpty()){
			return null;
		}
		List<String> urisList = new ArrayList<String>();
		Document document = Jsoup.parse(html);
		Elements uris = document.select("input[src$=.jpg]");
		for(Element e: uris){
			String uri = e.attr("src");
			urisList.add(uri);
		}
//		for(String uri: urisList){
//			System.out.println(uri);
//		}
//		System.out.println(urisList.size());
		return urisList;
	}

}
