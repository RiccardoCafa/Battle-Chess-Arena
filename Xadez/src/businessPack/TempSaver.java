package businessPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * TempSaver description - makes temporary files wich will manage player preferences, like volume.
 * @author ricca
 */
public class TempSaver {
    
    /* DECLARAÇÃO DE VARIÁVEIS */
    public static Map<String, File> saveFiles = new HashMap<String, File>();
    private String dirPath = System.getProperty("java.io.tmpdir") + "BattleChessArena";
    
    /**
     * TempSaver constructor makes the temporary directory if doesn't exist, and load all files if exist
     */
    public TempSaver() {
        File direc = new File(dirPath);
        direcManager();
        for(File f : direc.listFiles()) {
            saveFiles.put(f.getName(), f);
        }
        System.out.println(dirPath);
    }
    
    /**
     * writeOnFile description - writes a pair of key/file in a hashMap, then writes on this file the value to write
     * @param saveKey This key is the file name to find
     * @param key This is the key to write inside the saveKey file
     * @param value This is the value to write
     */
    public void writeOnFile(String saveKey, String key, String value) {
        direcManager();
        File f;
        if(saveFiles.containsKey(saveKey)){
            f = saveFiles.get(saveKey);
        } else {
            f = makeFile(saveKey + ".txt");
        }
        if(f==null)return;
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(key + " " + value);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(TempSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param saveKey This key is the file name to find
     * @param lista a HashMap with the Key - Value to put int the file saveKey
     * @deprecated 
     */
    public void writeOnFile(String saveKey, HashMap<String, String> lista) {
        direcManager();
        System.out.println("WriteOnFile(String saveKey, HashMap<String, String> lista) - Useless for now.");
        File f = saveFiles.get(saveKey);
        try {
            Iterator it = lista.entrySet().iterator();
            FileWriter fw = new FileWriter(f);
            
            while(it.hasNext()) {
                Map.Entry pair;
                pair = (Map.Entry<String, String>)it.next();
                fw.write(pair.getKey() + " " + pair.getValue());
                it.remove();
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(TempSaver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * readOnFile description - read the file pair of saveKey on the hashMap, look for key pair and return it as string.
     * @param saveKey The file name (without extension, all are .txt)
     * @param key The key to look for
     * @return the value of the pair
     */
    public String readOnFile(String saveKey, String key) {
        direcManager();
        File f;
        try {
            f = saveFiles.get(saveKey + ".txt");
            if(f==null || !f.exists()) {
                return null;
            }
            String st;
            String[] stF;
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((st = br.readLine()) != null) {
                stF = st.split(" ");
                System.out.println(stF[0]);
                if(stF[0].equals(key)) {
                    System.out.println(stF[0]);
                    return stF[1];
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        
        return null;
    }
    
    /**
     * makeFile makes a file with the name specified on the parameter and put it on the hashmap
     * @param file the file name that will be created
     * @return the new file
     */
    public File makeFile(String file) {
        File tempFile = null;
        direcManager();
        tempFile = new File(dirPath, file);
        saveFiles.put(tempFile.getName(), tempFile);
        return tempFile;
    }
    
    /**
     * getFile description - look for the file in the saveKey pair hashmap
     * @param saveKey the key to loop for in the hashmap
     * @return the pair file of this key
     */
    public File getFile(String saveKey) {
        return saveFiles.get(saveKey);
    }
    
    /**
     * dirExists description - check if the temporary directory exists
     * @return if temporary directory exists
     */
    private boolean dirExists() {
        File f = new File(dirPath);
        return f.exists();
    }
    
    /**
     * direcManager description - check if the temporary directory exists, if not then creates one
     */
    private void direcManager() {
        if(!dirExists()) 
        {
            new File(System.getProperty("java.io.tmpdir") + "BattleChessArena").mkdir();
        }
    }
    
}
