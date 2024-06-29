package org.example.coursework2;



public class MedicalParcel extends Parcel {

    private static final double COST = 3.00;
    private int biohazardLevel;
    private static final int PRIORITY_VALUE = 1;



    /**
     * Constructor to make a medical parcel.
     * @param sender sending ProcessingFacility
     * @param recipient receiving ProcessingFacility
     * @param biohazardLevel level of biohazard
     */
    public MedicalParcel(ProcessingFacility sender, ProcessingFacility recipient, int biohazardLevel) {
        super(sender, recipient, PRIORITY_VALUE);
        this.biohazardLevel = biohazardLevel;
    }

    /**
     * Method to calculate the price of delivering the medical parcel cost*(Biohazard level*number of visits)
     * @param processingFacility  processing facility where it is processed from.
     */
    @Override
    public void process(ProcessingFacility processingFacility) {
        super.process(processingFacility);
        /*
          Since biohazard level increases by one each time I increment biohazard to track the number of times it
          visits a facility.
         */
        //adding one to biohazard each time it visits a processing facility.
        biohazardLevel++;
        price = COST * biohazardLevel;

    }


    /**
     * Overridden to string that adds more relevant information about MedicalParcel.
     * @return String information about MedicalParcel.
     */
    @Override
    public String toString() {
        return "Medical Parcel" + super.toString() + String.format(" Biohazard Level: %d", biohazardLevel);
    }
}
