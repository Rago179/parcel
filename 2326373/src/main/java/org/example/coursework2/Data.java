package org.example.coursework2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Class to hold data that is added to the "database".
 * You may add methods to this class.
 */
public class Data {

    /**
     * Attributes to save our data to the "database"
     */
    private static ArrayList<ProcessingFacility> processingFacilities = new ArrayList<>();
    private static Stack<Parcel> parcels = new Stack<>();
    private static Stack<Parcel> processedParcels = new Stack<>();

    /**
     * Method to return the Stack of parcels
     * @return parcels which is a stack of parcels
     */
    public static Stack<Parcel> getParcels() {
        return parcels;
    }

    /**
     * Method to return the processing facilities
     * @return array list of processing facilities
     */
    public static ArrayList<ProcessingFacility> getProcessingFacilities() {
        return processingFacilities;
    }

    /**
     * Method to return the processed parcels.
     * @return stack of parcels called completed deliveries.
     */
    public static Stack<Parcel> getProcessedParcels() {
        return processedParcels;
    }

    /**
     * DO NOT EDIT ANY CODE ABOVE THIS COMMENT. You may need to write additional methods below.
     */

    /**
     * Searches the Arraylist of processing facilities using int ID
     * @param ID ID of the desired processing facility we want to find
     * @return the processing facility or null if unfound
     */
    public static ProcessingFacility findProcessingFacility(int ID) {
        //iterate through the arraylist.
        for (ProcessingFacility processingFacility : processingFacilities) {
            //Match the current ID of iterator to the ID we are searching for.
            if (processingFacility.getID() == ID) {
                return processingFacility;
            }
        }
        return null;
    }

    /**
     *  Searches the Arraylist of processing facilities using String address
     * @param address  address of the desired processing facility we want to find
     * @return the processing facility or null if unfound
     */
    public static ProcessingFacility findProcessingFacility(String address) {
        /*
        matches cases to make sure it contains what the user entered and iterates through the arraylist to search if
        it contains some or all of the entered title to store it in a String.
         */
        String lowerCase = address.toLowerCase();
        //iterate through arraylist
            for (ProcessingFacility processingFacility : processingFacilities) {
                //Match the current address of iterator to the address we are searching for.
                if (processingFacility.getADDRESS().toLowerCase().equals(lowerCase)) {
                    return processingFacility;
                }
            }
            return null;
        }


    /**
     * Read txt file storing addresses of processing facilities.
     * @throws FileNotFoundException File not found
     */
    protected static void readProcessingFacilities() throws FileNotFoundException {
        //create processing facilities by reading from processing facilities
        // add them to the array list of facilities
        String txtPathProcessingFacilities = "processingFacilities.txt";
        File ListOfProcessingFacilities = new File(txtPathProcessingFacilities);
        Scanner scan = new Scanner(ListOfProcessingFacilities);
        //Keep reading if there is a next line
        while (scan.hasNextLine()) {
            //read x y coordinates.
            int X = scan.nextInt();
            int Y = scan.nextInt();
            ProcessingFacility processingFacility = new ProcessingFacility(X, Y);
            Data.getProcessingFacilities().add(processingFacility);
        }
        scan.close();
    }

    /**
     * Read txt file storing addresses of processing facilities connections/links.
     * @throws FileNotFoundException  file not found.
     */
    protected static void readConnections() throws FileNotFoundException {
        String txtPathConnections = "connections.txt";
        File ListOfConnections = new File(txtPathConnections);
        Scanner scan = new Scanner(ListOfConnections);
        //Keep reading if there is a next line
        while (scan.hasNextLine()) {
                    //move scanner to next line
            scan.nextLine();
            //initialize String address A and B
            String addressA = scan.next();
            String addressB = scan.next();
            //creation of empty processing facilities that are connected and using the findProcess
            ProcessingFacility facilityA = null;
            ProcessingFacility facilityB = null;
            facilityA = findProcessingFacility(addressA);
            facilityB = findProcessingFacility(addressB);
            facilityA.addNeighbour(facilityB);
            facilityB.addNeighbour(facilityA);
        }
        scan.close();

    }

    /**
     * Read csv file of parcels and store them in arrayList
     * @throws FileNotFoundException  file not found.
     */
    protected static void readParcels() throws FileNotFoundException {

        ArrayList<Parcel> allParcels = new ArrayList<>();
        String csvPathParcels = "parcels.csv";
        File ListOfParcels = new File(csvPathParcels);
        Scanner scanFile = new Scanner(ListOfParcels);
        //Keep reading if there is a next line
        while (scanFile.hasNextLine()) {
            //read the whole line and make scanner for the string you just read which reads items seperated by delimiter
            String line = scanFile.nextLine();
            Scanner scanLine = new Scanner(line);
            scanLine.useDelimiter(",");
            //initialize String address for sender and recipient
            String sender = scanLine.next();
            String recipient = scanLine.next();
            /*
            creation of sender/recipient processing facilities and initializing them using string address we just
            read to search for the actual processing facility object.
             */
            ProcessingFacility senderFacility = findProcessingFacility(sender);
            ProcessingFacility recipientFacility = findProcessingFacility(recipient);
            String parcelType = scanLine.next();
            Parcel myParcel = null;
            /*
            Based on the type of parcel, there will be more data and different types of data or not at all, so I made
            (IF) statements for each case and then the program creates the appropriate type.
             */
            if (parcelType.equalsIgnoreCase("Standard")) {
               double otherInfo = scanLine.nextDouble();
               myParcel = new StandardParcel(senderFacility, recipientFacility, otherInfo);
            } else if (parcelType.equalsIgnoreCase("Tracked")) {
                myParcel = new TrackedParcel(senderFacility, recipientFacility);
            } else if (parcelType.equalsIgnoreCase("Medical")) {
                int otherInfo = scanLine.nextInt();
                myParcel = new MedicalParcel(senderFacility, recipientFacility, otherInfo);
            }
            allParcels.add(myParcel);
            scanLine.close();
        }
        //assign the arraylist to new sorted arraylist same data
        ArrayList<Parcel> allParcelsSorted = bubbleSort(allParcels);
        //fill stack with sorted array.
        fillStack(allParcelsSorted);

        scanFile.close();
    }

    /**
     * Sort arraylist given by parameter using bubble sort based on priority of parcel.
     * @param allParcels  arraylist to be sorted
     * @return arraylist but sorted
     */
    private static ArrayList<Parcel> bubbleSort(ArrayList<Parcel> allParcels) {
        int n = allParcels.size();
        //iterate through arraylist
        for (int i = 0; i < n - 1; i++) {
            // Compare the priority of the current Parcel with the next Parcel(s)
            for (int j = 0; j < n - i - 1; j++) {
                // Swap the positions of the current Parcel and the next Parcel
                if (allParcels.get(j).getPriority() < allParcels.get(j + 1).getPriority()) {
                    Parcel temp = allParcels.get(j);
                    allParcels.set(j, allParcels.get(j + 1));
                    allParcels.set(j + 1, temp);
                }
            }
        }
        return allParcels;
    }

    /**
     * Fills the stack in the order from the highest priority to lowest.
     * @param allParcelsSorted sorted arraylist that will fill the stack
     */
    private static void fillStack(ArrayList<Parcel> allParcelsSorted) {
        //iterate through arraylist
        for (Parcel parcel : allParcelsSorted) {
            //not null
            if (parcel != null) {
                //add  parcel to stack
                parcels.push(parcel);
            }
        }
    }




}
