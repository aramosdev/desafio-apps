package br.com.aramosdev.infoglobo.model.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class News implements Serializable {
    @SerializedName("conteudos")
    private List<Content> contents;
    @SerializedName("produto")
    private String productName;

    public List<Content> getContents() {
        return contents;
    }

    public void setContents(List<Content> contents) {
        this.contents = contents;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
