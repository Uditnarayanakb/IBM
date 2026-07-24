public class Exception_Handling {
    public static void main(String[] args) {
        int []arr = new int[5];
        System.out.println("We have a 5 element Array\nTrying to print 5th index of the Array: ");
        System.out.println(arr[5]);
        try {
            arr[5] = 6;
        } catch (Exception e) {
            System.out.println("Some error occurred, exception: "+ e);
        }

        System.out.println("Exiting Programme");
    }
}
