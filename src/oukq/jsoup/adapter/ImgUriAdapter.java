package oukq.jsoup.adapter;

import java.util.List;

public interface ImgUriAdapter {
	public  String getDir();
	public List<String> getUris(String html);
}
