package com.company;

public class SequenceAlignment {

    public SequenceAlignment() {

    }

    public int[][] alignSequences(String sequenceOne, String sequenceTwo, int matchScore, int mismatchScore, int indelScore){

        int[][] alignmentMatrix = new int[sequenceOne.length() + 1][sequenceTwo.length() + 1];
        alignmentMatrix[0][0] = 0;
        int matchOrMismatchScore = 0;

        for (int i = 1; i < sequenceOne.length() + 1; i++) {
            alignmentMatrix[i][0] = alignmentMatrix[i - 1][0] + indelScore;
        }
        for (int i = 1; i < sequenceTwo.length() + 1; i++) {
            alignmentMatrix[0][i] = alignmentMatrix[0][i - 1] + indelScore;
        }

        for (int i = 1; i < sequenceOne.length() + 1; i++) {
            for (int j = 1; j < sequenceTwo.length() + 1; j++) {

                if(sequenceOne.charAt(i - 1) == sequenceTwo.charAt(j -1)){
                    matchOrMismatchScore = matchScore;
                }else {
                    matchOrMismatchScore = mismatchScore;
                }

                alignmentMatrix[i][j] = Math.max(Math.max(alignmentMatrix[i][j - 1] + indelScore , alignmentMatrix[i- 1][j] + indelScore), alignmentMatrix[i - 1][j - 1] + matchOrMismatchScore);
            }
        }

        return alignmentMatrix;
    }
    private int matchOrMismatchCheck(char characterOne, char characterTwo) {
        if (characterOne == characterTwo) {
            return 2;
        }else{
            return -1;
        }
    }
    public void backtrackMatrix(String sequenceOne, String sequenceTwo, int[][] sequenceMatrix, int indelScore){
        StringBuilder alignmentOne = new StringBuilder();
        StringBuilder alignmentTwo = new StringBuilder();
        int i = sequenceOne.length();
        int j = sequenceTwo.length();

        while (i > 0 || j > 0) {
            if((i > 0) && (j > 0) && (sequenceMatrix[i][j] == sequenceMatrix[i-1][j -1] + matchOrMismatchCheck(sequenceOne.charAt(i - 1),sequenceTwo.charAt(j-1)))){
                alignmentOne.insert(0, sequenceOne.charAt(i - 1));
                alignmentTwo.insert(0, sequenceTwo.charAt(j - 1));
                i = i - 1;
                j = j - 1;
            }else if(i > 0 && sequenceMatrix[i][j] == sequenceMatrix[i -1][j] + indelScore ){
                alignmentOne.insert(0, sequenceOne.charAt(i - 1));
                alignmentTwo.insert(0, "_");
                i = i - 1;
            }else{
                alignmentOne.insert(0, "_");
                alignmentTwo.insert(0, sequenceTwo.charAt(j - 1));
                j = j - 1;
            }
        }

        System.out.println(alignmentOne);
        System.out.println(alignmentTwo);
    }

}

