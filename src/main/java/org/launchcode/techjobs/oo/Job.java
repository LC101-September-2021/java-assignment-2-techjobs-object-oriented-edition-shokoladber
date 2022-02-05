package org.launchcode.techjobs.oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency){
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() { return id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public static int getNextId() {
        return nextId;
    }

    @Override
    public String toString(){
        String thisString;

        if (name == "") {
            this.setName("Data not available");
        }
        if (employer.getValue() == "") {
            this.employer.setValue("Data not available");
        }
        if (location.getValue() == "") {
            this.location.setValue("Data not available");
        }
        if (positionType.getValue() == "") {
            this.positionType.setValue("Data not available");
        }
        if (coreCompetency.getValue() == "") {
            this.coreCompetency.setValue("Data not available");
        }
        if (name == "Data not available" &&
                employer.getValue() == "Data not available" &&
                location.getValue() == "Data not available" &&
                positionType.getValue() == "Data not available" &&
                coreCompetency.getValue() == "Data not available"){
            return "Oops! This job does not seem to exist.";
        }

        thisString ="\n" +
                "ID: " + id + "\n" +
                "Name: " + this.name + "\n" +
                "Employer: " + this.employer.getValue() + "\n" +
                "Location: " + this.location.getValue() + "\n" +
                "Position Type: " + this.positionType.getValue() + "\n" +
                "Core Competency: " + this.coreCompetency.getValue() + "\n" +
                "\n";

        return thisString;
    }
}
