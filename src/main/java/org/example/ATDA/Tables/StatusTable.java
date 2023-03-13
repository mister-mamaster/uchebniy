package org.example.ATDA.Tables;

import org.example.ATDA.Enums.Input;
import org.example.ATDA.Enums.Status;
import org.example.ATDA.Tables.Generators.StatusFactory;

import java.util.HashMap;
import java.util.Map;

public class StatusTable {
    private Map<Status, Map<Input, Status>> table = new HashMap<>();

    public Status getStatus(Status status, Input input) {
        return table.get(status).get(input);
    }

    public void setTable(Map<Status, Map<Input, Status>> table) {
        this.table = table;
    }

    @Override
    public String toString() {
        String str = "    ";
        for(int i = 1; i <= 5; i++) str += " " + Status.valueOf("A" + i) + " ";
        str += "\n";

        str += "    --------------------\n";

        Map<Input, Status> lines = table.get(Status.A1);

        for(int i = 1; i <= 5; i++){
            Input input = Input.valueOf("Z" + i);
            str += " " + input + " |";
            for(int j = 1; j <= 5; j++){
                str += " " + table.get(Status.valueOf("A" + j)).get(input) + " ";
            }
            str += "\n";
        }

        return str;
    }
}
