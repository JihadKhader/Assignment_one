package firstlook.jihad.assignment_one.model;

public class Subject {
    private String name;
    private String[] question;
    private String[][] choices;
    private String[] correctAnswer;

    public Subject(String name, String[] question, String[][] choices, String[] correctAnswer) {
        this.name = name;
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getQuestion() {
        return question;
    }

    public void setQuestion(String[] question) {
        this.question = question;
    }

    public String[][] getChoices() {
        return choices;
    }

    public void setChoices(String[][] choices) {
        this.choices = choices;
    }

    public String[] getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String[] correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
