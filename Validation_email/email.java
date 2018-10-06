
// Java program to check if an email address 
// is valid using Regex. 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class email
{
    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

    /* driver function to check */
    public static void main(String[] args)
    {
        String email = "shahi.sandeep3@gmail.com";
        if (isValid(email))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
} 