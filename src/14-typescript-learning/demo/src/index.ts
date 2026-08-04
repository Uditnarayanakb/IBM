// const name: string = "Udit";
// var name= "Udit"

// console.log(`Hello ${name}`);

function greet(msg:String): String {
    return msg;
}

// console.log(greet("hello"))

function sum(a:number,b:number) :number{
    return a+b;
}
// console.log(sum(2,6))

interface Employee {
    id: number;
    name: string;
    salary: number;
    email?:string;
}

const emp1: Employee = {
    id: 101,
    name: "Udit",
    salary: 50000,
    email: "hi@gmail.com"
};

const emp2: Employee = {
    id: 102,
    name: "Rahul",
    salary: 60000
};


// console.log(emp1);
// console.log(emp2);


class Employee {
    id: number;
    name: string;
    salary: number;

    constructor(id: number, name: string, salary: number) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

const Employee1 = new Employee(101, "Udit", 50000);

// console.log(emp1);






class Vehicle {

    public brand: string;
    private price: number;
    protected fuelType: string;

    constructor(
        brand: string,
        price: number,
        fuelType: string
    ) {
        this.brand = brand;
        this.price = price;
        this.fuelType = fuelType;
    }

    public displayVehicle(): void {
        console.log("Brand: " + this.brand);
        console.log("Price: " + this.price);
        console.log("Fuel Type: " + this.fuelType);
    }
}

class Car extends Vehicle {

    public showFuelType(): void {
        console.log("Fuel Type: " + this.fuelType);
    }
}

const car1 = new Vehicle(
    "Toyota",
    1500000,
    "Petrol"
);

// console.log(car1.brand);

// car1.displayVehicle();

const myCar = new Car(
    "Honda",
    1800000,
    "Diesel"
);

// myCar.showFuelType();

