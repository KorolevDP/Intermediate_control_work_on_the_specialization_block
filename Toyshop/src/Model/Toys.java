package Model;

public  class Toys  implements Comparable<Toys>{

    private int toyID;
    private String toyName;
    private int toyDropFrequency;

    public Toys(int toyID, String toyName, int toyDropFrequency) {
        this.toyID = toyID;
        this.toyName = toyName;
        this.toyDropFrequency = toyDropFrequency;
    }

    public int getToyID() {
        return toyID;
    }

    public void setToyID(int toyID) {
        this.toyID = toyID;
    }


    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public int getToyDropFrequency() {
        return toyDropFrequency;
    }

    public void setToyDropFrequency(int toyDropFrequency) {
        this.toyDropFrequency = toyDropFrequency;
    }

    @Override
    public String toString() {
        return "Toy [id = " + toyID + ", name= " + toyName + ", DropFrequency = " + toyDropFrequency + "]";
    }

    @Override
    public int compareTo(Toys o) {
        if (o.getToyDropFrequency() == this.getToyDropFrequency()) {
            return 0;
        }
        if (o.getToyDropFrequency() < this.getToyDropFrequency()) {
            return -1;
        } else return 1;
    }
}
