package com.company;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        String fileName = "test-sequences/test4.seq";

        System.out.println();
        List<String> sequenceList;
        UtilRead utilRead = new UtilRead();
        sequenceList = utilRead.readSequence(fileName);

        SequenceAlignment sequenceAlignment = new SequenceAlignment();
        int[][] alingmentScoreMatrix = sequenceAlignment.alignSequences(sequenceList.get(0),sequenceList.get(1),2, -1, -1);
        sequenceAlignment.backtrackMatrix(sequenceList.get(0),sequenceList.get(1),alingmentScoreMatrix , -1);


        System.out.println("Score of the Alignment: ");
        System.out.println(alingmentScoreMatrix[sequenceList.get(0).length() ][sequenceList.get(1).length()]);
    }
}