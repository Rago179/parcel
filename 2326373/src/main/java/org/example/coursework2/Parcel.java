package org.example.coursework2;

/**
 * Class to represent a Parcel object.
 * You will heavily edit this class, and therefore no further comments have been added.
 * Ensure you add comments when submitting.
 */


public class Parcel {

    private final ProcessingFacility sender;
    private final ProcessingFacility recipient;
    protected double price;
    private final int priority;
    private int ID;
    private static int nextID = 1;


    /**
     * Generic constructor for any type of parcel.
     * @param sender where the Processing Facility is going to be sent.
     * @param recipient where the Processing Facility is going to be received.
     * @param priority int demonstrating the importance.
     */
    public Parcel(ProcessingFacility sender, ProcessingFacility recipient, int priority) {
        this.priority = priority;
        this.recipient = recipient;
        this.sender = sender;
        ID = nextID;
        nextID++;
    }

    /**
     * genric method for processing prices for any type of parcel, not implemented here.
     * @param processingFacility which processing facility it's going to be processed.
     */
    public void  process(ProcessingFacility processingFacility) {

    }

    /**
     * Method to return the processing facility it will be delivered to.
     * @return sending processing facility
     */
    public ProcessingFacility getSender() {
        return sender;
    }

    /**
     * Method to return the processing facility it will be delivered to.
     * @return  receiving processing facility
     */
    public ProcessingFacility getRecipient() {
        return recipient;
    }


    /**
     * Method to return an int meaning priority.
     * @return int priority.
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Method to return the price
     * @return double price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method to return the unique ID
     * @return int ID.
     */
    public int getID() {
        return ID;
    }

    /**
     * Main parcel details that all types of parcels will print at the start.
     * @return String main information about parcels
     */
    @Override
    public String toString() {
        return  String.format(" [from %s to %s] - ID: %d Price: %.2f",
                sender.getADDRESS(), recipient.getADDRESS(), getID(), getPrice());
    }
}
