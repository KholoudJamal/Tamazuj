package com.Tamazj.TamazjApp.Model;

public class BillDetails {

    private int icon;
    private String billDetail;
    private String supBillDetail;

    public BillDetails(int icon, String billDetail, String supBillDetail) {
        this.icon = icon;
        this.billDetail = billDetail;
        this.supBillDetail = supBillDetail;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getBillDetail() {
        return billDetail;
    }

    public void setBillDetail(String billDetail) {
        this.billDetail = billDetail;
    }

    public String getSupBillDetail() {
        return supBillDetail;
    }

    public void setSupBillDetail(String supBillDetail) {
        this.supBillDetail = supBillDetail;
    }
}
