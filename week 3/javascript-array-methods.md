
# JavaScript Array Methods – Complete Guide
*(What it is for + Code + Output)*

---

## 1. push()
Adds elements to the end of an array.
```js
let items = ["mouse", "keyboard"];
items.push("monitor");
console.log(items);
```
Output:
["mouse", "keyboard", "monitor"]

## 2. pop()
Removes the last element.
```js
let items = ["mouse", "keyboard", "monitor"];
items.pop();
console.log(items);
```
Output:
["mouse", "keyboard"]

## 3. unshift()
Adds elements at the beginning.
```js
let items = ["keyboard", "monitor"];
items.unshift("mouse");
console.log(items);
```
Output:
["mouse", "keyboard", "monitor"]

## 4. shift()
Removes the first element.
```js
let items = ["mouse", "keyboard"];
items.shift();
console.log(items);
```
Output:
["keyboard"]

## 5. indexOf()
Finds index of an element.
```js
let items = ["mouse", "keyboard", "monitor"];
items.indexOf("keyboard");
```
Output:
1

## 6. includes()
Checks existence.
```js
["mouse","keyboard"].includes("mouse");
```
Output:
true

## 7. map()
Transforms elements.
```js
[100,200].map(p=>p+18);
```
Output:
[118,218]

## 8. filter()
Filters elements.
```js
[10,15,20].filter(n=>n%2===0);
```
Output:
[10,20]

## 9. reduce()
Combines values.
```js
[10,20,30].reduce((t,n)=>t+n,0);
```
Output:
60

## 10. forEach()
Iterates elements.
```js
["mouse","keyboard"].forEach(i=>console.log(i));
```
Output:
mouse
keyboard


## slice() with Normal Array
✅ What slice() does

Extracts a portion of an array without modifying the original array.

💻 Code
let nums = [10, 20, 30, 40, 50];

let result = nums.slice(1, 4);

console.log(result);
console.log(nums);

📤 Output
[20, 30, 40]
[10, 20, 30, 40, 50]

🧠 Explanation

Starts at index 1

Ends before index 4

Original array remains unchanged

✅ Copy Entire Array using slice()
let copy = nums.slice();
console.log(copy);

2️⃣ splice() with Normal Array
## ✅ What splice() does

Adds / removes / replaces elements and MODIFIES the original array.

### 🔸 Remove elements
💻 Code
let nums = [10, 20, 30, 40, 50];

let removed = nums.splice(2, 2);

console.log(removed);
console.log(nums);

📤 Output
[30, 40]
[10, 20, 50]

🧠 Explanation

Start at index 2

Remove 2 elements

Original array changed

🔸 Add elements
let nums = [10, 20, 40, 50];

nums.splice(2, 0, 30);
console.log(nums);

📤 Output
[10, 20, 30, 40, 50]

🔸 Replace elements
let nums = [10, 20, 30, 40];

nums.splice(1, 2, 99, 88);
console.log(nums);

📤 Output
[10, 99, 88, 40]

### 3️⃣ slice() with Array of Objects
💻 Example Data
let products = [
  { id: 1, name: "Monitor" },
  { id: 2, name: "Keyboard" },
  { id: 3, name: "Mouse" },
  { id: 4, name: "Laptop" }
];

✅ Extract subset (safe way)
let selectedProducts = products.slice(1, 3);

console.log(selectedProducts);
console.log(products);

📤 Output
[
 {id:2, name:"Keyboard"},
 {id:3, name:"Mouse"}
]

🧠 Explanation

Original array NOT affected

Commonly used in pagination, UI lists

## 4️⃣ splice() with Array of Objects
### 🔸 Remove object
let removedProduct = products.splice(2, 1);

console.log(removedProduct);
console.log(products);

📤 Output
[{id:3, name:"Mouse"}]

[
 {id:1, name:"Monitor"},
 {id:2, name:"Keyboard"},
 {id:4, name:"Laptop"}
]

#### 🔸 Insert new object
products.splice(1, 0, { id: 5, name: "Printer" });
console.log(products);

📤 Output
Monitor, Printer, Keyboard, Laptop

🔸 Replace object
products.splice(0, 1, { id: 10, name: "Smart TV" });
console.log(products);

### 5️⃣ Real-World Use Case (Interview Favorite)
❓ Remove product by id (Safe vs Unsafe)
❌ Using splice (mutates)
let index = products.findIndex(p => p.id === 2);
products.splice(index, 1);

## ✅ Using filter (preferred)
let updatedProducts = products.filter(p => p.id !== 2);

🧠 Interview-Ready Summary
slice()  → extract, copy, safe
splice() → add/remove/replace, mutates


Use slice() when you don’t want side effects
Use splice() when you intend to modify data