package com.example.and14_melon;

public class MelonDTO {
    private int album;
    private String title;
    private String artist;

    public MelonDTO(int album, String title, String artist, String rank) {
        this.album = album;
        this.title = title;
        this.artist = artist;
        this.rank = rank;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    private String rank;
}
