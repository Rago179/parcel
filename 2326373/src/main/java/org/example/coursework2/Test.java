package org.example.coursework2;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * - File-name = Test.java
 * @version 2.0
 * - Creation date: 20.3.24
 * - Last modification date: 27.4.24
 * @author Omar Sanad
 * - Copyright notice: no copyright
 * - Purpose of the program: personal testing and exploration
 * - Version history: 1.0 -pure code; 2.0 - comments added
 * - Test class, just showing my process of development and exploration.
 */
public class Test {


    public static void main(String[] args) throws FileNotFoundException {
        ProcessingFacility sender =new ProcessingFacility(100,100);
        ProcessingFacility receiver = new ProcessingFacility(200,200);
        StandardParcel stp=new StandardParcel(sender,receiver,1);
        stp.process(sender);
        System.out.println(stp);
        TrackedParcel Trp=new TrackedParcel(sender,receiver);
        Trp.process(sender);
        Trp.process(receiver);
        System.out.println(Trp);
        MedicalParcel Mdp=new MedicalParcel(sender,receiver,5);
        Mdp.process(sender);
        Mdp.process(receiver);
        System.out.println(Mdp);
//        Data.readProcessingFacilities();
//        Data.readConnections();
//        Data.readParcels();
      Parcel yuy = new Parcel(sender,receiver,2);
        
    }


}
