import java.util.Scanner;

public class FileModifier {


    public static void main(String[] args) {
        Stringplayground sp = new Stringplayground();
        boolean stillUsing = true;
        System.out.println("");
        String input = new String("");
        int count =0;
        while (stillUsing) {
            if(count == 0) {
                System.out.println();
                System.out.println();
                System.out.println("what do you want to do with this file?");
                System.out.println("Enter the number:");
                System.out.println("1: how many characters are in the file(not including the space)");
                System.out.println("2: find out how many words are in the file");
                System.out.println("3: search how many times a speciic words occur in the file");
                System.out.println("4: search how many times a speciic words occur in the file(Case Insensitive)");
                System.out.println("5: replace a word with another word");
                System.out.println("6: empty the file content");
                System.out.println("7: check the file content");
                System.out.println("8: append text in the file");
                System.out.println("0: I am done with the file");
                System.out.println();
            }
            else{
                System.out.println();
                System.out.println("what do you want to do next?");
                System.out.println("enter 1(count chars), 2(count words) ,3(search words appears)");
                System.out.println("4(search words appears Case Ignore) 5(replace words) 6(empty file) 7(check file) 8(append) 0(exit)" );
            }
            Scanner sc = new Scanner(System.in);

            input = sc.nextLine();
            switch (input) {
                case "1":
                    System.out.println("the file have "+sp.getChars()+" total characters");
                    System.out.println();
                    break;
                case "2":
                    System.out.println("the file have "+sp.getWords()+" total words");
                    System.out.println();
                    break;
                case "3":
                    sp.searchWord();
                    System.out.println();
                    break;

                case "4":
                    sp.searchWordCNS();

                    break;

                case "5":
                    sp.replaceWord();
                    System.out.println();

                    break;
                case "6":
                    sp.emptyFile();
                    System.out.println();

                    break;
                case "7":
                    System.out.println("file content:");
                    System.out.println(sp.getContent());

                    break;
                case "8":
                    sp.fileWrite();
                    break;
                case "0":
                    stillUsing = false;
                    System.out.println();
                    break;
                default:
                    System.out.println("please enter number 0, 1, 2 ,3 ,4");


            }
            if (!stillUsing) System.out.println("have a nice day :)");

            count++;
        }
    }
}


