package com.codeup.adlister.controllers;


import com.codeup.adlister.dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "controllers.ViewAdServlet", urlPatterns = "/view-ad")
//public class ViewAdServlet extends HttpServlet {
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        request.setAttribute("ads", DaoFactory.getAdsDao().viewAd());
//        request.getRequestDispatcher("/WEB-INF/ads/ad.jsp").forward(request, response);
//    }
//}