package design_pattern.proxypattern;

public class BrowserProxy implements IBrowser {

	private String url;
	private Html html;

	public BrowserProxy(String url) {
		this.url = url;
	}

	@Override
	public Html show() {
		// 핵심 기능 추가

		if (html == null) {
			
			System.out.println("url : " + url);
			
			this.html = new Html(url);
			
		}

		System.out.println("use html : " + url);

		return html;
	}

}
