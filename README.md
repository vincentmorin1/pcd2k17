
——————————————		RELEASE_DAY_1 et RELEASE_DAY_2   	—————————————————

# Avancées de notre projet :
début d'interface graphiques (2 fenêtres fonctionnelles, authentification + création devoir) mais problème de conditions sur la connexion plus problème de création sur le devoir (ne récupère pas ce qu'on écrit dans la fenêtre)
création d'une base de données et de ce classes permettant de récupérer un fichier csv afin de mettre a jour la base de données existante mais aucun lien vers Github pour l'instant => reste à faire la synchronisation base de données -> Github via un fichier csv. + importation base de données dans Github.

# Notre projet :
Après compilation, une première fenêtre s'ouvre pour effectuer l'authentification, un premier problème apparait : quel que soit les caractères qu'on entre en token, l'authentification marche. Ensuite, une fenêtre de création de devoir s'ouvre ou l'on peut renseigner les champs principaux de renseignements (description, nom, dates de fin et de début, etc...) et c'est ici que nous avons un deuxième problème : on ne récupère pas ce qui est écrit dans ces champs. Enfin, la base de données créée et les fonctions associées ainsi que l'incorporation d'un fichier csv n'est pour l'instant pas reliée avec le reste des données utilisées et à utiliser.


——————————————		RELEASE_DAY_3 et RELEASE_DAY_4		————————————————

#### 	 Avancées de notre projet	####
$$$$ Interface graphique $$$$
Pour l’interface graphique, nous chargeons une nouvelle Stage à chaque nouvelle fenêtre. La rapidité du chargement permet de ne pas gêner l’utilisateur. Hormis la fenêtre de connexion, nous utilisons un split menu avec les différents onglets à gauche (devoir, se déconnecter…) et la partie de droite est celle qui évolue en fonction du choix de l’utilisateur.
Un clique sur l’onglet déjà affiché recharge une nouvelle Stage.
	- 1 fenêtre de connexion : on se connecte via un token unique, que chacun peut récupérer sur gitlab. En cas d’erreur, une notification signale l’échec de la connexion. NB : implémentation d’un raccourci (touche entrée) pour se connecter. 
	- 1 page d’accueil : affiche les onglets à gauche devoir, liste élèves, se déconnecter, quitter. L’onglet devoir propose de créer ou modifier un devoir.
	- page créer devoir : permet de créer un devoir avec les différentes caractéristiques qui entrent en compte : titre, matière, description, liste d’élèves (1A,2A,3A,indifférent), date de début et de rendu (pb d’ordre des dates résolu, la date de rendu doit être après celle de début), visibilité (NB : de base sur privée), choix d’un préfixe commun (NB: de base sur non, si l’utilisateur clique sur oui, un TextField apparait pour noter le préfixe choisi), groupe aléatoire ou pas, et nombre d’élèves par groupe. Il suffit ensuite de cliquer sur créer. Si la création a échoué, un message apparaîtra en haut, soit pour le cas d’un problème de date (date de rendu avant celle de début, dates non remplies) soit pour un autre problème qui a déclencher la GitLabAPIException. Si tout se passe bien, l’utilisateur est ensuite redirigé vers la page de modification des devoirs où tous ces derniers sont répertoriés.
	- page modifier devoir : affiche la liste des différents devoirs créés. RESTE A FAIRE : récupérer les devoirs créés sur gitlab pour les afficher et ensuite pouvoir les sélectionner pour les modifier
	- liste élèves : RESTE A FAIRE : récupérer la liste des élèves pour l’afficher dans le tableau ; possibilité de trier selon la promo
	- déconnexion : renvoi à la stage de connexion
	- quitter: quitte l’application 
IMPLEMENTATION POSSIBLE :
	- rajouter une sauvegarde
	- ajouter des notifications 
	- laisser la connexion pendant 10min avant de redemander le token // OU // rester connecter indéfiniment
	- ajouter un « ? » à côté du token pour expliquer à l’utilisateur (lorsqu’il glisse la souris dessus) comment récupérer le token sur son compte gitlab 
	- ajouter une coche pour laisser le choix à l’utilisateur de rester connecter ou non
	- implémenter l’envoi de mail à un projet ou groupe de projet (cf API de Gmail)
	- ajouter une barre de recherche pour trouver plus facilement un devoir ou un élève
	- possibilité de créer des groupes pa niveau (en fonction des notes de chacun)
$$$$ API $$$$














——————————————		CodingWeek 2017 - Sample project	——————————————————


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
