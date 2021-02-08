package com.codeup.adlister.controllers;
import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.SearchAdServlet", urlPatterns = "/search_ads")
public class SearchAdsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        request.getRequestDispatcher("/WEB-INF/search_ads.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String searched_ad = request.getParameter("searched_ads");
        request.setAttribute("searched_ads", DaoFactory.getAdsDao().searchForAds(searched_ad));
        request.getRequestDispatcher("/WEB-INF/search_ads.jsp").forward(request, response);
    }
}
