package firstlook.jihad.assignment_one.model;

import java.util.ArrayList;

public class SubjectDAO {

    private ArrayList<Subject> subjects = new ArrayList<>();

    public SubjectDAO(){
        String[] mathArrayQuestions = {
                "4+11",
                "101-13",
                "10*7"
        };
        String[][] mathArrayChoices = {  {"12","20","15","30"},
                                         {"90","89","78","88"},
                                         {"77","35","70","17"}
        };
        String[] mathArrayAnswers = {
          "15",
          "88",
          "70"
        };
        subjects.add(new Subject("Math",mathArrayQuestions,mathArrayChoices,mathArrayAnswers));
    }

}
