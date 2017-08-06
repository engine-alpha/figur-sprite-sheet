# Konvertierung von Figuren zu Sprite Sheets

Dieses CLI-Tool ermöglicht die einfache Konvertierung von Figuren in PNG Sprite Sheets.
 
Bis zur Version 3 verwendete die Engine Alpha ein eigenes Dateiformat. Dieses wird nun durch Standardformate wie animierte GIFs und Sprite Sheets ersetzt.

Damit alte Figuren weiterhin verwendet werden können, müssen diese mit diesem Tool konvertiert werden.

## Benutzung

Zur Benutzung muss die aktuelle Version als `.jar`-Datei heruntergeladen werden. Diese steht im [Release-Bereich](https://github.com/engine-alpha/figur-sprite-sheet/releases) zum Download zur Verfügung.

Danach kann eine `.eaf`-Datei einfach mit folgendem Aufruf konvertiert werden.

```
java -jar figur-sprite-sheet.jar figur.eaf figur.png
```