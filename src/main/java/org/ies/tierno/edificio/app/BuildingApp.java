package org.ies.tierno.edificio.app;

import lombok.extern.slf4j.Slf4j;
import org.ies.tierno.edificio.exception.ApartmentNotFoundException;
import org.ies.tierno.edificio.model.Building;
import org.ies.tierno.edificio.model.Owner;
import org.ies.tierno.edificio.reader.BuildingReader;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class BuildingApp {
    private final Scanner scanner = new Scanner(System.in);
    private final BuildingReader buildingReader = new BuildingReader(scanner);
    private Building building;

    public static void main(String[] args) {
        new BuildingApp().run();
    }

    public void run() {
        building = buildingReader.read();

        while (true) {
            System.out.println("=== MENÚ ===");
            System.out.println("1. Ver todos los apartamentos");
            System.out.println("2. Ver un apartamento");
            System.out.println("3. Ver propietarios");
            System.out.println("4. Salir");
            System.out.print("Opción: ");

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        building.showApartments();
                        break;
                    case 2:
                        showApartment();
                        break;
                    case 3:
                        showOwners();
                        break;
                    case 4:
                        log.info("Adiós");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número");
            } catch (ApartmentNotFoundException e) {
                log.error(e.getMessage());
                System.out.println("Apartamento no encontrado");
            }

            System.out.println("\nPulsa Enter para continuar");
            scanner.nextLine();
        }
    }

    private void showApartment() throws ApartmentNotFoundException {
        System.out.print("Planta: ");
        int floor = Integer.parseInt(scanner.nextLine());
        System.out.print("Puerta: ");
        String door = scanner.nextLine();

        var apt = building.getApartment(floor, door);
        System.out.println("Planta " + apt.getFloor() + " - Puerta " + apt.getDoor());
        System.out.println("Propietarios: " + apt.getOwners().size());
    }

    private void showOwners() throws ApartmentNotFoundException {
        System.out.print("Planta: ");
        int floor = Integer.parseInt(scanner.nextLine());
        System.out.print("Puerta: ");
        String door = scanner.nextLine();

        List<Owner> owners = building.getOwners(floor, door);
        if (owners.isEmpty()) {
            System.out.println("Sin propietarios");
        } else {
            for (Owner o : owners) {
                System.out.println(o.getName() + " " + o.getLastName());
            }
        }
    }
}