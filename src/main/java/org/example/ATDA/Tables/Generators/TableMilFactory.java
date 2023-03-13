package org.example.ATDA.Tables.Generators;

import org.example.ATDA.Enums.Input;
import org.example.ATDA.Enums.Output;
import org.example.ATDA.Enums.Status;
import org.example.ATDA.Tables.OutputTableMil;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TableMilFactory {
    public static OutputTableMil createTable(){
        OutputTableMil table = new OutputTableMil();
        Map<Status, Map<Input, Output>> outputs = new HashMap<>();

        for(int i = 1; i < 6; i++){
            outputs.put(Status.valueOf("A" + i), new HashMap<>());
        }

        for (Status status: outputs.keySet()){
            for(int i = 1; i < 6; i++) {
                outputs.get(status).put(Input.valueOf("Z" + i), Output.valueOf("W" + (new Random().nextInt(5) + 1)));
            }
        }

        table.setOutputs(outputs);

        return table;
    }
}
