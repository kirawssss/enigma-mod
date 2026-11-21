package fr.bluewxll.enigma.client.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Exemple de mixin fonctionnel (repris du modèle officiel Legacy Fabric) :
 * il s'injecte à l'ouverture de l'écran titre. Sert de point de départ
 * vérifié pour les futures modifications d'interface d'Enigma.
 */
@Mixin(TitleScreen.class)
public class EnigmaTitleScreenMixin {

    @Inject(at = @At("HEAD"), method = "init()V")
    private void onInit(CallbackInfo info) {
        System.out.println("[Enigma] écran titre ouvert");
    }
}
