public class Distance {

    public static Integer getDistance(Integer x1, Integer y1, Integer x2, Integer y2)
    {
        Integer dist;
        dist = Math.abs((x2-x1) + (y2-y1));

        System.out.println("Distance Between"+"("+x1+","+y1+"),"+"("+x2+","+y2+")===>"+dist);

        return dist;
    }

    public static Integer getDistance(Integer[] pos1, Integer[] pos2) {
        return getDistance(pos1[0], pos2[0], pos1[1], pos2[1]);
    }

    public static Integer getDistance(Ride r1,Ride r2) {
        return getDistance(r1.getBeginLocal()[0], r2.getEndLocal()[0], r1.getBeginLocal()[1], r2.getEndLocal()[1]);
    }

}
