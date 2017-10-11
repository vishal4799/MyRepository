Execution steps:
zip contains 2 java files, 1 input txt file and read me file.
1.compile java files and generate class files. Order will be as below:
GalaxyGuide.java
TestGalaxyGuide.java
2.run GalaxyGuide and provide input.txt with full path as a command line argument
e.g. java GalaxyGuide C:\input.txt
3.To run jUnit test class you need to have Junit jar in your env.


Test Cases:
1.run without file argument
2.run with invalid file path
3.run with invalid file format(other than .txt)
all other test cases, i have tried to cover in input.txt file

Assumptions:
1.Roman to decimal conversion is valid from 0 to 3999.
2.input file can be provided by command line only.
3.input file can be .txt only.
4.Unit values assignment statement will be before all questions in .txt file. 
5.In each lines of file and for any language, general words's index(like how,much,many,is) will not change.
6.Assignment statement(e.g. glob is I) should be 3 words long only.
7.Question should ends with '?' (it can be configured with any other char)
8.Question keywords like(how, much, many, is) can be configured with any other single word as question detection logic is based on word's index. For example you can use 'xyz' instead of 'how', but you can't use 'abc xyz'.
