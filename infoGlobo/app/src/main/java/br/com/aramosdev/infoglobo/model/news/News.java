package br.com.aramosdev.infoglobo.model.news;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Alberto.Ramos on 09/09/17.
 */

public class News implements Serializable {
    @SerializedName("conteudos")
    private List<ContentNews> contentNewses;
    @SerializedName("produto")
    private String productName;

    public List<ContentNews> getContentNewses() {
        return contentNewses;
    }

    public void setContentNewses(List<ContentNews> contentNewses) {
        this.contentNewses = contentNewses;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
