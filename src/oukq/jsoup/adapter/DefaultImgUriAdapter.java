package oukq.jsoup.adapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import oukq.init.StaticProperty;

public class DefaultImgUriAdapter implements ImgUriAdapter{
	
	private String path = StaticProperty.PIC_DIR + "/default";
	
	public DefaultImgUriAdapter(){
		File f = new File(path);
		if(!f.exists() && !f.isFile()){
			f.mkdir();
		}
	}
	public DefaultImgUriAdapter(String dictionary){
		path = StaticProperty.PIC_DIR + "/" + dictionary;
	}
	@Override
	public String getDir() {
		return path;
	}

	@Override
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

}
