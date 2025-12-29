console.log("Welcome to Javascript ");
// Number
num1 = 900;
num2 = 100;
AdditonResult = num1 + num2;
difference = num1 - num2;
product = num1 * num2;
division = num1 / num2;
console.log("AdditonResult" + AdditonResult);
console.log(
  `Difference = ${difference} \n Product=${product}\n Division=${division}`
);

firstName = "Geetha";
lastName = "Samynathan";
fullName = firstName + " " + lastName;
console.log("fullName= ", fullName);

// Data types

//string;

let name = "Geetha";
let city = "coimbatore";
let message = `Hi ${name} welcome`;

//boolean
isLoggedIn = false;

console.log(` is Logged in ${isLoggedIn}`);

//undefined
let x;
console.log(`x value  is ${x}`);

// null
let user = null;
console.log(`user Count :${user}`);

//how to find the type of variable

console.log(`typeof user ${typeof user}`);
console.log(` type of name ${typeof name} \n Type of num1 ${typeof num1} \n
typeof x ${typeof x}`);

let mobileno = 98765432109876543210n;
console.log(`type of Mobileno ${typeof mobileno}`);

// //symbol

// let eid = Symbol("empid");
// let employees = [
//   { empid: 101, name: "Peter" },
//   { empid: 102, name: "Fransy" },
// ];

// console.log(employees[0].empid);
// console.log(employees[1].empid);

// with  symbol

const emp_id = Symbol("empid");
let employees = [
  { [emp_id]: 101, name: "Peter" },
  { [emp_id]: 101, name: "Fransy" },
];

console.log(employees[0][emp_id]);
console.log(employees[1][emp_id]);
