package org.example.coursework2;

import java.util.ArrayList;


public class TrackedParcel extends Parcel {

    private static final double COST = 1.5;
    private String trackingLocation;
    private ArrayList<ProcessingFacility> locations;
    private static final int PRIORITY_VALUE = 2;


    /**
     * Constructor for the tracked parcel which takes in information about Sending/Receiving processing Facilities
     * initializes tracking location string and locations Arraylist.
     * @param sender Sending ProcessingFacility
     * @param recipient receiving ProcessingFacility
     */
    public TrackedParcel(ProcessingFacility sender, ProcessingFacility recipient) {
        super(sender, recipient, PRIORITY_VALUE);
        trackingLocation = "";
        locations = new ArrayList<>();
    }

    /**
     * Current location of the parcel
     * @return String locations
     */
    public String getLocations() {
        return trackingLocation;
    }

    /**
     * Method to calculate price cost * number of locations.
     * @param processingFacility  processing facility where it is processed from.
     */
    @Override
    public void process(ProcessingFacility processingFacility) {
        super.process(processingFacility);
        locations.add(processingFacility);
        // Reset the tracking location string
        trackingLocation = "";
        // Iterate through the list of locations
        for (int i = 0; i < locations.size(); i++) {
            //adding a comma to the string if it is not the last location.
            if (i == locations.size() - 1) {
                trackingLocation = trackingLocation + locations.get(i).getADDRESS();
            } else {
                trackingLocation = trackingLocation + locations.get(i).getADDRESS() + ",";
            }
        }
        price = COST * locations.size();
    }

    /**
     * Overridden toString that adds more relevant information about TrackedParcels
     * @return String information about TrackedParcel
     */
    @Override
    public String toString() {
        return "Tracked Parcel" + super.toString() + " Locations: " + trackingLocation;
    }
}
