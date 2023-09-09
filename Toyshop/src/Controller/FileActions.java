package Controller;


import Model.Toys;

import java.io.FileWriter;

public class FileActions {

    private String fileName;

    public FileActions(String fileName) {
        this.fileName = fileName;

        try (FileWriter fw = new FileWriter(fileName, true))
        {
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveToyToFile(Toys toy) {
        try (FileWriter fw = new FileWriter(fileName, true))
        {
            fw.write("Название: "+ toy.getToyName()+ "вес: "+ toy.getToyDropFrequency()+ "id:"+toy.getToyId());
            fw.append('\n');

            fw.flush();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
