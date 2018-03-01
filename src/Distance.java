public class Distance {

    public static Integer getDistance(Integer x1, Integer y1, Integer x2, Integer y2)
    {
        Integer dist;
        dist = Math.abs((x2-x1) + (y2-y1));

        System.out.println("Distance Between"+"("+x1+","+y1+"),"+"("+x2+","+y2+")===>"+dist);

        return dist;
    }
}
