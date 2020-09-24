/**
 * Shaopeng LIU
 * July 12 2020
 * File editing tools.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Stringplayground {



    private String txtName;
    private String content = "";
    private int words =0;
    private int chars = 0;


    public Stringplayground() {

        this.getfilecontent();
        //System.out.println("not null character is: "+chars);
        //System.out.println("wordCount is: "+words);
        //this.searchWord();
        //this.replaceWord();
        //System.out.println(content);
    }

    public void getfilecontent()

    {
        Boolean fileFound = false;
        while(! fileFound) {
        System.out.println("enter the file you want to modify: ");
        Scanner sc = new Scanner(System.in);
        txtName = sc.nextLine();



            try {

                File file = new File(txtName);


                Scanner scfile = new Scanner(file);
                fileFound = true;
                while (scfile.hasNextLine()) {
                    String thisLine = scfile.nextLine();
                    String lineAfterTrim = thisLine.trim();
                    for (int i = 0; i < lineAfterTrim.length(); i++) {
                        if (lineAfterTrim.charAt(i) == ' ' && lineAfterTrim.charAt(i + 1) != ' ') {
                            words++;
                        } else {

                            chars++;
                        }
                    }
                    if (lineAfterTrim.length() != 0)
                        words++; //prevent the empty line, take care of the word at the last
                    content = content.concat(thisLine + "\n");

                }

            } catch (Exception e) {
                System.out.println("no such file found, please enter filename again ");
                System.out.println();
            }
        }



    }



    public void searchWord()
    {
        String token;
        int searchCount = 0;
        StringTokenizer st = new StringTokenizer(content, " ", false);
        System.out.println("enter the word you want to search:");
        Scanner searchInput = new Scanner (System.in);
        String wordInput = searchInput.nextLine();
        while(st.hasMoreTokens())
        {
            int i;
            Boolean found=false;
            token = st.nextToken();
            System.out.println(token);
            if(token.length()>=wordInput.length())
            {
            for(i =0; i<token.length();i++)
            {
                found =false;
                if(wordInput.charAt(0)==token.charAt(i))
                {
                   // System.out.println("the word is "+token);


                    for (int j=0; j<token.substring(i).length() && j<wordInput.length();j++)
                    {

                       if(wordInput.charAt(j)!=token.charAt(i+j)) break;
                        if(j==wordInput.length()-1) found = true;
                    }

                }
                if(found) searchCount ++;

            }
            }
        }
        System.out.println("the word "+ wordInput+" appeared "+ searchCount+ " times");
    }

    public void replaceWord()
    {
        System.out.println("enter the word you want to replace:");
        Scanner scReplace = new Scanner(System.in);
        String wordReplace = scReplace.nextLine();
        System.out.println("replace the word to:");
        Scanner scReplaceTo = new Scanner(System.in);
        String wordReplaceTo = scReplaceTo.nextLine();
        content = this.content.replace(wordReplace,wordReplaceTo);

        try{
            FileWriter fw = new FileWriter(txtName); //make a new file writer
            PrintWriter pw = new PrintWriter(fw); // printWriter actually write in the file
            System.out.println("modify success!");
            System.out.println("content now is:");
            System.out.println(content);
            pw.println(content);//write in the txt
            pw.close();// Close the file otherwise file might be destroyed.
        } catch (IOException e) {
            System.out.println("file error when replacing");
        }

    }

    public int getChars() {
        return chars;
    }

    public int getWords() {
        return words;
    }

    public void searchWordCNS()
    {
        String token;
        int searchCount = 0;
        StringTokenizer st = new StringTokenizer(content, " ", false);
        System.out.println("enter the word you want to search:");
        Scanner searchInput = new Scanner (System.in);
        String wordInput = searchInput.nextLine();
        while(st.hasMoreTokens())
        {
            int i;
            Boolean found=false;
            token = st.nextToken();
            System.out.println(token);
            if(token.length()>=wordInput.length())
            {
                for(i =0; i<token.length();i++)
                {
                    found =false;
                    if(Character.toLowerCase(wordInput.charAt(0))==Character.toLowerCase(token.charAt(i)))
                    {
                        // System.out.println("the word is "+token);


                        for (int j=0; j<token.substring(i).length() && j<wordInput.length();j++)
                        {

                            if(Character.toLowerCase(wordInput.charAt(j))!=Character.toLowerCase(token.charAt(i+j)) )break;
                            if(j==wordInput.length()-1) found = true;
                        }

                    }
                    if(found) searchCount ++;

                }
            }
        }
        System.out.println("the word "+ wordInput+" appeared "+ searchCount+ " times(Case Ignore)");
    }

    public void emptyFile() {
        String ept = "";
        try {
            FileWriter fw = new FileWriter(txtName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("");
            System.out.println("file is now empty");
            System.out.println();
            pw.close();
            content ="";

        } catch (Exception e) {
            System.out.println("error when empty the file");
        }
    }

    public String getContent() {
        return content;
    }

    public void fileWrite()
    {
        try {
            System.out.println( "enter the content you want to write: ");
            Scanner sc =new Scanner( System.in);
            String newContent = sc.nextLine();
            content+=newContent;
            FileWriter fw = new FileWriter(txtName);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(content);
            System.out.println("modify succuss!");
            pw.close();
        }
        catch(Exception e ){
            System.out.println("writing in the file failed");
        }

    }
}


