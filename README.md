How can I ensure that my code, program or software is functional and secure?

The best way I have found to make sure any project I have worked on is functional and secure is by beginning testing early on. I begin with unit testing each portion of the initial codebase line by line.
Some examples of how I have previously done tests like this would be testing constraints within a class. In the java files under the "Project One" folder of this github I have several simple files that
had various constraints tied to how they were intended to operate. Such as in the contact file, a contact had numerous fields tied to it that had to be a certain length among various other requirements.
I tested each of these classes individually by purposefully attempting to submit variables that violated these constraints and used JUNIT tests to assert that it would throw an exception, as the class'
definitions stated that their variables held had to follow a certain format.

How do I interpret user needs and incorporate them into a program?

The beginning step is obviously reading the requirements that a user is submitting. I take what they want to see in a program I am working on and translate it into workable code. After developing the code
I would make test cases for each of the user needs that were incorporated into the project and give them passing or failing criteria. Such as if a user tells me they need a way to have a search funciton
in a program. I would translate this into workable code, and then move into developing it. Once it has been finished in development, I would run several tests to ensure that it is running in a way that is
not only functional but also would be easy for a user to understand.

How do I approach designing software?

My approach to designing software is a cautious one. A simple mistake that may not be all that important when the program is early in its development lifecycle could potentially cause numerous errors 
further down the line. I try to catch as many possible errors early on, which I usually do by testing a class or function based exactly on what it is supposed to do. An example could be a formula for 
a mathematical equation. A small mistake in the equation could produce good results in early testing, but later on in development whenever that equation might handle multiple commands or large 
mathematical questions it could then produce wildly innacurate results. I always approach designing software cautiously, as any developer would know that overconfidence could lead ot missing a simple
mistake that will cause a lot of hassle in the future once the program has multiple relationships within the program. Debugging is always easier when it is done with a singular function instead of 
larger relationships within the program.

Edit on 11/14/2025

Added the file CSCapstone Appointment Application. This file contains the original code from the project, but now with a new file 'AppointmentApp.java' that contains a Main() program. Now instead of
separate code files that were only created for JUNIT testing, I have a working program that utilizes the old code files. The program is basic for now, it does not create a database, but it correctly
performs CRUD operations on the existing classes that I made.
