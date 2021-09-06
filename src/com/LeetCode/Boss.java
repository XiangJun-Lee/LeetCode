public class Boss {
    public static  void main(String[] args){
        String[] A = new String[]{"a", "c","z", "d","f", "g"};
        String[] B = new String[]{"a", "c", "d", "f","g"};
        if (B.length==0){
            System.out.println(A[0]);
            return;
        }
        System.out.println(findLetter(A,B));
    }

    private static String findLetter(String[] A, String[] B) {
        int start =0;
        int end = B.length-1;
        while (start<end){
            int mid = start+(end-start)/2;
            if (A[mid].equals(B[mid])){
                start=mid+1;
            }else {
                end=mid;
            }
        }
        return A[start];
    }
}
