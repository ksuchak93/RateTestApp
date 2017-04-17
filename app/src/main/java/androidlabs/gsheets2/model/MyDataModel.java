package androidlabs.gsheets2.model;


import java.util.Date;

public class MyDataModel {


    private Long id;

    private String name;

    private String phoneNumber;

    private String emailId;

    private String meal;

    private Long tasteRating;

    private Long looksRating;

    private Long sidesRating;

    private Long priceRating;

    private Long overallRating;

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

    public Long getTasteRating() {
        return tasteRating;
    }

    public void setTasteRating(Long tasteRating) {
        this.tasteRating = tasteRating;
    }

    public Long getLooksRating() {
        return looksRating;
    }

    public void setLooksRating(Long looksRating) {
        this.looksRating = looksRating;
    }

    public Long getSidesRating() {
        return sidesRating;
    }

    public void setSidesRating(Long sidesRating) {
        this.sidesRating = sidesRating;
    }

    public Long getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(Long priceRating) {
        this.priceRating = priceRating;
    }

    public Long getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Long overallRating) {
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
}