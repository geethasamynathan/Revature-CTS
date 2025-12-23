# Project: Databricks & SQL Assessment Banks

# All HTML5 Tags — Uses + Real-World Examples (with Explanation)

> **Note:** HTML5 includes **new semantic, media, form, and interactive tags**, and it **also keeps many older HTML tags**.
> At the end you’ll see **obsolete/deprecated tags** you should avoid.

---

## 1) Document & Metadata Tags

### `<!DOCTYPE html>`
**Use:** Tells the browser to use HTML5 standards mode.  
**Real-world example:** Every modern website starts with this line.

### `<html>`
**Use:** Root element that wraps the entire HTML document.  
**Real-world example:** All site pages start with `<html lang="en">...</html>`.

### `<head>`
**Use:** Stores metadata (not visible on the page).  
**Real-world example:** SEO, CSS links, page title, and viewport settings.

### `<title>`
**Use:** Sets the browser tab title.  
**Real-world example:** “ItTechGenie | HTML5 Semantic Tags”.

### `<meta>`
**Use:** Metadata (charset, viewport, SEO description, keywords).  
**Real-world example:** Responsive design: `<meta name="viewport" content="width=device-width, initial-scale=1">`.

### `<link>`
**Use:** Links external resources like CSS and icons.  
**Real-world example:** `<link rel="stylesheet" href="site.css">`, favicon.

### `<style>`
**Use:** Internal CSS inside the page.  
**Real-world example:** Small page-specific styling on a single landing page.

### `<base>`
**Use:** Defines base URL for relative links.  
**Real-world example:** Documentation site where all links share a common root.

---

## 2) Semantic Layout (Core HTML5)

### `<header>`
**Use:** Intro area for a page/section (logo, title, search, nav).  
**Real-world example:** Website top bar with logo + search + login button.

### `<nav>`
**Use:** Major navigation block.  
**Real-world example:** Top menu or sidebar menu.

### `<main>`
**Use:** Primary content of the page (**only one per page**).  
**Real-world example:** The main blog post content.

### `<section>`
**Use:** Thematic grouping with a heading.  
**Real-world example:** “Features”, “Pricing”, “Testimonials” on a product site.

### `<article>`
**Use:** Self-contained content that can stand alone.  
**Real-world example:** A blog post card, a news item, a product review.

### `<aside>`
**Use:** Related content (not the main focus).  
**Real-world example:** “Related posts” or “Trending products” sidebar.

### `<footer>`
**Use:** Closing content for page/section.  
**Real-world example:** Bottom footer with contact, terms, and social links.

### `<address>`
**Use:** Contact information for author/company.  
**Real-world example:** Company address in footer.

---

## 3) Headings & Text Blocks

### `<h1>`…`<h6>`
**Use:** Headings by importance.  
**Real-world example:** `h1` = page title, `h2` = section title, etc.

### `<p>`
**Use:** Paragraph of text.  
**Real-world example:** Blog content paragraphs.

### `<br>`
**Use:** Line break (not for layout).  
**Real-world example:** Address formatting in footer.

### `<hr>`
**Use:** Thematic break between sections.  
**Real-world example:** Separating chapters in long notes.

### `<pre>`
**Use:** Preformatted text; spacing preserved.  
**Real-world example:** Display command output logs.

### `<blockquote>`
**Use:** Block-level long quotation.  
**Real-world example:** Customer testimonial quote.

### `<q>`
**Use:** Inline short quote.  
**Real-world example:** “He said, `<q>Ship it today</q>`”.

### `<div>`
**Use:** Generic block container (no semantic meaning).  
**Real-world example:** Wrapper for layout or styling.

---

## 4) Inline Text Semantics

### `<span>`
**Use:** Generic inline wrapper.  
**Real-world example:** Highlight a word, apply a tooltip, or style small text.

### `<strong>`
**Use:** Important text.  
**Real-world example:** **Warning** on a delete confirmation page.

### `<em>`
**Use:** Emphasized text.  
**Real-world example:** Instructions like “You *must* verify email.”

### `<b>` / `<i>`
**Use:** Styling-only emphasis.  
**Real-world example:** Icon-like italic labels or bold headings in UI.

### `<u>`
**Use:** Underline text.  
**Real-world example:** Show misspelled word styling in a demo.

### `<small>`
**Use:** Small print text.  
**Real-world example:** Terms & conditions.

