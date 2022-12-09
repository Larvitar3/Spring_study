package design_pattern.proxypattern;

public class MainTest {
	
	public static void main(String[] args) {
		
		System.out.println("aaa");
		ChromeBrowser browser = new ChromeBrowser("www.naver.com");
		
		// 대신 HTML을 생성해주고 있다.
		// 외부에서는 Browser를 실행시키기만 한다
//		browser.show();
		
		BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		browserProxy.show();
		
	}
}
