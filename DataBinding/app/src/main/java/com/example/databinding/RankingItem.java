package com.example.databinding;

public class RankingItem {
    int ranking;
    String name;
    float star;

    public RankingItem(int ranking, String name, float star) {
        this.ranking = ranking;
        this.name = name;
        this.star = star;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getStar() {
        return star;
    }

    public void setStar(float star) {
        this.star = star;
    }
}
