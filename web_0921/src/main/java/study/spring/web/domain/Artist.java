package study.spring.web.domain;

public class Artist {
    private Long artistIdx;

    private String name;

    private int debutYear;

    public Long getArtistIdx() {
        return artistIdx;
    }

    public void setArtistIdx(Long artistIdx) {
        this.artistIdx = artistIdx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDebutYear() {
        return debutYear;
    }

    public void setDebutYear(int debutYear) {
        this.debutYear = debutYear;
    }
}
