package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.Ad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.ViewAdServlet", urlPatterns = "/ads/view-ad")
public class ViewAdServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idString = request.getParameter("id");
        long id = Long.parseLong(idString);

        request.setAttribute("ad", DaoFactory.getAdsDao().viewAd(id));
        request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);
    }
}
