package businessPack;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MultiLanguage description - makes the management of the language, there is a hash map that contains a pair of string and another hashmap of strings
 * The languagem type is stored by a diferent variable.
 * @author ricca
 */
public class MultiLanguage {
    
    public static String lang = "pt";
    public static HashMap<String, String> textos = new HashMap<String, String>();
    
    /**
     * AddText description - Add a text in the language specified with a special code,
     * for example, example-en to get it from later.
     * @param text the text to be showed
     * @param code the code to find this text later
     */
    public static void addText(String code, String text) 
    {
        textos.put(code, text);
    }
    
    /**
     * GetText description - Finds the text with this code and return it,
     * You have to remove the '-' part, example: if you added example-en, 
     * then you use only example to search
     * @param code the code to find the specific text 
     * @return the text translated to the current language
     */
    public static String getText(String code) {
        return textos.get(code + "-" + lang);
    }
    
    /**
     * UpdateLang description - Updates the language looking for Options files.
     */
    public static void updateLang() {
        TempSaver saver = new TempSaver();
        String lg = saver.readOnFile("Options", "lang");
        if(lg != null) {
            lang = lg;
        }
    }
    
    public static void setLang(String lang) {
        if(lang == "pt" || lang == "en") {
            MultiLanguage.lang = lang;
        }
    }
}
