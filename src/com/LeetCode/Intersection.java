/**
 * https://leetcode-cn.com/problems/intersection-lcci/solution/java-shuang-100-by-lalala-00/
 */
public class Intersection {
    public static double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        double a1,b1,a2,b2;
        if(start1[0]==end1[0]){
            b1=0;
            a1=Math.abs(start1[1]-end1[1]);
        }else {
            a1=(double)(start1[1]-end1[1])/(double)(start1[0]-end1[0]);
            b1=start1[1]-a1*start1[0];
        }

        if(start2[0]-end2[0]==0){
            b2=0;
            a2=Math.abs(start2[1]-end2[1]);
        }else {
            a2=(double)(start2[1]-end2[1])/(double)(start2[0]-end2[0]);
            b2=start2[1]-a2*start2[0];
        }

        if(a1==a2&&b1!=b2){
            return new double[]{};
        }

        if(a1==a2&&b1==b2){
            if((Math.max(start1[0],end1[0])<Math.min(start2[0],end2[0]))||(Math.min(start1[0],end1[0])>Math.max(start2[0],end2[0]))
                    ||(Math.max(start1[1],end1[1])<Math.min(start2[1],end2[1]))||(Math.min(start1[1],end1[1])>Math.max(start2[1],end2[1]))){
                return new double[]{};
            }

            double[] line1 = selectMinX(start1,end1);
            double[] line2 = selectMinX(start2,end2);
            return selectNode(line1,line2);
        }

        double x = (b2-b1)/(a1-a2);
        double y = a1*x+b1;
        //还差斜率不同，但不相交的线段
        if(start1[0]!=end1[0]&&(x-start1[0])*(x-end1[0])>0){
            return new double[]{};
        }
        if(start2[0]!=end2[0]&&(x-start2[0])*(x-end2[0])>0){
            return new double[]{};
        }
        return new double[]{x,y};
    }

    private static double[] selectNode(double[] line1, double[] line2) {
        if(line1[0]>line2[0]){
            return line1;
        }
        if(line1[0]<line2[0]){
            return line2;
        }
        if(line1[1]<line2[1]){
            return line1;
        }
        return line2;
    }

    private static double[] selectMinX(int[] start, int[] end) {
        double[] line = new double[2];
        if(start[0]<end[0]){
            line[0] = start[0];
            line[1] = start[1];
        }
        if(start[0]>end[0]){
            line[0] = end[0];
            line[1] = end[1];
        }
        return line;
    }

    public static void main(String[] args){
        int[] start1={-10,48};
        int[] end1 = {-43,46};
        int[] start2={-16,59};
        int[] end2 = {-1,85};
        double[] node = intersection(start1,end1,start2,end2);
        if(node.length==0){
            System.out.println("[]");
        }
        System.out.println("["+node[0]+","+node[1]+"]");
    }
}
