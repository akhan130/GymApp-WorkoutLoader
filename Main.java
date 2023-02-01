package Test;
import java.text.DecimalFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.print("If you want a customized workout plan generated based on your needs, proceed by entering 'GO': ");
        Scanner input = new Scanner(System.in);
        String buttonInput = input.next();
        int health;
        if (buttonInput.equalsIgnoreCase("GO")) {
            double feet = 0;
            double inch = 0;

            /*** Health Metrics stored in Queue ***/
            Queue<String> statsList = new LinkedList<String>();
            for (int i = 0; i < 1; i++) {
                System.out.print("\n" + "Please enter your height in ft: ");
                feet = input.nextDouble();
                double conversionFt = feet * 30.48;             // calculation to convert user feet input to feet

                System.out.print("Please enter your height in inch: ");
                inch = input.nextDouble();
                double conversionIn = inch * 2.54;              // calculation to convert user inch input to inch
                double total = conversionIn + conversionFt;     // calculation to calculate users height

                DecimalFormat decFor = new DecimalFormat("#.##");     // shorten decimal to 2 places for height
                statsList.add(decFor.format(total) + " cm");

                System.out.print("Please enter your weight (enter in lbs, ex: 150 lb): ");
                statsList.add(input.nextFloat() + " lbs");

                System.out.print("Please enter your gender (enter Male/Female): ");
                statsList.add(input.next());
            }

            String allergies = " ";
            String resHistory = " ";
            String resDisease = " ";

            String carHistory = " ";
            String carDisease = " ";
            String diabOrHyp = " ";

            health = 0;
            System.out.print("\n" + "Do you have any health problems? From the list below, enter the number of the health problem, " +
                    "(i.e. 4 for None):");

            /*** Health Problems stored in Stack ***/
            Stack behavior = new Stack();
            behavior.push("4. None");
            behavior.push("3. Both");
            behavior.push("2. Circulatory Problems");
            behavior.push("1. Respiratory Problems");

            System.out.println();
            for (int i = 0; i < 4; i++) {
                System.out.println("Health Problems: " + behavior.pop());
            }

            health = input.nextInt();

            /*** conditionals to ask user specific health questions based on their input on health problems ***/
            if (health == 1 || health == 3) {
                System.out.print("\n" + "Do you have any allergies? ");
                allergies = input.next();
                System.out.print("Do you have a family history of asthma, tuberculosis, lung cancer, bronchitis, or any other lung related disease? ");
                resHistory = input.next();
                System.out.print("Do you have any respiratory disease including and excluding the ones identified in the previous question? ");
                resDisease = input.next();
            }

            if (health == 2 || health == 3) {
                System.out.print("\n" + "Do you have a family history of cardiac disease, diabetes, hypertension, or any other cardiac related " +
                        "disease? ");
                carHistory = input.next();
                System.out.print("Do you have any cardiac diseases? ");
                carDisease = input.next();
                System.out.print("Do you have diabetes or hypertension? ");
                diabOrHyp = input.next();
            }

            /*** Availability stored in LinkedList ***/
            int numOfDays = 0;
            System.out.print("\n"+ "Enter the total number of days you are available to workout during the week: ");
            numOfDays = input.nextInt();
            LinkedList<String> days = new LinkedList<>();

            System.out.println("Enter the days you are available to workout during the week: ");
            for (int i = 0; i <= numOfDays; i++) {
                days.add(input.nextLine());
            }

            /*** Workout Preference stored in HashTable ***/
            Hashtable<String, String> socialSetting = new Hashtable<String, String>();
            Enumeration<String> enumeration = socialSetting.elements();
            String aloneSomeone = "";
            String indoorOrOutdoor = "";
            System.out.println();

            for(int i = 0; i < 1; i++) {
                System.out.print("Do you enjoy working out alone or with someone else?: ");
                aloneSomeone = input.next();

                if (aloneSomeone.equals("end")) {
                    break;
                }

                System.out.print("Would you rather workout indoor or outdoor? ");
                indoorOrOutdoor = input.next();
                socialSetting.put(aloneSomeone, indoorOrOutdoor);
            }

            while (enumeration.hasMoreElements()){
                System.out.println("hashtable values: " + enumeration.nextElement());
            }

            int activity = 0;

            System.out.print("\n" + "From the above list, what types of fitness activities have you participated in? (Enter the number of the activity " +
                    "for example '3' for Yoga): " + "\n");

            /*** Fitness Activities stored in Stack ***/
            Stack fitness = new Stack();
            fitness.push("4. Sports");
            fitness.push("3. Cardio - i.e. walking, running");
            fitness.push("2. Yoga");
            fitness.push("1. Other fitness activities");

            for (int i = 0; i < 4; i++) {
                System.out.println("Activity: " + fitness.pop());
            }


            /*** conditionals for printing out user inputs ***/
            activity = input.nextInt();

            /*** Type of Health Problem User Has Question ***/
            String healthOutput = " ";
            if (health == 1) {
                healthOutput = "Health Issue: Respiratory Problems";
            } if (health == 2) {
                healthOutput = "Health Issue: Circulatory Problems";
            } if (health == 3){
                healthOutput = "Health Issue: Both Respiratory & Circulatory Problems";
            } if (health == 4) {
                healthOutput = "Health Issue: None";
            }

            /*** Respiratory Disease Specific Questions ***/
            String allergyOutput = " ";
            if(allergies.equalsIgnoreCase("Yes")){
                allergyOutput = "You have allergies";
            } if(allergies.equalsIgnoreCase("No")){
                allergyOutput = "You do not have allergies";
            }

            String resFamHistory = " ";
            if(resHistory.equalsIgnoreCase("Yes")){
                resFamHistory = "Yes you have family history of lung related diseases";
            } if(resHistory.equalsIgnoreCase("No")) {
                resFamHistory = "No you do not have family history of lung related diseases";
            }

            String resIndHistory = " ";
            if(resDisease.equalsIgnoreCase("Yes")){
                resIndHistory = "Yes you have a lung related disease";
            } if(resDisease.equalsIgnoreCase("No")){
                resIndHistory = "No you do not have a lung related disease";
            }

            /*** Circulatory Disease Specific Questions ***/
            String diabOrHypOutput = " ";
            if(diabOrHyp.equalsIgnoreCase("Yes")){
                diabOrHypOutput = "You have diabetes or hypertension";
            } if(diabOrHyp.equalsIgnoreCase("No")){
                diabOrHypOutput = "You do not have diabetes or hypertension";
            }

            String carFamHistory = " ";
            if(carHistory.equalsIgnoreCase("Yes")){
                carFamHistory = "Yes you have family history of cardiac related diseases";
            } if(carHistory.equalsIgnoreCase("No")){
                carFamHistory = "No you do not have family history of cardiac related diseases";
            }

            String carIndHistory = " ";
            if(carDisease.equalsIgnoreCase("Yes")){
                carIndHistory = "Yes you have cardiac related diseases";
            }  if(carDisease.equalsIgnoreCase("No")){
                carIndHistory = "No you do not have cardiac related diseases";
            }

            /*** Conditionals for printing out type of fitness activities ***/
            String fitnessOutput = " ";
            if (activity == 1){
                fitnessOutput = "Fitness Activity: Other fitness activities";
            } if (activity == 2){
                fitnessOutput = "Fitness Activity: Yoga";
            } if (activity == 3){
                fitnessOutput = "Fitness Activity: Cardio";
            } if (activity == 4){
                fitnessOutput = "Fitness Activity: Sports";
            }

            /*** Print Results ***/
            System.out.println("\n" + "RESULTS");
            System.out.println("Health Metrics: " + statsList);
            System.out.println("Weekly Availability: " + days);

            /*** Prints Hashtable ***/
            for (String n : socialSetting.keySet()) {
                System.out.println("Social Preference:\t" + n + "\nSetting Preference:\t" + socialSetting.get(n));
            }

            /*** Specific Health Questions stored in Array & sorted by Yes/No with Bubblesort ***/
            String [] userResults = {healthOutput, fitnessOutput};
            System.out.println("\n" + userResults[0]);       // prints health problem user has

            if (health == 1 || health == 3) {
                String[] respiratoryResults = {allergyOutput, resFamHistory, resIndHistory};
                sortStrings(respiratoryResults);
                System.out.println("a: " + respiratoryResults[0]);
                System.out.println("b: " + respiratoryResults[1]);
                System.out.println("c: " + respiratoryResults[2] + "\n");
            }

            if (health == 2 || health == 3) {
                String[] circulatoryResults = {diabOrHypOutput, carFamHistory, carIndHistory};
                sortStrings(circulatoryResults);
                System.out.println("a: " + circulatoryResults[0]);
                System.out.println("b: " + circulatoryResults[1]);
                System.out.println("c: " + circulatoryResults[2] + "\n");
            }

            System.out.println(userResults[1] + "\n");         // prints fitness activities user has experience with

            /*** Binary Tree gathers all user inputs & recommeneds the user with a specific workout ***/
            BT workoutTree = new BT();
            workoutTree.insert(1,"Rowing");
            workoutTree.insert(2, "Hiking");
            workoutTree.insert(3, "Resistance Training");
            workoutTree.insert(4, "Frisbee");
            workoutTree.insert(5,"Stretch");
            workoutTree.insert(6, "Exercise Diapghram");
            workoutTree.insert(7, "Yoga Arm Balance");
            workoutTree.insert(8, "Tai Chi");
            workoutTree.insert(9,"Indoor Cycling");
            workoutTree.insert(10,"Jogging");
            workoutTree.insert(11,"Low Impact Aerobics");
            workoutTree.insert(12,"Jump Roping");
            workoutTree.insert(13,"Gymnastics");
            workoutTree.insert(14,"Swimming");
            workoutTree.insert(15,"Bowling");
            workoutTree.insert(16,"Tennis");
            workoutTree.insert(17,"Push Ups");
            workoutTree.insert(18,"Interval Training");
            workoutTree.insert(19,"Oblique Twists");
            workoutTree.insert(20,"Standing Roll Down");
            workoutTree.insert(21,"Aerobics");
            workoutTree.insert(22,"Walk");
            workoutTree.insert(23,"Spin Class");
            workoutTree.insert(24,"Outdoor Biking");
            workoutTree.insert(25,"Martial Arts");
            workoutTree.insert(26,"Diving");
            workoutTree.insert(27,"Table Tennis");
            workoutTree.insert(28,"Soccer");
            workoutTree.insert(29,"Squats");
            workoutTree.insert(30,"Circuit Training");
            workoutTree.insert(31,"Roller Blading");
            workoutTree.insert(32,"Tree Pose");
            workoutTree.insert(33,"Downward dog");
            workoutTree.insert(34,"Partner forward fold");
            workoutTree.insert(35,"Baby Pigeon");
            workoutTree.insert(36,"12:3:30");
            workoutTree.insert(37,"Run & Sprints");
            workoutTree.insert(38,"Robin Hood");
            workoutTree.insert(39,"Sprinting");
            workoutTree.insert(40,"Paddle Ball");
            workoutTree.insert(41,"Basketball");
            workoutTree.insert(42,"Dodgeball");
            workoutTree.insert(43,"Football");

            System.out.println("Searching tree for workout...");

            /*** conditionals for binary tree ***/
            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(1);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(2);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(3);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(4);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(5);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(6);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(7);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(8);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(9);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(10);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(11);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(12);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(13);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(14);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(15);
            }

            if(health==1 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(16);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(17);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(14);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(18);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(16);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(19);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(20);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(8);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(5);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(21);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(22);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(23);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(24);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(25);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(26);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(27);
            }

            if(health==2 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(28);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(29);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(14);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(3);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(4);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(5);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(6);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(7);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(8);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(9);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(10);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(11);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(12);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(13);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(14);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(15);
            }

            if(health==3 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(16);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(29);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(14);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==1) {
                workoutTree.search(30);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==1) {
                workoutTree.search(31);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(32);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(33);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==2) {
                workoutTree.search(34);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==2) {
                workoutTree.search(35);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(36);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(37);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==3) {
                workoutTree.search(38);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==3) {
                workoutTree.search(39);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(40);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("alone") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(41);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("indoor") && activity==4) {
                workoutTree.search(42);
            }

            if(health==4 && aloneSomeone.equalsIgnoreCase("someone else") && indoorOrOutdoor.equalsIgnoreCase("outdoor") && activity==4) {
                workoutTree.search(43);
            }

        } else {
            System.out.println("See you next time");
        }
    }

    /*** Algorithm defined for bubble sort ***/
    public static void sortStrings(String[] arr) {
        String temp;
        for (int j = 0; j < arr.length-1 - 1; j++) {
            for (int i = j + 1; i < arr.length; i++) {
                if (arr[j].compareTo(arr[i]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}


