import Decryption.MessageDecryption;
import Encryption.EncryptAesKeyWithRSAandDigSig;
import Encryption.EncryptDesKeyWithRSAandDS;
import Encryption.EncryptFile;
import Encryption.MessageEncryption;
import MessageType.AesKeyWithDigitalSignature;
import MessageType.DesKeyWithDigSig;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.security.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;

public class BobChatBox extends javax.swing.JFrame {

    private String msg;

    public BobChatBox() {
        initComponents();
    }
    
    static ServerSocket serversocket;
    static DataInputStream din;
    static DataOutputStream dout;
    static Socket socket;
    static ObjectOutputStream output;
    static ObjectInputStream input;
    static SecretKey AesKey;
    static SecretKey DesKey;
    static String msg_from_alice;
    public long time;
    String msg_for_alice = "";
    static String filepath;
    static File files;
    static byte[] file_con = null;
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        msg_area = new javax.swing.JTextArea();
        msg_txt = new javax.swing.JTextField();
        aes_encrypt_button = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        des_encrypt_button = new javax.swing.JButton();
        file_send_button = new javax.swing.JButton();
        des_encrypt_button1 = new javax.swing.JButton();
        decrypt_des = new javax.swing.JButton();
        decrypt_aes = new javax.swing.JButton();
        des_encrypt_button2 = new javax.swing.JButton();
        des_encrypt_button3 = new javax.swing.JButton();
        des_encrypt_button4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOB");

        msg_area.setColumns(20);
        msg_area.setRows(5);
        jScrollPane1.setViewportView(msg_area);

        msg_txt.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        aes_encrypt_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        aes_encrypt_button.setText("ENCRYPT(AES)");
        aes_encrypt_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aes_encrypt_buttonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("BOB");

