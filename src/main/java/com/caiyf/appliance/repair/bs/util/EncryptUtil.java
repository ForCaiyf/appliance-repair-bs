package com.caiyf.appliance.repair.bs.util;

import com.caiyf.appliance.repair.bs.exception.BusinessException;
import com.caiyf.appliance.repair.bs.model.result.CodeEnum;

import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.SecureRandom;

/**
 * @desc 加密工具（DES实现）
 * @date 2019/04/12
 * @author caiyf
 */
@Slf4j
public class EncryptUtil {

    private static final String ALGORITHM = "DES";
    private static final byte[] KEY = {'c', 'a', 'i', 'y', 'f', 5, 2, 0};

    /**
     * 生成密钥
     * @return
     * @throws Exception
     */
    private static SecretKey generateKey() throws Exception {
        DESKeySpec desKeySpec = new DESKeySpec(KEY);
        SecretKeyFactory factory = SecretKeyFactory.getInstance(ALGORITHM);
        return factory.generateSecret(desKeySpec);
    }

    /**
     * 数据加密
     * @param value
     * @return
     */
    public static String encrypt(String value) {
        String encryptValue;
        try {
            SecretKey key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key, new SecureRandom());
            encryptValue = new BASE64Encoder().encodeBuffer(cipher.doFinal(value.getBytes()));
        } catch (Exception e) {
            log.error("[encrypt error]", e);
            throw new BusinessException(CodeEnum.ENCRYPT_ERROR, e);
        }
        return encryptValue;
    }

    /**
     * 数据解密
     * @param value
     * @return
     */
    public static String decrypt(String value) {
        String decryptValue;
        try {
            SecretKey key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key, new SecureRandom());
            decryptValue = new String(cipher.doFinal(new BASE64Decoder().decodeBuffer(value)));
        } catch (Exception e) {
            log.error("[decrypt error]", e);
            throw new BusinessException(CodeEnum.DECRYPT_ERROR, e);
        }
        return decryptValue;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("cyf1996"));
    }
}
