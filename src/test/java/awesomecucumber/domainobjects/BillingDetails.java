package awesomecucumber.domainobjects;

public class BillingDetails
{
    private String billingfirstname;
    private String billinglastname;
    private String billingaddress_line1;
    private String billingcity;
    private String billingstate;
    private String billingcountry;
    private String billingzip;
    private String billingemail;

    public BillingDetails(String billingfirstname, String billinglastname, String billingaddress_line1,
                          String billingcity, String billingstate, String billingcountry, String billingzip,
                          String billingemail)
    {
        this.billingfirstname = billingfirstname;
        this.billinglastname = billinglastname;
        this.billingaddress_line1 = billingaddress_line1;
        this.billingcity = billingcity;
        this.billingstate = billingstate;
        this.billingcountry = billingcountry;
        this.billingzip = billingzip;
        this.billingemail = billingemail;
    }

    public String getBillingfirstname() {
        return billingfirstname;
    }

    public void setBillingfirstname(String billingfirstname) {
        this.billingfirstname = billingfirstname;
    }

    public String getBillinglastname() {
        return billinglastname;
    }

    public void setBillinglastname(String billinglastname) {
        this.billinglastname = billinglastname;
    }

    public String getBillingaddress_line1() {
        return billingaddress_line1;
    }

    public void setBillingaddress_line1(String billingaddress_line1) {
        this.billingaddress_line1 = billingaddress_line1;
    }

    public String getBillingcity() {
        return billingcity;
    }

    public void setBillingcity(String billingcity) {
        this.billingcity = billingcity;
    }

    public String getBillingstate() {
        return billingstate;
    }

    public void setBillingstate(String billingstate) {
        this.billingstate = billingstate;
    }

    public String getBillingcountry() {
        return billingcountry;
    }

    public void setBillingcountry(String billingcountry) {
        this.billingcountry = billingcountry;
    }

    public String getBillingzip() {
        return billingzip;
    }

    public void setBillingzip(String billingzip) {
        this.billingzip = billingzip;
    }

    public String getBillingemail() {
        return billingemail;
    }

    public void setBillingemail(String billingemail) {
        this.billingemail = billingemail;
    }
}