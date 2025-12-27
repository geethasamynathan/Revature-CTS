# Project: Databricks & SQL Assessment Banks

# CSS `transform` — Detailed Notes (Real‑World Examples for Every Property / Function)

## 1) What is `transform`?
`transform` lets you visually **move**, **rotate**, **resize**, **skew**, and add **3D depth** to an element **without changing the normal document flow** (so other elements don’t re-layout like they do with margin/position changes).

### Syntax
```css
.element {
  transform: translateX(20px) rotate(10deg) scale(1.1);
}
```

### Important rules
- **Order matters**: `translate() rotate()` is not the same as `rotate() translate()`.
- Often uses **GPU acceleration** (smooth, especially with 3D transforms).
- Works great with `transition`:
```css
.element { transition: transform 250ms ease; }
```

---

# A) 2D Transform Functions — Separate Real‑World Examples

## 2) `transform: none`
**Use case:** Reset styles (e.g., disable hover effects on mobile / reduced motion mode).
```html
<div class="card">Hover disabled</div>
<style>
  .card{
    width:220px; padding:16px; border:1px solid #ccc; border-radius:12px;
    font-family:Arial;
    transform: none;   /* reset */
  }
</style>
```

## 3) `translateX()`
**Use case:** Slide a “Quick View” button slightly when hovering a product.
```html
<button class="quick">Quick View →</button>
<style>
  .quick{
    font-family:Arial; padding:12px 16px; border:1px solid #111; border-radius:10px;
    background:#fff; cursor:pointer; transition:transform .2s ease;
  }
  .quick:hover{ transform: translateX(10px); }
</style>
```

## 4) `translateY()`
**Use case:** Lift a card up on hover (dashboards/e‑commerce).
```html
<div class="tile">Revenue Card</div>
<style>
  .tile{
    width:240px; padding:18px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .2s ease;
  }
  .tile:hover{ transform: translateY(-8px); }
</style>
```

## 5) `translate()` (X and Y)
**Use case:** Toast notification positioned diagonally (bottom‑right vibe).
```html
<div class="toast">Saved ✅</div>
<style>
  .toast{
    width:140px; padding:10px 14px; border-radius:10px; font-family:Arial;
    background:#111; color:#fff; display:inline-block;
    transform: translate(40px, 20px); /* X, Y */
  }
</style>
```

## 6) `scale()`
**Use case:** Image zoom on hover in a product gallery.
```html
<div class="imgWrap">
  <img class="pic" src="https://via.placeholder.com/260x160" alt="product">
</div>
<style>
  .imgWrap{ width:260px; height:160px; overflow:hidden; border-radius:14px; border:1px solid #ddd; }
  .pic{ width:100%; height:100%; object-fit:cover; transition:transform .25s ease; }
  .imgWrap:hover .pic{ transform: scale(1.12); }
</style>
```

## 7) `scaleX()`
**Use case:** Progress bar grows horizontally from 0 to a value.
```html
<div class="bar">
  <div class="fill"></div>
</div>
<style>
  .bar{ width:280px; height:12px; border:1px solid #ccc; border-radius:999px; overflow:hidden; }
  .fill{
    height:100%; background:#111;
    transform: scaleX(.25); transform-origin:left; /* 25% progress */
  }
</style>
```

## 8) `scaleY()`
**Use case:** Audio level meter grows vertically.
```html
<div class="meter"></div>
<style>
  .meter{
    width:26px; height:90px; background:#111; border-radius:8px;
    transform: scaleY(0.55); transform-origin: bottom; /* 55% */
  }
</style>
```

## 9) `rotate()`
**Use case:** Loading spinner.
```html
<div class="spinner"></div>
<style>
  .spinner{
    width:40px; height:40px; border-radius:50%;
    border:4px solid #ccc; border-top-color:#111;
    animation: spin 1s linear infinite;
  }
  @keyframes spin { to { transform: rotate(360deg); } }
</style>
```

## 10) `skew()`
**Use case:** “SALE” ribbon look.
```html
<div class="ribbon">SALE</div>
<style>
  .ribbon{
    width:120px; padding:10px; text-align:center; font-family:Arial; color:#fff;
    background:#111;
    transform: skew(-15deg, 0deg);
    display:inline-block;
  }
</style>
```

## 11) `skewX()`
**Use case:** Slanted checkout button.
```html
<button class="slant">Checkout</button>
<style>
  .slant{
    padding:12px 18px; border:0; border-radius:10px; background:#111; color:#fff;
    font-family:Arial; cursor:pointer;
    transform: skewX(-12deg);
  }
</style>
```

## 12) `skewY()`
**Use case:** Slanted “NEW” tag.
```html
<span class="tag">NEW</span>
<style>
  .tag{
    display:inline-block; padding:8px 12px; border-radius:10px;
    font-family:Arial; border:1px solid #111;
    transform: skewY(-10deg);
  }
</style>
```

---

# B) Combining Transforms (Order Matters)

## 13) Multiple transforms in one line
**Use case:** Premium hover effect (lift + rotate + scale).
```html
<div class="proCard">Premium Plan</div>
<style>
  .proCard{
    width:240px; padding:18px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .22s ease;
  }
  .proCard:hover{
    transform: translateY(-8px) rotate(-2deg) scale(1.03);
  }
</style>
```

---

# C) 3D Transform Functions — Separate Real‑World Examples

## 14) `perspective()` (as a transform function)
**Use case:** Add depth to a card.
```html
<div class="depth">3D Card</div>
<style>
  .depth{
    width:220px; padding:18px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .depth:hover{
    transform: perspective(700px) rotateX(12deg);
  }
</style>
```

