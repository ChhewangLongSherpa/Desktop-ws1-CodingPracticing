Java requires fully qualified names on the class path for the package set in order to run

Java file names must match class names in the .java file

if your package is "package org.clongs.java8", then the binary or the .java files needs to be in directory path
~/org/clongs/java8 or it will return the "Could not find or load main class" error

Ex: java -classpath ../../.. org.clongs.java8.<Class>
This will work 




