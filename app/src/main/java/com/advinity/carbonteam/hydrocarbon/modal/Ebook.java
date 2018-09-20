package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 02/12/16.
 */

public class Ebook {
    private String title;
    private String subtitle;
    private String writer;
    private int thumbnail;
    private int image;
    private String edition;
    private String year;
    private String description;
    private String url;

    public Ebook(String title, String subtitle, String writer, int thumbnail, int image, String edition, String year, String description, String url) {
        this.title = title;
        this.subtitle = subtitle;
        this.writer = writer;
        this.thumbnail = thumbnail;
        this.image = image;
        this.edition = edition;
        this.year = year;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
