package by.constpe.lab3.model;

import java.io.Serializable;

public class Bridge implements Serializable {
    private String name;
    private String height;
    private String description;
    private String tableImage;
    private String detailImage;
    private String url;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTableImage() {
        return tableImage;
    }

    public void setTableImage(String tableImage) {
        this.tableImage = tableImage;
    }

    public String getDetailImage() {
        return detailImage;
    }

    public void setDetailImage(String detailImage) {
        this.detailImage = detailImage;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
