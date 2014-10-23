import java.io.*;

public class TestRandomAccessFile {
  public static void main(String[] args) throws IOException {
    // Create a random access file
    RandomAccessFile inout = new RandomAccessFile("inout.dat", "rw");

    // Clear the file to destroy the old contents if exists
    inout.setLength(0);

    // Write new integers to the file
    for (int i = 0; i < 10; i++)
      inout.writeInt(i);

    //get initial size
    System.out.println("Initial size: "+inout.length());

    // Retrieve a byte
    inout.seek(7); // Move the file pointer to the beginning
    System.out.println("Offset 3: " + inout.readInt());

    // change number 
    inout.seek(5 * 4); // Move the file pointer to the tenth number
    inout.writeInt(666);

    // Display the new length
    System.out.println("The new length is " + inout.length());

    inout.close();
  }
}