

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Raspik on 18.02.2016.
 */
public class Teacher implements Serializable {
    String firstName;
    String lastName;
    static int id = 1;
    int myId;

    public Teacher(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        myId = id;
        id++;
        System.out.println("id "+myId+" "+firstName+" "+lastName+" was added to base");
    }
    public static void serializeStatic(ObjectOutputStream oos) throws IOException {
        oos.writeInt(id);
    }
    public static void deserializeStatic(ObjectInputStream ois) throws IOException {
        id=ois.readInt();
    }

    @Override
    public String toString() {
        return "ID "+myId+" "+" "
                +firstName+ " "+lastName;
    }
}
