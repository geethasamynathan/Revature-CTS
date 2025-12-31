# Callback Function in JavaScript

## What is a Callback Function?

A callback function is a function that is passed as an argument to another function and is executed later, after some operation is completed.

In simple terms:
> “Call this function back after you finish your work.”

---

## Why Callback Functions Are Needed

JavaScript is:
- Single-threaded
- Asynchronous

Callbacks allow JavaScript to:
- Handle tasks that take time
- Execute code after an operation finishes
- Respond to events like clicks, timers, and API calls

---

## Basic Callback Function Example

```javascript
function greet(name) {
    console.log("Hello " + name);
}

function processUser(callback) {
    let userName = "Amit";
    callback(userName);
}

processUser(greet);
```

### Output
```
Hello Amit
```

---

## How This Example Works

1. `greet` is a normal function.
2. `processUser` accepts a function as a parameter.
3. `greet` is passed without parentheses.
4. Inside `processUser`, the callback is executed.
5. `greet("Amit")` runs.

---

## Important Rule

Incorrect:
```javascript
processUser(greet());
```

Correct:
```javascript
processUser(greet);
```

Always pass the function reference, not the function call.

---

## Callback Function with Parameters

```javascript
function calculate(a, b, operation) {
    operation(a, b);
}

function add(x, y) {
    console.log(x + y);
}

calculate(10, 20, add);
```

### Output
```
30
```

---

## Callback Example Using setTimeout

```javascript
function showMessage() {
    console.log("This message appears after 2 seconds");
}

setTimeout(showMessage, 2000);
```

---

## Callback Function in Array Methods

### Example: forEach()

```javascript
let numbers = [1, 2, 3, 4];

numbers.forEach(function (num) {
    console.log(num * 2);
});
```

---

## Real-World Callback Example (Button Click)

### HTML
```html
<button onclick="handleClick(showMessage)">Click Me</button>
```

### JavaScript
```javascript
function showMessage() {
    alert("Button clicked!");
}

function handleClick(callback) {
    callback();
}
```

---

## Interview Definition

A callback function is a function passed as an argument to another function and executed later after the completion of an operation.
