

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Created by Raspik on 25.02.2016.
 */
public class Exercise implements Serializable{
    static int id = 1;
    int myId;
    String name;
    String description;
int mark;
    public Exercise(String name, String description) {
        this.name = name;
        this.description = description;
        myId=id;
        ++id;

    }
    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeInt(id);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException {
        id=ois.readInt();
    }

    @Override
    public String toString() {
        return    name+" " +mark ;
    }
}
