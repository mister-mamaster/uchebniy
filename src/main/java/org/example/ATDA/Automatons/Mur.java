package org.example.ATDA.Automatons;

import org.example.ATDA.Enums.Input;
import org.example.ATDA.Enums.Output;
import org.example.ATDA.Enums.Status;
import org.example.ATDA.Tables.Generators.StatusFactory;

import org.example.ATDA.Tables.Generators.TableMurFactory;
import org.example.ATDA.Tables.OutputTableMur;
import org.example.ATDA.Tables.StatusTable;

import java.util.Arrays;
import java.util.Random;

public class Mur{
    private StatusTable statuses;
    private OutputTableMur outputsTable;
    private Status status;

    public Mur(){
        this.statuses = StatusFactory.createTable();
        this.outputsTable = TableMurFactory.createTable();
        status = Status.A1;
    }

    public Output[] bip(Input[] inputs){
        Output[] outputs = new Output[inputs.length];

        for(int i = 0; i < inputs.length; i++){
            outputs[i] = outputsTable.getOutput(status);
            status = statuses.getStatus(status, inputs[i]);
        }

        return outputs;
    }

    public Output bip(Input input){
        Output output;

        output = outputsTable.getOutput(status);
        status = statuses.getStatus(status, input);

        return output;
    }

    public Status getStatus() {
        return status;
    }

    public StatusTable getStatuses() {
        return statuses;
    }

    public OutputTableMur getOutputsTable() {
        return outputsTable;
    }

    @Override
    public String toString() {
        return "Function of statuses\n" + statuses + "\nFunction of output\n" + outputsTable + "\n";
    }

    public static void main(String[] args) {
        Mur automat = new Mur();
        Input[] inputs = new Input[10];

        for(int i = 0; i < 10; i++){
            inputs[i] = Input.valueOf("Z" + (new Random().nextInt(5) + 1));
        }

        System.out.println(automat);
        System.out.println(Arrays.asList(inputs));

        Output[] outputs = automat.bip(inputs);
        System.out.println(Arrays.asList(outputs));

        System.out.println("\nValue of the final status function - " + automat.getStatus());
        System.out.println("Value of the final output function - " + outputs[outputs.length - 1]);
    }
}
