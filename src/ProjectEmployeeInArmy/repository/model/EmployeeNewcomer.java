package ProjectEmployeeInArmy.repository.model;


import java.util.Objects;

public class EmployeeNewcomer extends Employee {


//    private String first_name;
//    private String last_name;
    private Integer years_old;


//    public String getFirst_name() {
//        return first_name;
//    }
//
//    public void setFirst_name(String first_name) {
//        this.first_name = first_name;
//    }
//
//    public String getLast_name() {
//        return last_name;
//    }
//
//    public void setLast_name(String last_name) {
//        this.last_name = last_name;
//    }

    public Integer getYears_old() {
        return years_old;
    }

    public void setYears_old(Integer years_old) {
        this.years_old = years_old;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeNewcomer employeeNewcomer = (EmployeeNewcomer) o;
        return Objects.equals(getId(), employeeNewcomer.getId()) &&
                Objects.equals(getFirstName(), employeeNewcomer.getFirstName()) &&
                Objects.equals(getLastName(), employeeNewcomer.getLastName()) &&
                Objects.equals(years_old, employeeNewcomer.years_old);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), years_old);
    }

    @Override
    public String toString() {
        return "Newcomer{" +
                "id=" + getId() +
                ", first_name='" + getFirstName() + '\'' +
                ", last_name='" + getLastName() + '\'' +
                ", years_old=" + years_old +
                '}';
    }
}

