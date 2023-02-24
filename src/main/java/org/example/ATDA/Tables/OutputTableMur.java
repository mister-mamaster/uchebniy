package org.example.ATDA.Tables;

import org.example.ATDA.Enums.Output;
import org.example.ATDA.Enums.Status;
import org.example.ATDA.Tables.Generators.TableMurFactory;

import java.util.HashMap;
import java.util.Map;

public class OutputTableMur {
    private Map<Status, Output> outputs = new HashMap<>();

    public Output getOutput(Status status) {
        return outputs.get(status);
    }

    public void setOutputs(Map<Status, Output> outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 1; i <= 5; i++) str += " " + Status.valueOf("A" + i) + " ";
        str += "\n";

        for(int i = 1; i <= 5; i++){
            str += " " + outputs.get(Status.valueOf("A" + i)) + " ";
        }
        str += "\n";

        return str;
    }

}
