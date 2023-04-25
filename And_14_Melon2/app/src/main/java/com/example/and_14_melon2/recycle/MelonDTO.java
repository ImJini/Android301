package com.example.and_14_melon2.recycle;

public class MelonDTO {
    private int album, rank;
    private String title, artist;

    public MelonDTO(int album, int rank, String title, String artist) {
        this.album = album;
        this.rank = rank;
        this.title = title;
        this.artist = artist;
    }

    public int getAlbum() {
        return album;
    }

    public void setAlbum(int album) {
        this.album = album;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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
}
