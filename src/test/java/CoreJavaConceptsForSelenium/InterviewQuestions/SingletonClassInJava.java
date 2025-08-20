package CoreJavaConceptsForSelenium.InterviewQuestions;

public class SingletonClassInJava {

    // Create an Instance
    private static SingletonClassInJava Instance;

    //Declare a private instance Variable
    private String str;

    // Getter
    public String getStr() {
        return str;
    }

    //Setter
    public void setStr(String str) {
        this.str = str;
    }

    //private Constructor, this will allow java to create no more Constructor
    private SingletonClassInJava() {
        str = "This is a Singleton class";
    }


    // Method to access a singleton Class Variable
    public static SingletonClassInJava getInstance() {
       if (Instance == null) {
           Instance = new SingletonClassInJava();
       }
       return Instance;
    }
}

class TestSingleton {

    public static void main(String[] args) {
        SingletonClassInJava singleton = SingletonClassInJava.getInstance();
        System.out.println(singleton.getStr());

        singleton.setStr("New Instance");
        System.out.println(singleton.getStr());
    }
}
