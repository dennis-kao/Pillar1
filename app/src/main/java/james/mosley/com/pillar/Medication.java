package james.mosley.com.pillar;

import java.util.*;

public class Medication {

    public static enum DosageType {MG, ML, PUFFS, PILLS, DROPS}

    //Medication information
    private int medID = 0;
    private String name = "";
    private int dosage = 0;
    private DosageType type = DosageType.PILLS;
    private ArrayList<Date>frequency = new ArrayList<>(); //Uses time fields of Date Class.
    private Date startDate = null;
    private Date endDate = null;
    private boolean nofify = true;
    private String notes = "";
    private int notifyBefore = 0;
    private int hits = 0;
    private int misses = 0;

    public Medication () {

    }


}