package design_pattern.proxypattern;

public class ChromeBrowser implements IBrowser{

	private String url;
	
	public ChromeBrowser(String url) {
		this.url = url;
	}
	
	@Override
	public Html show() {
		System.out.println("ChromeBrower Loding html form : " + url);
		return new Html(url);
	}

}
