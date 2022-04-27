import java.util.*;
public class Methods {
    Scanner scan = new Scanner(System.in);
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    List<Ubication> ubications = new ArrayList<Ubication>();
    String [] frases = {"Hola mundo", "Solo sé, que nada sé", "Tengo hambre", "Aguacate Aguacate", "No sé", "jajsajsj", "ksdjkdjsd"};
    public static void main(String[]args) {
        Methods objeto2=new Methods();
        objeto2.mostrarMenu();

    }

    public  void mostrarMenu() {

        System.out.println("0 - Finalizar la ejecución del programa\r\n"
                + "1 - Añadir un nuevo zombie al sistema\r\n"
                + "2 - Ver información de los zombies en el sistema\r\n"
                + "3 - Conocer cuántos zombies hay creados en el sistema\r\n"
                + "4 - Ver información de loz zombies con tipo de sangre O+ y AB+\r\n"
                + "5 - Ver información de zombies nacidos después del años 2000\r\n"
                + "6 - Reducir a la mitad vida de los zombies\r\n"
                + "7 - Añadir una nueva ciudad al sistema\r\n"
                + "8 - Ver información de las ciudades en el sistema\r\n"
                + "9 - Conocer la información de la ubicación más segura creada en el sistema\r\n"
                + "10 - Ver información de las ciudades ordenadas de menor a mayor distancia en el sistema\r\n"
                + "11 - Frase de zombies\r\n"
                + "12 - Modificar datos de los Zombies ");
        while(true) {
            System.out.println("Ingrese un numero para ejecutar alguna funcion del programa TheWalkingDead");
            int num=scan.nextInt();
            scan.nextLine();
            if(num==0){
                break;
            }else {
                switch(num){
                    case 1:
                        this.crearZombie();
                        break;
                    case 2:
                        this.infoZombies();
                        break;
                    case 3:
                        this.getZombies();
                        break;
                    case 4:
                        this.typeBlood();
                        break;
                    case 5:
                        this.born2000();
                        break;
                    case 6:
                        this.halfLife();
                        break;
                    case 7:
                        this.newUbication();
                        break;
                    case 8:
                        this.infoLugares();
                        break;
                    case 9:
                        this.lugarSeguro();
                        break;
                    case 10:
                        this.sortDistances();
                        break;
                    case 11:
                        this.frase();
                        break;
                    case 12:
                        this.modifyZombiesData();
                        break;
                    default:
                        System.out.println("El dato no es válido, por favor digite un número nuevamente");
                        break;
                }
            }

        }
    } //Metodo menu

    public void crearZombie() {
        String date;
        boolean control=false;
        System.out.println("Ingrese el nombre del Zombie");
        String name = scan.nextLine();
        while(true) {
            for(int i = 0; i < zombies.size(); i++) {
                if(zombies.get(i).getNameZ().equalsIgnoreCase(name) ) {
                    control = true;
                    System.out.println("El nombre ya existe en el sistema, agregue un número al final del nombre");
                    name = scan.nextLine();
                    break;
                }else {
                    control=false;
                }
            }
            if(control==false) {
                break;
            }
        }
        System.out.println("Ingrese el valor de la salud del zombie");
        int value = scan.nextInt();
        scan.nextLine();
        while (true) {
            System.out.println("Ingrese la fecha de nacimiento del zombie con el siguiente formato dd/mm/aa");
            date = scan.nextLine();
            if (date.length() == 10) {
                break;

            } else {
                System.out.println("La fecha debe tener dos dígitos para el día y para el mes, cuatro dígitos para el año e incluir las barras inclinadas para separar los números");
            }
        }
        System.out.println("Digite el tipo de sangre del Zombie");
        String blood = scan.nextLine();
        Zombie objeto = new Zombie(name, value, date, blood);
        zombies.add(objeto);
    } /*Metodo 1*/

