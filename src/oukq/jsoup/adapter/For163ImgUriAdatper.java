package oukq.jsoup.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import oukq.init.StaticProperty;

public class For163ImgUriAdatper implements ImgUriAdapter{
	
	public String pathFor163 = StaticProperty.PIC_DIR + "/163";
	
	public For163ImgUriAdatper(){
		File f = new File(pathFor163);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
	public List<String> getUris(String html) {
		List<String> uris = new ArrayList<String>();
		if(null == html|| html.isEmpty()){
			return null;
		}
		Document doc = Jsoup.parse(html);
		Elements imgs = doc.select("img[src$=.jpg]");
		for(Element e : imgs){
			uris.add(e.attr("src"));
		}
		return uris;
	}

	@Override
	public String getDir() {
		return pathFor163;
	}
 
	

}
