Hackcamp Wolfsburg 2014-2
=========================
Oberthema des 2. Hackcamps 2014 ist das Spring Framework. Dieses Beispielprojekt kann dabei die Grundlage für weitere Hacks bilden.
Bei diesem Beispielprojekt handelt es sich um eine äußerst simple Blogapplikation.

# Fachliche Anforderungen
 - Als Benutzer will ich beliebig viele Blogeinträge erstellen.
 	- Blogeintrag: Name, Datum, Inhalt
 - Als Benutzer will ich meinem Blogeintrag beliebig viele Kategorien zuweisen.
 - Als Administrator will ich Kategorien definieren.
 	- Eine Kategorie besteht aus einem Namen.
 - Als Administrator will ich alle Blogeinträge ändern und löschen können.
 - Als Benutzer will ich meine eigenen Blogeinträge ändern und löschen können.
 - Als Administrator will ich neue Benutzer hinzufügen.
 	- Benutzername
 	- Passwort
 	- Angezeigter Name
 - Als Administrator will ich Benutzer das Administratorrecht geben und entziehen können.
 - Als Besucher will ich die Blogeinträge paginiert angezeigt bekommen
 	- 5 Einträge pro Seite, aktuellster zuerst
 - Als Besucher will ich die Blogeinträge nach Kategorien paginiert angezeigt bekommen
 	- 5 Einträge pro Seite, aktuellster Eintrag zuerst
 
# Mögliche Unterthemen
 - Implementierung der notwendigen Repository-Methoden und -(Integrations)Tests
 - Implementierung der Oberfläche mit spring-mvc
 - Anpassung der Oberfläche anhand des Google Material Designs (http://www.google.com/design/spec/material-design/introduction.html)
 - Implementierung der Sicherheit (Login, Autorisierung auf Löschen/Ändern) mit spring-security
 - Pagination mit spring-data-jpa
 - Live-Anzeige, wenn ein neuer Blogeintrag gepostet worden ist (Websockets)
 
# Mögliches Vorgehen
 - Gruppen aus max. 3 Personen
 - Anforderungen analyisieren und in Unteraufgaben aufteilen
 	- Kanban-Board?
 - Sprints von 1h? Danach Meeting, was erreicht worden ist bzw. Austausch über neue Kentnisse
 - max. 2 Personen programmieren gleichzeitig; einer sollte als "Consulter" zuarbeiten
 - Tests schreiben!

# Entwicklungsdetails
## Grundeinstellungen des Projekts
 - Alle grundlegenden Abhängigkeiten sind in der pom.xml bereits definiert
 - Als Logging kommt logback zum Einsatz. Damit Fehler besser identifiziert werden können, ist das Loglevel auf DEBUG gesetzt
 - Standardmäßig wird auf auf eine H2-Datenbank deployt. Über den Parameter -Dprofile=production kann aber auch auf eine MySQL-Datenbank deployt werden
 - In der pom.xml ist Java 8 der Standard. Du kannst also Lambdas und Streams nutzen.
 - Beim Starten werden automatisch Integrationsdaten in der Datenbank gespeichert (OnStartupListener)

## Einrichten der Entwicklungsumgebung
 - STS installieren (http://spring.io/tools/sts), mindestens 3.6.2
 - Projekt in Eclipse STS importieren
 	- Bei der Nutzung von tcServer "Enable Java Agent-based reloading" aktivieren
 - Das Projekt dem Application Server zuweisen und Server starten
 - http://localhost:8080/hackcamp-wolfsburg-2014-2 im Browser aufrufen
 
## Kompilierung auf der Kommandozeile

	mvn clean package

## Paketbenamung
- Root-Package ist de.wolfsburg.hackcamp
- alle Klassen, die Geschäftsprozesse abbilden, kommen in das Package .business
- Repositories/DAOs gehören in .business..persistence
- Entitäten von Repositories kommen in .business..persistence.entity
- Web-Themen kommen nach .business..web