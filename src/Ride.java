public class Ride {

    public int[] beginLocal = new int[2];
    public int[] endLocal = new int[2];
    public Integer beginDate;
    public Integer endDate;

    public int[] getBeginLocal() {
        return beginLocal;
    }

    void setBeginLocal(int[] beginLocal) {
        this.beginLocal = beginLocal;
    }


    public int[] getEndLocal() {
        return endLocal;
    }

    void setEndLocal(int[] endLocal) {
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
