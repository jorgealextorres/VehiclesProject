package VehiclesProject.src.com;

import VehiclesProject.src.com.vehicles.project.Bike;
import VehiclesProject.src.com.vehicles.project.Car;
import VehiclesProject.src.com.vehicles.project.Vehicle;
import VehiclesProject.src.com.vehicles.project.Wheel;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VehiclesProject {
    public static final Double MIN_DIAMETRO = new Double(0.4);
    public static final Double MAX_DIAMETRO = new Double(4);

    public static void main(String[] args) {
        try {

            System.out.println("-- Seleccione tipo de vehiculo: 1 moto, 2 coche --");
            Integer selectVehiculo = getSelection();

            // vehiculo
            String matricula = getMatricula();
            String marca = getInput("marca :");
            String color = getInput("color :");

            Vehicle vehicle = null;

            if (selectVehiculo.intValue() == 1) {
                vehicle = new Bike(matricula, marca, color);
            } else {
                vehicle = new Car(matricula, marca, color);
            }

            // ruedas traseras
            System.out.println("-- Rueda(s) trasera(s) --");
            String marcaRuedaTrasera = getInput("marca :");
            Double diametroRuedaTrasera = getDiametroRueda();

            List<Wheel> ruedasTraseras = new ArrayList<>();

            do {
                ruedasTraseras.add(new Wheel(marcaRuedaTrasera, diametroRuedaTrasera));
            } while (vehicle instanceof Car && ruedasTraseras.size() < 2);

            // ruedas delanteras
            System.out.println("-- Rueda(s) delantera(s) --");
            String marcaRuedaDelantera = getInput("marca :");
            Double diametroRuedaDelantera = getDiametroRueda();

            List<Wheel> ruedasDelanteras = new ArrayList<>();
            do {
                ruedasDelanteras.add(new Wheel(marcaRuedaDelantera, diametroRuedaDelantera));
            } while (vehicle instanceof Car && ruedasDelanteras.size() < 2);


            // adding wheels
            vehicle.addWheels(ruedasDelanteras, ruedasTraseras);

            System.out.println(vehicle.toString());

        } catch (Exception e){
            System.out.println("Se ha producido un error en la aplicacion. ");
            e.printStackTrace();
        }
    }

    private static String getInput(String prompt) {
        System.out.print(prompt);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static Integer getSelection() {
        Integer selection = null;
        Pattern patron = Pattern.compile("[0-9]{1}");
        boolean correcto = false;

        while(!correcto) {
            try {
                String selectionAux = getInput("seleccion :");
                Matcher mat = patron.matcher(selectionAux);

                if (mat.matches()) {
                    selection = new Integer(selectionAux);
                    if (selection == 1 || selection == 2) {
                        correcto = true;
                    } else {
                        throw new VehicleProjectException("La seleccion no es correcta. Elija 1 o 2.");
                    }
                }
            } catch(VehicleProjectException e){
                System.out.println(e.getMessage());
            }
        }

        return selection;
    }

    private static String getMatricula(){
        boolean correcto = false;
        Pattern patron = Pattern.compile("[0-9]{4}[A-Za-z]{2}");

        String matricula = null;

        while(!correcto){
            try {
                matricula = getInput("matricula :");

                if (!matricula.isEmpty()) {

                    if (matricula.length() >= 6 && matricula.length() <= 7) {
                        Matcher mat = patron.matcher(matricula);
                        if (mat.matches()) {
                            correcto = true;
                        }
                    } else {
                        throw new VehicleProjectException("Matricula incorrecta. Formatos permitidos: 9999ZZ o 9999ZZZ");
                    }
                }
            } catch(VehicleProjectException e){
                System.out.println(e.getMessage());
            }
        }

        return matricula;
    }

    private static Double getDiametroRueda(){
        boolean correcto = false;
        Double diametro = null;
        String aux = null;
        Pattern patron = Pattern.compile("[0-9]+(.[0-9]+)?");

        while(!correcto){
            try {
                aux = getInput("diametro :");

                if (!aux.isEmpty()) {
                    Matcher mat = patron.matcher(aux);

                    if (mat.matches()) {
                        diametro = new Double(aux);


                        if (diametro.compareTo(MIN_DIAMETRO) >= 0 && diametro.compareTo(MAX_DIAMETRO) < 1) {
                            correcto = true;
                        } else {
                            throw new VehicleProjectException("El diametro debe estar entre 0.4 y 4.");
                        }
                    } else {
                        throw new VehicleProjectException("El formato no es correcto. Debe ser un valor numérico.");
                    }
                }
            } catch(VehicleProjectException e){
                System.out.println(e.getMessage());
            }
        }

        return diametro;
    }
}