## 15) `rotateX()`
**Use case:** Panel tilts like opening a lid.
```html
<div class="panel">Report Panel</div>
<style>
  .panel{
    width:240px; padding:18px; border:1px solid #ccc; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .panel:hover{ transform: perspective(700px) rotateX(18deg); }
</style>
```

## 16) `rotateY()`
**Use case:** Product tilt left/right.
```html
<div class="tilt">Phone Preview</div>
<style>
  .tilt{
    width:240px; padding:18px; border:1px solid #ccc; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .tilt:hover{ transform: perspective(700px) rotateY(18deg); }
</style>
```

## 17) `rotateZ()`
**Use case:** Badge tilt (explicit Z axis).
```html
<div class="badge">Approved</div>
<style>
  .badge{
    display:inline-block; padding:10px 14px; border:1px solid #111; border-radius:12px;
    font-family:Arial; transition:transform .2s ease;
  }
  .badge:hover{ transform: rotateZ(-6deg); }
</style>
```

## 18) `translateZ()`
**Use case:** Pop‑out on hover.
```html
<div class="pop">Hover Pop</div>
<style>
  .pop{
    width:200px; padding:16px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .pop:hover{ transform: perspective(700px) translateZ(40px); }
</style>
```

## 19) `translate3d(x, y, z)`
**Use case:** Slide + pop forward (modal entry feel).
```html
<div class="modal">Modal</div>
<style>
  .modal{
    width:200px; padding:16px; border:1px solid #111; border-radius:14px;
    font-family:Arial;
    transform: perspective(700px) translate3d(30px, 10px, 30px);
  }
</style>
```

## 20) `scale3d(x, y, z)`
**Use case:** 3D zoom (mostly x/y; z affects depth scaling in 3D space).
```html
<div class="zoom3d">3D Zoom</div>
<style>
  .zoom3d{
    width:220px; padding:16px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .zoom3d:hover{ transform: perspective(700px) scale3d(1.08, 1.08, 1.2); }
</style>
```

## 21) `rotate3d(x, y, z, angle)`
**Use case:** Rotate around a custom axis (fancy product tilt).
```html
<div class="box3d">3D Box</div>
<style>
  .box3d{
    width:220px; padding:16px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .box3d:hover{ transform: perspective(800px) rotate3d(1, 1, 0, 18deg); }
</style>
```

## 22) `matrix(a, b, c, d, tx, ty)`
**Use case:** Advanced combined transform (often tool‑generated).
```html
<div class="m2d">Matrix 2D</div>
<style>
  .m2d{
    width:220px; padding:16px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial;
    transform: matrix(1, 0.2, 0.1, 1, 20, 10);
  }
</style>
```

## 23) `matrix3d(...)`
**Use case:** Rare manually; used by engines/tools for complex 3D.
```html
<div class="m3d">Matrix 3D</div>
<style>
  .m3d{
    width:220px; padding:16px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial;
    transform: perspective(700px) matrix3d(
      1,0,0,0,
      0,1,0,0,
      0,0,1,0,
      20,10,30,1
    );
  }
</style>
```

---

# D) Transform‑Related Properties (Control how transforms behave)

## 24) `transform-origin`
**Use case:** Rotate a clock hand from the bottom (pivot point).
```html
<div class="clock">
  <div class="hand"></div>
</div>
<style>
  .clock{ width:140px; height:140px; border:2px solid #111; border-radius:50%; position:relative; }
  .hand{
    width:4px; height:55px; background:#111; position:absolute; left:50%; top:20%;
    transform-origin: bottom center;  /* key */
    transform: rotate(35deg);
  }
</style>
```

## 25) `perspective` (property on parent)
**Use case:** Apply consistent depth to children.
```html
<div class="stage">
  <div class="card3d">Hover me</div>
</div>
<style>
  .stage{ perspective:800px; }
  .card3d{
    width:220px; padding:16px; border:1px solid #ddd; border-radius:14px;
    font-family:Arial; transition:transform .25s ease;
  }
  .card3d:hover{ transform: rotateY(18deg); }
</style>
```

## 26) `transform-style: preserve-3d`
**Use case:** Keep nested 3D transforms (flip cards/cubes).
```html
<div class="wrap3d">
  <div class="inner">3D Child</div>
</div>
<style>
  .wrap3d{
    width:240px; padding:18px; border:1px solid #ddd; border-radius:14px;
    transform-style: preserve-3d;
    perspective:800px;
  }
  .inner{ transform: translateZ(40px); font-family:Arial; }
</style>
```

## 27) `backface-visibility`
**Use case:** Credit card flip—hide back side when rotated.
```html
<div class="flip">
  <div class="face front">FRONT</div>
  <div class="face back">BACK</div>
</div>

<style>
  .flip{ width:220px; height:120px; position:relative; perspective:900px; }
  .face{
    position:absolute; inset:0; display:flex; align-items:center; justify-content:center;
    border:1px solid #111; border-radius:14px; font-family:Arial;
    backface-visibility: hidden;
    transition: transform .5s ease;
  }
  .front{ transform: rotateY(0deg); }
  .back{ transform: rotateY(180deg); }
  .flip:hover .front{ transform: rotateY(-180deg); }
  .flip:hover .back{ transform: rotateY(0deg); }
</style>
```

---

# Quick Cheat Sheet (Most used in real UI)
- Move: `translateX/Y`, `translate()`
- Zoom: `scale()`
- Spin: `rotate()`
- Slant: `skewX/Y`
- 3D tilt: `perspective(...) rotateX/Y`
- 3D pop: `translateZ()`
- Pivot control: `transform-origin`
