package recursion;

public class StringRecursion {

    public String skipCharacter(String str, char c) {
        StringBuilder stringBuilder = new StringBuilder();

        skipCharacter(str, c, 0, stringBuilder);
        return stringBuilder.toString();
    }

    private void skipCharacter(String str, char c, int index, StringBuilder stringBuilder) {

        /* iterative approach
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                stringBuilder.append(str.charAt(i));
            }
        }
        */

        if(index == str.length())
            return;
        if (str.charAt(index) != c) {
            stringBuilder.append(str.charAt(index));
        }
        skipCharacter(str, c, index + 1, stringBuilder);

    }


    public static void main(String[] args) {

        String str = "appleballcat";
        StringRecursion stringRecursion = new StringRecursion();
        String result = stringRecursion.skipCharacter(str, 'a');
        System.out.println(result);

    }

}
