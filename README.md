
â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”		RELEASE_DAY_1 et RELEASE_DAY_2   	â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”

# AvancÃ©es de notre projet :
dÃ©but d'interface graphiques (2 fenÃªtres fonctionnelles, authentification + crÃ©ation devoir) mais problÃ¨me de conditions sur la connexion plus problÃ¨me de crÃ©ation sur le devoir (ne rÃ©cupÃ¨re pas ce qu'on Ã©crit dans la fenÃªtre)
crÃ©ation d'une base de donnÃ©es et de ce classes permettant de rÃ©cupÃ©rer un fichier csv afin de mettre a jour la base de donnÃ©es existante mais aucun lien vers Github pour l'instant => reste Ã  faire la synchronisation base de donnÃ©es -> Github via un fichier csv. + importation base de donnÃ©es dans Github.

# Notre projet :
AprÃ¨s compilation, une premiÃ¨re fenÃªtre s'ouvre pour effectuer l'authentification, un premier problÃ¨me apparait : quel que soit les caractÃ¨res qu'on entre en token, l'authentification marche. Ensuite, une fenÃªtre de crÃ©ation de devoir s'ouvre ou l'on peut renseigner les champs principaux de renseignements (description, nom, dates de fin et de dÃ©but, etc...) et c'est ici que nous avons un deuxiÃ¨me problÃ¨me : on ne rÃ©cupÃ¨re pas ce qui est Ã©crit dans ces champs. Enfin, la base de donnÃ©es crÃ©Ã©e et les fonctions associÃ©es ainsi que l'incorporation d'un fichier csv n'est pour l'instant pas reliÃ©e avec le reste des donnÃ©es utilisÃ©es et Ã  utiliser.


â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”		RELEASE_DAY_3 et RELEASE_DAY_4		â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”

#### 	 AvancÃ©es de notre projet	####
$$$$ Interface graphique $$$$
Pour lâ€™interface graphique, nous chargeons une nouvelle Stage Ã  chaque nouvelle fenÃªtre. La rapiditÃ© du chargement permet de ne pas gÃªner lâ€™utilisateur. Hormis la fenÃªtre de connexion, nous utilisons un split menu avec les diffÃ©rents onglets Ã  gauche (devoir, se dÃ©connecterâ€¦) et la partie de droite est celle qui Ã©volue en fonction du choix de lâ€™utilisateur.
Un clique sur lâ€™onglet dÃ©jÃ  affichÃ© recharge une nouvelle Stage.
	- 1 fenÃªtre de connexion : on se connecte via un token unique, que chacun peut rÃ©cupÃ©rer sur gitlab. En cas dâ€™erreur, une notification signale lâ€™Ã©chec de la connexion. NB : implÃ©mentation dâ€™un raccourci (touche entrÃ©e) pour se connecter. 
	- 1 page dâ€™accueil : affiche les onglets Ã  gauche devoir, liste Ã©lÃ¨ves, se dÃ©connecter, quitter. Lâ€™onglet devoir propose de crÃ©er ou modifier un devoir.
	- page crÃ©er devoir : permet de crÃ©er un devoir avec les diffÃ©rentes caractÃ©ristiques qui entrent en compte : titre, matiÃ¨re, description, liste dâ€™Ã©lÃ¨ves (1A,2A,3A,indiffÃ©rent), date de dÃ©but et de rendu (pb dâ€™ordre des dates rÃ©solu, la date de rendu doit Ãªtre aprÃ¨s celle de dÃ©but), visibilitÃ© (NB : de base sur privÃ©e), choix dâ€™un prÃ©fixe commun (NB: de base sur non, si lâ€™utilisateur clique sur oui, un TextField apparait pour noter le prÃ©fixe choisi), groupe alÃ©atoire ou pas, et nombre dâ€™Ã©lÃ¨ves par groupe. Il suffit ensuite de cliquer sur crÃ©er. Si la crÃ©ation a Ã©chouÃ©, un message apparaÃ®tra en haut, soit pour le cas dâ€™un problÃ¨me de date (date de rendu avant celle de dÃ©but, dates non remplies) soit pour un autre problÃ¨me qui a dÃ©clencher la GitLabAPIException. Si tout se passe bien, lâ€™utilisateur est ensuite redirigÃ© vers la page de modification des devoirs oÃ¹ tous ces derniers sont rÃ©pertoriÃ©s.
	- page modifier devoir : affiche la liste des diffÃ©rents devoirs crÃ©Ã©s. RESTE A FAIRE : afficher et ensuite pouvoir sÃ©lectionner les devoirs pour les modifier
	- liste Ã©lÃ¨ves : liste des Ã©lÃ¨ves affichées dans le tableau ; possibilité de trier selon la colonne (decroissant/croissant/neutre)
	- dÃ©connexion : renvoi Ã  la stage de connexion
	- quitter: quitte lâ€™application 
