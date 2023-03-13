package org.example.ATDA.Tables.Generators;

import org.example.ATDA.Enums.Input;
import org.example.ATDA.Enums.Status;
import org.example.ATDA.Tables.StatusTable;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class StatusFactory {
    public static StatusTable createTable(){
        StatusTable table = new StatusTable();
        Map<Status, Map<Input, Status>> statuses = new HashMap<>();

        for(int i = 1; i < 6; i++){
            statuses.put(Status.valueOf("A" + i), new HashMap<>());
        }

        for (Status status: statuses.keySet()){
            for(int i = 1; i < 6; i++) {
                statuses.get(status).put(Input.valueOf("Z" + i), Status.valueOf("A" + (new Random().nextInt(5) + 1)));
            }
        }

        table.setTable(statuses);

        return table;
    }
}
