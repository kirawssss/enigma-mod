# Enigma — client Minecraft 1.8.9 (mod Legacy Fabric)

Ton client Enigma, reparti de zéro et **propre** : c'est un mod Minecraft 1.8.9
basé sur [Legacy Fabric](https://legacyfabric.net). Il ne contient **aucun fichier
de Minecraft** — uniquement ton code. Minecraft est téléchargé séparément depuis
les serveurs de Mojang (par le launcher, ou par Gradle en développement). Tu es
donc 100 % dans ton droit pour le distribuer.

Base : le modèle officiel `Legacy-Fabric/fabric-example-mod`, rebrandé en Enigma.

## Prérequis

- **JDK 17** (pour faire tourner Gradle) — par ex. [Temurin 17](https://adoptium.net).
  Le mod, lui, cible Java 8 (comme Minecraft 1.8.9), c'est géré automatiquement.
- Rien d'autre : le wrapper Gradle télécharge le bon Gradle tout seul.

## Compiler

Dans PowerShell, à la racine du projet :

```powershell
.\gradlew build
```

La première fois, Gradle télécharge Minecraft 1.8.9, les mappings et Fabric
(quelques minutes). Résultat : **`build\libs\Enigma-0.1.0.jar`** — c'est ton client.
(Le launcher s'attend à `Enigma.jar` : le script de distribution le renommera, ou
renomme-le à la main.)

## Tester tout de suite (sans launcher)

```powershell
.\gradlew runClient
```

Ça lance un Minecraft 1.8.9 avec Enigma chargé. Dans la console tu verras :
`[Enigma] client v0.1.0 chargé sur Minecraft 1.8.9`, et à l'écran titre
`[Enigma] écran titre ouvert`. C'est la preuve que le mod se charge.

## Structure

```
build.gradle, settings.gradle, gradle.properties   configuration (Legacy Fabric Loom)
gradlew, gradlew.bat, gradle/                       wrapper Gradle (rien à installer)
src/main/java/fr/bluewxll/enigma/client/
  EnigmaClient.java          point d'entrée : c'est ici qu'on branchera les features
  mixin/EnigmaTitleScreenMixin.java   exemple de mixin fonctionnel (modif d'interface)
src/main/resources/
  fabric.mod.json            déclaration du mod (id "enigma", entrée client)
  enigma.mixins.json         liste des mixins
  assets/enigma/icon.png     icône
```

## Features à venir

Le squelette est prêt à recevoir des features **légitimes** de client PvP :
HUD (FPS, coordonnées, ping), affichage des touches (keystrokes), compteur de CPS,
cosmétiques, raccourcis. On les ajoute une par une.

Comme je ne peux pas compiler depuis mon côté, la méthode fiable : tu lances
`.\gradlew build`, et si une feature utilisant une classe de Minecraft ne compile
pas (les noms internes de la 1.8.9 sont parfois surprenants), tu me colles l'erreur
et je corrige. `.\gradlew genSources` génère le code source de Minecraft, ce qui me
permet de te donner les bons noms.

## Ce qui reste (côté launcher)

Le launcher que j'ai déjà fait doit être adapté pour :
1. télécharger Minecraft 1.8.9 **officiel depuis Mojang** (au lieu de l'embarquer) ;
2. injecter **Fabric Loader** ;
3. charger **ton Enigma.jar** par-dessus.

C'est l'étape suivante. Le CDN (dépôt jsDelivr) n'hébergera alors que ton
`Enigma.jar` — jamais Minecraft.
