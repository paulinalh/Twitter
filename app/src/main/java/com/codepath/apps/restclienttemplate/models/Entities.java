package com.codepath.apps.restclienttemplate.models;


import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.List;

@Parcel
public class Entities {
    //public Media media;
    //List<Media> media;

    //Empty constructor for Parcel library
    public Entities() {
    }

    public static Entities fromJson(JSONObject jsonObject) throws JSONException {
        Entities entities = new Entities();

        //entities.media = Media.fromJson(jsonObject.getJSONArray("media"));
        return entities;

    }
}
