package Encryption;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptDesKeyWithRSAandDS {
    
    private byte[] cipherKeyDES;
    private byte[] signature;
    private long time;
    
    public EncryptDesKeyWithRSAandDS(byte[] plainText, PublicKey publicKey, PrivateKey privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, SignatureException {
        // get an RSA cipher object
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");

        // encrypt the plaintext using the public key
        final long startTime = System.nanoTime();
        System.out.println( "\nStart encryption" );
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = cipher.doFinal(plainText);
        System.out.println( "Finish encryption: " );
        System.out.println( new String(cipherText, StandardCharsets.UTF_8) );

        Signature sig = Signature.getInstance("MD5WithRSA");     //Creates the Signature object.
        sig.initSign(privateKey);                                //Initializes the Signature object.
        sig.update(cipherText);                                  //Calculates the signature with a plaintext string.
        byte[] signature = sig.sign();
        System.out.println( "\nSignature:"  + signature );
        System.out.println( new String(signature, StandardCharsets.UTF_8) );
        this.signature = signature;
        this.cipherKeyDES = cipherText;
        final long duration = System.nanoTime() - startTime;
        this.time = duration;
        System.out.println("Finish encryption: ");
    }

    public long getTime()
    {
        return this.time;
    }
    
    public byte[] getCipherKeyDES() {
        return this.cipherKeyDES;
    }

    public byte[] getSignature() {
        return this.signature;
    } 
}
