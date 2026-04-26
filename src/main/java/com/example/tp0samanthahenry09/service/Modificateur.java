package com.example.tp0samanthahenry09.service;

import jakarta.enterprise.context.Dependent;

import java.io.Serializable;

/**
 * Classe de service pour les modificateurs de question.
 * Un modificateur de question prend en entrée une question et retourne
 * la question modifiée.
 */
@Dependent
public class Modificateur implements Serializable {
    /**
     * Modificateur de question.
     * @param question La question à modifier.
     * @param roleSysteme Le rôle système à utiliser pour la modification de la question.
     * @return Une réponse avec le nombre de mots contenant w, x, y ou z.
     */
    public String modifier(String question, String roleSysteme) {
        String q = question == null ? "" : question.trim();
        int nombreDeMotsAvecWxyz = 0;

        if (!q.isBlank()) {
            String[] mots = q.split("\\s+");
            for (String mot : mots) {
                String motNettoye = mot.replaceAll("^[^\\p{L}\\p{N}]+|[^\\p{L}\\p{N}]+$", "");
                if (motNettoye.isBlank()) {
                    continue;
                }
                String min = motNettoye.toLowerCase();
                if (min.contains("w") || min.contains("x") || min.contains("y") || min.contains("z")) {
                    nombreDeMotsAvecWxyz++;
                }
            }
        }

        if (nombreDeMotsAvecWxyz < 2) {
            return "On dit que les lettres wxyz sont rares dans notre langue, il semble que ce soit vrai : "
                    + nombreDeMotsAvecWxyz
                    + " trouve.";
        }

        return "On dit que les lettres wxyz sont rares dans notre langue, mais tu viens d'enchaîner "
                + nombreDeMotsAvecWxyz
                + " mot(s) les contenant. Super le petit génie!";
    }
}
