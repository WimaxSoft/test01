import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;




public class CodingExercise {

    public static void main(String[] args) throws Exception {

        System.out.println();           
        System.out.println(ReverseSentence("Good afternoon"));
        System.out.println();
        System.out.println(ReverseSentence("Hello, how are you?"));
        System.out.println();
        System.out.println(ReverseSentence("Are you twenty-one years old?"));
        System.out.println();


        /*  Output
            afternoon Good
            ?you are how, Hello
            ?old years twenty-one you Are         
        */
    }

    public static String  ReverseSentence(String Text) throws Exception {

        List<String> NewSentence = new ArrayList<String>();
        String Word =""; 
        //Cant find one liner Regex
        for(int i=0;i<Text.length();i++){

            char L = Text.charAt(i);

            if (Character.isLetterOrDigit(L) || L=='-') {   //Word with hyphens must be respected
                Word += Character.toString(L);
            }
            else if ((Pattern.matches("(?![-])\\p{Punct}", Character.toString(L))) )
//            else if ((Pattern.matches("!\"#$%&'()*+,./:;<=>?@[\\]^_`{|}~", Character.toString(L))) )
            
            {
                NewSentence.add(Word);
                Word="";
                    NewSentence.add(Character.toString(L));}
            else if (Character.isWhitespace(L) && !Word.isEmpty()){
                NewSentence.add(Word);
                Word="";
            }
        }

        //Last Word
        if (!Word.isEmpty()){
            NewSentence.add(Word);
        }

//            System.out.println(String.join(" ",NewSentence));
            Collections.reverse(NewSentence);
            Word = String.join(" ",NewSentence);
            Word = Word.replace("? ","?");  //As per requirement
            Word = Word.replace(" ,",",");  //As per requirement
//            System.out.println(String.join(" ",NewSentence));
            return Word;
        }
}


