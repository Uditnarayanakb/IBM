public class Multi_level_inheritence {
    public static void main(String[] args) {
        Employee emp = new Employee();
        System.out.println("Permissions for Employees: "+ emp.permission_level);
        
        Employee manager = new Manager();
        System.out.println("Permissions for Managers: "+ manager.permission_level);

        Employee pem = new People_Manager();
        System.out.println("Permissions for People Managers: "+ pem.permission_level);

    }
}

class Employee{
    String permission_level = "Basic";
}

class Manager extends Employee{
    Manager(){
        this.permission_level = super.permission_level + ", Escalation";
    }
}

class People_Manager extends Manager{
    People_Manager(){
        this.permission_level = super.permission_level + ", Sacking";
    }
}

