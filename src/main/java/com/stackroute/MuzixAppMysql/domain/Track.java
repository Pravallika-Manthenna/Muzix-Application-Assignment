package com.stackroute.MuzixAppMysql.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

@Entity
@Table(name = "Track")
@Data
@NoArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    //declaring variables
    private int id;

    private String name;

    private String artist;

    private String url;

    private String streamable;

    private int listeners;

    //generating setters and getters for the declared variables
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public int getListeners() {
        return listeners;
    }

    public void setListeners(int listeners) {
        this.listeners = listeners;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //constructor for the declared variables 
    public Track(int id, String name, String artist, String url, String streamable, int listeners) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.url = url;
        this.streamable = streamable;
        this.listeners = listeners;
    }
}
