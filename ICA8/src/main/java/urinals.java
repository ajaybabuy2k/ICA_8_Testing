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
            int urinalsCount=countUrinals(returnedString);
            System.out.println(urinalsCount);
        }

    }
    public static boolean goodString(String str){
        for(int iter=0;iter<str.length();iter++)
        {
            if(str.charAt(iter)=='1' || str.charAt(iter)=='0')
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


    public static int countUrinals(String inputString)
    {
        int[]arrStringInput=new int[inputString.length()];
        for(int iterator=0;iterator<arrStringInput.length;iterator++)
        {
            arrStringInput[iterator]=0;
        }
        for(int iterator=0;iterator<inputString.length();iterator++)
        {
            if(iterator==0)
            {
                if(inputString.charAt(iterator)=='0')
                {
                    if(iterator+1<inputString.length()) {

                        if (inputString.charAt(iterator + 1) == '1') {
                            arrStringInput[iterator] = 0;
                        }

                        else if(inputString.charAt(iterator + 1) != '1'){
                            arrStringInput[iterator] = 1;
                        }
                    }
                }
                else if(iterator!=0) {

                    arrStringInput[iterator]=0;

                }
            }
            else if(iterator==1)
            {
                if(inputString.charAt(iterator)=='1') {
                    arrStringInput[iterator] = arrStringInput[iterator - 1];
                }
                else if(inputString.charAt(iterator)!='1')
                {
                    if(inputString.charAt(iterator-1)=='1')
                    {
                        arrStringInput[iterator]=arrStringInput[iterator-1];
                    }
                    else if(iterator+1<inputString.length() && inputString.charAt(iterator+1)=='1')
                    {
                        arrStringInput[iterator]=arrStringInput[iterator-1];
                    }
                    else
                    {
                        arrStringInput[iterator]=1;
                    }
                }
            }
            else {
                arrStringInput[iterator]=arrStringInput[iterator-1];
                if(inputString.charAt(iterator)=='1') {
                    arrStringInput[iterator] = arrStringInput[iterator - 1];
                }
                else
                {
                    if(inputString.charAt(iterator-1)=='1')
                    {
                        arrStringInput[iterator]=arrStringInput[iterator-1];
                    }
                    else if(iterator+1<inputString.length() && inputString.charAt(iterator+1)=='1')
                    {
                        arrStringInput[iterator]=arrStringInput[iterator-1];
                    }
                    else
                    {
                        arrStringInput[iterator]=Math.max(arrStringInput[iterator],1+arrStringInput[iterator-2]);
                    }
                }
            }
        }
        return arrStringInput[inputString.length()-1];
    }


    public static String getString(){
        Scanner scannerObj=new Scanner(System.in);
        System.out.println("Enter the input string:");
        String inputStr=scannerObj.next();
        return inputStr;
    }

}
