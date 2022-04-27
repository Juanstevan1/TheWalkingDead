public class Zombie {
    public String NameZ;
    public int HealthZ;
    public String DateZ;
    public String BloodZ;

    public Zombie(){

    }
    public Zombie(String nameZ, int HealthZ, String DateZ, String BloodZ){
        this.NameZ = nameZ;
        this.HealthZ = HealthZ;
        this.DateZ = DateZ;
        this.BloodZ =  BloodZ;
    }

    public void setBloodZ(String bloodZ) {
        BloodZ = bloodZ;
    }

    public void setDateZ(String dateZ) {
        DateZ = dateZ;
    }

    public void setHealthZ(int healthZ) {
        HealthZ = healthZ;
    }

    public void setNameZ(String nameZ) {
        NameZ = nameZ;
    }

    public int getHealthZ() {
        return HealthZ;
    }

    public String getDateZ() {
        return DateZ;
    }

    public String getBloodZ() {
        return BloodZ;
    }

    public String getNameZ() {
        return NameZ;
    }
}