IMPLEMENTATION POSSIBLE :
	- rajouter une sauvegarde
	- ajouter des notifications 
	- laisser la connexion pendant 10min avant de redemander le token // OU // rester connecter indÃ©finiment
	- ajouter un Â«Â ?Â Â» Ã  cÃ´tÃ© du token pour expliquer Ã  lâ€™utilisateur (lorsquâ€™il glisse la souris dessus) comment rÃ©cupÃ©rer le token sur son compte gitlab 
	- ajouter une coche pour laisser le choix Ã  lâ€™utilisateur de rester connecter ou non
	- implÃ©menter lâ€™envoi de mail Ã  un projet ou groupe de projet (cf API de Gmail)
	- ajouter une barre de recherche pour trouver plus facilement un devoir ou un Ã©lÃ¨ve
	- possibilitÃ© de crÃ©er des groupes pa niveau (en fonction des notes de chacun)
$$$$ API $$$$


$$$$ BDD $$$$
Il est maintenant possible d'upload des fichier.csv et d'en recuperer toutes les données et de les communiquer a la base de données. La façon de procéder a été la suivante : nous avons recuperer sur l'intranet la liste des 1A,2A et 3A. Nous avons fait de ces trois fichiers un fichier unique "eleves.csv" qui contient les données nom, prenom, adresse mail (sauf pour les 3A) , promotion et TD/approfondissement. Nous avons choisi pour les deuxieme année de garder uniquement l'approfondissement pour simplifier le probleme lors de nos requetes. Ainsi dans notre dossier de projet se trouve ce fichier .csv. Nous tenons à préciser que malheureusement certaines données de ces fichiers récupérés sont manquantes car elles sont do'rigine manquantes sur l'intranet.
Ensuite, lors de la connexion à l'aide du token nous créons la base de données et la table appelee "eleves" representant plus precisement les users de github en general. Nous recuperons via des appels a Gitlab deux donnees uniquement : l'id et le username associe. Nous inserons ces deux donnees dans la table users puis nous parsons les username pour la plupart de la forme "prenom.nom". Nous recuperons le nom et le prenom, puis nous interrogeons la base de donnees en lisant ligne par ligne si le nom et prenom parsé correspond aux noms et prenoms presents dans le fichier csv loadé des la connexion(ce qui explique le temps entre la premiere et la deuxieme fenetre de notre application). Si nous trouvons un match des prenom et des noms, nous mettons a jour la table users en ajoutant les donnees email, promotion, et groupe de td ou approfondissement dans la base de donnees. Ainsi, nous completons la base de donnees pour les users de maniere quasi-satisfaisante. Quasi-satisfaisante en effet car il subsiste quelques champs initialisés a null et qui pourront difficilement etre recuperer. En effet, les professeurs ou administrateurs ou comptes fantômes ne sont pas presents dans la liste csv. Il nous a fallu utilise un pager pour pouvoir recuperer l'entierete des donnees de gitlab car les fonctions de base sans pager vont au delà des tailles de liste prevues.
Ainsi, l'autre enjeu etait maintenant de pouvoir recuperer les donnees concernant les matieres(id_mat,nom_mat), devoirs(id_dev, nom,datedeb,datefin,matiere),et projets( id_projet,nom_proj, liste_membres,devoir) de la meme maniere par laquelle nous avons recuperer les donnees des users possibles. Nous souhaitons recuperer ces donnes des la connexion de l'utilisateur.Cependant, nous n'avons pas reussi a recuperer ces donnees et de les inserer directemet dans les trois nouvelles tables matieres,devoirs et projets correspondantes meme si toutes les fonctions permettant l'extraction des donnees sont a notre disposition. Ainsi, notre choix a ete de recuperer les donnees et de les stocker en local dans un premier temps viades dictionnaires pour dans un deuxieme temps faire appel a ces fonctions pour recuperer les donnees qui nous interessent. 
Le fait de ne pas reussir a uploader ces donnees est genant quant à l'avancement general du projet car pour le developpement de l'interface graphique et notamment pour pouvoir ajouter une ligne dans la fenetre "modifier un devoir", nous avons besoin de recuperer ces donnees. Nous esperons avoir le temps de finir cette etape demain pour arriver a une base de donnees fonctionnelle.
Precisions : la base de donnees cree est locale via sqlite en java. 
Nous avions auparavant reussi à implementer de fonctions permettant, lors de la creation d'un devoir, de recuperer les donnees rentrees dans les champs de l'interface et ainsi de mettre instantanement la table devoirs de la base de donnees a jour directement.

