package com.upgrad.hirewheels.entities;
import javax.persistence.*;

@Entity
public class City {

    @Id
    @Column(name = "city_id")
    private  int cityId;

    @Column(name = "city_name", length = 50, nullable = false)
    private String cityName;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{cityId="+cityId
                +", cityName"+cityName
                +"}";
    }
}
