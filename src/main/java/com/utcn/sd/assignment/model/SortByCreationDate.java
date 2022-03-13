package com.utcn.sd.assignment.model;

import java.util.Comparator;

public class SortByCreationDate implements Comparator<QuestionResponse> {

    public int compare(QuestionResponse a, QuestionResponse b) {
        if (a.getQuestion().getCreationDate().isEqual(b.getQuestion().getCreationDate())) {
            return 0;
        }
        if (a.getQuestion().getCreationDate().isAfter(b.getQuestion().getCreationDate())) {
            return -1;
        }
        return 1;
    }
}
