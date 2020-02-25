package ru.sibsutis;

class Dev extends User implements CSV {
    private String dep;

    public Dev(String name, String email, String dep) {
        super(name, email);
        this.dep = dep;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    @Override
    public String toCSV() {
        String nm, ml;
        nm = getName();
        ml = getEmail();
        return nm + ";" + ml + ";" + this.dep;
    }

    @Override
    public void fromCSV(String str) {
        String[] array = str.split(";");
        this.setName(array[1]);
        this.setEmail(array[2]);
        this.setDep(array[3]);
    }
}
