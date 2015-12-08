package snake;




import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Utilities implements Serializable {
    private static final String fileName = "settings";
    private static Utilities instance = null;

    public static final boolean debug = false;

    private int current_speed;
    private int DifficultyMode;

    private int bonusExistTime = 30;
    private int bonusGrows = 3;
    private int bonusValue = 100;

    private String playerName;


    private int width = 20;
    private int height = 20;

    private int numberOfHighScores = 10;

    private int nCurrColor = 0;

    private Utilities() {
    }

    public static Utilities getInstance() {
        if (instance == null) { // first call
            instance = loadSettings();
            if (instance == null) { // could not load settings
                instance = new Utilities();
            }
        }
        return instance;
    }

    public int getColor() { return nCurrColor; }
    public void setColor(int c) { nCurrColor = c; }

    public int getSpeed() {
        if(DifficultyMode==0){
            current_speed = 1000;
        }else if(DifficultyMode == 1){
            current_speed = 500;
        }else {
            current_speed = 250;
        }
        return current_speed;

    }

    public void setDifficultyMode(int difficultyMode) {
        DifficultyMode = difficultyMode;
    }



    public String getPlayerName() {
        return playerName;
    }


    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }




    public int getWidth() {
        return width;
    }


    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }


    public void setHeight(int height) {
        this.height = height;
    }

    public int getNumberOfHighScores() {
        return numberOfHighScores;
    }


    public void setNumberOfHighScores(int numberOfHighScores) {
        this.numberOfHighScores = numberOfHighScores;
    }

    public static void saveSettings() {
        ObjectOutputStream oop = null;
        OutputStream os = null;
        try {
            os = new FileOutputStream(fileName);
            oop = new ObjectOutputStream(os);
            oop.writeObject(instance);
        } catch (IOException ex) {
            print("saveSettings: " + ex);
        } finally {
            if (oop != null) {
                try {
                    oop.close();
                } catch (IOException ex) {
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    private static Utilities loadSettings() {
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(fileName);
            ois = new ObjectInputStream(is);
            return (Utilities) ois.readObject();
        } catch (FileNotFoundException fnf) {
            print("loadSettings (file not found): " + fnf);
            saveSettings();
        } catch (Exception ioe) {
            print("loadSettings: " + ioe);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ex) {
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                }
            }
        }
        return null;
    }


    public static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {

        Utilities.print(Utilities.getInstance().getPlayerName());
        Utilities.getInstance().setPlayerName("bla");
        Utilities.print(Utilities.getInstance().getPlayerName());
        Utilities.getInstance().setPlayerName("other bla");
        Utilities.saveSettings();
        Utilities.print(Utilities.getInstance().getPlayerName());

    }
}


