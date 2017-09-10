package br.com.aramosdev.infoglobo.model.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class Content implements Serializable {

    @SerializedName("id")
    private long id;

    @SerializedName("autores")
    private String[] authors;

    @SerializedName("informePublicitario")
    private boolean isPublicityReport;

    @SerializedName("subTitulo")
    private String subTitle;

    @SerializedName("texto")
    private String text;

    @SerializedName("atualizadoEm")
    private String updated;

    @SerializedName("publicadoEm")
    private String published;

    @SerializedName("secao")
    private Section section;

    @SerializedName("tipo")
    private String type;

    @SerializedName("titulo")
    private String title;

    @SerializedName("url")
    private String url;

    @SerializedName("urlOriginal")
    private String originalUrl;

    @SerializedName("imagens")
    private List<Image> images;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public boolean isPublicityReport() {
        return isPublicityReport;
    }

    public void setPublicityReport(boolean publicityReport) {
        isPublicityReport = publicityReport;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
