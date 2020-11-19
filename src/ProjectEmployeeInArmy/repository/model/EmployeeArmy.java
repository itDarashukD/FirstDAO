package ProjectEmployeeInArmy.repository.model;

import java.util.Objects;

public class EmployeeArmy extends Employee {


    private Integer yearInArmy;
    private String positions;
    private String rank;


    public Integer getYear_in_army() {
        return yearInArmy;
    }

    public void setYear_in_army(Integer yearInArmy) {
        this.yearInArmy = yearInArmy;
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
        EmployeeArmy that = (EmployeeArmy) o;
        return getId() == that.getId() &&
                Objects.equals(yearInArmy, that.yearInArmy) &&
                Objects.equals(getFirstName(), that.getLastName()) &&
                Objects.equals(getLastName(), that.getLastName()) &&
                Objects.equals(positions, that.positions) &&
                Objects.equals(rank, that.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), yearInArmy, getFirstName(), getLastName(), positions, rank);
    }

    @Override
    public String toString() {
        return "EmployeeArmy{" +
                "id=" + getId() +
                ", yearInArmy=" + yearInArmy +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", position='" + positions + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}
