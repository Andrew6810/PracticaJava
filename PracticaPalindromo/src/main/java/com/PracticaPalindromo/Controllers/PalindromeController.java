package com.PracticaPalindromo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para la validación de palabras palíndromas.
 */
@RestController
public class PalindromeController {

    /**
     * Clase que mapea los enpoints para verificar si una palabra es palindromo
     * @param word La palabra a verificar, enviada desde la solicitud HTTP.
     * @return mensaje indicando si la palabra es un palindromo o no
     */
    @GetMapping("/validar-palindromo/{word}")
    public String Palindrome (@PathVariable String word) {
        if (isPalindrome(word)){
            return "La palabra " + word + " es un palindromo";
        } else {
            return "La palabra " + word + " NO es un palindromo";
        }

    }

    /**
     * Metodo para verificar si una  palabra es un palíndromo
     * @param word La palabra a verificar, enviada desde la solicitud HTTP.
     * @return true si la palabra es un palindromo, false si NO lo es
     */
    private boolean isPalindrome (String word){
        int length = word.length();
        for (int i = 0; i < length / 2 ; i++) {
            if (word.charAt(i) != word.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
