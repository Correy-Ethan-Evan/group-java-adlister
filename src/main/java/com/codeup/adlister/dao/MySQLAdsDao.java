package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.applet.Applet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO ads(user_id, title, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

    @Override
    public List<Ad> searchForAds(String searched_ad) {
        String query = "SELECT * FROM ads WHERE title LIKE ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, searched_ad);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a Ad by Title", e);
        }
    }

    @Override
    public Ad viewAd(long id) {
        try {
            String selectAd = "SELECT id, user_id, title, description FROM ads WHERE id = ? LIMIT 1";
            PreparedStatement stmt = connection.prepareStatement(selectAd);
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ad.", e);
        }
    }

    @Override
    public boolean delete(long id) {
        try {
            System.out.println(id);
            String deleteQuery = "DELETE FROM ads WHERE id = " + id;
            PreparedStatement stmt = connection.prepareStatement(deleteQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting an ad.", e);
        }
    }

@Override
    public List<Ad> userAds(User user) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads WHERE user_id = ?");
            stmt.setLong(1, user.getId());
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving user ads.", e);
        }

    }

}
