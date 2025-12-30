let products = [
  { id: 201, Name: "Monitor", qty: 12, price: 7800 },
  { id: 202, Name: "Magic pen", qty: 5, price: 12500 },
  { id: 203, Name: "Keyboard", qty: 3, price: 6900 },
  { id: 204, Name: "Laptop", qty: 10, price: 78000 },
];

products.forEach((p) => {
  console.log(`${p.id} -${p.Name} -${p.qty} - ${p.price}`);
});

productsSortByPrice = products.sort((a, b) => a.price - b.price);
console.log(" \n\nProducts sort by Price");
productsSortByPrice.forEach((p) => {
  console.log(`${p.id} -${p.Name} -${p.qty} - ${p.price}`);
});

let productPrice = [45, 900, 23, 780];
sortedProductPrice = productPrice.sort();
sortedProductPrice.forEach((p) => {
  console.log(p);
});

//1. map() – Transform Data
//Get product names
let productNames = products.map((p) => p.Name);
console.log(productNames);

//Add totalValue (qty × price)
let productsWithTotal = products.map((p) => ({
  ...p,
  totalValue: p.qty * p.price,
}));
console.log(productsWithTotal);

//2. filter() – Select Data
//Products price > 10000
let costlyProducts = products.filter((p) => p.price > 10000);
console.log("\n\n Products more than 10000");
console.log(costlyProducts);

//3. reduce() – Calculate
//Total inventory value
let totalInventoryValue = products.reduce(
  (total, p) => total + p.qty * p.price,
  0
);
console.log(totalInventoryValue);

//Sort by name (A–Z)
let sortByName = [...products].sort((a, b) => a.Name.localeCompare(b.Name));
console.log(sortByName);

console.log("\n\n Beffore  Reverse \n");
console.log(...products);
let reversedProducts = [...products].reverse();
console.log(reversedProducts);
