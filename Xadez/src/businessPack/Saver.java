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

public class Saver {
    
    /* DECLARAÇÃO DE VARIÁVEIS */
    private Map<String, File> saveFiles = new HashMap<>();
    private String dirPath = System.getProperty("java.io.tmpdir") + "/BattleChessArena";
    
    /**
     * Makes a temp directory of the game if it doesn't exists
     * Load all files inside if exists
     */
    public Saver() {
        File direc = new File(dirPath);
        if(!direc.exists()) new File(dirPath).mkdir();
        for(File f : direc.listFiles()) {
            saveFiles.put(f.getName(), f);
        }
    }
    
    /**
     * 
     * @param saveKey This key is the file name to find
     * @param key This is the key to write inside the saveKey file
     * @param value This is the value to write
     */
    public void writeOnFile(String saveKey, String key, String value) {
        direcManager();
        File f = saveFiles.get(saveKey);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(key + " " + value);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param saveKey This key is the file name to find
     * @param lista a HashMap with the Key - Value to put int the file saveKey
     */
    public void writeOnFile(String saveKey, HashMap<String, String> lista) {
        direcManager();
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
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readOnFile(String saveKey, String key) {
        direcManager();
        File f = null;
        try {
            f = getFile(saveFiles.get(saveKey).toString());
            if(!f.exists()) return null;
            String st;
            String[] stF;
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((st = br.readLine()) != null) {
                stF = st.split(" ");
                if(stF.equals(key)) {
                    return stF[1];
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
        }
        
        return null;
    }
    
    public File makeFile(String file) {
        File tempFile = null;
        direcManager();
        tempFile = new File(dirPath, file);
        saveFiles.put(tempFile.getName(), tempFile);
        return tempFile;
    }
    
    public File getFile(String saveKey) {
        return saveFiles.get(saveKey);
    }
    
    private boolean dirExists() {
        File f = new File(dirPath);
        return f.exists();
    }
    
    private void direcManager() {
        if(!dirExists()) 
        {
            new File(System.getProperty("java.io.tmpdir") + "BattleChessArena").mkdir();
        }
    }
    
}
