import java.io.*;

public class MainClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Staff s1 = new Staff("12345", "John Burke", "Dublin", 50000);
        Staff s2 = new Staff("123456", "Mary Smith", "Athlone", 75000);

        //Serialize

        try{
            FileOutputStream fileOut = new FileOutputStream("staff2.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(s1);
            objectOut.writeObject(s2);
            objectOut.close();
            System.out.println("File serialized");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Deserialize
        try {
            FileInputStream fileIn = new FileInputStream("staff2.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            Staff newStaff = (Staff) objectIn.readObject();
            Staff newStaff2 = (Staff) objectIn.readObject();
            objectIn.close();
            System.out.println(newStaff.getName() + " " + newStaff.getAddress() + " " + newStaff.getSalary());
            System.out.println(newStaff2.getName() + " " + newStaff2.getAddress() + " " + newStaff2.getSalary());
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}