class Static_var{

    public static void main(String []args){
        C.display();
        C obj = new C();
        obj.name = "Sukanta";
        System.out.println("Before Modification:");
        System.out.println(obj.school+", "+ obj.name);
        System.out.println("Class.school: "+ C.school);
        
        obj.name = "Felu";
        obj.school = "MCKV";
        System.out.println("Before Modification:");
        System.out.println(obj.school+", "+ obj.name);

        System.out.println("Class.school: "+ C.school);

    }
}

class C{
    static String school="SMHS";
    String name;

    static void display(){
        System.out.println("Hellooo");
    }
}