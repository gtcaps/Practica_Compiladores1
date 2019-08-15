java -jar .\Cup\java-cup-11b.jar -parser ParserDatos -symbols symDatos Sintactico_Datos 
java -jar .\JFlex\JFlex.jar Lexico_Datos
pause

java -jar .\Cup\java-cup-11b.jar -parser ParserReportes -symbols symReportes Sintactico_Reportes_2 
java -jar .\JFlex\JFlex.jar Lexico_Reportes
pause