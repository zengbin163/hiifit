package com.hiifit.haipay.util.pki;

import org.junit.Assert;
import org.junit.Test;

public class PKIUtilsTest {
    
    private String cert = "/haipay.crt";
    private String store = "/haipay.keystore";
    private String plainText = "嗨健康，我爱你";
    
    @Test
    public void testEncryptAndDecrypt1() {
        // 公钥加密
        byte[] result = PKIUtils.encryptWithPublicKey(PKIUtilsTest.class.getResourceAsStream(cert),plainText.getBytes());
        
        // 私钥解密
        result = PKIUtils.decryptWithPrivateKey(PKIUtilsTest.class.getResourceAsStream(store),"111111", "111111", "haipay", result);

        Assert.assertEquals(plainText, new String(result));
    }
    
    @Test
    public void testEncryptAndDecrypt2() {
        // 私钥加密
        byte[] result = PKIUtils.encryptWithPrivateKey(PKIUtilsTest.class.getResourceAsStream(store), "111111", "111111", "haipay", plainText.getBytes());
        
        // 公钥解密
        result = PKIUtils.decryptWithPublicKey(PKIUtilsTest.class.getResourceAsStream(cert), result);
        
        Assert.assertEquals(plainText, new String(result));
    }
    
    @Test
    public void testSignatureAndVerifySignature() {
        // 私钥签名
        byte[] signature = PKIUtils.signature(PKIUtilsTest.class.getResourceAsStream(store), "111111", "111111", "haipay", plainText.getBytes());
        
        // 公钥验证签名
        boolean correct = PKIUtils.verifySignature(PKIUtilsTest.class.getResourceAsStream(cert), plainText.getBytes(), signature);
        
        Assert.assertTrue(correct);
    }
}
