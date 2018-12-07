package businessPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Saver {
    
    /* DECLARAÇÃO DE VARIÁVEIS */
    private Map<String, File> saveFiles = new HashMap<>();
    private String dirPath = System.getProperty("java.io.tmpdir") + "/BattleChessArena";
    
    
    public Saver() {
        File direc = new File(dirPath);
        if(!direc.exists()) new File(dirPath).mkdir();
        for(File f : direc.listFiles()) {
            saveFiles.put(f.getName(), f);
        }
    }
    
    public void writeOnFile(String saveKey, String key, String value) {
        File f = saveFiles.get(saveKey);
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(key + " " + value);
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void writeOnFile(String saveKey, String[] key, String[] value) {
        File f = saveFiles.get(saveKey);
        try {
            FileWriter fw = new FileWriter(f);
            for(int i = 0; i < key.length; i++) {
                fw.write(key[i] + " " + value[i]);
            }
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(Saver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readOnFile(String saveKey, String key) {
        File f = null;
        try {
            f = getFile(saveFiles.get(saveKey).toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
        if(!f.exists()) return null;
        String st;
        String[] stF;
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            while((st = br.readLine()) != null) {
                stF = st.split(" ");
                if(stF.equals(key)) {
                    return stF[1];
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não possível pegar a informação: " + saveKey);
        }
        return null;
    }
    
    public File makeFile(String file) {
        File tempFile = null;
        if(!dirExists()) {
            new File(System.getProperty("java.io.tmpdir") + "BattleChessArena").mkdir();
        } 
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
}
