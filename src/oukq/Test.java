package oukq;

import tools.FileUtils;
import tools.ShowPict;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "http://img1.gtimg.com/news/pics/hv1/233/101/1558/101334938.jpg";
		String fpath = "D://163.html";
//		String content = HttpClientStaticMethod.getHtmlByUrl(path);
//		if(null == content || content.isEmpty()){
//			System.out.println("���ַ���");
//		} else {
//			String res = FileUtils.outToNewFile(fpath,content);
//			if(!res.isEmpty()){
//				System.out.println("success!");
//				return;
//			}
//			
//		}
//		System.out.println("fail!");
		String res = HttpClientStaticMethod.getPictFromUri(path);
		if(null == res || res.isEmpty()){
			System.out.println("�޷���ȡͼƬ");
			return;
		} else {
			System.out.println("�ɹ���");
		}
		new ShowPict(res).setVisible(true);
	}
	
	public void test(){
	}

}
