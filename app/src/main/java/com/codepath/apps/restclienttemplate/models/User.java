package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

@Parcel
public class User {
    //User is an object of Tweet. This class extracts the details of User from Json

    public String name;
    public String screenName;
    public String profileImageUrl;

    //Empty constructor for Parcel library
    public User() {
    }

    //In this method we assign the keys from the Json file for each field  to the String
    // variables defined at the top of the page
    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        return user;

    }
}
