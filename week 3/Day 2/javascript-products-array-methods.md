
# JavaScript Array Methods – Products Example
*(map, filter, reduce, sort, reverse and more)*

---

## Base Products Array
```js
let products = [
  { id: 201, Name: "Monitor", qty: 12, price: 7800 },
  { id: 202, Name: "Magic pen", qty: 5, price: 12500 },
  { id: 203, Name: "Keyboard", qty: 3, price: 6900 },
  { id: 204, Name: "Laptop", qty: 10, price: 78000 },
];
```

---

## 1. map() – Transform Data
### Get product names
```js
let productNames = products.map(p => p.Name);
console.log(productNames);
```
**Output**
```
["Monitor", "Magic pen", "Keyboard", "Laptop"]
```

### Add totalValue (qty × price)
```js
let productsWithTotal = products.map(p => ({
  ...p,
  totalValue: p.qty * p.price
}));
console.log(productsWithTotal);
```

---

## 2. filter() – Select Data
### Products price > 10000
```js
let costlyProducts = products.filter(p => p.price > 10000);
console.log(costlyProducts);
```
**Output**
```
Magic pen, Laptop
```

### Products with low stock (qty < 6)
```js
let lowStock = products.filter(p => p.qty < 6);
console.log(lowStock);
```

---

## 3. reduce() – Calculate
### Total inventory value
```js
let totalInventoryValue = products.reduce(
  (total, p) => total + (p.qty * p.price),
  0
);
console.log(totalInventoryValue);
```

### Total quantity
```js
let totalQty = products.reduce((sum, p) => sum + p.qty, 0);
console.log(totalQty);
```

---

## 4. sort() – Order Data
### Sort by price (ascending)
```js
let sortByPriceAsc = [...products].sort(
  (a, b) => a.price - b.price
);
console.log(sortByPriceAsc);
```

### Sort by name (A–Z)
```js
let sortByName = [...products].sort(
  (a, b) => a.Name.localeCompare(b.Name)
);
console.log(sortByName);
```

---

## 5. reverse() – Reverse Order
```js
let reversedProducts = [...products].reverse();
console.log(reversedProducts);
```

---

## 6. some() – At Least One Match?
```js
let hasLowStock = products.some(p => p.qty < 5);
console.log(hasLowStock);
```
**Output**
```
true
```

---

## 7. every() – All Match?
```js
let allInStock = products.every(p => p.qty > 0);
console.log(allInStock);
```
**Output**
```
true
```

---

## 8. find() – First Match
```js
let findLaptop = products.find(p => p.Name === "Laptop");
console.log(findLaptop);
```

---

## 9. findIndex() – Index of Match
```js
let indexKeyboard = products.findIndex(p => p.Name === "Keyboard");
console.log(indexKeyboard);
```

---

## 10. forEach() – Display
```js
products.forEach(p => {
  console.log(`${p.Name} costs ${p.price}`);
});
```

---

## Interview Summary
```
map     → transform
filter  → select
reduce  → calculate
sort    → order
reverse → flip
some    → at least one
every   → all
find    → first match
```
