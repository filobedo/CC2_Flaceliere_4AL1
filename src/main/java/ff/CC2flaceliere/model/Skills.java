package ff.CC2flaceliere.model;

public class Skills {
    private int experienceYears;
    private String country;

    public Skills(int experienceYears, String country) {
        this.experienceYears = experienceYears;
        this.country = country;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public String getCountry() {
        return country;
    }
}
