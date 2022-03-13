package com.utcn.sd.assignment.model;

import java.util.Comparator;

public class SortByVotes implements Comparator<AnswerResponse> {

    public int compare(AnswerResponse a, AnswerResponse b) {
        return b.getAnswer().getLikeCount() - a.getAnswer().getLikeCount();
    }
}
