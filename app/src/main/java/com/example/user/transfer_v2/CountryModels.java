package com.example.user.transfer_v2;

/**
 * Created by User on 2017-05-22.
 */

public class CountryModels {

    private String      countryName         = null;
    private String      countryCurremcy     = null;
    private int         imageId             = 0;


    public CountryModels() {

    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryCurremcy(String currency) {
        countryCurremcy = currency;
    }

    public String getCountryCurremcy() {
        return countryCurremcy;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

}
