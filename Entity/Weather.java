package project.Entity;

public class Weather {
    private String city;
    private String LocalDate;
    private double temperature;

    public Weather(String city, String localDate, double temperature){
        this.city = city;
        this.LocalDate = localDate;
        this.temperature = temperature;
    }
    public String getCity(){
        return city;
    }
    public String getLocalDate(){
        return LocalDate;
    }
    public double getTemperature(){
        return temperature;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setLocalDate(String localDate) {
        LocalDate = localDate;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public  String toString(){
        return "Weather {"+
                "city = " + city + '\'' +
                ", local data = " + LocalDate + '\'' +
                ", temperature = " + String.format("%.2f", temperature) +
                '}';
    }
}
