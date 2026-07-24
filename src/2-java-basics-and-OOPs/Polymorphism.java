

class Polymorphism{

    float add_nums(int a, int b){
        System.out.print("sum of "+a+" and "+b+" : ");
        return (float)(a+b);
    }

    float add_nums(int a, int b, int c){
        System.out.print("sum of "+a+", "+b+" and "+c+" : ");
        return (float)(a+b+c);
    }

    float add_nums(int a, float b){
        System.out.print("sum of "+a+" and "+b+" : ");
        return (float)(a + b);
    }

    float add_nums(float b, int a){
        System.out.print("sum of "+a+" and "+b+" : ");
        return (float)(a + b);
    }

    public static void main(String[] args) {
        Polymorphism ob = new Polymorphism();
        System.out.println(ob.add_nums(4,5));
        System.out.println(ob.add_nums(4,5, 9));
        System.out.println(ob.add_nums(4,5.5f));
        System.out.println(ob.add_nums(4.5f,5));
    }
}

