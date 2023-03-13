package org.example.ATDA;

import org.example.ATDA.Automatons.Mili;
import org.example.ATDA.Automatons.Mur;
import org.example.ATDA.Enums.Input;
import org.example.ATDA.Enums.Output;
import org.example.ATDA.Enums.Status;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("src/../Results.txt");
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        BufferedWriter bWriter = new BufferedWriter(writer);

        Mili automat = new Mili();
        Input[] inputs = new Input[10];

        for(int i = 0; i < 10; i++){
            inputs[i] = Input.valueOf("Z" + (new Random().nextInt(5) + 1));
        }

        writer.append(automat.toString()).append(String.valueOf('\n'));

        Output[] outputs = new Output[inputs.length + 1];
        Status[] statuses = new Status[inputs.length + 1];

        for(int i = 0; i < inputs.length; i++){
            statuses[i] = automat.getStatus();
            outputs[i] = automat.bip(inputs[i]);
        }

        statuses[statuses.length - 1] = automat.getStatus();
        outputs[outputs.length - 1] = automat.bip(inputs[inputs.length - 1]);


        writer.append(Arrays.asList(statuses).toString()).append(String.valueOf('\n'));
        writer.append(Arrays.asList(inputs).toString()).append(String.valueOf('\n'));
        writer.append(Arrays.asList(outputs).toString()).append(String.valueOf('\n'));

        writer.append("\nValue of the final status function - ").append(String.valueOf(statuses[statuses.length - 1])).append(String.valueOf('\n'));
        writer.append("Value of the final output function - ").append(String.valueOf(outputs[outputs.length - 1])).append(String.valueOf('\n')).append(String.valueOf('\n'));


        Mur mur = new Mur();
        Input[] in = new Input[10];

        for(int i = 0; i < 10; i++){
            in[i] = Input.valueOf("Z" + (new Random().nextInt(5) + 1));
        }

        writer.append(mur.toString()).append(String.valueOf('\n'));
        outputs = new Output[in.length + 2];
        statuses = new Status[in.length + 2];

        outputs[0] = mur.getOutputsTable().getOutput(mur.getStatus());
        statuses[0] = mur.getStatus();

        for(int i = 0; i < in.length; i++){
            statuses[i + 1] = mur.getStatus();
            outputs[i + 1] = mur.bip(in[i]);
        }

        statuses[statuses.length - 1] = automat.getStatus();
        outputs[outputs.length - 1] = automat.bip(in[in.length - 1]);

        writer.append(Arrays.asList(statuses).toString()).append(String.valueOf('\n'));
        writer.append("    ").append(String.valueOf(Arrays.asList(in))).append(String.valueOf('\n'));
        writer.append(Arrays.asList(outputs).toString()).append(String.valueOf('\n'));

        writer.append("\nValue of the final status function - ").append(String.valueOf(statuses[statuses.length - 1])).append(String.valueOf('\n'));
        writer.append("Value of the final output function - ").append(String.valueOf(outputs[outputs.length - 1])).append(String.valueOf('\n'));

        bWriter.close();
        writer.close();
    }
}
