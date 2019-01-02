package Encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class MessageEncryption {
    
    private String message;
    private String type;
    private long time;
    
    
    public MessageEncryption(String message, Key key,String type) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException {
        
        byte[] plainText = message.getBytes(StandardCharsets.UTF_8);
        Cipher cipher = Cipher.getInstance(type + "/ECB/PKCS5Padding");
        
        // encrypt using the key and the plaintext
        System.out.println("\nStart Encryption:");

        final long startTime = System.nanoTime();
        //  Initializes the Cipher Object
        cipher.init(Cipher.ENCRYPT_MODE, key);

        //Calculates The Ciphertext With a Plaintext String
        byte[] cipherText = cipher.doFinal(plainText);
        String cipher_msg = "";

        for (byte b:cipherText) {
            cipher_msg +=(char)b;
        }
        
        this.message = cipher_msg;
        final long duration = System.nanoTime() - startTime;
        
        time = duration;
        System.out.println("Finish encryption: ");
        System.out.println("It took " + duration + " nanosecond to encrypt the message \"" + message +"\" using AES");
        System.out.println("Message length is " + message.length());
    }

    public String getMessage() {
        return message;
    }
    
    public long getTime()
    {
        return time;
    }
}