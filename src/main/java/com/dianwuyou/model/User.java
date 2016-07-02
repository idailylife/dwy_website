package com.dianwuyou.model;

import com.dianwuyou.util.Encoding;
import com.mysql.jdbc.Blob;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by hebowei on 16/6/10.
 */
@Entity
@Table(name = "user")
public class User {
    public static final int USERTYPE_REQUESTER = 0;
    public static final int USERTYPE_WORKER = 1;

    public static final int TAOBAO_RANK_LE_2STAR = 0; //1❤️到2❤️
    public static final int TAOBAO_RANK_LE_5STAR = 1; //3-5❤️
    public static final int TAOBAO_RANK_LE_2DIAM = 2; //1-2钻
    public static final int TAOBAO_RANK_GE_3DIAM = 3; //3钻及以上

    public static Double getUnitPrice(int RANK){
        switch (RANK){
            case TAOBAO_RANK_LE_2STAR:
                return 5.0;
            case TAOBAO_RANK_LE_5STAR:
                return 6.0;
            case TAOBAO_RANK_LE_2DIAM:
                return 7.0;
            case TAOBAO_RANK_GE_3DIAM:
                return 8.0;
            default:
                return 0.0;
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name= "type", nullable = false)
    private Integer type;

    @Column(name = "email", unique = true, nullable = false)
    @Length(max = 64)
    @Email
    @NotNull
    private String email;

    @Column(name = "password", nullable = false)
    @Length(max = 256)
    private String password;

    @Column(name = "salt", nullable = false)
    @Length(max = 64)
    private String salt;

    @Column(name = "token")
    @Length(max = 64)
    private String token;

    @Column(name = "gender")
    @Length(max = 10)
    private String gender;

    @Column(name = "phone_number", nullable = false)
    @Length(min = 11, max = 45)
    private String phoneNumber;

    @Column(name = "inviter")
    private Integer inviter;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "score", nullable = false)
    @Min(0)
    private Long score;

    @Column(name = "taobao_id")
    @Length(max = 64)
    private String taobaoId;

    @Column(name = "invite_code")
    @Length(max = 64)
    private String inviteCode;

    @Column(name = "real_name")
    @Length(max = 64)
    private String realName;

    @Column(name = "age")
    @Min(0)
    @Max(150)
    private Integer age;

    @Column(name = "taobao_rank")
    private Integer taobaoRank;

    @Column(name = "personal_id")
    @Length(min = 15, max = 18)
    private String personalId;

    @Column(name = "alipay_id")
    @Length(max = 64)
    private String alipayId;

    @Column(name = "province")
    @Length(max = 16)
    private String province;

    @Column(name = "city")
    @Length(max = 16)
    private String city;

    @Column(name = "district")
    @Length(max = 16)
    private String district;

    @Column(name = "street_address")
    @Length(max = 64)
    private String streetAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_photo")
    private UpdFile idPhoto;    //身份证正面

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_photo1")
    private UpdFile idPhoto1;   //手持身份证

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "living_photo")
    private UpdFile livingPhoto;//生活照

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "verify_photo")
    private UpdFile verifyPhoto;//手势验证照

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "screenshot_img")
    private UpdFile screenshotImg;//认证用聊天截图

    @Column(name = "qq")
    private String qq;

    @Column(name = "reputation")
    private Integer reputation;

    @NotNull
    @Column(name = "user_validation_state")
    private Integer userValidationState;    //0 - Not validated, 1 - Verified, 2 - Failed

    @NotNull
    @Column(name = "shop_validation_state")
    private Integer shopValidationState;    //0 - Not validated, 1 - Verified, 2 - Failed

    @Column(name = "version")
    @Version
    private Integer version;    //乐观锁

    public User(){
        score = 0L;
        balance = 0.0;
        reputation = 0;
        userValidationState = 0;
        shopValidationState = 0;
    }

    //Methods
    public void fillPersionInfo(UserValdation userValdation)
            throws IOException, SQLException{
        realName = userValdation.realName;
        personalId = userValdation.personalId;
        gender = userValdation.gender;
        age = userValdation.age;
        taobaoRank = userValdation.taobaoRank;
        alipayId = userValdation.alipayId;
        province = userValdation.province;
        city = userValdation.city;
        district = userValdation.district;
        streetAddress = userValdation.streetAddress;
        idPhoto = new UpdFile();
        idPhoto.setFilename(userValdation.idPhoto.getOriginalFilename());
        idPhoto.setContent(new SerialBlob(
                userValdation.idPhoto.getBytes()
        ));
        idPhoto1 = new UpdFile();
        idPhoto1.setFilename(userValdation.idPhoto1.getOriginalFilename());
        idPhoto1.setContent(new SerialBlob(userValdation.idPhoto1.getBytes()));
    }

    public void generateSaltPassword(){
        //MD5(salt + MD5(password))
        //Assume the password is already encoded at the frontend
        password = Encoding.getEncodedString(salt + password);
    }

    @Override
    public boolean equals(Object obj) {
        if(! (obj instanceof User)){
            return false;
        }
        if(((User) obj).getId() == null || this.id == null)
            return false;
        return ((User) obj).id.equals(id);
    }

    @Override
    public int hashCode() {
        if(id == null){
            return -1;
        }
        return id;
    }


    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getInviter() {
        return inviter;
    }

    public void setInviter(Integer inviter) {
        this.inviter = inviter;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public String getTaobaoId() {
        return taobaoId;
    }

    public void setTaobaoId(String taobaoId) {
        this.taobaoId = taobaoId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getTaobaoRank() {
        return taobaoRank;
    }

    public void setTaobaoRank(Integer taobaoRank) {
        this.taobaoRank = taobaoRank;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
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

    public UpdFile getIdPhoto() {
        return idPhoto;
    }

    public void setIdPhoto(UpdFile idPhoto) {
        this.idPhoto = idPhoto;
    }

    public UpdFile getIdPhoto1() {
        return idPhoto1;
    }

    public void setIdPhoto1(UpdFile idPhoto1) {
        this.idPhoto1 = idPhoto1;
    }

    public UpdFile getLivingPhoto() {
        return livingPhoto;
    }

    public void setLivingPhoto(UpdFile livingPhoto) {
        this.livingPhoto = livingPhoto;
    }

    public UpdFile getVerifyPhoto() {
        return verifyPhoto;
    }

    public void setVerifyPhoto(UpdFile verifyPhoto) {
        this.verifyPhoto = verifyPhoto;
    }

    public UpdFile getScreenshotImg() {
        return screenshotImg;
    }

    public void setScreenshotImg(UpdFile screenshotImg) {
        this.screenshotImg = screenshotImg;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getUserValidationState() {
        return userValidationState;
    }

    public void setUserValidationState(Integer userValidationState) {
        this.userValidationState = userValidationState;
    }

    public Integer getShopValidationState() {
        return shopValidationState;
    }

    public void setShopValidationState(Integer shopValidationState) {
        this.shopValidationState = shopValidationState;
    }
}