        des_encrypt_button.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        des_encrypt_button.setText("ENCRYPT(DES)");
        des_encrypt_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_encrypt_buttonActionPerformed(evt);
            }
        });

        file_send_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        file_send_button.setText("SELECT FILE");
        file_send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                file_send_buttonActionPerformed(evt);
            }
        });

        des_encrypt_button1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        des_encrypt_button1.setText("SEND MESSAGE");
        des_encrypt_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_encrypt_button1ActionPerformed(evt);
            }
        });

        decrypt_des.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        decrypt_des.setText("DECRYPT(DES)");
        decrypt_des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrypt_desActionPerformed(evt);
            }
        });

        decrypt_aes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        decrypt_aes.setText("DECRYPT(AES)");
        decrypt_aes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                decrypt_aesActionPerformed(evt);
            }
        });

        des_encrypt_button2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        des_encrypt_button2.setText("SEND FILE");
        des_encrypt_button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_encrypt_button2ActionPerformed(evt);
            }
        });

        des_encrypt_button3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        des_encrypt_button3.setText("ENCRYPT(AES)FILE");
        des_encrypt_button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_encrypt_button3ActionPerformed(evt);
            }
        });

        des_encrypt_button4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        des_encrypt_button4.setText("ENCRYPT(DES)FILE");
        des_encrypt_button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                des_encrypt_button4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(des_encrypt_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(des_encrypt_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(aes_encrypt_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(file_send_button, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(decrypt_aes, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(des_encrypt_button, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(decrypt_des, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(des_encrypt_button3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(des_encrypt_button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(msg_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(des_encrypt_button1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(des_encrypt_button2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aes_encrypt_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decrypt_des, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(des_encrypt_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(des_encrypt_button4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(file_send_button, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decrypt_aes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(des_encrypt_button3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //encrypt with AES
    private void aes_encrypt_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aes_encrypt_buttonActionPerformed
        // TODO add your handling code here:
        
        msg_for_alice = msg_txt.getText().trim();
        msg_area.setText(msg_area.getText() + "\n \t \t You : " + msg_for_alice + "\n");
        try {
            MessageEncryption mssg = new MessageEncryption(msg_for_alice,AesKey,"AES");
            msg_for_alice = mssg.getMessage();
            time = mssg.getTime();
            msg_area.setText(msg_area.getText() + "\n \t \t EncryptedWithAES : " + msg_for_alice + "\n\nTime : " + time);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aes_encrypt_buttonActionPerformed

    private void des_encrypt_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_encrypt_buttonActionPerformed
        msg_for_alice = msg_txt.getText().trim();
        msg_area.setText(msg_area.getText() + "\n \t \t You : " + msg_for_alice + "\n");
        try {
            MessageEncryption mssg = new MessageEncryption(msg_for_alice,DesKey,"DES");
            msg_for_alice = mssg.getMessage();
            time = mssg.getTime();
            msg_area.setText(msg_area.getText() + "\n \t \t EncryptedWithDES : " + msg_for_alice + "\n\nTime : " + time);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_des_encrypt_buttonActionPerformed

    //Sending Encrypted Message
    private void des_encrypt_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_encrypt_button1ActionPerformed
        try {
            // TODO add your handling code here:
            dout.writeUTF(msg_for_alice);
        } catch (IOException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
            msg_txt.setText("");
    }//GEN-LAST:event_des_encrypt_button1ActionPerformed

    private void decrypt_desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrypt_desActionPerformed
        // TODO add your handling code here:
        MessageDecryption mssg = new MessageDecryption(msg_from_alice,DesKey,"DES");
        msg_from_alice = mssg.getMessage();
        long tim = mssg.getTime();
        msg_area.setText(msg_area.getText() + "\n\nDecrypted Message(DES) : " + msg_from_alice + "\nTime : " + tim + "\n");
    }//GEN-LAST:event_decrypt_desActionPerformed

    private void decrypt_aesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_decrypt_aesActionPerformed
        // TODO add your handling code here:
        MessageDecryption mssg = new MessageDecryption(msg_from_alice,AesKey,"AES");
        msg_from_alice = mssg.getMessage();
        long tim = mssg.getTime();
        msg_area.setText(msg_area.getText() + "\n\nDecrypted Message(AES) : " + msg_from_alice + "\nTime : " + tim + "\n");
    }//GEN-LAST:event_decrypt_aesActionPerformed

    private void file_send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_file_send_buttonActionPerformed
        JFileChooser file = new JFileChooser();
        int returnvalue = file.showOpenDialog(file);
        filepath = null;
        if(returnvalue == JFileChooser.APPROVE_OPTION){
            filepath = file.getSelectedFile().getAbsolutePath();
        }else{
            System.exit(1);
        }
        
        files = new File(filepath);
        file_con = new byte[(int)files.length()];
        try {
            BufferedReader br = new BufferedReader(new FileReader(files));
            msg_for_alice = "";
            String st = "";
            while((st = br.readLine()) != null){
                msg_for_alice += (st + "/");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_file_send_buttonActionPerformed

    private void des_encrypt_button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_encrypt_button2ActionPerformed

        try {
            dout.writeUTF("file/" + msg_for_alice);
        } catch (IOException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_des_encrypt_button2ActionPerformed
    
    private void des_encrypt_button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_encrypt_button3ActionPerformed
        try {
            MessageEncryption msgc = new MessageEncryption(msg_for_alice,AesKey,"AES");
            msg_for_alice = msgc.getMessage();
            System.out.println("File in " + msg_for_alice);
            long tim = msgc.getTime();
            msg_area.setText(msg_area.getText() + "\nTime : " + tim + "\n");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_des_encrypt_button3ActionPerformed

    private void des_encrypt_button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_des_encrypt_button4ActionPerformed
        // TODO add your handling code here:
        try {
            MessageEncryption msgc = new MessageEncryption(msg_for_alice,DesKey,"DES");
            msg_for_alice = msgc.getMessage();
            System.out.println("File in " + msg_for_alice);
            long tim = msgc.getTime();
            msg_area.setText(msg_area.getText() + "\nTime : " + tim + "\n");
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_des_encrypt_button4ActionPerformed
    
    public static void main(String args[]) throws IOException {

        try {
            /* Set the Nimbus look and feel */
            //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
            /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
            * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
            */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(BobChatBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(BobChatBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(BobChatBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(BobChatBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>
            
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new BobChatBox().setVisible(true);
                }
            });
            
            
            serversocket = new ServerSocket(6666);
            socket = serversocket.accept();
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            
            //generate public and private key (RSA)
            KeyPairGenerator keyGenRSA = KeyPairGenerator.getInstance("RSA");
            keyGenRSA.initialize(1024);
            KeyPair keyRSA = keyGenRSA.generateKeyPair();
            PrivateKey keyRSAPrivate = keyRSA.getPrivate();
            PublicKey keyRSAPublic = keyRSA.getPublic();
            //System.out.println("Finish generating RSA key");
            
            msg_area.setText(msg_area.getText() + "\n\nI know My Public Key : " + keyRSAPublic + "\n\nI know My Private Key : " + keyRSAPrivate + "\n\n");
            //sending publicKey(RSA) to Alice 
            output = new ObjectOutputStream(socket.getOutputStream());
            output.writeObject(keyRSAPublic);
            
            PublicKey publicKeyOfAlice = null;
            
            //receive publicKey of Alice(RSA) 
            input = new ObjectInputStream(socket.getInputStream());
            try {
                publicKeyOfAlice = (PublicKey)input.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            msg_area.setText(msg_area.getText() + "\n\nI Know Public Key Of Alice : " + publicKeyOfAlice + "\n\n");
            
            //Generate AES Key
            KeyGenerator keyGenAES = KeyGenerator.getInstance("AES");
            keyGenAES.init(128);    //In AES cipher block size is 128 bits
            AesKey = keyGenAES.generateKey();
            
            msg_area.setText(msg_area.getText().trim() + "\nAES Key : " + AesKey + "\n\n\n");
            
            EncryptAesKeyWithRSAandDigSig encryptedAesKeyWithRSAandDS;
            AesKeyWithDigitalSignature encryptedAESKeyObject = null;
            
            long tim = 0;
            //Encrypt AES Key using RSA
            try {
                //encrypt AES Key with RSA and Digital Signature
                encryptedAesKeyWithRSAandDS = new EncryptAesKeyWithRSAandDigSig(AesKey.getEncoded(), publicKeyOfAlice,keyRSAPrivate);
                tim = encryptedAesKeyWithRSAandDS.getTime();
                encryptedAESKeyObject = new AesKeyWithDigitalSignature(encryptedAesKeyWithRSAandDS.getCipherKeyAES(),encryptedAesKeyWithRSAandDS.getSignature());
                //this.bind("cn=AesKeyWithDigitalSignature",encryptedAESKeyObject);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SignatureException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            }

            msg_area.setText(msg_area.getText().trim() + "\nAES After Encryp. " + encryptedAESKeyObject + "\n\nTime in Encryption(AES) with RSA" + tim);
            
            //Sending AES EncryptedCipherText and Respective DigitalSignature
            out.write(encryptedAESKeyObject.getCipherKeyAES());
            out.write(encryptedAESKeyObject.getSignature());
            
            //output.writeObject(encryptedAESKeyObject);
            System.out.println("error here");
            
            String  msg_from_Alice = "";
            
            //Generate DES Key
            KeyGenerator keyGenDES = KeyGenerator.getInstance("DES");
            keyGenDES.init(56);    //In DES cipher block size is 56 bits
            DesKey = keyGenDES.generateKey();
            
            msg_area.setText(msg_area.getText().trim() + "\nDES Key : " + DesKey + "\n\n\n");
            
            EncryptDesKeyWithRSAandDS encryptedDesKeyWithRSAandDS = null;
            DesKeyWithDigSig encryptedDESKeyObject = null;
            
            //Encrypt DES Key using RSA
            try {
                //encrypt AES Key with RSA and Digital Signature
                encryptedDesKeyWithRSAandDS = new EncryptDesKeyWithRSAandDS(DesKey.getEncoded(), publicKeyOfAlice,keyRSAPrivate);
                System.out.println("time taken : " + encryptedDesKeyWithRSAandDS.getTime());
                encryptedDESKeyObject = new DesKeyWithDigSig(encryptedDesKeyWithRSAandDS.getCipherKeyDES(),encryptedDesKeyWithRSAandDS.getSignature());
                //this.bind("cn=AesKeyWithDigitalSignature",encryptedAESKeyObject);
            } catch (NoSuchPaddingException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadPaddingException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalBlockSizeException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidKeyException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SignatureException ex) {
                Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
            }
            tim = encryptedDesKeyWithRSAandDS.getTime();
            msg_area.setText(msg_area.getText().trim() + "\nDES After Encryp. " + encryptedDESKeyObject.getCipherKeyDES() + "  " + encryptedDESKeyObject.getSignature() + "\n\nTime in Encryption(DES) with RSA " + tim);
            
            //Sending EncryptedCipherText and Digital Signature
            output.writeObject(encryptedDESKeyObject);
            msg_from_alice = "";
            while(!msg_from_alice.equals("exit"))
            {
                msg_from_alice = din.readUTF();
                msg_area.setText(msg_area.getText().trim() + "\nAlice's Cipher Text : " + msg_from_alice + "\n");
            }
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(BobChatBox.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aes_encrypt_button;
    private javax.swing.JButton decrypt_aes;
    private javax.swing.JButton decrypt_des;
    private javax.swing.JButton des_encrypt_button;
    private javax.swing.JButton des_encrypt_button1;
    private javax.swing.JButton des_encrypt_button2;
    private javax.swing.JButton des_encrypt_button3;
    private javax.swing.JButton des_encrypt_button4;
    private javax.swing.JButton file_send_button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea msg_area;
    private javax.swing.JTextField msg_txt;
    // End of variables declaration//GEN-END:variables
}