package school.sptech.ensine.me.controllers.id;

public class IdControllerUsuario {
    private static int id = 0;

    public static int generateId(){
        id++;
        return id;
    }

    public static int getId(){
        return id;
    }
}
