package com.dianwuyou.model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by hebowei on 16/7/2.
 */
public class UserValdation {
    @NotNull
    @Size(max = 32)
    String realName;

    @NotNull
    @Size(max = 18)
    String personalId;

    @NotNull
    @Size(max = 10)
    String gender;

    @NotNull
    int age;

    @NotNull
    int taobaoRank;

    @NotNull
    String alipayId;

    @NotNull
    String province;

    @NotNull
    String city;

    @NotNull
    String district;

    @NotNull
    @Size(max = 50)
    String streetAddress;

    @NotNull
    MultipartFile idPhoto;

    @NotNull
    MultipartFile idPhoto1;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTaobaoRank() {
        return taobaoRank;
    }

    public void setTaobaoRank(int taobaoRank) {
        this.taobaoRank = taobaoRank;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public MultipartFile getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(MultipartFile idPhoto) {
        this.idPhoto = idPhoto;
    }

    public MultipartFile getIdPhoto1() {
        return idPhoto1;
    }

    public void setIdPhoto1(MultipartFile idPhoto1) {
        this.idPhoto1 = idPhoto1;
    }
}
