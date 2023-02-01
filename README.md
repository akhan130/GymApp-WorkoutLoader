# Fitness Socials
> Fitness App developed as part of a final project for Data Structures & Algorithms. This is a Java console application. The idea of this project is to take in user inputs and based on the user's responses, the app will recommend them a customized workout. Since there are many different fitness apps developed already, the goal of this app was to make it unique. In order to make this app unique, specific parameters were given preference such as social. One of the parameters that this application focuses on is whether the user enjoys working out alone or with someone else. 

## Development
The method that was followed to perform this algorithm is the following:

The user is asked certain health metrics such as height, weight, gender, history of circulatory and respiratory issues, and their past experience with different fitness activities. The user is also asked about their availability, if they enjoy working out alone or with someone else, and if they enjoy working out indoors or outdoors.

After taking in these responses, 80 different combinations were created for all the possible set of responses a user could input during each session. After these combinations were created, a binary tree was used to map each of the combinations into separate nodes. In other words, combination one was stored in node one, combination two was stored in node two, etc.

In order to come up with these combinations, the following steps were followed. First, focus was given to whether the user enjoys working out alone or with someone else. Based on the response given, focus was then given to whether the user enjoys working out indoors or outdoors. Based on these responses, research was conducted on workouts that are usually performed in a group or workouts that are performed alone. Then, research was conducted on what workouts are usually performed indoors with and without a group or outdoors with and without a group. The same steps were applied to the parameters such as past health and fitness history. The goal was to begin with the user's preference of working out alone or in a group and then build up on different parameters so the recommended workout meets the user's needs. 

## Tools/Skills Utilized
1. Java Programming
2. Data Structures & Algorithms [Queue, Stack, LinkedList, Array, BubbleSort, Hashtable, & Binary Tree]
3. IntelliJ IDEA

## What does the future look like for this app?
  1. Building a user interface for this app so it is user friendly for the public
  2. Improve the workout recommendations provided to the user since it is still not meeting every single parameter
  3. Allow the app to stop running if the user enters an inaccurate day of the week
  4. Allow multiple users to use the app simulataneously & save the previous users data
  5. Connect all the users that use the app with each other if their preferences align with each other
