public class Ubication implements Comparable<Ubication>{
    public String NameU;
    public Float DistanceU;
    public int totalZatU;

    public Ubication(){

    }
    public Ubication(String Name, float DistanceU, int TotalZatU){
        this.DistanceU = DistanceU;
        this.NameU = Name;
        this.totalZatU = TotalZatU;
    }

    public Float getDistanceU() {
        return DistanceU;
    }

    public int getTotalZatU() {
        return totalZatU;
    }

    public String getNameU() {
        return NameU;
    }
    public void setDistanceU(Float distanceU) {
        DistanceU = distanceU;
    }

    public void setNameU(String nameU) {
        NameU = nameU;
    }

    public void setTotalZatU(int totalZatU) {
        this.totalZatU = totalZatU;
    }
    public int compareTo(Ubication o) {
        return DistanceU.compareTo(o.getDistanceU());
    }
}

