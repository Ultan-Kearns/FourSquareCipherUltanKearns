# FourSquareCipherUltanKearns

Features and functionality

1.	Has text-based UI which allows user to encrypt/decrypt, set keys, encrypt / decrypt URL and decrypt/encrypt string.
2.	Can encrypt/decrypt in O(Log n) time due to taking two characters at once and using one loop.
3.	Allows user to specify what text file they would like to encrypt/decrypt then allows user to save to file or not save file.
4.	Allows user to set the keys for encrypt/decrypt but was unable to rid cipher of duplicates due to time although it does remove special characters and numbers.
5.  	Allows user to specify paths for the files they are trying to encrypt/decrypt.
6.	Provides error handling for incorrectly named files.
7.  	Encrypt/decrypt from URL(Does not encrypt / decrypt unicode characters).
8.	Provides error handling for incorrectly named URL.
9.  	Outputs the plaintext and decrypted or encrypted text to console for user.
10.  	Jar file fully works tested on two PCs.
11. 	Used Jsoup for HTML parsing of URLs.
12. 	Use  "java -cp  .;./four-square.jar;./jsoup.jar ie.gmit.sw.Runner" to compile due to Jsoup.
