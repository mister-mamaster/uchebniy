package org.example.ATDA.Tables;

import org.example.ATDA.Enums.Input;
import org.example.ATDA.Enums.Output;
import org.example.ATDA.Enums.Status;

import java.util.HashMap;
import java.util.Map;

public class OutputTableMil {
    private Map<Status, Map<Input, Output>> outputs = new HashMap<>();

    public Output getOutput(Status status, Input input) {
        return outputs.get(status).get(input);
    }

    public void setOutputs(Map<Status, Map<Input, Output>> outputs) {
        this.outputs = outputs;
    }

    @Override
    public String toString() {
        String str = "    ";
        for(int i = 1; i <= 5; i++) str += " " + Status.valueOf("A" + i) + " ";
        str += "\n";

        str += "    --------------------\n";

        Map<Input, Output> lines = outputs.get(Status.A1);

            for(int i = 1; i <= 5; i++){
                Input input = Input.valueOf("Z" + i);
                str += " " + input + " |";
                for(int j = 1; j <= 5; j++){
                    str += " " + outputs.get(Status.valueOf("A" + j)).get(input) + " ";
                }
                str += "\n";
            }

        return str;
    }
}
