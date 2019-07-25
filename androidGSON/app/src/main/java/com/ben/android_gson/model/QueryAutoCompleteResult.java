package com.ben.android_gson.model;

public class QueryAutoCompleteResult {

    public class Prediction {
        public String description;
        public String id;
        public String place_id;
        public String reference;
    }

    public Prediction[] predictions;
    public String status;
}
