package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;

import java.util.List;

public interface Ads {
    // get a list of all the ads
    List<Ad> all();
    // insert a new ad and return the new ad's id
    Long insert(Ad ad);
    // get an individual ad
    Ad viewAd(long id);

    boolean delete(long id);

    // get all ads from a user
    List<Ad> userAds(User user);


    List<Ad> searchForAds(String searched_ad);


}
