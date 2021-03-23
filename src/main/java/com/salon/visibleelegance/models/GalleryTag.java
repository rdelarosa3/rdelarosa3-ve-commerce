package com.salon.visibleelegance.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="gallery_tags")
public class GalleryTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    // relationships
    @OneToMany(mappedBy = "tag")
    private Set<GalleryImage> galleryImages = new HashSet<>();

    public GalleryTag(){}

    public GalleryTag(String name) {
        this.name = name;
    }

    public GalleryTag(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<GalleryImage> getGalleryImages() {
        return galleryImages;
    }

    public void setGalleryImages(Set<GalleryImage> galleryImages) {
        this.galleryImages = galleryImages;
    }
}
