public class Ride {

    public Integer[] beginLocal = new Integer[2];
    public Integer[] endLocal = new Integer[2];
    public Integer beginDate;
    public Integer endDate;

    public Integer[] getBeginLocal() {
        return beginLocal;
    }

    void setBeginLocal(Integer[] beginLocal) {
        this.beginLocal = beginLocal;
    }


    public Integer[] getEndLocal() {
        return endLocal;
    }

    void setEndLocal(Integer[] endLocal) {
        this.endLocal = endLocal;
    }


    public Integer getBeginDate() {
        return beginDate;
    }

    void setBeginDate(Integer beginDate) {
        this.beginDate = beginDate;
    }


    public Integer getEndDate() {
        return endDate;
    }

    void setEndDate(Integer endDate) {
        this.endDate = endDate;
    }
}
