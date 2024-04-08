package otros;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * Clase que proporciona métodos para encriptar y desencriptar números de teléfono.
 * @author Francisco López Ruiz
 */
public class Encriptacion {
    private static final String ALGORITMO = "AES";
    private static final String CLAVE_SECRETA = "k#sJD2&hG9@L$pT4"; // Clave secreta para AES

    /**
     * Método para encriptar un número de teléfono.
     * @param telefono El número de teléfono a encriptar.
     * @return El número de teléfono encriptado como una cadena de texto.
     * @throws Exception Si ocurre un error durante la encriptación.
     */
    public static String encriptarTelefono(String telefono) throws Exception {
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        SecretKey clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
        cifrador.init(Cipher.ENCRYPT_MODE, clave);
        byte[] textoCifrado = cifrador.doFinal(telefono.getBytes());
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    /**
     * Método para desencriptar un número de teléfono.
     * @param telefonoEncriptado El número de teléfono encriptado.
     * @return El número de teléfono desencriptado.
     * @throws Exception Si ocurre un error durante la desencriptación.
     */
    public static String desencriptarTelefono(String telefonoEncriptado) throws Exception {
        Cipher cifrador = Cipher.getInstance(ALGORITMO);
        SecretKey clave = new SecretKeySpec(CLAVE_SECRETA.getBytes(), ALGORITMO);
        cifrador.init(Cipher.DECRYPT_MODE, clave);
        byte[] textoCifrado = Base64.getDecoder().decode(telefonoEncriptado);
        byte[] textoPlano = cifrador.doFinal(textoCifrado);
        return new String(textoPlano);
    }

}
