package com.happyride.rideshare.utils;

import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class GlobalUtilities {
    public static String getDateTimeCount(Date d1) {
        Date d2 = new Date();
        long diff = d2.getTime() - d1.getTime();
        long day = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        return day+"";
    }
    public static String getRedirectedUrl(HttpServletRequest request){
        StringBuffer requestURL = new StringBuffer(new UrlPathHelper().getPathWithinApplication(request));
        String queryString = request.getQueryString();
        String redirectedUrl = "";

        if (queryString == null) {
            redirectedUrl = new UrlPathHelper().getPathWithinApplication(request);
            return redirectedUrl;
        } else {
            redirectedUrl = requestURL.append('?').append(queryString).toString();
            return  redirectedUrl;
        }
    }

    public static String tomcatContextPathParent(String path){
        File f = new File(path);
        String orginalPath = f.getParent();
        return orginalPath;
    }

}
