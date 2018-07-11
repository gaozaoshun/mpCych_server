package com.mtty.igood.util;

import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.AlgorithmParameters;
import java.security.Security;
import java.util.Arrays;

/**
 * @Author: superknight
 * @Date: 2018/3/16 20:51
 * @Description: 微信小程序解密算法
 */
public class MpDecryptUtil {
    private static Logger log = LoggerFactory.getLogger(MpDecryptUtil.class);

    /**
     * @Author: superknight
     * @Date: 2018/3/16 20:55
     * @param encryptedData 包括敏感数据在内的完整用户信息的加密数据
     * @param sessionKey 微信返回的sessionkey
     * @param iv 加密算法的初始向量
     * @Description:
     *
     */
    public static String getWxUserInfo(String encryptedData, String sessionKey, String iv){
        if (StringUtils.isEmpty(encryptedData) || StringUtils.isEmpty(sessionKey) || StringUtils.isEmpty(iv)){
            return null;
        }
        try {
            //被加密的数据
            byte[] dataByte = Base64.decode(encryptedData);
            // 加密秘钥
            byte[] keyByte = Base64.decode(sessionKey);
            // 偏移量
            byte[] ivByte = Base64.decode(iv);

            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (keyByte.length % base != 0){
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp,(byte) 0);
                System.arraycopy(keyByte,0,temp,0,keyByte.length);
                keyByte = temp;
            }

            //初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));

            // 初始化
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                return result;
            }
        } catch (Exception e){
            log.error("error",e);
        }
        return null;
    }
}
