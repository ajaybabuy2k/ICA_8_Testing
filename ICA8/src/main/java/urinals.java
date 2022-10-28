import java.util.Scanner;

public class urinals {

    public static boolean True;

    public static boolean False;


    public static void main(String[] args) {

        String returnedString = getString();

        boolean verifyGoodString=goodString(returnedString);

        if(verifyGoodString==False)
        {
            System.out.println("Invalid Urinals Positions, printing -1");
        }

        else if(verifyGoodString==True)
        {
            System.out.println("Valid Urinals Positions");
        }

    }
    public static boolean goodString(String str){
        for(int iter=0;iter<str.length();iter++)
        {
            boolean condition = str.charAt(iter)=='1' || str.charAt(iter)=='0';

            if(condition )
            {
                if((iter>0) && (str.charAt(iter)=='1') && (str.charAt(iter-1)=='1'))
                {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static String getString(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string:");
        String str=sc.next();
        return str;
    }

}
