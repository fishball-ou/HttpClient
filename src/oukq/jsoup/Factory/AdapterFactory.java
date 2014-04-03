package oukq.jsoup.Factory;

import oukq.init.StaticProperty;
import oukq.jsoup.adapter.DefaultImgUriAdapter;
import oukq.jsoup.adapter.For1024ImgUriAdapter;
import oukq.jsoup.adapter.For163ImgUriAdatper;
import oukq.jsoup.adapter.ImgUriAdapter;

public class AdapterFactory {
	
	public  ImgUriAdapter getImgUriAdapter(int type){
		if(StaticProperty.TYPE_1024 == type){
			return new For1024ImgUriAdapter();
		}
		if(StaticProperty.TYPE_163 == type){
			return new For163ImgUriAdatper();
		}
		return new DefaultImgUriAdapter();
	}
}
