package Model;

import Controller.iGetModel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.PriorityQueue;
import java.util.stream.Collectors;


public class ModelFile implements iGetModel {

    private String filename;

    public ModelFile(String filename) {
        this.filename = filename;

        try (FileWriter fw = new FileWriter(filename, true))
        {
            fw.flush();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public PriorityQueue<Toys> getAllToys() {
        PriorityQueue<Toys> toys = new PriorityQueue<Toys>();
        try {
            File file = new File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();

            while (line != null)
            {
                String[] param = line.split(" ");
                Toys item = new Toys(Integer.parseInt(param[0]), param[1], Double.parseDouble(param[2]));
                toys.add(item);
                line = reader.readLine();
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        return toys;
    }

    @Override
    public void deleteSelToy(Toys std) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteToy'");
    }

    public void saveAllToyToFile(PriorityQueue<Toys> toys) {
        try (FileWriter fw = new FileWriter(filename, true))
        {
            for(Toys item: toys)
            {
                fw.write(item.getToyId()+ " " + item.getToyName() + " " + item.getToyDropFrequency());
                fw.append('\n');
            }
            fw.flush();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public PriorityQueue<Toys> getFoundToyById(int id) {
        final PriorityQueue<Toys> result = (PriorityQueue<Toys>) this.getAllToys().stream().filter(item -> Integer.valueOf(item.getToyId()).equals(id))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void addNewToy(Toys newToy) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNewToy'");
    }
}


























//import java.io.FileWriter;
//import java.util.PriorityQueue;


//public class ModelFile  {
//    private String filename;
//
//    public ModelFile(String filename){
//        this.filename = filename;
//
//        try(FileWriter fw = new FileWriter(filename, true)){
//            fw.flush();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public void saveToyToFile(Toys toy){
//        try (FileWriter fw = new FileWriter(filename, true)) {
//                fw.write(toy.getToyID() + "; " + toy.getToyName() + "; " + toy.getToyDropFrequency());
//                fw.append("\n");
//                fw.flush();
//        }catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//}

