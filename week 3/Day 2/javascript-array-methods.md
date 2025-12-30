
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
