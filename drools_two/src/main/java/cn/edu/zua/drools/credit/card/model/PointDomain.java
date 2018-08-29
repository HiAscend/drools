package cn.edu.zua.drools.credit.card.model;

/**
 * 积分计算对象
 * Created by ascend on 2017/2/9 14:22.
 */
public class PointDomain {
    private String userName;    //用户名
    private boolean birthDay;   //是否当日生日
    private long point;         //增加积分数目
    private int buyNums;        //当月购物次数
    private int backNums;       //当月退货次数
    private double buyMoney;    //当月购物总金额
    private double backMoney;   //当月退货总金额
    private int billThisMonth;  //当月信用卡还款次数

    /**
     * 记录积分发放流水，防止重复发放
     * @param userName userName
     * @param type  type
     */
    public void recordPointLog(String userName,String type){
        System.out.println("增加对"+userName+"的类型为"+type+"的积分操作记录。");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isBirthDay() {
        return birthDay;
    }

    public void setBirthDay(boolean birthDay) {
        this.birthDay = birthDay;
    }

    public long getPoint() {
        return point;
    }

    public void setPoint(long point) {
        this.point = point;
    }

    public int getBuyNums() {
        return buyNums;
    }

    public void setBuyNums(int buyNums) {
        this.buyNums = buyNums;
    }

    public int getBackNums() {
        return backNums;
    }

    public void setBackNums(int backNums) {
        this.backNums = backNums;
    }

    public double getBuyMoney() {
        return buyMoney;
    }

    public void setBuyMoney(double buyMoney) {
        this.buyMoney = buyMoney;
    }

    public double getBackMoney() {
        return backMoney;
    }

    public void setBackMoney(double backMoney) {
        this.backMoney = backMoney;
    }

    public int getBillThisMonth() {
        return billThisMonth;
    }

    public void setBillThisMonth(int billThisMonth) {
        this.billThisMonth = billThisMonth;
    }

    @Override
    public String toString() {
        return "PointDomain{" +
                "userName='" + userName + '\'' +
                ", birthDay=" + birthDay +
                ", point=" + point +
                ", buyNums=" + buyNums +
                ", backNums=" + backNums +
                ", buyMoney=" + buyMoney +
                ", backMoney=" + backMoney +
                ", billThisMonth=" + billThisMonth +
                '}';
    }
}
