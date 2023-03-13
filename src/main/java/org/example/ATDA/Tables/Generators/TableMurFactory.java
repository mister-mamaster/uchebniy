package org.example.ATDA.Tables.Generators;

import org.example.ATDA.Enums.Output;
import org.example.ATDA.Enums.Status;
import org.example.ATDA.Tables.OutputTableMil;
import org.example.ATDA.Tables.OutputTableMur;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TableMurFactory {
    public static OutputTableMur createTable(){
        OutputTableMur table = new OutputTableMur();
        Map<Status, Output> outputs = new HashMap<>();

        for(int i = 1; i < 6; i++){
            outputs.put(Status.valueOf("A" + i), Output.valueOf("W" + (new Random().nextInt(5) + 1)));
        }

        table.setOutputs(outputs);

        return table;
    }
}
