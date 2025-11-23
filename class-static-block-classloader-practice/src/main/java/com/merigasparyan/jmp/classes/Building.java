package com.merigasparyan.jmp.classes;

public class Building {

    private String buildingName = "PAB Building";
    private static int totalBuildings = 2;

    public class Classroom {
        private String roomNumber;

        public Classroom(String roomNumber) {
            this.roomNumber = roomNumber;
        }

        public void printDetails() {
            System.out.println("Inside inner class");
            System.out.println("Room: " + roomNumber);

            System.out.println("Belongs to building: " + buildingName);
            System.out.println("Total buildings: " + totalBuildings);
        }
    }



    public static void main(String[] args) {
        Building building = new Building();
        System.out.println("Inner class");
        Classroom classroom = building.new Classroom("307E");
        classroom.printDetails();
    }
}

