package edu.url.salle.malou.lundstrom.geoquiz.model;

public class Question {
    private int textId;
    private boolean isAnswerTrue;

    public Question(int textId, boolean isAnswerTrue) {
        this.textId = textId;
        this.isAnswerTrue = isAnswerTrue;
    }

    public int getTextId() {
        return textId;
    }

    public boolean isAnswerTrue() {
        return isAnswerTrue;
    }

}
