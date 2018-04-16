# Console-drawing
Console drawing program

# Software tools used
1. Java 8
2. Collections
3. Maven
4. Intellij

# Known issues
DOS does not support color on console, therefore it is insisted to run on Linux terminal or Intellij IDE

# Steps
* Clone the repository https://github.com/adityapant1286/console-drawing.git
* Import in Intellij/Eclipse/NetBeans
* Maven build = mvn clean install
* Run com.console.DrawingBoard.java from IDE OR
* Login to Linux (Due to known issue)
* Copy generated `console-drawing-1.0.jar` file to a directory
* Assuming Java 8 is installed and JAVA_HOME is set in environment classpath
* Run following command to run the program
* `java -jar console-drawing-1.0.jar`
* Enter command as per below table


# Usage
  Command        | Description
  -------------  |---------------------------------------------
  C w h          | Create a new canvas of width w and height h.
  L x1 y1 x2 y2  | Create a new line of 'x' from (x1,y1) to (x2,y2). Only support horizontal or vertical lines.
  R x1 y1 x2 y2  | Create a new rectangle, (x1,y1) is upper left corner & (x2,y2) is lower right corner.
  B x y c        | Fill the entire area around (x,y) with "colour" c. Color can be any one of these ["r", "b", "y", "g", "c", "p"].
  Q              | Quit.

 # Main class
 com.console.DrawingBoard.java
