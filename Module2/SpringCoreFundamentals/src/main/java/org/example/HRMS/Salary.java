package org.example.HRMS;

public class Salary {
    private final long basic;
    private final long da;
    private final long hra;

    public Salary(long
                          basic, long
                          da, long
                          hra) {
        this.basic = basic;
        this.da = da;
        this.hra = hra;
    }

    public long
    getBasic() {
        return basic;
    }

    public long
    getDa() {
        return da;
    }

    public long
    getHra() {
        return hra;
    }

    public long
    getTotal() {
        return basic+da+hra;
    }
}