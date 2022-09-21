package javaFundamentals.alfredBot;

import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name, String timeOfDay) {
        return String.format("Happy %s, %s! I am so happy you are here.", timeOfDay, name);
    }
    
    public String dateAnnouncement() {
        return String.format("It is currently %s.", new Date());
    }
    
    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis") > -1) {
            return "That airhead never does anything right.";
        }
        if(conversation.indexOf("Alfred") > -1) {
            return "Your wish is my command";
        }
        return "Right. And with that I shall retire.";
    
    }

    public String playMusic(String music) {
        return String.format("Playing %s now.", music);
    }

}

