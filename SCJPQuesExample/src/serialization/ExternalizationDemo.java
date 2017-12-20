package serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class ExternalizationDemo {

	public ExternalizationDemo() {
		// TODO Auto-generated constructor stub
	}

	
	private String filePath = "user.ser";
	 
    public void serialize() throws IOException {
        UserExtern user = new UserExtern();
 
        user.setCode(123);
        user.setName("Tom");
        user.setBirthday(new Date());
        user.setPassword("secret123");
        user.setSocialSecurityNumber(1234567890);
 
 
        // serialize object's state
        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream outputStream = new ObjectOutputStream(fos);
        outputStream.writeObject(user);
        outputStream.close();
 
 
        System.out.println("User's details before serialization:\n" + user);
        System.out.println("Serialization done");
    }
    
    
    public void deserialize() throws ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream inputStream = new ObjectInputStream(fis);
        UserExtern user = (UserExtern) inputStream.readObject();
        inputStream.close();
 
        System.out.println("User's details afeter de-serialization:\n" + user);
    }
 
    public static void main(String[] args)
            throws ClassNotFoundException, IOException {
        ExternalizationDemo demo = new ExternalizationDemo();
 
        demo.serialize();
 
        System.out.println("\n=============\n");
 
        demo.deserialize();
 
    }
}
