package com.salon.visibleelegance.models;

import javax.persistence.*;

@Entity
@Table(name="gallery_images")
public class GalleryImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String url;

    // relationship
    // many images to one gallery tag
    @ManyToOne
    private GalleryTag tag;

    public GalleryImage(){}

    public GalleryImage(String url) {
        this.url = url;
    }

    public GalleryImage(long id, String url) {
        this.id = id;
        this.url = url;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public GalleryTag getTag() {
        return tag;
    }

    public void setTag(GalleryTag tag) {
        this.tag = tag;
    }
}