### `<mark>`
**Use:** Highlight relevant content.  
**Real-world example:** Highlight a searched keyword in results.

### `<time>`
**Use:** Machine-readable date/time.  
**Real-world example:** Blog published date (SEO + accessibility).

### `<abbr>`
**Use:** Abbreviation with full meaning in `title`.  
**Real-world example:** `<abbr title="HyperText Markup Language">HTML</abbr>`.

### `<cite>`
**Use:** Title of a work.  
**Real-world example:** Mention a book/article name.

### `<dfn>`
**Use:** Term being defined.  
**Real-world example:** Define “Semantic HTML” in glossary.

### `<code>`
**Use:** Inline code fragment.  
**Real-world example:** Display `<code>git status</code>` in tutorials.

### `<kbd>`
**Use:** Keyboard input.  
**Real-world example:** Press `<kbd>Ctrl</kbd> + <kbd>S</kbd>`.

### `<samp>`
**Use:** Sample program output.  
**Real-world example:** “Build succeeded.”

### `<var>`
**Use:** Variable name.  
**Real-world example:** Math or programming variables.

### `<sub>` / `<sup>`
**Use:** Subscript / superscript.  
**Real-world example:** H<sub>2</sub>O, x<sup>2</sup>.

### `<s>`
**Use:** Text no longer accurate (strike-through).  
**Real-world example:** Old price displayed with strike.

### `<del>` / `<ins>`
**Use:** Deleted/inserted content (edit tracking).  
**Real-world example:** Policy update showing changes.

### `<wbr>`
**Use:** Word break opportunity.  
**Real-world example:** Break long URLs on mobile.

### `<bdi>` / `<bdo>`
**Use:** Bi-directional text handling.  
**Real-world example:** Mixed Arabic/English UI support.

### `<ruby>` / `<rt>` / `<rp>`
**Use:** Ruby annotations (pronunciation).  
**Real-world example:** Language learning content for Japanese.

---

## 5) Links

### `<a>`
**Use:** Hyperlink / anchor.  
**Real-world example:** “Read more” button, download links, navigation links.

---

## 6) Lists

### `<ul>`
**Use:** Unordered list.  
**Real-world example:** Feature bullet list.

### `<ol>`
**Use:** Ordered list.  
**Real-world example:** Step-by-step tutorial.

### `<li>`
**Use:** List item.  
**Real-world example:** Each bullet point or step.

### `<dl>`
**Use:** Definition list.  
**Real-world example:** Glossary page.

### `<dt>` / `<dd>`
**Use:** Definition term / definition description.  
**Real-world example:** “API” → explanation text.

---

## 7) Images & Embedded Content

### `<img>`
**Use:** Displays an image.  
**Real-world example:** Product image in e-commerce.

### `<figure>` / `<figcaption>`
**Use:** Media with a caption.  
**Real-world example:** A chart with caption.

### `<picture>`
**Use:** Responsive images for different screens/formats.  
**Real-world example:** WebP for modern browsers, JPEG fallback.

### `<source>`
**Use:** Media sources for `<picture>`, `<audio>`, `<video>`.  
**Real-world example:** Multiple video formats like mp4 + webm.

### `<iframe>`
**Use:** Embed another page/app.  
**Real-world example:** Embed YouTube, Google Maps, dashboards.

### `<embed>`
**Use:** Embed external content (like PDFs).  
**Real-world example:** PDF viewer inside a page.

### `<object>`
**Use:** Embed resources with fallback.  
**Real-world example:** Embed SVG/PDF with fallback text.

### `<param>`
**Use:** Parameters for `<object>` (legacy embedding settings).  
**Real-world example:** Pass settings to an embedded object.

### `<map>` / `<area>`
**Use:** Clickable areas on an image map.  
**Real-world example:** Click different rooms/blocks on a campus map.

---

## 8) Audio/Video (HTML5 Media)

### `<audio>`
**Use:** Audio player.  
**Real-world example:** Podcast player.

### `<video>`
**Use:** Video player.  
**Real-world example:** Course lesson videos.

### `<track>`
**Use:** Captions/subtitles for accessibility.  
**Real-world example:** English subtitles for training videos.

---

## 9) Graphics & Templates

### `<canvas>`
**Use:** Draw graphics using JavaScript.  
**Real-world example:** Simple game, drawing pad, signature capture.

### `<svg>`
**Use:** Vector graphics markup.  
**Real-world example:** Scalable icons, diagrams.

