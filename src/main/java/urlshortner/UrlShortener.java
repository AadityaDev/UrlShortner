package urlshortner;

import javax.servlet.http.HttpServletResponse;

import entity.Urldetails;

public interface UrlShortener {

	String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    int BASE = ALPHABET.length();
    String APP_URL = "http://localhost:8080/";
    
    static String encode(int num) {
        StringBuilder sb = new StringBuilder();
        while ( num > 0 ) {
            sb.append( ALPHABET.charAt( num % BASE ) );
            num /= BASE;
        }
        return sb.reverse().toString();   
    }

    static int decode(String str) {
        int num = 0;
        for ( int i = 0; i < str.length(); i++ )
            num = num * BASE + ALPHABET.indexOf(str.charAt(i));
        return num;
    } 
	
    String urlToShortUrl(String url) throws Exception;
    
    Urldetails shortURLtoUrl(String shortURL) throws Exception;
    
    void redirectUrlToThirdParty(HttpServletResponse httpServletResponse, String originalUrl) throws Exception;
    
}
