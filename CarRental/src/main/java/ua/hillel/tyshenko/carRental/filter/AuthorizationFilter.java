//package ua.hillel.tyshenko.carRental.filter;
//
//import com.mysql.jdbc.Connection;
//import com.sun.deploy.net.HttpRequest;
//import org.apache.log4j.Logger;
//import ua.hillel.tyshenko.carRental.model.Administrator;
//import ua.hillel.tyshenko.carRental.utils.ApplicationLogger;
//import ua.hillel.tyshenko.carRental.utils.StoreAndCookieUtil;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//
//
///**
// * Created by roman on 31.08.16.
// */
//@WebFilter(filterName = "AuthorizationFilter")
//public class AuthorizationFilter implements Filter  {
//
//    static final Logger logger = ApplicationLogger.getLogger(AuthorizationFilter.class);
//
//    public AuthorizationFilter() {
//    }
//
//    public void destroy() {
//    }
//
//    public void doFilter(ServletRequest request, ServletResponse resp, FilterChain chain) throws ServletException, IOException,  {
//        chain.doFilter(request, resp);
//        Administrator loginedAdministrator = StoreAndCookieUtil.getLoginedAdministrator(request.getSession());
//
//            Connection connection = StoreAndCookieUtil.getStoredConnection(request);
//        if (connection )
//
//
//    }
//
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//}
