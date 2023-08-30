package Model;

import java.io.FileWriter;
import java.util.PriorityQueue;

import Controller.iGetModel;

public class ModelFile implements iGetModel {
    private String filename;

    public ModelFile(String filename){
        this.filename = filename;

        try(FileWriter fw = new FileWriter(filename, true)){
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void saveToyToFile(Toys toy){
        try (FileWriter fw = new FileWriter(filename, true)) {
                fw.write(toy.getToyID() + "; " + toy.getToyName() + "; " + toy.getToyDropFrequency());
                fw.append("\n");
                fw.flush();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public PriorityQueue<Toys> getAllToys() {
        return null;
    }
}
