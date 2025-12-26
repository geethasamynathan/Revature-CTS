# Project: Databricks & SQL Assessment Banks

# Difference between CSS `position` values
In CSS, `position` controls **how an element is placed** and **what it is positioned relative to**.

---

## 1) `position: static` (default)
**Meaning:** Normal document flow (no special positioning).  
**`top/left/right/bottom`:** ❌ Ignored.

**When to use:** Regular layouts (most elements).

```html
<div class="box static">Static</div>

<style>
.box{padding:12px;margin:8px;background:#e3f2fd;}
.static{ position: static; top: 20px; left: 20px; } /* ignored */
</style>
```

✅ The element stays where it normally is.

---

## 2) `position: relative`
**Meaning:** Still in normal flow, **but you can shift it** visually using `top/left/right/bottom`.  
**Important:** The element **keeps its original space** (gap remains).

**When to use:**
- Small nudges (move an icon/label slightly)
- To make a parent act as the reference for an `absolute` child

```html
<div class="box relative">Relative (moved)</div>

<style>
.relative{
  position: relative;
  top: 10px;
  left: 20px;
}
</style>
```

✅ Moves visually, but original space is still reserved.

---

## 3) `position: absolute`
**Meaning:** Removed from normal flow (**no space reserved**).  
Positions relative to:
- the **nearest ancestor** that is not `static` (relative/absolute/fixed/sticky)
- otherwise, the **page** (initial containing block)

**When to use:**
- Badges (SALE)
- Close buttons (✖)
- Tooltips / dropdown panels inside a component

```html
<div class="card">
  Card
  <span class="badge">SALE</span>
</div>

<style>
.card{
  position: relative;        /* makes this the reference for .badge */
  padding: 30px;
  border: 2px solid #333;
  width: 220px;
}
.badge{
  position: absolute;
  top: 8px;
  right: 8px;
  background: tomato;
  color: white;
  padding: 4px 8px;
  border-radius: 10px;
}
</style>
```

✅ Badge sits on the card’s top-right corner.  
⚠️ If `.card` is not positioned (`relative`), the badge may go to the page corner instead.

---

## 4) `position: fixed`
**Meaning:** Removed from normal flow and **fixed to the viewport** (screen).  
Does **not move** when you scroll.

**When to use:**
- Floating “Chat” button
- Back-to-top button
- Always-visible header

```html
<button class="chat">Chat</button>

<style>
.chat{
  position: fixed;
  bottom: 20px;
  right: 20px;
  padding: 12px 16px;
}
</style>
```

✅ Stays in the same screen location even while scrolling.

---

## 5) `position: sticky`
**Meaning:** Behaves like `relative` **until a scroll point**, then behaves like `fixed`.  
It sticks **within its parent container**.

**Important:** Must set at least one of `top/left/right/bottom` (commonly `top: 0;`).

**When to use:**
- Table headers
- Section headings while reading
- Sidebars that should stick during scroll

```html
<div class="wrap">
  <div class="header">Sticky Header</div>
  <p>Scroll content ...</p>
  <p>More content ...</p>
  <p>More content ...</p>
</div>

<style>
.wrap{
  height: 200px;
  overflow: auto;
  border: 2px solid #333;
  padding: 10px;
}
.header{
  position: sticky;
  top: 0;
  background: #fff59d;
  padding: 10px;
}
</style>
```

✅ The header sticks at the top **only while scrolling inside** `.wrap`.

---

# Quick comparison table

| Position | In normal flow? | Scroll behavior | Positioned relative to |
|---|---|---|---|
| `static` | ✅ Yes | normal | normal document flow |
| `relative` | ✅ Yes (space kept) | normal | its own normal position |
| `absolute` | ❌ No | scrolls with page | nearest positioned ancestor |
| `fixed` | ❌ No | **does not scroll** | viewport (screen) |
| `sticky` | ✅ Yes (until stuck) | sticks after threshold | parent container + scroll |

---

## Real-world mapping (super easy)
- **static**: normal sections, paragraphs, cards  
- **relative**: minor adjustments; parent for absolute child  
- **absolute**: badge, tooltip, dropdown, close button  
- **fixed**: chat widget, floating button, fixed navbar  
- **sticky**: table header, section title, reading sidebar
