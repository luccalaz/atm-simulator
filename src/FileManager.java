import java.io.*;

public class FileManager {
    private static FileManager instance;

    private FileManager() {};

    // ------------------------------------------------------------- public methods
    public void save(String filename, Object object) {
        try {
			File file = new File(filename);
			FileOutputStream fileStream = new FileOutputStream(file);
			ObjectOutputStream dataStream = new ObjectOutputStream(fileStream);

			dataStream.writeObject(object);

			dataStream.close();
		} catch (Exception e) {
			System.out.println("Binary file output error: " + e.getMessage());
			e.printStackTrace();
		}
    }
    
    public Object load(String filename) {
        try {
            //setup the streams
            File file = new File(filename);
            if (file.exists()){
                FileInputStream fileStream = new FileInputStream(file);
                ObjectInputStream dataStream = new ObjectInputStream(fileStream);
                Object object = dataStream.readObject();
                //output done, so close the stream
                dataStream.close();
                return object;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println("Binary file input error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // -------------------------------------------------------------- class methods
    public static FileManager getInstance() {
        if (instance == null) {
            instance = new FileManager();
        }
        return instance;
    }
}