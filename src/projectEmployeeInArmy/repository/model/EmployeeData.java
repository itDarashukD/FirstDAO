package projectEmployeeInArmy.repository.model;

import java.util.Objects;

public class EmployeeData extends Employee {


    private Integer yearsOld;
    private String education;
    private String cityLive;

    public Integer getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(Integer yearsOld) {
        this.yearsOld = yearsOld;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCityLive() {
        return cityLive;
    }

    public void setCityLive(String cityLive) {
        this.cityLive = cityLive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeData that = (EmployeeData) o;
        return getId() == that.getId() &&
                Objects.equals(yearsOld, that.yearsOld) &&
                Objects.equals(education, that.education) &&
                Objects.equals(cityLive, that.cityLive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), yearsOld, education, cityLive);
    }

    @Override
    public String toString() {
        return "Employee_data{" +
                "id=" + getId() +
                ", yearsOld=" + yearsOld +
                ", education='" + education + '\'' +
                ", cityLive='" + cityLive + '\'' +
                '}';
    }
}
