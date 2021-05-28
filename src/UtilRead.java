package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class UtilRead {


    public List<String> readSequence(String sequencePath) throws IOException {

        List<String> sequenceList = new LinkedList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(sequencePath))) {
            for (String line; (line = br.readLine()) != null; ) {
                sequenceList.add(line);
            }
        }

        return sequenceList;
    }

}