    public void infoZombies() { /* Metodo numero 2*/
        if(zombies.isEmpty()==true){
            System.out.println("Aún no hay zombies registrados en el sistema");
        }else{
            System.out.println("Informacion zombies hasta el momento");

            for (int i = 0; i < zombies.size(); i++) {
                System.out.println("");
                System.out.print("|" + zombies.get(i).getNameZ());
                System.out.print("|" + zombies.get(i).getBloodZ());
                System.out.print("|" + zombies.get(i).getDateZ());
                System.out.print("|" + zombies.get(i).getHealthZ() + "|\n");
            }


        }
    }
    /*Metodo 2*/

    public void getZombies() {

        System.out.println("Zombies creados hasta el momento: " + zombies.size());
    } /*Metodo 3*/

    public void typeBlood() {
        boolean tri = false;
        System.out.println("Zombies con tipo de sangre O+ o AB+");
        /*Tipo de sangre 0+ y AB+*/
        for (int i = 0; i < zombies.size(); i++) {
            if (zombies.get(i).getBloodZ().equalsIgnoreCase( "O+") || zombies.get(i).getBloodZ().equalsIgnoreCase("AB+")) {
                System.out.println("");
                System.out.print("|" + zombies.get(i).getNameZ());
                System.out.print("|" + zombies.get(i).getBloodZ());
                System.out.print("|" + zombies.get(i).getDateZ());
                System.out.print("|" + zombies.get(i).getHealthZ() + "|\n");
                tri = true;
            }
        }
        if(tri == false){
            System.out.println("Aún no hay zombies registrados con tipo de sangre O+ o AB+");
        }

    } /*Metodo 4*/

    public void born2000() {
        System.out.println("Zombies que han nacido despues del 2000");
        boolean tri = false;
        for (int i = 0; i < zombies.size(); i++) {
            String cut = zombies.get(i).getDateZ().substring(6, 10);
            int year = Integer.parseInt(cut);
            if (year > 2000) {
                tri = true;
                System.out.println("");
                System.out.print("|" + zombies.get(i).getNameZ());
                System.out.print("|" + zombies.get(i).getBloodZ());
                System.out.print("|" + zombies.get(i).getDateZ());
                System.out.print("|" + zombies.get(i).getHealthZ() + "|");
            }
        }
        System.out.println("");
        if(tri == false){
            System.out.println("Aun no se han registrado zombies que nacieron despues del 2000");
        }
    } /*Metodo 5*/

    public void halfLife() {
        System.out.println("Se lanzo bomba, 1/2 de vida a todos los zombies");
        for (int i = 0; i < zombies.size(); i++) {
            zombies.get(i).setHealthZ((zombies.get(i).getHealthZ() / 2));
        }
    } /*Metodo 6*/

    public void newUbication() {
        System.out.println("Ingrese el nombre de la ciudad");
        String name=scan.nextLine();
        System.out.println("Ingrese la distancia a la que se encuentra la ciudad de Alejandría");
        float distance=scan.nextFloat();
        System.out.println("Ingrese la cantidad de zombies que se encuentran dentro de la ciudad");
        int num=scan.nextInt();
        Ubication objeto=new Ubication(name,distance,num);
        ubications.add(objeto);
    }//Método 7

    public void infoLugares() {
        if(ubications.size()==0){
            System.out.println("Aún no hay ciudades registradas");
        }else{
            System.out.print("Informacion lugares hasta el momento");
            for (int i = 0; i < ubications.size(); i++) {
                System.out.println("");
                System.out.print("|" + ubications.get(i).getNameU());
                System.out.print("|" + ubications.get(i).getDistanceU());
                System.out.print("|" + ubications.get(i).getTotalZatU() + "|\n");
            }
        }
    } /*Metodo 8*/

    public void lugarSeguro() {
        if(ubications.size()==0){
            System.out.println("Aún no hay ubicaciones registradas en el sistema");
        }else{
            int numMin = ubications.get(0).getTotalZatU(), indice=0;
            for (int i = 0; i < ubications.size(); i++) {
                if (ubications.get(i).getTotalZatU() < numMin) {
                    numMin = ubications.get(i).getTotalZatU();
                    indice=i;
                }
            }
            System.out.println("Lugar seguro\n");
            System.out.print("|" + ubications.get(indice).getNameU());
            System.out.print("|" + ubications.get(indice).getDistanceU());
            System.out.print("|" + ubications.get(indice).getTotalZatU() + "|\n");
        }
    } /*Metodo 9*/

