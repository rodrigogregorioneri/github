package com.example.rodrigoneri.github.models;

/**
 * Created by rodrigo.neri on 18/10/2017.
 */

public class DTOExample {
    private String name;
    private String login;
    private String stargazerscount;
    private String avatarurl;
    private String forkscount;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getStargazerscount() {
        return stargazerscount;
    }

    public void setStargazerscount(String stargazerscount) {
        this.stargazerscount = stargazerscount;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getForkscount() {
        return forkscount;
    }

    public void setForkscount(String forkscount) {
        this.forkscount = forkscount;
    }
}
