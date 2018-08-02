package urlshortner;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UrlDetailsRepository;
import entity.Urldetails;

@Service
public class UrlShortenerImpl implements UrlShortener {

	@Autowired
	private UrlDetailsRepository urlDetailsRepository;
	
	@Override
	public String urlToShortUrl(String url) throws Exception {
		// Save url to database and get integer id
		Urldetails urldetails = new Urldetails();
		urldetails.setUrl(url);
		urldetails.setCreatedDate(new Date());
		LocalDate localDate = LocalDate.now().plusDays(30);
		urldetails.setExpiryDate(Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		urlDetailsRepository.save(urldetails);
		return APP_URL + UrlShortener.encode(urldetails.getUrlDetailsID());
	}

	@Override
	public Urldetails shortURLtoUrl(String shortURL) throws Exception {
		// convert shorturl to id and get from database
		int n = UrlShortener.decode(shortURL);
		//fetch original url from database using n and return original url
		Urldetails urldetails = urlDetailsRepository.findByUrlDetailsID(n);
		return urldetails;
	}

	@Override
	public void redirectUrlToThirdParty(HttpServletResponse httpServletResponse, String originalUrl) throws Exception {
		httpServletResponse.sendRedirect(originalUrl);
	}


}
