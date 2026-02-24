# Django – Notes + Step‑by‑Step Guide

## What is Django?

**Django** is a **high-level Python web framework** used to build web applications quickly and correctly.  
It follows the **MVT pattern (Model–View–Template)** and gives you many features “ready-made” so you don’t have to build everything from scratch.

**In simple words:** Django helps you build websites/web apps using Python with less effort, more speed, and better security.

---

## Why use Django?

### ✅ 1) Faster Development
- Django provides built-in modules for common web needs: login, database, admin panel, forms, etc.
- You can build a working app in hours instead of days.

### ✅ 2) Built-in Security
Django includes protection against common attacks:
- CSRF (Cross Site Request Forgery)
- XSS (Cross Site Scripting)
- SQL Injection
- Clickjacking

### ✅ 3) Built-in Admin Panel
- Django can automatically create an **Admin Dashboard** for your database tables.
- You can add/update/delete data without building an admin UI.

### ✅ 4) Powerful Database Handling (ORM)
- You don’t need to write SQL most of the time.
- Django ORM lets you query data using Python code.

### ✅ 5) Scalable and Production-ready
- Used by many real apps and can handle large projects if structured well.

---

## What all can we do using Django?

You can build almost any kind of web application, such as:

### 🌐 Web Applications
- Company websites
- Blog websites
- Learning portals (like your ItTechGenie)

### 🛒 E-commerce Apps
- Product listing, cart, payment integration, order tracking

### 🔐 Authentication Systems
- User registration
- Login/Logout
- Roles and permissions (Admin/User/Moderator)

### 🧩 REST APIs (Backend for Mobile/React Apps)
- Build APIs using Django REST Framework (DRF)

### 📊 Dashboards & Admin Systems
- Employee management
- Student/course management
- Inventory systems

### 📁 File Upload Systems
- Upload images, PDFs, documents, videos

### ✅ Forms & Validations
- Contact forms
- Admission forms
- Survey forms with validation

---

# How to create a Django application (Step-by-Step)

Below is the complete beginner-friendly workflow.

---

## Step 0: Check Python installed
Open terminal (Command Prompt / PowerShell) and run:

```bash
python --version
```

If it shows a version like `Python 3.x.x`, you are good.

---

## Step 1: Create a project folder
Example:

```bash
mkdir DjangoLearning
cd DjangoLearning
```

---

## Step 2: Create a virtual environment (recommended)
Virtual environment keeps Django and dependencies isolated.

```bash
python -m venv venv
```

✅ Activate it:

### Windows:
```bash
venv\Scripts\activate
```

### Mac/Linux:
```bash
source venv/bin/activate
```

You should now see `(venv)` in terminal.

---

## Step 3: Install Django
```bash
pip install django
```

Verify:
```bash
django-admin --version
```

---

## Step 4: Create a Django project
```bash
django-admin startproject myproject
```

Now go inside:
```bash
cd myproject
```

✅ Your structure becomes like:

- myproject/
  - manage.py
  - myproject/
    - settings.py
    - urls.py
    - wsgi.py

---

## Step 5: Run the Django server (test)
```bash
python manage.py runserver
```

Open in browser:
- http://127.0.0.1:8000/

If you see Django welcome page ✅ done.

Stop server:
- Press `CTRL + C`

---

# Now create your FIRST Django App (inside the project)

## Step 6: Create an app
Example app name: `myapp`

```bash
python manage.py startapp myapp
```

You will get:

- myapp/
  - admin.py
  - apps.py
  - models.py
  - views.py
  - tests.py
  - migrations/

---

## Step 7: Register the app in settings.py
Open:

`myproject/settings.py`

Find `INSTALLED_APPS` and add:

```python
INSTALLED_APPS = [
    'django.contrib.admin',
    'django.contrib.auth',
    'django.contrib.contenttypes',
    'django.contrib.sessions',
    'django.contrib.messages',
    'django.contrib.staticfiles',

    'myapp',  # ✅ add this
]
```

---

## Step 8: Create a simple view (Hello World)
Open:

`myapp/views.py`

Add:

```python
from django.http import HttpResponse

def home(request):
    return HttpResponse("Hello Django!")
```

---

## Step 9: Connect URL routing

### 9.1 Create app urls.py
Create a new file:

`myapp/urls.py`

Add:

```python
from django.urls import path
from . import views

urlpatterns = [
    path('', views.home),
]
```

### 9.2 Link app urls into project urls.py
Open:

`myproject/urls.py`

Change to:

```python
from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('myapp.urls')),  # ✅ connect myapp
]
```

---

## Step 10: Run server and test
```bash
python manage.py runserver
```

Open:
- http://127.0.0.1:8000/

✅ Output:
`Hello Django!`

---

# Next: Create Database Tables using Django ORM (Quick preview)

## Step 11: Create a model (table)
In `myapp/models.py`:

```python
from django.db import models

class Student(models.Model):
    name = models.CharField(max_length=100)
    age = models.IntegerField()

    def __str__(self):
        return self.name
```

---

## Step 12: Make migrations + migrate
```bash
python manage.py makemigrations
python manage.py migrate
```

✅ Now your Student table is created.

---

# Next: Enable Admin Panel for your Model

## Step 13: Create admin user
```bash
python manage.py createsuperuser
```

Enter:
- username
- email
- password

---

## Step 14: Register model in admin
Open `myapp/admin.py`:

```python
from django.contrib import admin
from .models import Student

admin.site.register(Student)
```

---

## Step 15: Run and open admin
```bash
python manage.py runserver
```

Open:
- http://127.0.0.1:8000/admin

Login with superuser.

✅ You can now add Student records from Admin UI.

---

## Summary Flow (Most Important)
1) Create venv  
2) Install Django  
3) startproject  
4) runserver  
5) startapp  
6) add app to INSTALLED_APPS  
7) write view  
8) add urls  
9) migrate DB  
10) use admin panel  
