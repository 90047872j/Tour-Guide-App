package com.example.juan.tourguideapp;

class Location {

    private String locationName;
    private String locationAddress;
    private String locationPhone;
    private String locationWebPage;
    private String locationEmail;
    private static final int NO_IMAGE_PROVIDED = -1;
    private int imageResourceId = NO_IMAGE_PROVIDED;

    public Location(String locationName, String locationWebPage, String locationAddress, String locationPhone, String locationEmail, int imageResourceId) {
        this.locationName = locationName;
        this.locationWebPage = locationWebPage;
        this.locationAddress = locationAddress;
        this.locationPhone = locationPhone;
        this.locationEmail = locationEmail;
        this.imageResourceId = imageResourceId;
    }

    public String getLocationName() {
        return locationName;
    }

    public String getlocationWebPage() {
        return locationWebPage;
    }

    public String getlocationAddress() {
        return locationAddress;
    }

    public String getlocationPhone() {
        return locationPhone;
    }

    public String getlocationEmail() {
        return locationEmail;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
