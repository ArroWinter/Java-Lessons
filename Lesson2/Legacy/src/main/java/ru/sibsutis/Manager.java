package ru.sibsutis;

public class Manager extends User implements CSV{
    private String phone;

    public Manager(String name, String email, String phone) {
        super(name, email);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toCSV() {
        String nm, ml;
        nm = getName();
        ml = getEmail();
        return nm + ";" + ml + ";" + this.phone;
    }

    @Override
    public void fromCSV(String str) {
        String[] array = str.split(";");
        this.setName(array[1]);
        this.setEmail(array[2]);
        this.setPhone(array[3]);
    }
}
