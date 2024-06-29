package org.example.coursework2;


public class StandardParcel extends Parcel {

    private static final double COST = 1.25;
    private final double WEIGHT_KG;
    private static final int PRIORITY_VALUE = 3;

    /**
     * Constructor for standard parcel initializing weight, sender, recipient.
     * @param sender sending ProcessingFacility
     * @param recipient receiving ProcessingFacility
     * @param weightInKG weight of parcel in Kg
     */
    public StandardParcel(ProcessingFacility sender, ProcessingFacility recipient, double weightInKG) {
        super(sender, recipient, PRIORITY_VALUE);
        this.WEIGHT_KG = weightInKG;
    }

    /**
     * Determines price of delivery based on weight and stable cost AKA rate per Kg.
     * @param processingFacility processingFacility where it is processed from.
     */
    @Override
    public void process(ProcessingFacility processingFacility) {
        super.process(processingFacility);
        price = COST * WEIGHT_KG;
    }

    /**
     * Overridden to string that adds more relevant information about StandardParcel.
     * @return String information about StandardParcel.
     */
    @Override
    public String toString() {
        return "Standard Parcel" + super.toString() + String.format(" Weight: %.2f", WEIGHT_KG);
    }
}
