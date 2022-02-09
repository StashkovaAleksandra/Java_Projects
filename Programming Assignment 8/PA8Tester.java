///////////////////////////////////////////////////////////////////////////////
// Main Class File:    PA8Tester.java
// File:               PA8Tester.java
// Quarter:            Spring 2021
//
// Author:             Yundong Wang
// Instructor's Name:  Haytham Allos
///////////////////////////////////////////////////////////////////////////////

/**
 * The {@code PA8Tester} class contains testers to test the functionality of all
 * other java classes. 
 *
 * Bugs: None
 *
 * @author Yundong Wang
 */
public class PA8Tester {
    /**
     * A comprehensive tester for the file system.
     * @return return true if the tester passes
     */
    private static boolean comprehensiveTest() {
        System.out.println("Start comprehensive test...\n");
        
        RootDirectory root = new RootDirectory("HOME");
        NormalFile pic = new NormalFile("cat.png", 4);
        NormalFile rice = new NormalFile("rice.mp3", 10);
        SubDirectory music = new SubDirectory("music");
        root.addComponent(pic);
        root.addComponent(rice);
        root.addComponent(music);

        /**
         * print the following
         * * * * * * * * * * * * * * * * * * * *
         *  RootDirectory: HOME                
         *      Normal file: cat.png       
         *      Normal file: rice.mp3         
         *      Sub Directory: music
         * * * * * * * * * * * * * * * * * * * * 
         */
        root.printStructure();
        System.out.println("* * * * * * * * * * * * * * * * * * * * ");

        
        rice.moveTo(music);
        /**
         * print the following
         * * * * * * * * * * * * * * * * * * * *
         *  RootDirectory: HOME                
         *      Normal file: cat.png                
         *      Sub Directory: music
         *          Normal file: rice.mp3
         * * * * * * * * * * * * * * * * * * * * 
         */
        root.printStructure();
        System.out.println("* * * * * * * * * * * * * * * * * * * * ");

        SubDirectory secret = new SubDirectory("secret");
        ProtectedFile protectedFile = new ProtectedFile(".cse8b_final_exam", 5);
        NormalFile video = new NormalFile("lecture10.mp4", 30);
        SubDirectory lecture = new SubDirectory("lecture");
        secret.addComponent(protectedFile);
        lecture.addComponent(video);
        root.addComponent(secret);
        root.addComponent(lecture);

        /**
         * print the following
         * * * * * * * * * * * * * * * * * * * *
         *  RootDirectory: HOME                
         *      Normal file: cat.png                
         *      Sub Directory: music
         *          Normal file: rice.mp3
         *      Sub Directory: secret
         *          Protected file: .cse8b_final_exam
         *      Sub Directory: lecture
         *          Normal file: lecture10.mp4
         * * * * * * * * * * * * * * * * * * * * 
         */
        root.printStructure();
        System.out.println("* * * * * * * * * * * * * * * * * * * * ");
        
        boolean checkMoveTo = music.moveTo(secret);
        boolean checkRename1 = lecture.rename("secret");
        boolean checkDelete = secret.delete();
        boolean checkRename2 = video.rename("Lecture10.mp4");

        /**
         * print the following
         * * * * * * * * * * * * * * * * * * * *
         *  RootDirectory: HOME                
         *      Normal file: cat.png                
         *      Sub Directory: secret
         *          Protected file: .cse8b_final_exam
         *          Sub Directory: music
         *              Normal file: rice.mp3
         *      Sub Directory: lecture
         *          Normal file: Lecture10.mp4
         * * * * * * * * * * * * * * * * * * * * 
         */
        root.printStructure();
        System.out.println("The size of root directory is " + root.getSize());
        return checkMoveTo && !checkRename1 && !checkDelete && checkRename2 && 
            root.getSize() == 49;
    }





    public static void main(String[] args) {

        // calls unit test
        if(comprehensiveTest()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }
    }
}