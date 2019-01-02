package Encryption;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptFile {
    private byte[] ciphertext;
    private long time; 
    
    public EncryptFile(byte[] filear,Key key,String type) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, InvalidKeyException, BadPaddingException
    {
        
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        
        // encrypt using the key and the plaintext
        System.out.println("\nStart Encryption:");

        final long startTime = System.nanoTime();
        //  Initializes the Cipher Object
        cipher.init(Cipher.ENCRYPT_MODE, key);

        //Calculates The Ciphertext With a Plaintext String
        byte[] cipherText = cipher.doFinal(filear);
        String cipher_msg = "";
        ciphertext = cipherText;
        final long duration = System.nanoTime() - startTime;
        time = duration;
        System.out.println("Finish Encryption File: " + cipherText.toString());
//        System.out.println("It took " + duration + " nanosecond to encrypt the message \"" + message +"\" using AES");
//        System.out.println("Message length is " + message.length());
    }
    
    public byte[] getCipherText()
    {
        return ciphertext;
    }
    
    public long getTime()
    {
        return time;
    }
    
}