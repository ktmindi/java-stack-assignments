package javaFundamentals.hashMatique;




import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Forever", "You will forever live in my dreams for eternity");
        trackList.put("Say Goodbye", "Never let your love go to sleep without hearing you say I love you");
        trackList.put("Rainbows ", "If I could describe my feelings for you they would spell out the rainbows in my heart");
        trackList.put("Fun","Get up! Get out! Spin around and never look back.");

        String name = trackList.get("Fun");
        System.out.println("The lyrics to our song Fun start with " + name);


        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key + " : " + trackList.get(key));
        }
    }
}

//solution for the code from CD
//import java.util.HashMap;

//public class Hashmatique {
//    public static void Challange() {
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("Mr. Moom", "Its a real cold moon...");
//        map.put("Dog Day", "Dog day baybee");
//        map.put("For whom the bell", "Look to the sky rhy befor u die");
//        map.put("LALAL", "Who boy hahah LALA");

//        String val = map.get("Dog Day");

//        for (String key : map.keySet()) {
//            System.out.println(String.format("Track: %s: Lyrics: %s", key, map.get(key)));
//        }


//    }
//}