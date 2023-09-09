package jonas.rewardapp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Redemption {
    private long id;
    private String name;
    private int rewardPointValue;
    private Date issueDate;
    private Date expirationDate;
    private boolean isValid;

    private List<Redemption> redemptionList;

    public Redemption(long id, String name, int rewardPointValue) {
        this.id = id;
        this.name = name;
        this.rewardPointValue = rewardPointValue;

    }
    public Redemption(){
        redemptionList = new ArrayList<>();
        Redemption redemption1 = new Redemption(1,"Amazon gift card",2000);
        Redemption redemption2 = new Redemption(2,"Travel gift card",1500);
        Redemption redemption3 = new Redemption(3,"Headphone",2000);
        Redemption redemption4 = new Redemption(4,"T-shirts",200);
        this.redemptionList.add(redemption1);
        this.redemptionList.add(redemption2);
        this.redemptionList.add(redemption3);
        this.redemptionList.add(redemption4);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRewardPointValue() {
        return rewardPointValue;
    }

    public void setRewardPointValue(int rewardPointValue) {
        this.rewardPointValue = rewardPointValue;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public List<Redemption> getRedemptionList() {
        return redemptionList;
    }

    public void setRedemptionList(List<Redemption> redemptionList) {
        this.redemptionList = redemptionList;
    }

    @Override
    public String toString() {
        return "Redemption{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rewardPointValue=" + rewardPointValue +
                '}';
    }
}
