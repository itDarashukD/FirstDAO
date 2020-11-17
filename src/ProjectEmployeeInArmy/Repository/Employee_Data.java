package ProjectEmployeeInArmy.Repository;

import ProjectEmployeeInArmy.Entity.Entity;

import java.util.Objects;

public class Employee_Data extends Entity {


    private Integer yearsold;
    private String education;
    private String cityLive;

    public Integer getYearsold() {
        return yearsold;
    }

    public void setYearsold(Integer yearsold) {
        this.yearsold = yearsold;
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
        Employee_Data that = (Employee_Data) o;
        return getId() == that.getId() &&
                Objects.equals(yearsold, that.yearsold) &&
                Objects.equals(education, that.education) &&
                Objects.equals(cityLive, that.cityLive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), yearsold, education, cityLive);
    }

    @Override
    public String toString() {
        return "Employee_data{" +
                "id=" + getId() +
                ", yearsOld=" + yearsold +
                ", education='" + education + '\'' +
                ", cityLive='" + cityLive + '\'' +
                '}';
    }
}
