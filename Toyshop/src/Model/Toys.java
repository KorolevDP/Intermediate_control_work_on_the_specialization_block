package Model;

public  class Toys  implements Comparable<Toys>{

    private int toyId;
    private String toyName;
    private double toyDropFrequency;

    public Toys(int toyId, String toyName, double toyDropFrequency) {
        this.toyId = toyId;
        this.toyName = toyName;
        this.toyDropFrequency = toyDropFrequency;
    }

    public int getToyId() {
        return toyId;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }


    public String getToyName() {
        return toyName;
    }

    public void setToyName(String toyName) {
        this.toyName = toyName;
    }

    public double getToyDropFrequency() {
        return toyDropFrequency;
    }

    public void setToyDropFrequency(double toyDropFrequency) {
        this.toyDropFrequency = toyDropFrequency;
    }

    @Override
    public String toString() {
        return "Toy [id = " + toyId + ", name= " + toyName + ", DropFrequency = " + toyDropFrequency + "]";
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
