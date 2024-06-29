package org.example.coursework2;

import java.util.ArrayList;


public class ProcessingFacility {

    private final int X;
    private final int Y;
    private final String ADDRESS;
    private ArrayList<ProcessingFacility> neighbours;

    protected final int ID;
    private static int nextId = 1;

    /**
     * Constructor for ProcessingFacility that takes in x,y coordinate and stores it in a String ADDRESS and creates a
     * unique ID for the processing facility
     * @param X x coordinate
     * @param Y y coordinate
     */
    public ProcessingFacility(int X, int Y) {
        neighbours = new ArrayList<>();
        this.X = X;
        this.Y = Y;
        ID = nextId;
        nextId++;
        ADDRESS = "X" + X + "Y" + Y;
    }

    /**
     * Adding a processing facility to the arraylist because it is a neighbors to this ProcessingFacility.
     * @param processingFacility the neighboring facility being added to the Arraylist of neighbors
     */
    public void addNeighbour(ProcessingFacility processingFacility) {
        neighbours.add(processingFacility);
    }

    /**
     * Method to return the x coordinate.
     * @return x coordinate.
     */
    public int getX() {
        return X;
    }

    /**
     * Method to return the y coordinate.
     * @return y coordinate.
     */
    public int getY() {
        return Y;
    }

    /**
     * Method to return the Adress string (x,y)
     * @return address String (x,y)
     */
    public String getADDRESS() {
        return ADDRESS;
    }

    /**
     * Method to return the unique ID.
     * @return int ID
     */
    public int getID() {
        return ID;
    }

    /**
     * Method to return arraylist storing neighboring arraylist
     * @return array list of neighboring processing facility
     */
    public ArrayList<ProcessingFacility> getNeighbours() {
        return neighbours;
    }

    /**
     * String information about the processing facility.
     * @return String info about processing facility.
     */
    @Override
    public String toString() {
        String neighboringAdresses = "";
        //iterating through the array to store all neighboring addresses in a string then print it all at the end.
        for (int i = 0; i < neighbours.size(); i++) {
            neighboringAdresses = neighboringAdresses + neighbours.get(i).getADDRESS();
        }
        return "Address:" + ADDRESS + " Neighbours:" + neighboringAdresses;
    }
}
