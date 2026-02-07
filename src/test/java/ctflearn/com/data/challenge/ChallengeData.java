package ctflearn.com.data.challenge;


public class ChallengeData {

    private String title;
    private String flag;
    private String description;
    private String category;
    private int points;
    private String solution;

    public ChallengeData() {
    }

    public ChallengeData(String title,
                         String flag,
                         String description,
                         String category,
                         int points,
                         String solution) {
        this.title = title;
        this.flag = flag;
        this.description = description;
        this.category = category;
        this.points = points;
        this.solution = solution;
    }

    // ===== Getters & Setters =====

    public String getTitle() {
        return title;
    }

    public ChallengeData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getFlag() {
        return flag;
    }

    public ChallengeData setFlag(String flag) {
        this.flag = flag;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ChallengeData setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ChallengeData setCategory(String category) {
        this.category = category;
        return this;
    }

    public int getPoints() {
        return points;
    }

    public ChallengeData setPoints(int points) {
        this.points = points;
        return this;
    }

    public String getSolution() {
        return solution;
    }

    public ChallengeData setSolution(String solution) {
        this.solution = solution;
        return this;
    }
}

