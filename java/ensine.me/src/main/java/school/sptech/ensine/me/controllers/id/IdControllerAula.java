package school.sptech.ensine.me.controllers.id;

public class IdControllerAula {
    private static int id = 1000;

    public static int generateId(){
        id++;
        return id;
    }

    public static int getId(){
        return id;
    }
}
