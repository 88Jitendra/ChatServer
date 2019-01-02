package MessageType;

import java.io.Serializable;

public class AesKeyWithDigitalSignature implements Serializable {
    
    //private static final long serialVersionUID = 6529685098267757690L;
    private byte[] cipherKeyAES;
    private byte[] dig_signature;

    public AesKeyWithDigitalSignature(byte[] cipherKeyAES, byte[] signature) {
        this.cipherKeyAES = cipherKeyAES;
        this.dig_signature = signature;
    }

    public byte[] getCipherKeyAES() {
        return cipherKeyAES;
    }

    public byte[] getSignature() {
        return dig_signature;
    }
}
