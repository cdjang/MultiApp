# MultiApp
Personal Coding Project using Android Studios

Contains multiple types of files regarding different types of skills
for learning Android Development

Multi-App contains all types of activities within one project
This allows the user to access a spinner and choose which activity they want

# Connecting to GitHub
File - Settings - Version Control GitHub

Authorization Type should be changed to Password

Host GitHub 

VCS - Git contains all instructions for the Repository


# Kaspersky Complications
If unable to connect, Go into Kaspersky Security Settings
and disable the Web Anti-Virus Temporarily so you can commit/push

-OR-

Add the Kaspersky Certificate into the Ca-Bundle Certificate
by first going into Kaspersky:

Settings > Additional > Network > Encrypted connections scanning - Advanced Settings >
Install Certificate > Show Certificate > Details > Copy to File > Base-64 encoded X.509 (.cer)

Once you have that certificate, go and access Git Certificates
C:\Program Files\Git\mingw64\ssl\certs

Open the Kaspersky Cert in Notepad++ and copy the contents to the
end of the ca-bundle cert.  Once saved, android studio shoould be able to 
connect properly

# Author
Caleb Jang - Multi-App
