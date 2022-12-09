package design_pattern.proxypattern.aop;

import design_pattern.proxypattern.Html;
import design_pattern.proxypattern.IBrowser;

public class AopBrowser implements IBrowser{
	
	private String url;
	private Html html;
	private Runnable before;
	private Runnable after;

	public AopBrowser(String url, Runnable before, Runnable after) {
		this.url = url;
		this.before = before;
		this.after = after;
	}
	
	@Override
	public Html show() {
		
		before.run();
		
		if(html == null) {
			System.out.println("url : " + url);
			this.html = new Html(url);
			
			try {
				Thread.sleep(1500);
			} catch (Exception e) {
				
			}
		}
		
		after.run();
		System.out.println("use html : " + url);
		return html;
	}

}
