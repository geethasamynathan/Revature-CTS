# Linux: Add lines to an existing file + `cat` command uses

## Part 1: Add some lines to an existing file (step-by-step)

### Option A — Append lines using `cat >>` (most common)
1) Go to your folder:
```bash
cd ~/projects
```

2) Ensure the file exists (creates it if missing):
```bash
touch notes.txt
```

3) Append new lines to the **existing** file:
```bash
cat >> notes.txt
This is line 1 I am adding
This is line 2 I am adding
This is line 3 I am adding
```

4) Press **Ctrl + D** to save and exit (end-of-input).

5) Verify:
```bash
cat notes.txt
```

✅ **Why `>>`?**  
`>>` means **append** (it keeps old content and adds new lines at the end).

---

### Option B — Add one line quickly (append) using `echo`
```bash
echo "This is a new line" >> notes.txt
```

---

### Option C — Add multiple lines using a heredoc (append)
```bash
cat >> notes.txt << 'EOF'
Line A
Line B
Line C
EOF
```

---

## Part 2: What are all the uses of the `cat` command?

`cat` = **concatenate** + **display** file contents.

### 1) View a file
```bash
cat notes.txt
```

### 2) View multiple files together
```bash
cat file1.txt file2.txt
```

### 3) Combine multiple files into a new file (overwrite target)
```bash
cat file1.txt file2.txt > merged.txt
```
`>` **overwrites** `merged.txt` (replaces content if it already exists).

### 4) Append one file into another file
```bash
cat file1.txt >> notes.txt
```
`>>` **appends** (adds at the end).

### 5) Create a new file with typed content (overwrite)
```bash
cat > myfile.txt
Hello
Welcome
# press Ctrl+D to save and exit
```

### 6) Append typed content to an existing file
```bash
cat >> myfile.txt
More lines here
# press Ctrl+D to save and exit
```

### 7) Show line numbers
```bash
cat -n notes.txt
```

### 8) Show non-printing characters (useful for debugging)
```bash
cat -A notes.txt
```
This can reveal tabs (`^I`) and line endings (`$`).

### 9) `cat` in pipelines (common real-world use)
- View a log and filter lines containing ERROR:
```bash
cat app.log | grep -i error
```
Tip: You can also do `grep -i error app.log` (often better), but this helps you understand pipelines.

---

## Quick safety note
Be careful with:
- `cat > file.txt`  (can overwrite your file)
- `rm -rf folder`   (deletes permanently)

If you tell me your exact file name/path, I can give the exact commands for your scenario.
