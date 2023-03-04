package twopointer;

import java.util.HashMap;

public class PermutationOfString {

    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()) return false;

        int length = s1.length();
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();

        for(int i=0;i<s1.length();i++){

            char curr = s1.charAt(i);
            if(map.get(curr)!=null){
                map.put(curr, map.get(curr)+1);
            }
            else{
                map.put(curr,1);
            }

            curr = s2.charAt(i);
            if(map2.get(curr)!=null){
                map2.put(curr, map2.get(curr)+1);
            }
            else{
                map2.put(curr,1);
            }
        }

        //System.out.println(map);
        //System.out.println(map2);

        if(map.equals(map2)) return true;

        int right = s1.length();
        int left = 0;

        while(right<s2.length()){

            char add = s2.charAt(right);
            if(map2.get(add)==null){
                map2.put(add,1);
            }
            else{
                map2.put(add, map2.get(add)+1);
            }

            char remove = s2.charAt(left);
            if(map2.get(remove)==1){
                map2.remove(remove);
            }
            else{
                map2.put(remove, map2.get(remove)-1);
            }

            //System.out.println(map2);

            if(map.equals(map2)){
                return true;
            }

            right+=1;
            left+=1;

        }

        return false;

    }

}
