// //var
var x1 = 10;
if (true) {
  var x1 = 200;
  console.log("x1=" + x1);
}
console.log(x1);

let x = 100;
if (true) {
  let x = 340;
  console.log("x=" + x);
}
console.log(x);

let num1 = 100;
let num2 = "100";
if (num1 == num2) {
  console.log(" both values are same");
}

if (num1 === num2) {
  console.log("Both value and types are same");
} else {
  console.log("datatype and value are not same");
}

//array
let studentNames = new Array();
studentNames.push("Tina");
studentNames.push("Preethi");
studentNames.push("Oswal");

// for (i = 0; i < studentNames.length; i++) {
//   console.log(studentNames[i]);
// }

// for (let name of studentNames) {
//   console.log(name);
// }
//to remove last item
//console.log("pop() " + studentNames.pop());

//to remove first  item
console.log(studentNames.shift());

console.log("\n\n after removed irst item");
for (let name of studentNames) {
  console.log(name);
}

//to add item or elelment in the begnning

studentNames.unshift("Ram");
console.log("\n\n after Added ram at  first item");
for (let name of studentNames) {
  console.log(name);
}
