# Project: Databricks & SQL Assessment Banks

# HTML5 Semantic Tags — List, Uses, and Real Use Cases

## 1) Page Structure (Layout/Content)

### `<header>`
**Use:** Intro area for a page/section (logo, title, search, nav).  
**Real use case:** E-commerce top bar with logo + search + cart icon.

### `<nav>`
**Use:** Major navigation links for the site/section.  
**Real use case:** Main menu (Home, Courses, Contact) or docs sidebar.

### `<main>`
**Use:** Primary content of the page (**only one** per page).  
**Real use case:** Blog post body area excluding header/footer/sidebar.

### `<section>`
**Use:** Thematic grouping of content (usually with a heading).  
**Real use case:** Landing page blocks like Features, Pricing, Testimonials.

### `<article>`
**Use:** Self-contained content that can stand alone (post/news/review).  
**Real use case:** Each blog post card in a list page; each news item in a feed.

### `<aside>`
**Use:** Related but not central content (sidebar, related links, ads).  
**Real use case:** “Related articles” panel or “Trending posts” column.

### `<footer>`
**Use:** Closing area for a page/section (copyright, links, contacts).  
**Real use case:** Site bottom area with privacy policy, address, social links.

---

## 2) Media & Figure Meaning

### `<figure>`
**Use:** A self-contained media/content block referenced by the main content.  
**Real use case:** Tutorial screenshot or a chart included in an article.

### `<figcaption>`
**Use:** Caption/description for a `<figure>`.  
**Real use case:** “Figure 2: Sales trend from Jan–Dec”.

---

## 3) Text Meaning

### `<mark>`
**Use:** Highlights text as relevant.  
**Real use case:** Highlight search keywords in search results.

### `<time>`
**Use:** Machine-readable date/time using `datetime=""`.  
**Real use case:** Blog publish date for SEO + accessibility.

---

## 4) Collapsible / Interactive Meaning

### `<details>`
**Use:** Expand/collapse container.  
**Real use case:** FAQ section where answers are hidden until expanded.

### `<summary>`
**Use:** Visible heading/label for a `<details>` block.  
**Real use case:** “What is REST API?” (click to expand explanation)

---

## 5) Forms / Measurement Meaning

### `<meter>`
**Use:** Measurement within a known range (like 0–100).  
**Real use case:** Battery level, storage usage, strength indicator.

### `<progress>`
**Use:** Progress of a task over time.  
**Real use case:** File upload/download progress indicator.

---

## 6) Data / Annotation Meaning

### `<data>`
**Use:** Human-readable text with machine-readable value via `value=""`.  
**Real use case:** Show “₹1.2L” but keep numeric value `120000` for scripts.

### `<output>`
**Use:** Displays the result of a calculation (often linked to inputs).  
**Real use case:** Live “Total Price” in a booking form when user changes dates/guests.

---

## Bonus: Common Semantic Inline Tags (Very useful in real projects)
These are not all “new in HTML5”, but they are semantic and widely used:

- `<strong>`: important text  
- `<em>`: emphasized text  
- `<cite>`: title of a work (book/article)  
- `<address>`: contact information  
- `<abbr>`: abbreviation (use `title=""`)  
- `<code>`: code fragment  
- `<kbd>`: user keyboard input  

---

## Mini Real-World Semantic Layout Example

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
      <h2>HTML5 Semantic Tags</h2>
      <p>Published <time datetime="2025-12-23">Dec 23, 2025</time></p>
    </header>

    <section>
      <h3>Why semantic tags?</h3>
      <p>They improve readability, SEO, and accessibility.</p>

      <figure>
        <img src="semantic-layout.png" alt="Page layout diagram">
        <figcaption>Semantic layout: header, nav, main, aside, footer.</figcaption>
      </figure>
    </section>

    <details>
      <summary>FAQ: When to use section vs article?</summary>
      <p>Use article for standalone content; section for grouped topics.</p>
    </details>

    <footer>
      <p>Tags: <mark>HTML5</mark>, Accessibility</p>
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