### `<template>`
**Use:** Hidden HTML blueprint cloned by JS.  
**Real-world example:** Render reusable cards dynamically.

---

## 10) Tables

### `<table>`
**Use:** Table container.  
**Real-world example:** Pricing comparison table.

### `<caption>`
**Use:** Table title.  
**Real-world example:** “Monthly Sales Summary”.

### `<thead>` / `<tbody>` / `<tfoot>`
**Use:** Table sections.  
**Real-world example:** Header row, data rows, totals row.

### `<tr>` / `<th>` / `<td>`
**Use:** Row / header cell / data cell.  
**Real-world example:** Reports grid.

### `<colgroup>` / `<col>`
**Use:** Group/style columns.  
**Real-world example:** Highlight “Best plan” column.

---

## 11) Forms (HTML5 Improvements)

### `<form>`
**Use:** Form container.  
**Real-world example:** Login or registration form.

### `<label>`
**Use:** Label for inputs; improves accessibility.  
**Real-world example:** Click label focuses input.

### `<input>`
**Use:** Single-line input control (many types).  
**Real-world example:** Email/password/date/file upload.

### `<textarea>`
**Use:** Multi-line input.  
**Real-world example:** Feedback message.

### `<button>`
**Use:** Button control.  
**Real-world example:** Submit / Save / Cancel.

### `<select>` / `<option>` / `<optgroup>`
**Use:** Dropdown selections.  
**Real-world example:** Country list grouped by region.

### `<fieldset>` / `<legend>`
**Use:** Group fields with a title.  
**Real-world example:** “Billing Address” group.

### `<datalist>`
**Use:** Autocomplete suggestions for inputs.  
**Real-world example:** Suggest cities while typing.

### `<output>`
**Use:** Display calculated output.  
**Real-world example:** Live total price in booking form.

### `<progress>`
**Use:** Task progress indicator.  
**Real-world example:** File upload progress.

### `<meter>`
**Use:** Known-range measurement.  
**Real-world example:** Password strength.

**Common HTML5 input types (real-world):**  
`text, password, email, number, tel, url, search, date, time, datetime-local, month, week, color, range, file, checkbox, radio, hidden, submit, reset, button`

---

## 12) Interactive UI

### `<details>` / `<summary>`
**Use:** Expand/collapse UI.  
**Real-world example:** FAQ section.

### `<dialog>`
**Use:** Native dialog/modal window.  
**Real-world example:** Confirm delete modal popup.

---

## 13) Scripting

### `<script>`
**Use:** JavaScript code.  
**Real-world example:** Form validation, API calls.

### `<noscript>`
**Use:** Fallback message when JS disabled.  
**Real-world example:** “Enable JavaScript to use this site.”

---

## 14) Obsolete/Deprecated Tags (Avoid in HTML5)

Do **not** use these in modern sites:
- Layout/presentation: `<center>`, `<font>`, `<big>`, `<strike>`, `<tt>`
- Frames: `<frameset>`, `<frame>`, `<noframes>`
- Others: `<acronym>`, `<applet>`, `<basefont>`, `<dir>`, `<isindex>`

**Modern replacement:** semantic HTML + CSS.

---

## Mini Real-World Layout Example

```html
<header>
  <h1>ItTechGenie</h1>
  <nav>
    <a href="/">Home</a>
    <a href="/courses">Courses</a>
    <a href="/contact">Contact</a>
  </nav>
</header>

<main>
  <article>
    <header>
      <h2>All HTML5 Tags</h2>
      <p>Published <time datetime="2025-12-23">Dec 23, 2025</time></p>
    </header>

    <section>
      <h3>Why HTML5 tags?</h3>
      <p>They improve SEO, accessibility, and code readability.</p>
    </section>

    <details>
      <summary>FAQ: Why use semantic tags?</summary>
      <p>They help screen readers and search engines understand the layout.</p>
    </details>

    <footer>
      <p>Tags: <mark>HTML5</mark>, Web Development</p>
    </footer>
  </article>

  <aside>
    <h3>Related Tutorials</h3>
    <ul>
      <li><a href="/html/forms">HTML Forms</a></li>
      <li><a href="/css/layout">CSS Layout</a></li>
    </ul>
  </aside>
</main>

<footer>
  <address>
    Contact: <a href="mailto:support@ittechgenie.com">Support Team</a>
  </address>
</footer>
```
