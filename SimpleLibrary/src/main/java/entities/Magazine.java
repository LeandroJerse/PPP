package entities;

public class Magazine extends AbsBooks{

    private String organization;
    private Float volume;
    private Integer number;

    public Magazine() {

    }

    public Magazine(String title, Integer Year, String organization, Float volume, Integer number) {
        super(title, Year);
        this.organization = organization;
        this.volume = volume;
        this.number = number;
    }

    public String getTitle() {
        return super.getTitle() +" "+ getOrganization() + " " + getVolume() + " " + getNumber();
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Revista: "+super.getTitle() + "\t" + "Organização: " + getOrganization() + "\tVolume: " + getVolume() + "\tNro: " + getNumber() + "\tAno: " + getYear();
    }
}