    public void sortDistances() {
        if(ubications.size()==0){
            System.out.println("Aún no hay ubicaciones registradas en el sistema");
        }else{
            Collections.sort(ubications);
            System.out.println("ubicaciones de la ciudad ordenadas por distancia a Alexandria.");
            System.out.println("");
            for(int i=0;i<ubications.size();i++) {
                System.out.printf("%f | %4d | %s\n",ubications.get(i).getDistanceU(),ubications.get(i).getTotalZatU(),ubications.get(i).getNameU());
            }
        }
    } // Método 10

    public void frase(){
        int min = 1;
        int max = 5;
        Random random = new Random();

        int value = random.nextInt(max + min) + min;
        System.out.println("Un zombie dijo: "+frases [value]);
    } /* Metodo 11*/
    public void modifyZombiesData() {
        if(zombies.size()==0) {
            System.out.println("No se han registrado zombies en el sistema");
        }else {
            int indice = 0;
            System.out.println("Ingrese el nombre del zombie al que desea modificar los datos");
            String nombre=scan.nextLine();

            while(true) {
                boolean contro = true;
                for (int i = 0; i < zombies.size(); i++) {
                    if (zombies.get(i).getNameZ().equals(nombre)) {
                        indice = i;
                        contro = false;
                        break;
                    } else {
                        System.out.println("El nombre del zombie no se encuentra en el sistema, por favor ingrese el nombre de nuevo");
                        nombre = scan.nextLine();
                    }
                }
                if (!contro) {
                    break;
                }
            }
                while (true) {

                    System.out.println("Qué dato desea modificar: \n"
                            + "0 - Terminar ejecución\n"
                            + "1 - Nombre del zombie\n"
                            + "2 - Salud del zombie\n"
                            + "3 - Fecha de nacimiento del zombie\n"
                            + "4 - Tipo de sangre del zombie\n");
                    int valor = scan.nextInt();
                    scan.nextLine();
                     if(valor != 0) {
                        switch (valor) {
                            case 1:
                                boolean control = false;
                                System.out.println("Ingrese el nombre del Zombie");
                                String name1 = scan.nextLine();
                                while (true) {
                                    for (int i = 0; i < zombies.size(); i++) {
                                        if (zombies.get(i).getNameZ().equals(name1)) {
                                            control = true;
                                            System.out.println("El nombre ya existe en el sistema, agregue un número al final del nombre");
                                            name1 = scan.nextLine();

                                        } else {
                                            control = false;
                                        }
                                    }
                                    if (control == false) {
                                        break;
                                    }
                                }
                                zombies.get(indice).setNameZ(name1);
                                break;
                            case 2:
                                System.out.println("Ingrese el valor de la salud del zombie");
                                int health = scan.nextInt();
                                zombies.get(indice).setHealthZ(health);
                                break;
                            case 3:
                                String date;
                                while (true) {
                                    System.out.println("Ingrese la fecha de nacimiento del zombie con el siguiente formato dd/mm/aa");
                                    date = scan.nextLine();
                                    if (date.length() == 10) {
                                        break;

                                    } else {
                                        System.out.println("La fecha debe tener dos dígitos para el día y para el mes, cuatro dígitos para el año e incluir las barras inclinadas para separar los números");
                                    }
                                }
                                zombies.get(indice).setDateZ(date);
                                break;
                            case 4:
                                System.out.println("Ingrese el tipo de sangre del zombie");
                                String blood = scan.nextLine();
                                zombies.get(indice).setBloodZ(blood);
                                break;
                            default:
                                System.out.println("El dato no es válido, vuelva a ingresar un número");
                                break;
                        }
                    }
                    if (valor == 0) {
                        break;
                    }

                }
            }
        } /*Metodo 12*/
    }
