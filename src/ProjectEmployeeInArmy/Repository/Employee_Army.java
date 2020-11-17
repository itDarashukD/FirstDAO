package ProjectEmployeeInArmy.Repository;

import ProjectEmployeeInArmy.Entity.Entity;

import java.util.Objects;

public class Employee_Army extends Entity {


    private Integer year_in_army;
    private String firstname;
    private String lastname;
    private String positions;
    private String rank;


    public Integer getYear_in_army() {
        return year_in_army;
    }

    public void setYear_in_army(Integer year_in_army) {
        this.year_in_army = year_in_army;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPositions() {
        return positions;
    }

    public void setPositions(String positions) {
        this.positions = positions;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee_Army that = (Employee_Army) o;
        return getId() == that.getId() &&
                Objects.equals(year_in_army, that.year_in_army) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(positions, that.positions) &&
                Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), year_in_army, firstname, lastname, positions, rank);
    }

    @Override
    public String toString() {
        return "EmployeeArmy{" +
                "id=" + getId() +
                ", yearInArmy=" + year_in_army +
                ", firstName='" + firstname + '\'' +
                ", lastName='" + lastname + '\'' +
                ", position='" + positions + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
