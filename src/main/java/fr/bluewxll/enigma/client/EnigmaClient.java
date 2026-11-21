package fr.bluewxll.enigma.client;

import net.fabricmc.api.ClientModInitializer;

/**
 * Point d'entrée du client Enigma.
 *
 * Ce mod se greffe sur un Minecraft 1.8.9 officiel (téléchargé par le launcher
 * depuis Mojang). Il ne contient aucun fichier de Minecraft : uniquement le code
 * d'Enigma.
 *
 * Les features (HUD FPS, affichage des touches, etc.) viendront s'enregistrer ici
 * et dans le package `mixin`.
 */
public class EnigmaClient implements ClientModInitializer {

    public static final String NAME = "Enigma";
    public static final String VERSION = "0.1.0";

    @Override
    public void onInitializeClient() {
        System.out.println("[" + NAME + "] client v" + VERSION + " chargé sur Minecraft 1.8.9");
        // TODO features : enregistrer ici les modules (HUD, keybinds, cosmétiques…).
    }
}
