package androidlabs.gsheets2.model;


import java.util.Date;

public class MyDataModel {


    private Long id;

    private String name;

    private String phoneNumber;

    private String emailId;

    private String meal;

    private float tasteRating;

    private float looksRating;

    private float amountRating;

    private float sidesRating;

    private float priceRating;

    private float overallRating;

    private String commentsSuggestions;

    private Date date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public float getTasteRating() {
        return tasteRating;
    }

    public void setTasteRating(float tasteRating) {
        this.tasteRating = tasteRating;
    }

    public float getLooksRating() {
        return looksRating;
    }

    public void setLooksRating(float looksRating) {
        this.looksRating = looksRating;
    }

    public float getSidesRating() {
        return sidesRating;
    }

    public void setSidesRating(float sidesRating) {
        this.sidesRating = sidesRating;
    }

    public float getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(float priceRating) {
        this.priceRating = priceRating;
    }

    public float getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(float overallRating) {
        this.overallRating = overallRating;
    }

    public String getCommentsSuggestions() {
        return commentsSuggestions;
    }

    public void setCommentsSuggestions(String commentsSuggestions) {
        this.commentsSuggestions = commentsSuggestions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmountRating() {
        return amountRating;
    }

    public void setAmountRating(float amountRating) {
        this.amountRating = amountRating;
    }
}