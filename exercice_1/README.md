Compilation

```
javac -d bin src\*.java
```

Interprétation

```
java -cp bin Main
```

Créer un jar executable
```
jar cfm exercice1.jar ./src/MANIFEST.MF -C bin .
```

Vérifier le contenu du jar
```
jar tf exercice1.jar
```

Test fichier jar
```
java -jar exercice1.jar
```