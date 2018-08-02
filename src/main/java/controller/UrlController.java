package controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.Urldetails;
import urlshortner.UrlShortener;

@Controller
public class UrlController {

	@Autowired
	private UrlShortener urlShortener;
	
	@RequestMapping("/")
	String entry(Model model) {
		return "urlview";
	}
	
	@RequestMapping(value="/urlshorten", method = RequestMethod.POST)
	   public String urlshorten(@RequestParam("url") String url, Model model) {
			try {
				model.addAttribute("url", urlShortener.urlToShortUrl(url));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "urlshortview";
	   }
	
	@ResponseBody
	@RequestMapping(value="/{url}", method = RequestMethod.GET)
	   public String originalurl(@PathVariable("url") String url, HttpServletResponse httpServletResponse) {
		Urldetails urldetails = null;	
		try {
				urldetails = urlShortener.shortURLtoUrl(url);
				if(null != urldetails) {
					Date today = new Date();
					if(urldetails.getCreatedDate().before(urldetails.getExpiryDate())) {
						urlShortener.redirectUrlToThirdParty(httpServletResponse, urldetails.getUrl());
					} else {
						return "URL time expires";
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "URL not exist. Please create short url and then try again ";
	   }
	
}
