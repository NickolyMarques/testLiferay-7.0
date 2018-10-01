package com.custom.page;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"servlet-context-name=",
		"servlet-filter-name=Custom Filter",
		"url-pattern=/web/*"
	},
	service = Filter.class
)
public class CustomPage extends BaseFilter {

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {

		HttpSession session = request.getSession (); 
		LastPath currentLastPath = (LastPath) session.getAttribute (WebKeys.LAST_PATH);
		System.out.println("Page Visited: " + currentLastPath);
		filterChain.doFilter(request, response);
	}

	@Override
	protected Log getLog() {
		// TODO Auto-generated method stub
		return null;
	}

}