# Avancement Projet

Lien entre l'interface, l'application et GitLab : Connexion, création de groupes(Room,Devoir,Matière).
Lien entre application et GitLab : ajout/modif/suppression de groupes/devoirs/membres.
Lien entre Gitlab et la BDD locale (sqlite) : la table users est quasi complete et exploitable, contrairement a matieres,devoirs, projets.

Release push un peu tard, en effet nous avons tenu à implémenter certaines fonctionnalités. Nous vous prions de nous en excuser.




â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”		RELEASE_DAY_5 : finale
â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”

#### 	 AvancÃ©es de notre projet	####
$$$$ Interface graphique $$$$


$$$$ API $$$$



$$$$ BDD $$$$
La base de donnees est enfin fonctionnelle! Nous avons creer des classes permettant de recuperer les listes de devoirs, de projets et de matieres, ce qui nous permet de simplifier la recuperation de donnees de lgitlab plus facilement. En effet, nous pouvons a partir de la liste des noms de toutes les matieres recuperer les noms des matieres et leurs ids. Ainsi, nous inserons ces donnees pour toutes les matieres déjà crees dans la table matieres. Nous faisons de meme pour la liste des devoirs en la recuperant et ainsi, recuperer les donnees des devoirs telles que : id_dev, matiere,nom_dev,datedebut, datefin, liste concernee(1A,2A ou 3A). Avec ces donnees nous completons la table Devoirs, liee a la table matiere par la cle etrangere devoirs.matiere. Enfin, nous recuperons les noms de tous les projets deja crees par devoir et ensuite nous recuperons les autres informations : id_proj, nom_proj, devoir, owner, date de debut. De même, il y a une clef etrangere nom_proj qui permet de lier la table projets a la table devoirs. Chaque id de chaque table est une clef primaire. Avec ces trois ajouts de table, nous pouvons donc creer une base de donnees complete contenant les tables : users, matiere, devoirs, projets. Ensuite, les differents updates et ajouts de tables a realiser lors de la creation d'un projet par exemple, etaient deja traitees lors des precedentes release. Il manque cependant certaines informations, dificiles a recuperer comme les dates limites d'un projet, ou encore les nom et prenom des utilisateurs non referencees dans le csv.



# Avancement Projet
Base de donnees fonctionnelle, lien entre Gitlab et base de donnees locale.



â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”		CodingWeek 2017 - Sample project	â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”â€”


This project provides a sample application that demonstrates the use of [Gradle](https://gradle.org/) for building a JavaFX application.

It provides basic dependencies such as [Log4j2](https://logging.apache.org/log4j/2.x/) for logging messages, [JUnit](http://junit.org/junit4/) for unit testing and [GitLab API for Java](https://github.com/gmessner/gitlab4j-api) for conversing with a GitLab server.

All these dependencies are defined in the `build.gradle` file. You can freely edit this file in order to add your own dependencies or replace GitLab API for Java library with [Java GitLab API](https://github.com/timols/java-gitlab-api) (by uncommenting `org.gitlab:java-gitlab-api:1.2.8`)

## Basic Gradle commands

Gradle will help you to build and distribute your project. It will allow you to easily manage your dependencies.

Gradle supports the following basic tasks on this project:
- `gradle test` to run the unit tests
- `gradle run` to run the project as a Java application
- `gradle assembleDist` to bundle the project as distribution in a `.zip` and a `.tar` files.
- `gradle clean` to clean up the project (deletes the `build` and `dist` directories)
- `gradle tasks` to list all the available tasks

**Note**: if `gradle` is not installed on your system, you can use the provided wrapper by using the `gradlew` command instead of the `gradle` one.

## Importing this project configuration in an IDE

Gradle is supported in mainstream IDEs such as IntelliJ, Eclipse or NetBeans. Therefore, you can easily import this project in your favorite IDE without having to reconfigure your build process.

### IntelliJ

IntelliJ allows to import gradle project. You just have to import the project and select the `build.gradle` file during the importation.

### Eclipse

Eclipse allows to import a gradle project.

### NetBeans

You first have to install the gradle plugin in NetBeans before being able to import a gradle project.
