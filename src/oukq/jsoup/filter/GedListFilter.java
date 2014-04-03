package oukq.jsoup.filter;

import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import oukq.init.StaticProperty;

public class GedListFilter {
	/**
	 * 过滤出可用连接
	 * @return
	 */
	public static List<String> filterUrl(String html){
		List<String> uris = new LinkedList<String>();
		Document doc = Jsoup.parse(html);
		Elements es = doc.select("td>h3>a[href$=.html]");
		for(Element e:es){
			String uri = StaticProperty.HOST_1024+e.attr("href");
			uris.add(uri);
		}
		return uris;
	}
}
