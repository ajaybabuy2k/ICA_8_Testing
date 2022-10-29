import java.io.IOException;
import java.util.Scanner;
import java.io.File;

import java.io.*;


import java.util.Vector;

public class urinals {



    public static boolean True;

    public static boolean False;




    public static boolean checkFileData(String filePath) {
        try {
            File fileNamePath = new File(filePath);
            Scanner scannerObj = new Scanner(fileNamePath);
            return scannerObj.hasNextLine();

        }

        catch (Exception exceptione) {

            //if(exceptione):
            //{
            //    System.out.println("Exception Found");
            //}

            return false;
        }
    }

    public static boolean nameFileFound(String filePath) {

        try {

            File fileNamePath = new File(filePath);
            Scanner scannerObject = new Scanner(fileNamePath);
            return true;

        }
        catch (FileNotFoundException exceptione)
        {
            //if(exceptione):
            //{
            //    System.out.println("Exception Found");
            //}
            return false;
        }

    }

    public static void writeToRuleFile(Vector<Integer>v) throws IOException,FileNotFoundException {

        File ruleFile=new File("src/main/java/rule.dat");
        File dataRuleFile=ruleFile;
        int iterCounter=1;

        while(dataRuleFile.exists())
        {
            dataRuleFile=new File("src/main/java/rule"+iterCounter+".dat");
            iterCounter=iterCounter+1;
        }
        ruleFile=dataRuleFile;

        FileWriter ruleFileReader=new FileWriter(ruleFile.getAbsoluteFile());
        BufferedWriter fileBufferWriter=new BufferedWriter(ruleFileReader);
        for(Integer counterInteger:v)
        {
            fileBufferWriter.write(counterInteger+"\n");
        }
        fileBufferWriter.close();
    }

    public static void readInputNameFile(String filePath) throws IOException,FileNotFoundException
    {

        if(nameFileFound(filePath)==false)
        {
            System.out.println("Input File not found in the database");
            return;
        }
        if(checkFileData(filePath)==false)
        {
            System.out.println("The File has no data in it and it's Empty file");
            return;
        }
        File fileNamePath = new File(filePath);
        Scanner scannerObj = new Scanner(fileNamePath);
        Vector<Integer> vectorInput=new Vector<Integer>();

        while(scannerObj.hasNextLine()) {
            String readLineInput=scannerObj.nextLine();
            boolean returnedGoodString = goodString(readLineInput);
            if (returnedGoodString == false) {
                vectorInput.add(-1);
                break;
            }
            else {
                int countedValue = countUrinals(readLineInput);
                vectorInput.add(countedValue);
            }
        }
        writeToRuleFile(vectorInput);
    }









    public static void main(String[] args) throws IOException,FileNotFoundException {

        System.out.println("You can take the input file as per your requirement");
        System.out.println("Do you want to read ");
        System.out.println("1. Using File Name");
        System.out.println("2. From the String");

        Scanner scannerObject=new Scanner(System.in);
        int scannerInput=scannerObject.nextInt();

        if(scannerInput==1) {
            readInputNameFile("src/main/java/urina.dat");
        }
        else if(scannerInput==2) {
            String getInputString = getString();
            System.out.println("The No of Urinals can be adjusted are "+countUrinals(getInputString));
        }
        else {
            System.out.println("Invalid User Input");
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
