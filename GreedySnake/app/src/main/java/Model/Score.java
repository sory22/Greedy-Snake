package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import snake.Utilities;

public class Score implements Serializable {

    private static final long serialVersionUID = 4759476774332194829L;
    private static final String fileName = "highscore";
    private static Score instance = null;

    private final List<HighScoreEntry> entries;


    private static boolean couldLoadFile = false;

    private Score() {

        entries = new ArrayList<HighScoreEntry>();
    }

    public List<HighScoreEntry> getEntries() {
        return entries;
    }

    public static Score getInstance() {
        if (instance == null) { // first call
            instance = loadHighScore();
            if (instance == null) { // could not load highscore
                instance = new Score();
            }
        }
        return instance;
    }

    public void addAndSave(String name, int score) {
        entries.add(new HighScoreEntry(name, score));
        Collections.sort(entries, new EntryComparator());
        if (entries.size() >= Utilities.getInstance().getNumberOfHighScores()) {
            entries.removeAll(entries.subList(Utilities.getInstance()
                    .getNumberOfHighScores(), entries.size()));
        }
        saveHighScore();
    }

    public void clearAndSave() {
        entries.clear();
        saveHighScore();
    }

    private static void saveHighScore() {
        if (couldLoadFile) {
            ObjectOutputStream oop = null;
            OutputStream os = null;
            try {
                os = new FileOutputStream(fileName);
                oop = new ObjectOutputStream(os);
                oop.writeObject(instance);
            } catch (IOException ex) {
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
    }

    private static Score loadHighScore() {
        InputStream is = null;
        ObjectInputStream ois = null;
        try {
            is = new FileInputStream(fileName);
            ois = new ObjectInputStream(is);
            couldLoadFile = true;
            return (Score) ois.readObject();
        } catch (FileNotFoundException fnf) {
            couldLoadFile = true;
            saveHighScore();
        } catch (Exception ioe) {
            couldLoadFile = false;
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

    public class HighScoreEntry implements Serializable {
        private static final long serialVersionUID = 4759476774332194829L;

        private final String name;
        private final int score;

        /**
         * @param name
         * @param score
         */
        public HighScoreEntry(String name, int score) {
            super();
            this.name = name;
            this.score = score;
        }

        /**
         * @return the name
         */
        public String getName() {
            return name;
        }

        /**
         * @return the score
         */
        public int getScore() {
            return score;
        }
    }


    @Override
    public String toString() {
        List<HighScoreEntry> entries = Score.getInstance().getEntries();
        String values = "";
        for (int i = 0; i < entries.size(); i++) {
            values += entries.get(i).getName() + ": "
                    + entries.get(i).getScore() + "\n";
        }
        return values;
    }

    private class EntryComparator implements Comparator<HighScoreEntry> {

        @Override
        public int compare(HighScoreEntry t, HighScoreEntry t1) {
            return t1.getScore() - t.getScore();
        }
    }

    public static void main(String[] args) {
         Score.getInstance().clearAndSave();
        Score.getInstance().addAndSave("TEST", 1);
        Score.getInstance().addAndSave("TEST", 200);
        for (int i = 0; i < 12; i++) {
            Score.getInstance().addAndSave("TEST", i);
        }
        Utilities.print(Score.getInstance().toString());

    }
}

