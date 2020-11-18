package Repository;

import Model.ProgramState;

import java.io.*;
import java.util.ArrayList;

public class Repository implements IRepository{
    ArrayList<ProgramState> listOfPrograms;
    final String filePath;

    public Repository(String filePath) {
        this.listOfPrograms = new ArrayList<>();
        this.filePath = filePath;
    }

    @Override
    public void addPrg(ProgramState state) {
        this.listOfPrograms.add(state);
    }

    @Override
    public ProgramState getCurrentPrg() {
        return this.listOfPrograms.get(this.listOfPrograms.size() - 1);
    }

    public void logProgState() throws IOException {
        BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(this.filePath, true));
        String print = this.listOfPrograms.get(this.listOfPrograms.size() - 1).toString();
        bufferedReader.write(print);
        bufferedReader.close();
    }
}
