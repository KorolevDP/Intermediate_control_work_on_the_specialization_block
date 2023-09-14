package Controller;

import Model.Toys;
import java.util.List;

public interface iGetModel {

    public List<Toys> getAllToys();

    void addNewToy(Toys newToy);

}
